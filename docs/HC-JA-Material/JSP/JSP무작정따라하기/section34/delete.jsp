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
String passwd = request.getParameter("passwd");
String db_passwd="";
String confirm_yn="N";
	
	try{
    	stmt = conn.createStatement();
    	String sql0=" select passwd from board "+
    	             " where articleid="+articleid;
    	rs = stmt.executeQuery(sql0);
    	if(rs.next()){
    		db_passwd=rs.getString(1);
    	}
    	if(passwd.equals(db_passwd)){
    		confirm_yn="Y";
    	}
    	if(confirm_yn.equals("Y")){
    		String sql = " delete board  "+
    	    			  " where articleid="+articleid;
    		stmt.executeUpdate(sql);			  
    	}
    	rs.close();
    	stmt.close();
    }catch(SQLException e){ 
    }
%>
<html>
<head>
<script language="Javascript">
function alrim(){
    var confirm_yn='<%=confirm_yn%>';
	if(confirm_yn=='Y'){
		alert("성공적으로 삭제하였습니다.")
		location.href="../section31/list.jsp";
	} else{
		alert("비밀번호가 일치하지 않습니다.");
		history.go(-1);
	}
}
</script>
</head>
<body onload="alrim();">
</body>
</html>
