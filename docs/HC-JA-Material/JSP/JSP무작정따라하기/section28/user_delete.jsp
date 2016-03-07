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

int no=0;
String user_id=request.getParameter("user_id");	
String del_id=request.getParameter("del_id");	
	   
String sql1 = " delete user_info"+
			  " where user_id='"+del_id+"'";	
	
	try{
    	stmt = conn.createStatement();
        stmt.executeUpdate(sql1);
    	stmt.close();
    }catch(SQLException e){
    }
%>
<html>
<head>
<script language="Javascript">
function alrim(){
	alert("<%=del_id%>를 삭제하였습니다.")
	location.href="user_list.jsp?user_id=<%=user_id%>";
}
</script>
</head>
<body onload="alrim();">
</body>
</html>
