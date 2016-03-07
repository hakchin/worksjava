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

Vector v_title = new Vector();
Vector v_file_name = new Vector();

String sql1 = " select title,file_name "+
			 " from file_upload ";

	try{
    	stmt = conn.createStatement();
        rs = stmt.executeQuery(sql1);
        while(rs.next()){
        	v_title.addElement(rs.getString(1));
        	v_file_name.addElement(rs.getString(2));
    	}
    	stmt.close();
        rs.close();
    }catch(SQLException e){
    }
%>
<html>
<head>
<STYLE TYPE="text/css" MEDIA="screen">
body  { font-size: 12px; font-family: ±¼¸²; text-decoration: none; color: black }
th		{ font-size: 12px; font-family: ±¼¸²; text-decoration: none; color: white }
td		{ font-size: 12px; font-family: ±¼¸²; text-decoration: none; color: black }
a 		{ font-family: "±¼¸²", "Verdana"; color: #000000; text-decoration: none }
  			a:link { font-family:±¼¸²; font-size:9pt; text-decoration:none;}
  			a:visited { font-family:±¼¸²; font-size:9pt; text-decoration:none;}
  			a:hover { font-family:±¼¸²; text-decoration:underline ;}

</STYLE>

</head>
<body  topmargin=0 leftmargin=0>
<form name=board_search method=post>
<br>
<table width=730 border=0 cellspacing=0 cellpadding=0>
<tr>
	<td width=730 align=center>
		<table width=650 border=0 cellspacing=0 cellpadding=0>
		<tr height=20>
			<td width=10>&nbsp;</td>
			<td align=left  colspan=2>°Ô½ÃÆÇ ÀÌ¸§ : <font color="#0000FF">[ÀÚ·á´Ù¿î¹Þ±â]</font></td>
		</tr>
		</table>
		<table width=650 border=0 cellspacing=0 cellpadding=0>
		<tr bgcolor="#7baad6" height=21>
				<td width=10  valign=bottom align="left"><img src="j_b19.gif" border="0" align=absmiddle></td>
				<th width=500  valign=bottom align=center>Á¦ ¸ñ</th>
				<th width=130  valign=bottom align=center>ÆÄÀÏÀÌ¸§</th>
				<td width=10  valign=bottom align= right><img src="j_b20.gif" border="0" align=absmiddle></td>
		</tr>
		</table>
		<!-- ³»  ¿ë -->
		<table width=650 bgcolor=#7BAAD6 cellpadding=4 cellspacing=1 border=0>
		<%
			for(int j=0;j<v_title.size();j++){
		%>
		  <tr bgcolor=ffffff onMouseOver=this.style.backgroundColor='#FFF8DE'  onMouseOut=this.style.backgroundColor='#FFFFFF'>
			 <td width=510 align="left">&nbsp;
			     <%=v_title.elementAt(j)%>
			  </td>
			 <td width=140 align=center>
			  <a href="/examples/jsp/section36/down/<%=v_file_name.elementAt(j)%>"><%=v_file_name.elementAt(j)%></a>
			 </td>
		  </tr>
		<%
			}
		%>
		</table>
		
		<table width=650 BGCOLOR=000000 border=0 cellpadding=0 cellspacing=0>
		<tr  bgcolor="#7baad6" height=5>
		    <td colspan=4 align="center" valign="bottom">
		      <img src="j_b04.gif" border="0" align="left" hspace="0" vspace="0">
		      <img src="j_b05.gif" border="0" align="right" hspace="0" vspace="0">
		    </td>
		</tr>
		</table>
</form>

	</td>
</tr>
</table>
</body>
</html>