<%@ page import="java.util.*, java.text.*" %>
<%@ page language="java" contentType="text/html;charset=euc-kr" %>
<HTML>
<HEAD><TITLE>����ð�</TITLE></HEAD>
<BODY>
���ݽð���<p>
<%
Date now = new Date();
out.println(now);
out.println("�Դϴ�<p>");
out.println(DateFormat.getTimeInstance().format(now));
out.println("�Դϴ�");
%>
</BODY>
</HTML>
