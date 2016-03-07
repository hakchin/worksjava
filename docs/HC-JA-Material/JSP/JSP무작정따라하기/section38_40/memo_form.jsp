<%@ page contentType="text/html; charset=KSC5601" %>
<%@ page language="java" import="java.sql.*,java.util.*,javax.servlet.http.* "%>
<%!
Connection DB_Connection() throws ClassNotFoundException, SQLException,Exception
{
  String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
  Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection conn=DriverManager.getConnection(url,"scott","tiger");
  return conn;
}
%>
<%
Cookie[] cookies = request.getCookies();
  String user_id ="";
  int ln=1;
  for (  ln = 0; ln < cookies.length; ln++ )  {
    if (cookies[ln].getName().equals("user_id") == true)  
      user_id = cookies[ln].getValue();
  }
Connection      conn = DB_Connection();
Statement       stmt = null;
ResultSet       rs = null;
String user_name="";
String to_id = request.getParameter("to_id");
String sql1 = " select user_name from user_info "+
              " where user_id='"+user_id+"'";
  try{
    stmt = conn.createStatement();
    rs = stmt.executeQuery(sql1);
    if(rs.next()){
      user_name=rs.getString(1);  
    }
  	stmt.close();
    rs.close();
  }catch(SQLException e){
  }
%>
<html>
<head>
<STYLE TYPE="text/css">
body  { font-size: 12px; font-family: 굴림; text-decoration: none; color: black }
td		{ font-size: 12px; font-family: 굴림; text-decoration: none; color: black }
</STYLE>

<script>
function writeCheck()
{
	var form = document.memo_form;
	if(form.memo_content.value.length==0){
		alert("내용을 입력하여 주십시요.");
		form.memo_content.focus();
		return ;
	}
	form.submit();
}
</script>
</head>
<body  topmargin=0 leftmargin=0>
<form name=memo_form method=post action="memo_insert.jsp">
<TABLE WIDTH="730" BORDER="0" CELLSPACING="0" CELLPADDING="0">
  <TR>
    <TD ALIGN=CENTER><br><br>
      <TABLE BORDER="0" WIDTH="650" CELLPADDING="0" CELLSPACING="0" ALIGN="CENTER">
		<tr bgcolor="#7baad6" valign="top"  height=20>
		  <TD WIDTH="20"><IMG SRC="u_b02.gif" VSPACE="0" HSPACE="0" ALIGN="LEFT"></TD>
		  <TD WIDTH=610 ALIGN="CENTER" VALIGN="BOTTOM"><FONT COLOR="#FFFFFF"><B>
					쪽지쓰기</B></FONT>
     	   </TD>
		   <TD WIDTH="20"><IMG SRC="u_b03.gif" ALIGN="RIGHT" VSPACE="0" HSPACE="0"></TD>
        </tr>
		<tr>
			<td align=center width=650 colspan=3>
			<table border=0 cellspacing=1 cellpadding=0 bgcolor=#7BAAD6 width=650>
				<tr height=20>
				   <td width=100 align=center bgcolor="#eff4fa">보내는 이</td>
				   <td width=550 colspan=3 bgcolor=ffffff>&nbsp;<%=user_name%>(<%=user_id%>)</td>
				</tr>	
				<tr>
				   <td width=100 align=center bgcolor="#eff4fa">받는이</td>
				   <td width=550 colspan=3 bgcolor=ffffff>&nbsp;<input type="text" name="to_id" value="<%=to_id%>" size=76 maxlength=50></td>
				</tr>	
				<tr>
				   <td width=100 align=center bgcolor="#eff4fa">내 용</td>
				   <td width=550 colspan=3 bgcolor=ffffff>
				   <table>
				      <tr>
				         <td bgcolor=ffffff width=550><textarea cols=76 rows=5 name="memo_content"></textarea></td>
				      </tr>
				   </table>
				   </td>
				</tr>
			  </table>
			</TD>
    	  </TR>
		  <TR HEIGHT=15 bgcolor="#7baad6">
		     <TD VALIGN="BOTTOM" COLSPAN="3">
		         <IMG SRC="u_b04.gif" BORDER="0" ALIGN="LEFT" VSPACE="0" HSPACE="0">
		         <IMG SRC="u_b05.gif" BORDER="0" ALIGN="RIGHT" VSPACE="0" HSPACE="0">
		       </td>
		  </TR>
		  <TR>
		   	<td colspan=3 align=right height=28 valign=bottom>
			  <a href="javascript:writeCheck()"><img src="m_bt11.gif" border=0></a>
			  <a href="javascript:history.go(-1)"><img src="m_bt12.gif" border=0></a>
		   	</td>
		  </TR>
		</table>
	  </TD>
	</TR>
</TABLE>
   <input type="hidden" name="from_id"   value="<%=user_id%>">
</form>
</body>
</html>
