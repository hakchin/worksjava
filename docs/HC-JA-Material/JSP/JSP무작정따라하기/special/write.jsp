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
ResultSet rs;
String title=request.getParameter("title");	
	   title = TO_DB(title);
String start_year=request.getParameter("start_year");	
String start_month=request.getParameter("start_month");	
String start_day = request.getParameter("start_day");	
String start_date = start_year+start_month+start_day;
String contents=request.getParameter("contents");	
	   contents = TO_DB(contents);
String sql_date = " select to_char(sysdate,'yyyy'), to_char(sysdate,'mm') "+
	        " from dual ";
String this_year="";
String this_month="";
	try{
    	stmt = conn.createStatement();
    	
    	String sql = " insert into schedule "+
    		   " values( seq_schedule.nextval "+
    		   ",'"+title+
    		   "','"+start_date+
    		   "','"+contents+"')";
    	System.out.println(sql);  
    	stmt.executeUpdate(sql);	
    	System.out.println(sql_date);  
    	rs = stmt.executeQuery(sql_date);
    	rs.next();
    	this_year = rs.getString(1);
    	this_month= rs.getString(2);
    	stmt.close();
    }catch(SQLException e){ 
    	System.out.println(e.getMessage());
    }
%>
<html>
<head>
<script language="Javascript">
function alrim(){
	alert("성공적으로 등록하였습니다.")
	location.href="month.jsp?start_year=<%=this_year%>&start_month=<%=this_month%>&opt=0";
}
</script>
</head>
<body onload="alrim();">
</body>
</html>
