<html>
<head>
<title>�α����� �� �ּ��� </title>
 
<SCRIPT LANGUAGE="JavaScript">
<!--
function go_login(){
  if(document.login.userid.value.length<=0){
    alert("User ID�� �Է��Ͻʽÿ�");
    document.login.userid.focus();
    return false;
  }
  if(document.login.passwd.value.length <= 0){
   alert("Password �� �Է��Ͽ� �ֽʽÿ�");
   document.login.passwd.focus();
   return false;
  }
  document.login.submit();
}
function move_focus(){
  document.login.userid.focus();
  return;
}
//-->
</SCRIPT>
</head>
<body onload="move_focus();">
<form name="login" method="post" action="login_ok.jsp">
  <table cellpadding=0 cellspacing=0 border=0 align="center">
    <tr>
      <td>ID:</td>
      <td><input type="text" name="userid" size=8 maxlength=12></td>
    </tr>
    <tr>
      <td>PASSWORD:</td>
      <td><input type="password" name="passwd" size=8 ></td>
    </tr>
    <tr>
      <td colspan=2 align=right><a href="javascript:go_login()">[�α���]</a></td>
    </tr>
  </table>
</form>
</body>
</html>