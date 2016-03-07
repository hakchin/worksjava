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

String from_id=request.getParameter("from_id");	
String to_id=request.getParameter("to_id");	
String memo_content = request.getParameter("memo_content");	
	   memo_content = TO_DB(memo_content);

	try{
    	stmt = conn.createStatement();
    	String sql = " insert into memo "+
    				  " values( seq_memo.nextval "+
    				  ",'"+from_id+
    				  "','"+to_id+
    				  "','"+memo_content+
    				  "', sysdate "+
    				  ",'N')";
    	stmt.executeUpdate(sql);			  
    	stmt.close();
    }catch(SQLException e){ 
    }
%>
<html>
<head>
<script language="Javascript">
function alrim(){
	alert("<%=to_id%>님께 쪽지를 보냈습니다.")
	//location.href="send_memo_list.jsp";
}
</script>
</head>
<body onload="alrim();">
</body>
</html>
