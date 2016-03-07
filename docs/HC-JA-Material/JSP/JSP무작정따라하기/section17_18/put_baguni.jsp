<%@ page language="java" import="java.util.*" %>
<%
String book[]= new String[5];
  book[0] = request.getParameter("book0");
  book[1] = request.getParameter("book1");
  book[2] = request.getParameter("book2");
  book[3] = request.getParameter("book3");
  book[4] = request.getParameter("book4");
String userid = request.getParameter("userid");
if(book[0].length()!=0){
	Cookie cookie0 = new Cookie("book0",book[0]);
	response.addCookie(cookie0);
}
if(book[1].length()!=0){
	Cookie cookie1 = new Cookie("book1",book[1]);
	response.addCookie(cookie1);
}
if(book[2].length()!=0){
	Cookie cookie2 = new Cookie("book2",book[2]);
	response.addCookie(cookie2);
}
if(book[3].length()!=0){
	Cookie cookie3 = new Cookie("book3",book[3]);
	response.addCookie(cookie3);
}
if(book[4].length()!=0){
	Cookie cookie4 = new Cookie("book4",book[4]);
	response.addCookie(cookie4);
}
	Cookie cookie = new Cookie("userid",userid);
	response.addCookie(cookie);

%>  
<html>
<head>
<script language="javascript">
function go_my_baguni(){
	location.href="my_baguni.jsp";
}
</script>
</head>
<body onload="go_my_baguni();">
</body>
</html>