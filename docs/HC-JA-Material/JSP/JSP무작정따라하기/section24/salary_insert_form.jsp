<html>
<head>
<title>�޿� �Է�ȭ��  </title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<script language="JavaScript">
function go_insert(){
	if(document.insert.name.value.length==0){
		alert("�̸��� �Է��ϼ���");
	}else if(document.insert.pos.value=='0'){
		alert("��å�� �����ϼ���");
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
    <td colspan=2 bgcolor="#E7F0F7" align=center> <b>�޿��Է��ϱ�</b>
    </td>
  </tr>
  <tr>
    <td bgcolor="#E7F0F7" width=80 align=center> �̸� </td>
    <td width=270> <input type=text name="name" size=35></td>
  </tr>
  <tr>
    <td bgcolor="#E7F0F7" align=center> ��å </td>
    <td> <select name="pos">
    		<option value="0">----��å�� �����ϼ���---</option>
    		<option value="1">�Ƹ�����Ʈ��</option>
    		<option value="2">���</option>
    		<option value="3">�븮</option>
    		<option value="4">����</option>
    		<option value="5">����</option>
    		<option value="6">�̻�</option>
    		<option value="7">����</option>
    	 </select>
    </td>
  </tr>
</table>
<table align=center width="550" border=0>
  <tr>
    <td align=center><a href="javascript:go_insert()">[���]</a></td>
  </tr>
</table>
</form>
</body>
</html>	