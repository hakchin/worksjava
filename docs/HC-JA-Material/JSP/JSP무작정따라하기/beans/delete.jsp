<html>
 <head>
  <title>���� �� ����
  </title>
 <STYLE TYPE="text/css">
  <!--
   body { font-family: ����, Verdana; font-size: 9pt}
   td   { font-family: ����, Verdana; font-size: 9pt; text-decoration: none; color: #000000} 
  --->
 </STYLE>			
 <Script Language="JavaScript">
  <!--
    function unsubmit(){				
     if(document.submit_user.adminID.value=="") {
      alert("ID�� �Էµ��� �ʾҽ��ϴ�.");						
      return false;
    }
     if(document.submit_user.adminPass.value=="") {
     alert("Password�� �Էµ��� �ʾҽ��ϴ�.");
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
  <%=request.getParameter("delno")%>��</b></font><font color="#336600"> ���� �����ϰڽ��ϴ�.</h3>
  <h3 align="center">�������� ���̵�� ��й�ȣ�� �Է��� �ּ���.</font></h3>
  <FORM name="submit_user" METHOD=POST ACTION="delete_end.jsp?delno=<%=request.getParameter("delno")%>"
  onSubmit="return unsubmit()">
				
    <table align="center">
    <li>�� ������ �������Դϴ�.<br>
    &nbsp;&nbsp;���� �⺻������  <br>&nbsp;&nbsp;adminID :  <font color="#0000CC">'id'</font><br>
    &nbsp;&nbsp;adminPass :  <font color="#CC0033">'pass'</font><br>�� �����Ǿ� �ֽ��ϴ�.
     <tr>
      <td><li></td>
      <td align="center"><font color="#0000CC">������ ID</font></td>
      <td><INPUT TYPE="text" NAME="adminID"></td>
     </tr>
     <tr>
      <td><li></td>
      <td align="center"><font color="#CC0033">������ ��ȣ</font></td>
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
