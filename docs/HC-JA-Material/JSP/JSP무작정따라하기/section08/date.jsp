<%@ page import="java.util.*, java.text.*" %>
<%@ page language="java" contentType="text/html;charset=euc-kr" %>
<HTML>
<HEAD><TITLE>현재시간</TITLE></HEAD>
<BODY>
지금시간은<p>
<%
Date now = new Date();
out.println(now);
out.println("입니다<p>");
out.println(DateFormat.getTimeInstance().format(now));
out.println("입니다");
%>
</BODY>
</HTML>
