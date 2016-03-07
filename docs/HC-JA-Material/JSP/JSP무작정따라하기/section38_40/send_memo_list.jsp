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

Vector v_no = new Vector();
Vector v_to_id = new Vector();
Vector v_memo_content = new Vector();
Vector v_create_date = new Vector();
Vector v_read_yn = new Vector();
Vector v_to_user_name = new Vector();
String sql1 = " select "+
			  " a.no,a.to_id,a.memo_content,"+
			  " to_char(a.create_date,'yyyy/mm/dd hh:mi'),a.read_yn, b.user_name "+
			  " from memo a,user_info b"+
			  " where a.from_id='"+user_id+"' "+
			  " and b.user_id = a.to_id"+
			  " order by no desc";
try{
	stmt = conn.createStatement();
    rs = stmt.executeQuery(sql1);
    
    while(rs.next()){
    	v_no.addElement(Integer.toString(rs.getInt(1)));
    	v_to_id.addElement(rs.getString(2));
    	String temp_memo_content="";
    	String memo_content=rs.getString(3);
    	StringTokenizer st = new StringTokenizer(memo_content,"\n");
    	while(st.hasMoreTokens()){
    		temp_memo_content = temp_memo_content +st.nextToken()+"<br>";
    	}
    	v_memo_content.addElement(temp_memo_content);
    	v_create_date.addElement(rs.getString(4));
    	v_read_yn.addElement(rs.getString(5));
    	v_to_user_name.addElement(rs.getString(6));
	}
	
	stmt.close();
    rs.close();
}catch(SQLException e){
}
%>
<html>
<head>
<STYLE TYPE="text/css" MEDIA="screen">
body  { font-size: 12px; font-family: 굴림; text-decoration: none; color: black }
th		{ font-size: 12px; font-family: 굴림; text-decoration: none; color: white }
td		{ font-size: 12px; font-family: 굴림; text-decoration: none; color: black }
a 		{ font-family: "굴림", "Verdana"; color: #000000; text-decoration: none }
  			a:link { font-family:굴림; font-size:9pt; text-decoration:none;}
  			a:visited { font-family:굴림; font-size:9pt; text-decoration:none;}
  			a:hover { font-family:굴림; text-decoration:underline ;}

</STYLE>
</head>
<body  topmargin=0 leftmargin=0>
<form name=board_search method=post>
<br>
<table width=730 border=0 cellspacing=0 cellpadding=0>
<tr>
	<td width=730 align=center>
		<table width=650 border=0 cellspacing=0 cellpadding=0>
		<tr bgcolor="#7baad6" height=21>
			<td width=10  valign=bottom align="left"><img src="u_b02.gif" border="0" align=absmiddle></td>
            <td align=center><FONT COLOR="#FFFFFF"><b>쪽지보기</b></FONT></td>
			<td width=10  valign=bottom align= right><img src="u_b03.gif" border="0" align=absmiddle></td>
		</tr>
		</table>
		<!-- 내  용 -->
		<table width=650 bgcolor=#7BAAD6 cellpadding=4 cellspacing=1 border=0>
		<%
			for(int j=0;j<v_no.size();j++){
		%>
		  <tr bgcolor=ffffff>
			 <td width=100 align=center bgcolor="#eff4fa">받는이
			 </td>
			 <td width=200 align="left">&nbsp;
			     <%=v_to_user_name.elementAt(j)%>(<%=v_to_id.elementAt(j)%>)
			  </td>
			  <td width=100 align=center bgcolor="#eff4fa">보낸시간
			 </td>
			 <td width=250 align="left">&nbsp;
			     <%=v_create_date.elementAt(j)%>
			  </td>
		  </tr>
		  <tr bgcolor=ffffff>
			 <td width=100 align=center bgcolor="#eff4fa">내용
			 </td>
			 <td width=550 align="left" colspan=3>&nbsp;
			     <%=v_memo_content.elementAt(j)%>
			  </td>
		  </tr>
		  <tr bgcolor=ffffff>
			 <td width=650 colspan=4 align=center bgcolor="#eff4fa">
			   <%
			    if(v_read_yn.elementAt(j).toString().equals("Y")){
			      out.println("<font color=blue>"+v_to_id.elementAt(j)+"님께서 쪽지를 읽으셨습니다.</font>");
			    }else{
			      out.println("<font color=blue>"+v_to_id.elementAt(j)+"님께서 아직 쪽지를 개봉하지 않았습니다.</font>");
			    }
			   %>
			 </td>
		  </tr>
		<%
			}
		%>
		</table>
		
		<table width=650 BGCOLOR=000000 border=0 cellpadding=0 cellspacing=0>
		<tr  bgcolor="#7baad6" height=5>
		    <td colspan=4 align="center" valign="bottom">
		      <img src="u_b04.gif" border="0" align="left" hspace="0" vspace="0">
		      <img src="u_b05.gif" border="0" align="right" hspace="0" vspace="0">
		    </td>
		</tr>
		</table>
</form>
</tr>
</table>
</body>
</html>