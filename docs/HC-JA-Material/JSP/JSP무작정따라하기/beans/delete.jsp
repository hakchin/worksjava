<html>
 <head>
  <title>방명록 글 삭제
  </title>
 <STYLE TYPE="text/css">
  <!--
   body { font-family: 돋움, Verdana; font-size: 9pt}
   td   { font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color: #000000} 
  --->
 </STYLE>			
 <Script Language="JavaScript">
  <!--
    function unsubmit(){				
     if(document.submit_user.adminID.value=="") {
      alert("ID가 입력되지 않았습니다.");						
      return false;
    }
     if(document.submit_user.adminPass.value=="") {
     alert("Password가 입력되지 않았습니다.");
     return false;
    }
     return true;
    }
  //-->
 </Script>
 </head>
 <body background="images/r_back.gif">
  <BR><BR><BR><BR>
  <h3 align="center"><font color="#FF0066"><b>
  <%=request.getParameter("delno")%>번</b></font><font color="#336600"> 글을 삭제하겠습니다.</h3>
  <h3 align="center">관리자의 아이디와 비밀번호를 입력해 주세요.</font></h3>
  <FORM name="submit_user" METHOD=POST ACTION="delete_end.jsp?delno=<%=request.getParameter("delno")%>"
  onSubmit="return unsubmit()">
				
    <table align="center">
    <li>이 방명록은 연습용입니다.<br>
    &nbsp;&nbsp;현재 기본적으로  <br>&nbsp;&nbsp;adminID :  <font color="#0000CC">'id'</font><br>
    &nbsp;&nbsp;adminPass :  <font color="#CC0033">'pass'</font><br>로 지정되어 있습니다.
     <tr>
      <td><li></td>
      <td align="center"><font color="#0000CC">관리자 ID</font></td>
      <td><INPUT TYPE="text" NAME="adminID"></td>
     </tr>
     <tr>
      <td><li></td>
      <td align="center"><font color="#CC0033">관리자 암호</font></td>
      <td><INPUT TYPE="password" NAME="adminPass"></td>
       <INPUT TYPE="hidden" name="no" value="<%=request.getParameter("delno")%>">
     </tr>
    </table>					
    <p>
    <table  align="center">
     <tr>
      <td>							
       <INPUT TYPE="image" SRC="images/delete.gif">&nbsp;&nbsp;
       </FORM>
      </td>
      <td>
       <FORM name="new_User" METHOD=POST ACTION="list.jsp">&nbsp;&nbsp;
       <INPUT TYPE="image" SRC="images/cancel.gif">
       </FORM>
      </td>
     </tr>					
    </table>		
 </body>
</html>
