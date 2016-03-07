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
Connection      conn = DB_Connection();
Statement       stmt = null;
ResultSet       rs = null;
String articleid = request.getParameter("articleid");
String description = "";
			
String sql1 = " select  description from board"+
			  " where articleid ="+articleid;
	try{
    	stmt = conn.createStatement();
    	rs = stmt.executeQuery(sql1);
    	if(rs.next()){
    	  description = rs.getString(1);
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
th		{ font-size: 12px; font-family: 굴림; text-decoration: none; color: white }
td		{ font-size: 12px; font-family: 굴림; text-decoration: none; color: black }
a 		{ font-family: "굴림", "Verdana"; color: #000000; text-decoration: none }
		a:link { font-family:굴림; font-size:9pt; text-decoration:none;}
		a:visited { font-family:굴림; font-size:9pt; text-decoration:none;}
		a:hover { font-family:굴림; text-decoration:underline ;}
.term {  line-height: 20px}
</STYLE>
<script>
function go_reply()
{
	var form = document.reply_form;
	
	if(!form.title.value){
		alert("제목을 입력하세요.");
		form.title.focus();
		return ;
	}
	if(!form.passwd.value){
		alert("암호를 입력하세요");
		form.passwd.focus();
		return ;
	}
	if(!form.user_name.value){
		alert("이름을 입력하세요");
		form.user_name.focus();
		return ;
	}
	if(!form.description.value){
		alert("내용을 입력하세요.");
		form.description.focus();
		return;
	}
	form.submit();
}

</script>
</head>
<body  topmargin=0 leftmargin=0>
<TABLE WIDTH="730" BORDER="0" CELLSPACING="0" CELLPADDING="0">
  <TR>
    <TD ALIGN=CENTER><br><br>
<form method="post" name="reply_form" action="reply.jsp">
      <TABLE BORDER="0" WIDTH="650" CELLPADDING="0" CELLSPACING="0" ALIGN="CENTER">
		<tr bgcolor="#7baad6" valign="top"  height=20>
		  <TD WIDTH="20"><IMG SRC="h_b02.gif" VSPACE="0" HSPACE="0" ALIGN="LEFT"></TD>
		  <TD WIDTH=610 ALIGN="CENTER" VALIGN="BOTTOM"><FONT COLOR="#FFFFFF"><B>
					게시물 답변</B></FONT>
     	   </TD>
		   <TD WIDTH="20"><IMG SRC="f_b03.gif" ALIGN="RIGHT" VSPACE="0" HSPACE="0"></TD>
        </tr>
		<tr>
			<td align=center width=650 colspan=3>
			
			<table border=0 cellspacing=1 cellpadding=0 bgcolor=#7BAAD6 width=650>
				<tr class="term">
				   <td width=100 align=center bgcolor="#eff4fa">등록자</td>
				   <td width=225 bgcolor=ffffff>&nbsp;<input type="text" name="user_name" size=20 maxlength="10" value=""></td>
				   <td width=100 align=center bgcolor="#eff4fa">암호</td>
				   <td width=225 bgcolor=ffffff>&nbsp;<input type="password" name="passwd" size=20 maxlength="10" value="" ></td>
				</tr>	
				<tr class="term">
				   <td width=100 align=center bgcolor="#eff4fa">제 목</td>
				   <td width=550 colspan=3 bgcolor=ffffff>&nbsp;<input type="text" size=76 name="title" value="">
				   </td>
				</tr>	
				<tr class="term">
				   <td width=100 align=center bgcolor="#eff4fa">E-mail</td>
				   <td width=550 colspan=3 bgcolor=ffffff>&nbsp;<input type="text" size=76 name="e_mail" value="">
				   </td>
				</tr>	
				<tr class="term">
				   <td width=100 align=center bgcolor="#eff4fa">홈페이지</td>
				   <td width=550 colspan=3 bgcolor=ffffff>&nbsp;
				     http://<input type="text" size=70 name="home_url" value="">
				   </td>
				</tr>	
				<tr class="term">
				   <td width=100 align=center bgcolor="#eff4fa">내 용</td>
				   <td width=550 colspan=3 bgcolor=ffffff>
				   <table>
				      <tr>
				        <td>
				         <textarea cols=76 rows=17 name="description"><%out.println(description);%>-----------답글을 쓰세요----------------------</textarea>
				       </td>
				      </tr>
				   </table>
				   </td>
				</tr>
			  </table>
			</TD>
    	  </TR>
		  <TR HEIGHT=15 bgcolor="#7baad6">
		     <TD VALIGN="BOTTOM" COLSPAN="3">
		         <IMG SRC="h_b04.gif" BORDER="0" ALIGN="LEFT" VSPACE="0" HSPACE="0">
		         <IMG SRC="h_b05.gif" BORDER="0" ALIGN="RIGHT" VSPACE="0" HSPACE="0">
		       </td>
		  </TR>
		  <TR>
		   	<td colspan=3 align=right height=28 valign=bottom>
		   	  <a href="javascript:go_reply()"><img src="m_bt11.gif" border=0></a>
			  <a href="javascript:history.go(-1)"><img src="m_bt12.gif" border=0></a>
		   	</td>
		  </TR>
		</table>
	<input type="hidden" name="parent_articleid" value="<%=articleid%>">
	<input type="hidden" name="type" value="R">
</form>
	  </TD>
	</TR>
</TABLE>
</body>
</html>
