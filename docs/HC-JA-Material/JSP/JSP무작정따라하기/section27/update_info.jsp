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

String user_name=request.getParameter("user_name");	
	   user_name = TO_DB(user_name);
String security_id1=request.getParameter("security_id1");	
String security_id2=request.getParameter("security_id2");	
String user_id=request.getParameter("user_id");	
String passwd=request.getParameter("passwd");	
String addr_gubun = request.getParameter("addr_gubun");	
String zip1=request.getParameter("zip1");	
String zip2=request.getParameter("zip2");			
String address=request.getParameter("address");	
	   address = TO_DB(address);
String tel1=request.getParameter("tel1");	
String tel2=request.getParameter("tel2");	
String tel3=request.getParameter("tel3");	
String hand_tel1=request.getParameter("hand_tel1");	
String hand_tel2=request.getParameter("hand_tel2");	
String hand_tel3=request.getParameter("hand_tel3");	
String e_mail=request.getParameter("e_mail");	
String open_yn=request.getParameter("open_yn");	
String job_type=request.getParameter("job_type");
	   job_type=TO_DB(job_type);
String intro = request.getParameter("intro");
	   intro = TO_DB(intro);
	try{
    	stmt = conn.createStatement();
    	String sql = " update  user_info "+
    		  "  set user_name='"+user_name+
    		  "', security_id1='"+security_id1+
    		  "', security_id2='"+security_id2+
    		  "', passwd='"+passwd+
    		  "', addr_gubun='"+addr_gubun+
    		  "', zip1='"+zip1+
    		  "', zip2='"+zip2+
    		  "', address='"+address+
    		  "', tel1='"+tel1+
    		  "', tel2='"+tel2+
    		  "', tel3='"+tel3+
    		  "', hand_tel1='"+hand_tel1+
    		  "', hand_tel2='"+hand_tel2+
    		  "', hand_tel3='"+hand_tel3+
    		  "', e_mail='"+e_mail+
    		  "', open_yn='"+open_yn+
    		  "', job_type='"+job_type+
    		  "', intro='"+intro+
	          "' where user_id='"+user_id+"'"; 			
	     
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
	location.href="view_info.jsp?user_id=<%=user_id%>";
}
</script>
</head>
<body onload="alrim();">
</body>
</html>
