<%@ page language="java" contentType="text/html;charset=euc-kr" %>
<%@ page import="java.util.*, java.text.*" %>
<html>
<head>
<title>selectbox test</title>
<body>
<%
      String checks = request.getParameter("curjob");
      if(checks.equals("1")) {
   %>
    ����� ������ �����Դϴ�
   <%
      }
      else if(checks.equals("2")){
   %>
     ����� ������ ����Դϴ�.
   <%
      }
      else if(checks.equals("3")){
   %>
     ����� ������ �����Դϴ�.
      <%
      }
      else if(checks.equals("4")){
   %>
     ����� ������ ������Դϴ�.
       <%
      }
      else if(checks.equals("5")){
   %>
     ����� ������ �ѷ��Դϴ�.
       <%
      }
      else if(checks.equals("6")){
   %>
     ����� ������ �ݰ��Դϴ�.
       <%
      }
      else if(checks.equals("7")){
   %>
     ����� ������ �����Դϴ�.

 <%
      }
      else if(checks.equals("8")){
   %>
     ����� ������ �Ͽ콺 �������Դϴ�.
   <%
      }
      else if(checks.equals("9")){
   %>
     ����� ������ �����Դϴ�.
      <%
      }
      else if(checks.equals("0")){
   %>
     ����� ������ ��Ÿ�Դϴ�.
  <%
     }
  %>
 </body>
 </html>
