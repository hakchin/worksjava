<%@ page language="java" import="java.util.*" %>
<%
	String userid=request.getParameter("userid");
	String passwd=request.getParameter("passwd");
%>
<html>
<head>
<title>ȸ������</title>
<meta http-equiiv="Content-Type" content="text/html" charset=euc-kr">
<SCRIPT LANGUAGE="JavaScript">
function fail_login(){
	var userid="<%=userid%>";               
  	var passwd="<%=passwd%>";
  	if(userid!="webmaster") {
    	alert("�α��� ���̵� Ʋ���ϴ�.");
    	history.go(-1);
  	}
  	else if(passwd!="manager") {
    	alert("��й�ȣ�� Ʋ���ϴ�.");
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
   <%=userid%>���� �α����Ͻô� �� �����ϼ̽��ϴ�.
<%
   }
%>    
</body>
</html>
