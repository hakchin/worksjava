<%@ page language="java" import="java.util.*" %>
<%
	String userid=request.getParameter("userid");
	String passwd=request.getParameter("passwd");
%>
<html>
<head>
<title>회원인증</title>
<meta http-equiiv="Content-Type" content="text/html" charset=euc-kr">
<SCRIPT LANGUAGE="JavaScript">
function fail_login(){
	var userid="<%=userid%>";               
  	var passwd="<%=passwd%>";
  	if(userid!="webmaster") {
    	alert("로그인 아이디가 틀립니다.");
    	history.go(-1);
  	}
  	else if(passwd!="manager") {
    	alert("비밀번호가 틀립니다.");
    	history.go(-1);
  	}
}
</SCRIPT>
</head>
<body onload=fail_login();>
<%
   if(userid.equals("webmaster") && passwd.equals("manager"))
   {
%>
   <%=userid%>님은 로그인하시는 데 성공하셨습니다.
<%
   }
%>    
</body>
</html>
