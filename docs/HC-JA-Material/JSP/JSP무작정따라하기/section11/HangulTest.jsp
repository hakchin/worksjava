<%@page import="java.util.*" contentType="text/html;charset=euc-kr"%>
<html>
<%
String HangulValue=request.getParameter("hangulvalue");
       HangulValue = new String(HangulValue.getBytes("8859_1"),"EUC-KR");
%>
���۹��� ���� <%=HangulValue%> �Դϴ�.
</html>