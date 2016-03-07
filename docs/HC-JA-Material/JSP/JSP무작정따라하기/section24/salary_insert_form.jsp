<html>
<head>
<title>급여 입력화면  </title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<script language="JavaScript">
function go_insert(){
	if(document.insert.name.value.length==0){
		alert("이름을 입력하세요");
	}else if(document.insert.pos.value=='0'){
		alert("직책을 선택하세요");
	}else{
		document.insert.submit();
	}
}
</script>
</head>
<body>
<form name="insert" method="post" action="salary_insert.jsp">
<table align=center width="350" border="1" cellspacing="0" cellpadding="2" bordercolorlight="#81ACD6" bordercolordark="white">
  <tr>
    <td colspan=2 bgcolor="#E7F0F7" align=center> <b>급여입력하기</b>
    </td>
  </tr>
  <tr>
    <td bgcolor="#E7F0F7" width=80 align=center> 이름 </td>
    <td width=270> <input type=text name="name" size=35></td>
  </tr>
  <tr>
    <td bgcolor="#E7F0F7" align=center> 직책 </td>
    <td> <select name="pos">
    		<option value="0">----직책을 선택하세요---</option>
    		<option value="1">아르바이트생</option>
    		<option value="2">사원</option>
    		<option value="3">대리</option>
    		<option value="4">과장</option>
    		<option value="5">부장</option>
    		<option value="6">이사</option>
    		<option value="7">사장</option>
    	 </select>
    </td>
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