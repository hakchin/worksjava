<html>
<head>
<title>주소록 입력화면 만들기</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<script language="JavaScript">
function go_insert(){
	document.insert.submit();
}
</script>
</head>
<body>
<form name="insert" method="post" action="addr_insert.jsp">
<table align=center width="350" border="1" cellspacing="0" cellpadding="2" bordercolorlight="#81ACD6" bordercolordark="white">
  <tr>
    <td colspan=2 bgcolor="#E7F0F7" align=center> <b>주소입력하기</b>
    </td>
  </tr>
  <tr>
    <td bgcolor="#E7F0F7" width=80 align=center> 이름 </td>
    <td width=270> <input type=text name="name" size=35></td>
  </tr>
  <tr>
    <td bgcolor="#E7F0F7" align=center> 주소 </td>
    <td> <input type=text name="addr" size=35></td>
  </tr>
  <tr>
    <td bgcolor="#E7F0F7" align=center> 집 전화번호 </td>
    <td> <input type=text name="home_tel_no" size=35></td>
  </tr>
  <tr>
    <td bgcolor="#E7F0F7" align=center> 회사 전화번호 </td>
    <td> <input type=text name="com_tel_no" size=35></td>
  </tr>
  <tr>
    <td bgcolor="#E7F0F7" align=center> 핸드폰 전화번호 </td>
    <td> <input type=text name="hand_tel_no" size=35></td>
  </tr>
</table>
<table align=center width="550" border=0>
  <tr>
    <td align=center><a href="javascript:go_insert()">[등록]</a></td>
  </tr>
</table>
</form>
</body>
</html>	