<HTML>
<HEAD>
<TITLE>�α׿�</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<STYLE TYPE="text/css">
<!--
body { font-family: ����, Verdana; font-size: 9pt}
td   { font-family: ����, Verdana; font-size: 9pt; text-decoration: none; color: #000000; 
      BACKGROUND-POSITION: left top; BACKGROUND-REPEAT: no-repeat;}
//-->
</STYLE>
<Script Language="JavaScript">
function check_submit()
{
	if(document.fname.elements[0].value.length <= 0) {
		alert("User ID�� �Է��Ͻʽÿ�.");
		document.fname.elements[0].focus();
		return false;
	}
	if(document.fname.elements[1].value.length <= 0) {
		alert("Password�� �Է��Ͻʽÿ�.");
		document.fname.elements[1].focus();
		return false;
	}
	return true;
}
</Script>
</HEAD>
<body bgcolor="#FFFFFF" text="#000000" leftmargin=0 
  topmargin=0 onLoad='document.fname.user_id.focus();'>
<br><br>
<TABLE width="683" border="0" cellspacing="0" cellpadding="0" height="265">
<TR>
  <TD width=100>&nbsp;</td>
  <TD>
    <table width="583" border="0" cellspacing="0" cellpadding="0" height="265">
	  <form name=fname method=post action="login_ok.jsp"  onSubmit="return check_submit()">
	    <tr>
		  <td height="298"> 
		    <table width="100%" border="0" cellspacing="0" cellpadding="0">
			  <tr> 
			    <td width="9"><img src="h_b02.gif" width="9" height="21"></td>
				<td bgcolor="7aaad5"> 
				 <div align="center"><font color="#FFFFFF"><b>Member Login</b></font></div>
				 </td>
				 <td width="9"><img src="f_b03.gif" width="9" height="21"></td>
			  </tr>
			 </table>
			 <table border="0" cellpadding="0" cellspacing="0" width="550">
			   <tr> 
			     <td bgcolor="#7aaad5"> 
				   <table border="0" cellpadding="3" cellspacing="1" width="99%" height="321">
				     <tr bgcolor="#FFFFFF"> 
					   <td align=CENTER bgcolor="#eff4f8" height="92"> 
					     <table width="330" border="0" cellspacing="0" cellpadding="1">
							<tr valign=bottom> 
							  <td width="21"><img src="h_bl02.gif" width="18" height="16"></td>
							  <td width="55" nowrap>�� �� ��</td>
							  <td width="175">: 
								<input type=text name="user_id" size=16 maxlength=16 STYLE="WIDTH:155">
							  </td>
							  <td width="79"></td>
							</tr>
							<tr valign=bottom> 
							  <td><img src="h_bl02.gif" width="18" height="16"></td>
							  <td nowrap>��й�ȣ</td>
							  <td>: 
								<input type=password name="passwd" size=14 maxlength=12 STYLE="WIDTH:155">
							  </td>
							  <td><input type=image src="login.gif" border=0 align=absmiddle></td>
							</tr>
						  </table>
						</td>
					  </tr>
					  <tr bgcolor="#FFFFFF"> 
						<td bgcolor="#ffffff" align=CENTER height="138"> 
						  <table width="600" border="0" cellspacing="0" cellpadding="0">
							<tr> 
							  <td> 
								<table cellpadding=2 cellspacing=0 align=center border=0>
								  <tr> 
									<td> 
										<p style="LINE-HEIGHT:15PX;"><font color="#AFAFB1">
										�̰��� JSP�� ������ �ϴ� ���̸� ������
										   <FONT COLOR="#006F70">ȸ������ �� �� �ִ� </FONT>���Դϴ�.<BR><BR>
									</td> 
								  </tr> 
					              <tr> 
							        <td> 
							          <p style="LINE-HEIGHT:15PX;"><font color="#AFAFB1">���̵� 
								      ������ ���� <a href="../section25/userinfo_insert_form.jsp">
							          <font color="#ff7508">�̿��ڰ���</font></a>�� �Ͻñ� �ٶ��ϴ�.<br>
							            <br>
							            <br>
							          </p>
							       </td>
							      </tr>
						         </table>
						       </td>
					         </tr>
					       </table>
				         </td>
				       </tr>
			         </table>
			  <table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr> 
				  <td width="9"><img src="h_b04.gif" width="12" height="11"></td>
				  <td bgcolor="7aaad5" width="612"> 
					<div align="center"></div>
				  </td>
				  <td width="10"><img src="h_b05.gif" width="12" height="11"></td>
				</tr>
			  </table>
			</td>
  		</tr>
		</table>
		</form>
	</TD>
</TR>
</TABLE>
</body>
</html>

