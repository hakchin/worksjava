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

String no = request.getParameter("no");	
	
	try{
    	stmt = conn.createStatement();
    		String sql = " delete memo  "+
    	    			  " where no="+no;
    		stmt.executeUpdate(sql);			  
    	   	stmt.close();
    }catch(SQLException e){ 
    }
%>
<html>
<head>
<script language="Javascript">
function alrim(){
	alert("성공적으로 삭제하였습니다.")
	location.href="memo_list.jsp";
	
}
</script>
</head>
<body onload="alrim();">
</body>
</html>
