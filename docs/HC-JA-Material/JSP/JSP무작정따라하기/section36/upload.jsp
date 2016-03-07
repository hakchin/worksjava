<%@ page contentType="text/html; charset=KSC5601" %>
<%@ page language="java" import="java.sql.*,java.util.*,java.io.*,javax.servlet.*,javax.servlet.http.* "%>
<%@ include file="fileUpload.jsp" %>
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

fileUpload fu = new fileUpload();
fu.readForm(request,response);
String title = fu.getParameter("title");	
	   title = TO_DB(title);
String file_name=fu.getParameter("file_name");	
	   file_name = TO_DB(file_name);

	try{
    	stmt = conn.createStatement();
    	
    	String sql = " insert into file_upload (title,file_name) "+
    				 " values ('"+title+"','"+file_name+"')";
    	stmt.executeUpdate(sql);			  
    	stmt.close();
    }catch(SQLException e){
    }
%>
<html>
<head>
<script language="Javascript">
function alrim(){
	alert("성공적으로 등록하였습니다.")
	location.href="../section37/file_list.jsp";
}
</script>
</head>
<body onload="alrim();">
</body>
</html>
