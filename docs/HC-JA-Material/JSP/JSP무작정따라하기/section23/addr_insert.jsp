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
String name=request.getParameter("name");	
	   name = TO_DB(name);
String addr=request.getParameter("addr");	
		addr = TO_DB(addr);
String home_tel_no=request.getParameter("home_tel_no");	
String com_tel_no=request.getParameter("com_tel_no");	
String hand_tel_no=request.getParameter("hand_tel_no");	

String sql1 = " select max(no) from address";	
	
	try{
    	stmt = conn.createStatement();
        rs = stmt.executeQuery(sql1);
        
        if(rs.next()){
        	no = rs.getInt(1);
    	}
    	no++;
    	String sql2 = " insert into address "+
    				  " values("+no+
    				  ",'"+name+
    				  "','"+addr+
    				  "','"+home_tel_no+
    				  "','"+com_tel_no+
    				  "','"+hand_tel_no+"')";
    	stmt.executeUpdate(sql2);			  
    	stmt.close();
        rs.close();
    }catch(SQLException e){
    }
%>
<html>
<head>
<script language="Javascript">
function alrim(){
	alert("성공적으로 등록하였습니다.")
}
</script>
</head>
<body onload="alrim();">
</body>
</html>
