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

String title = request.getParameter("title");	
	   title = TO_DB(title);
String e_mail=request.getParameter("e_mail");	
String home_url = request.getParameter("home_url");	
String description = request.getParameter("description");	
	   description = TO_DB(description);
String articleid = request.getParameter("articleid");	
	
	try{
    	stmt = conn.createStatement();
    	
    	String sql = " update board  "+
    				  " set title='"+title+"',"+
    				  " e_mail ='"+e_mail+"',"+
    				  " home_url ='"+home_url+"',"+
    				  " description ='"+description+"'"+
    				  " where articleid="+articleid;
    	stmt.executeUpdate(sql);			  
    	stmt.close();
    }catch(SQLException e){ 
    }
%>
<html>
<head>
<script language="Javascript">
function alrim(){
	alert("성공적으로 수정하였습니다.")
	location.href="../section31/list.jsp";
}
</script>
</head>
<body onload="alrim();">
</body>
</html>
