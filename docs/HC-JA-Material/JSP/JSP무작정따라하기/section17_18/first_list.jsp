<%@ page language="java" import="java.util.*" %>
<%
	String userid="";//����� ���� �ʱ�ȭ
	String passwd="";//����� ���� �ʱ�ȭ
	String cookie_userid="";//����� ���� �ʱ�ȭ
	if(request.getParameter("userid")!=null){
		userid=request.getParameter("userid");
	}
	if(request.getParameter("passwd")!=null){
		passwd=request.getParameter("passwd");
	}
	if(userid.length()==0){
	Cookie[] cookies = request.getCookies();
		for ( int i = 0; i < cookies.length; i++ ) {
			if (cookies[i].getName().equals("userid") == true){
   				cookie_userid = cookies[i].getValue();
   				if(cookie_userid.equals("buybook")) userid = cookie_userid;
   			}
   		}
	}
%>
<html>
<head>
<title>���� ���θ��� ���� ���� ȯ���մϴ�. </title>
 
<SCRIPT LANGUAGE="JavaScript">
<!--
function go_login(){
  if(document.login.userid.value.length<=0){
    alert("User ID�� �Է��Ͻʽÿ�");
    document.login.userid.focus();
  }
  else if(document.login.passwd.value.length <= 0){
   alert("Password�� �Է��Ͽ� �ֽʽÿ�");
   document.login.passwd.focus();
  }
  else{
  	document.login.submit();
  }
}
function put_baguni(bookid){
	var id='<%=userid%>';
	var bid=bookid
	if(id=='buybook'){
		document.baguni.elements[bid].value="put";
		document.baguni.submit();
	}else{
		alert("�α����� �Ͽ� �ֽʽÿ�");
	}
}
//-->
</SCRIPT>
</head>
<body>
<table width=600 border=0>
<tr><td>
<%if(userid.length()==0)
{
%>
<form name="login" method="post" action="first_list.jsp">
  <table cellpadding=0 cellspacing=0 border=0>
    <tr>
      <td>���̵�:</td>
      <td><input type="text" name="userid" size=8 maxlength=12></td>
      <td width=20></td>
      <td>�н�����:</td>
      <td><input type="password" name="passwd" size=8 >
         <a href="javascript:go_login()">[�α���]</a>
      </td>
    </tr>
  </table>
</form>
<%
}else if(cookie_userid.equals("buybook")){
	userid=cookie_userid;
%>
  <table cellpadding=0 cellspacing=0 border=0>
    <tr>
      <td><%=cookie_userid%>�� ȯ���մϴ�.</td>
    </tr>
  </table>
<%
}else if(userid.equals("buybook") && passwd.equals("buybook")){
%>
  <table cellpadding=0 cellspacing=0 border=0>
    <tr>
      <td><%=userid%>�� ȯ���մϴ�.</td>
    </tr>
  </table>
<%
}else{
%>
	<script>
		alert("���̵� �Ǵ� �н����尡 Ʋ���ϴ�.");
		history.go(-1);
	</script>
<%
}
%>
</td></tr>
<tr><td>
  <table width=600 cellpadding=3 cellspacing=0 border=0 align="center" >
    <tr>
      <td colspan=3 align=center><font color=red><b>���θ� ����Ʈ</b></font></td>
    </tr>
    <tr>
      <td width=300> <b>����</b>
      </td>
      <td width=150> <b>����</b>
      </td>
      <td width=150> <b>��ٱ��� ���</b>
      </td>
    </tr>
    <tr>
      <td> <font color=blue>�ڹٸ� ��ƶ�</font></td>
      <td>10,000��</td>
      <td> <a href="javascript:put_baguni('0')">[��ٱ��� ���]</a></td>
    </tr>
    <tr>
      <td> <font color=blue>��濡�� ���� JSP</font></td>
      <td>15,000��</td>
      <td> <a href="javascript:put_baguni('1')">[��ٱ��� ���]</a></td>
    </tr>
    <tr>
      <td> <font color=blue>JSP ������ �������</font></td>
      <td>20,000��</td>
      <td> <a href="javascript:put_baguni('2')">[��ٱ��� ���]</a></td>
    </tr>
    <tr>
      <td> <font color=blue>�ڹ� ���� JSP �Ѵ�</font></td>
      <td>25,000��</td>
      <td> <a href="javascript:put_baguni('3')">[��ٱ��� ���]</a></td>
    </tr>
    <tr>
      <td> <font color=blue>JSP�� ���θ� �����ϱ�</font></td>
      <td>30,000��</td>
      <td> <a href="javascript:put_baguni('4')">[��ٱ��� ���]</a></td>
    </tr>
  </table>
</tr></td>
</table>
<form name="baguni" method="post" action="put_baguni.jsp">
<%
 for(int i=0;i<=4;i++){
%>
<input type=hidden name="book<%=i%>" >
<%
 }
%>
<input type=hidden name="userid" value="<%=userid%>">
</form>
</body>
</html>
