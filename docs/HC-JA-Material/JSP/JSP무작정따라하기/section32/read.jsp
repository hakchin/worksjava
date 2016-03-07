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
String TO_DB(String str) throws Exception
{
   if(str==null)
   {
   return null;
   }
   return new String(str.getBytes("8859_1"),"KSC5601");
}
%>
<%
Connection      conn = DB_Connection();
Statement       stmt = null;
ResultSet       rs = null;
String articleid = request.getParameter("articleid");
String title="";
String user_name="";
String write_date="";
String e_mail ="";
String home_url = "";
int hits=0;
String description = "";
String temp_description="";

String sql1 = " select title,user_name,to_char(write_date,'yyyy/mm/dd hh:mi'),"+
			  " nvl(e_mail,' '),nvl(home_url,' '),hits, description from board"+
			  " where articleid ="+articleid;
	try{
    	stmt = conn.createStatement();
        rs = stmt.executeQuery(sql1);
        
        if(rs.next()){
        	title = rs.getString(1);
        	user_name= rs.getString(2);
        	write_date = rs.getString(3);
        	e_mail = rs.getString(4);
        	home_url = rs.getString(5);
        	hits = rs.getInt(6);
        	description = rs.getString(7);
        }
        
        StringTokenizer st = new StringTokenizer(description,"\n");
        while(st.hasMoreTokens()){
        	temp_description = temp_description +st.nextToken()+"<br>";
        }
        description = temp_description;
        int plus_hits=hits+1;
        String sql2 = " update board "+
        			  " set hits ="+Integer.toString(plus_hits)+
        			  " where articleid ="+ articleid;
        stmt.executeUpdate(sql2);
        
    	stmt.close();
        rs.close();
    }catch(SQLException e){
    	
    }
%>
<html>
<head>
<STYLE TYPE="text/css">
body  { font-size: 12px; font-family: ±¼¸²; text-decoration: none; color: black }
th		{ font-size: 12px; font-family: ±¼¸²; text-decoration: none; color: white }
td		{ font-size: 12px; font-family: ±¼¸²; text-decoration: none; color: black }
a 		{ font-family: "±¼¸²", "Verdana"; color: #000000; text-decoration: none }
		a:link { font-family:±¼¸²; font-size:9pt; text-decoration:none;}
		a:visited { font-family:±¼¸²; font-size:9pt; text-decoration:none;}
		a:hover { font-family:±¼¸²; text-decoration:underline ;}
.term {  line-height: 20px}
</STYLE>
<script>

</script>
</head>
<body  topmargin=0 leftmargin=0>
<TABLE WIDTH="730" BORDER="0" CELLSPACING="0" CELLPADDING="0">
  <TR>
    <TD ALIGN=CENTER><br><br>
      <TABLE BORDER="0" WIDTH="650" CELLPADDING="0" CELLSPACING="0" ALIGN="CENTER">
		<tr bgcolor="#7baad6" valign="top"  height=20>
		  <TD WIDTH="20"><IMG SRC="j_b19.gif" VSPACE="0" HSPACE="0" ALIGN="LEFT"></TD>
		  <TD WIDTH=610 ALIGN="CENTER" VALIGN="BOTTOM"><FONT COLOR="#FFFFFF"><B>
					°Ô½Ã¹° ÀÐ±â</B></FONT>
     	   </TD>
		   <TD WIDTH="20"><IMG SRC="j_b20.gif" ALIGN="RIGHT" VSPACE="0" HSPACE="0"></TD>
        </tr>
		<tr>
			<td align=center width=650 colspan=3>
			<table border=0 cellspacing=1 cellpadding=0 bgcolor=#7BAAD6 width=650>
				<tr class="term">
				   <td width=100 align=center bgcolor="#eff4fa">µî·ÏÀÚ</td>
				   <td width=225 bgcolor=ffffff>&nbsp;<%=user_name%></td>
				   <td width=100 align=center bgcolor="#eff4fa">µî·Ï³¯Â¥</td>
				   <td width=225 bgcolor=ffffff>&nbsp;
				   <%=write_date%>
				   </td>
				</tr>	
				<tr class="term">
				   <td width=100 align=center bgcolor="#eff4fa">Á¦ ¸ñ</td>
				   <td width=550 colspan=3 bgcolor=ffffff>&nbsp;<%=title%></td>
				</tr>	
				<tr class="term">
				   <td width=100 align=center bgcolor="#eff4fa">E-mail</td>
				   <td width=550 colspan=3 bgcolor=ffffff>&nbsp;
				    <a href="mailto:<%=e_mail%>"><%=e_mail%></a></td>
				</tr>	
				<tr class="term">
				   <td width=100 align=center bgcolor="#eff4fa">È¨ÆäÀÌÁö</td>
				   <td width=550 colspan=3 bgcolor=ffffff>&nbsp;
				    <a href="http://<%=home_url%>" target=new>http://<%=home_url%></a></td>
				</tr>	
				<tr class="term">
				   <td width=100 align=center bgcolor="#eff4fa">³» ¿ë</td>
				   <td width=550 colspan=3 bgcolor=ffffff>
				   <table>
				      <tr>
				         <td bgcolor=ffffff width=550><%=description%></td>
				      </tr>
				   </table>
				   </td>
				</tr>
			  </table>
			</TD>
    	  </TR>
		  <TR HEIGHT=15 bgcolor="#7baad6">
		     <TD VALIGN="BOTTOM" COLSPAN="3">
		         <IMG SRC="j_b04.gif" BORDER="0" ALIGN="LEFT" VSPACE="0" HSPACE="0">
		         <IMG SRC="j_b05.gif" BORDER="0" ALIGN="RIGHT" VSPACE="0" HSPACE="0">
		       </td>
		  </TR>
		  <TR>
		   	<td colspan=3 align=right height=28 valign=bottom>
		   	  <img src="j_bt07.gif" border=0>
			  <img src="j_bt08.gif" border=0>
			  <img src="j_bt09.gif" border=0>
			  <a href="javascript:history.go(-1)"><img src="m_bt06.gif" border=0></a>
		   	</td>
		  </TR>
		</table>
	  </TD>
	</TR>
</TABLE>
</body>
</html>
