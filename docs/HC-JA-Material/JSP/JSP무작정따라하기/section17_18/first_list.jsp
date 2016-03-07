<%@ page language="java" import="java.util.*" %>
<%
	String userid="";//사용할 변수 초기화
	String passwd="";//사용할 변수 초기화
	String cookie_userid="";//사용할 변수 초기화
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
<title>저희 쇼핑몰에 오신 것을 환영합니다. </title>
 
<SCRIPT LANGUAGE="JavaScript">
<!--
function go_login(){
  if(document.login.userid.value.length<=0){
    alert("User ID를 입력하십시오");
    document.login.userid.focus();
  }
  else if(document.login.passwd.value.length <= 0){
   alert("Password를 입력하여 주십시오");
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
		alert("로그인을 하여 주십시오");
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
      <td>아이디:</td>
      <td><input type="text" name="userid" size=8 maxlength=12></td>
      <td width=20></td>
      <td>패스워드:</td>
      <td><input type="password" name="passwd" size=8 >
         <a href="javascript:go_login()">[로그인]</a>
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
      <td><%=cookie_userid%>님 환영합니다.</td>
    </tr>
  </table>
<%
}else if(userid.equals("buybook") && passwd.equals("buybook")){
%>
  <table cellpadding=0 cellspacing=0 border=0>
    <tr>
      <td><%=userid%>님 환영합니다.</td>
    </tr>
  </table>
<%
}else{
%>
	<script>
		alert("아이디 또는 패스워드가 틀립니다.");
		history.go(-1);
	</script>
<%
}
%>
</td></tr>
<tr><td>
  <table width=600 cellpadding=3 cellspacing=0 border=0 align="center" >
    <tr>
      <td colspan=3 align=center><font color=red><b>쇼핑몰 리스트</b></font></td>
    </tr>
    <tr>
      <td width=300> <b>제목</b>
      </td>
      <td width=150> <b>가격</b>
      </td>
      <td width=150> <b>장바구니 담기</b>
      </td>
    </tr>
    <tr>
      <td> <font color=blue>자바를 잡아라</font></td>
      <td>10,000원</td>
      <td> <a href="javascript:put_baguni('0')">[장바구니 담기]</a></td>
    </tr>
    <tr>
      <td> <font color=blue>골방에서 배우는 JSP</font></td>
      <td>15,000원</td>
      <td> <a href="javascript:put_baguni('1')">[장바구니 담기]</a></td>
    </tr>
    <tr>
      <td> <font color=blue>JSP 무작정 따라잡기</font></td>
      <td>20,000원</td>
      <td> <a href="javascript:put_baguni('2')">[장바구니 담기]</a></td>
    </tr>
    <tr>
      <td> <font color=blue>자바 몰라도 JSP 한다</font></td>
      <td>25,000원</td>
      <td> <a href="javascript:put_baguni('3')">[장바구니 담기]</a></td>
    </tr>
    <tr>
      <td> <font color=blue>JSP로 쇼핑몰 구축하기</font></td>
      <td>30,000원</td>
      <td> <a href="javascript:put_baguni('4')">[장바구니 담기]</a></td>
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
