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
    당신의 직업은 무직입니다
   <%
      }
      else if(checks.equals("2")){
   %>
     당신의 직업은 백수입니다.
   <%
      }
      else if(checks.equals("3")){
   %>
     당신의 직업은 도둑입니다.
      <%
      }
      else if(checks.equals("4")){
   %>
     당신의 직업은 대통령입니다.
       <%
      }
      else if(checks.equals("5")){
   %>
     당신의 직업은 한량입니다.
       <%
      }
      else if(checks.equals("6")){
   %>
     당신의 직업은 콜걸입니다.
       <%
      }
      else if(checks.equals("7")){
   %>
     당신의 직업은 사기꾼입니다.

 <%
      }
      else if(checks.equals("8")){
   %>
     당신의 직업은 하우스 관리자입니다.
   <%
      }
      else if(checks.equals("9")){
   %>
     당신의 직업은 조폭입니다.
      <%
      }
      else if(checks.equals("0")){
   %>
     당신의 직업은 기타입니다.
  <%
     }
  %>
 </body>
 </html>
