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
String user_id_yn = "Y";
String sec_no_yn = "Y";
int user_id_cnt=0;
int sec_no_cnt=0;
	try{
    	stmt = conn.createStatement();
    	String sql_user_id  = " select count(*) from user_info "+
    		       	      " where user_id='"+user_id+"'";
    	String sql_sec_no = " select count(*) from user_info "+
    		       	    " where security_id1='"+security_id1+"'"+
    		       	    " and security_id2='"+security_id2+"'";
    	String sql = " insert into user_info "+
    				  " ( user_name,security_id1,security_id2, "+
    				  " user_id, passwd, addr_gubun, "+
    				  " zip1,zip2,address, "+
    				  " tel1,tel2,tel3,"+
    				  " hand_tel1,hand_tel2,hand_tel3,"+
    				  " e_mail,open_yn,job_type,"+
    				  " intro,joining_time )"+
    				  " values('"+user_name+
    				  "','"+security_id1+
    				  "','"+security_id2+
    				  "','"+user_id+
    				  "','"+passwd+
    				  "','"+addr_gubun+
    				  "','"+zip1+
    				  "','"+zip2+
    				  "','"+address+
    				  "','"+tel1+
    				  "','"+tel2+
    				  "','"+tel3+
    				  "','"+hand_tel1+
    				  "','"+hand_tel2+
    				  "','"+hand_tel3+
    				  "','"+e_mail+
    				  "','"+open_yn+
    				  "','"+job_type+
    				  "','"+intro+
    				  "', sysdate)";
    	rs = stmt.executeQuery(sql_user_id);
    	if(rs.next()){
    	     user_id_cnt = rs.getInt(1);
    		if( user_id_cnt> 0) user_id_yn="N";
    	}
    	rs = stmt.executeQuery(sql_sec_no);
    	if(rs.next()){
    	     sec_no_cnt = rs.getInt(1);
    		if( sec_no_cnt > 0) sec_no_yn="N";
    	}
    	if( user_id_cnt==0 && sec_no_cnt==0){
    		stmt.executeUpdate(sql);			  
    	}
    	stmt.close();
    }catch(SQLException e){
    }
%>
<html>
<head>
<script language="Javascript">
function alrim(){
	var user_id_yn ='<%=user_id_yn%>';
	var sec_no_yn = '<%=sec_no_yn%>';
	if(user_id_yn =='N'){
	    alert("이미 존재하는 아이디입니다.")
	    history.go(-1);
	}else if( sec_no_yn =='N'){
	    alert("이미 등록된 주민등록번호입니다.")
	    history.go(-1);
	} else{
	   alert("성공적으로 등록하였습니다.")
	   location.href="../section26/login_form.jsp";
	}
}
</script>
</head>
<body onload="alrim();">
</body>
</html>
