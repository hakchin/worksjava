<%@page import="java.util.*" contentType="text/html;charset=euc-kr"%>
<html>
<%
String HangulValue=request.getParameter("hangulvalue");
       HangulValue = new String(HangulValue.getBytes("8859_1"),"EUC-KR");
%>
전송받은 값은 <%=HangulValue%> 입니다.
</html>