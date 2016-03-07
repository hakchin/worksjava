<html>
<head>
<STYLE TYPE="text/css">
body  { font-size: 12px; font-family: 굴림; text-decoration: none; color: black }
td		{ font-size: 12px; font-family: 굴림; text-decoration: none; color: black }
</STYLE>

<script>
function writeCheck()
{
	var form = document.bbs_form;
	
	if(!form.title.value){
		alert("제목을 입력하세요.");
		form.title.focus();
		return ;
	}
	form.submit();
}
</script>
</head>
<body  topmargin=0 leftmargin=0>
<form name=bbs_form method=post action="upload.jsp" encType="multipart/form-data">
<TABLE WIDTH="730" BORDER="0" CELLSPACING="0" CELLPADDING="0">
  <TR>
    <TD ALIGN=CENTER><br><br>
      <TABLE BORDER="0" WIDTH="650" CELLPADDING="0" CELLSPACING="0" ALIGN="CENTER">
		<tr bgcolor="#7baad6" valign="top"  height=20>
		  <TD WIDTH="20"><IMG SRC="j_b19.gif" VSPACE="0" HSPACE="0" ALIGN="LEFT"></TD>
		  <TD WIDTH=610 ALIGN="CENTER" VALIGN="BOTTOM"><FONT COLOR="#FFFFFF"><B>
					파일 첨부하기</B></FONT>
     	   </TD>
		   <TD WIDTH="20"><IMG SRC="j_b20.gif" ALIGN="RIGHT" VSPACE="0" HSPACE="0"></TD>
        </tr>
		<tr>
			<td align=center width=650 colspan=3>
			<table border=0 cellspacing=1 cellpadding=0 bgcolor=#7BAAD6 width=650>
				<tr>
				   <td width=100 align=center bgcolor="#eff4fa">제 목</td>
				   <td width=550 colspan=3 bgcolor=ffffff>&nbsp;<input type="text" name="title" size=76 maxlength=50></td>
				</tr>	
				<tr>
				   <td width=100 align=center bgcolor="#eff4fa">파일첨부</td>
				   <td width=550 colspan=3 bgcolor=ffffff>&nbsp;<input type="file" name="file_name" size=50></td>
				</tr>	
			  </table>
			</TD>
    	  </TR>
		  <TR HEIGHT=15 bgcolor="#7baad6">
		     <TD VALIGN="BOTTOM" COLSPAN="3">
		         <IMG SRC="j_b04.gif" BORDER="0" ALIGN="LEFT" VSPACE="0" HSPACE="0">
		         <IMG SRC="j_b05.gif" BORDER="0" ALIGN="RIGHT" VSPACE="0" HSPACE="0">
		       </td>
		  </TR>
		  <TR>
		   	<td colspan=3 align=right height=28 valign=bottom>
			  <a href="javascript:writeCheck()"><img src="m_bt11.gif" border=0></a>
			  <a href="javascript:history.go(-1)"><img src="m_bt12.gif" border=0></a>
		   	</td>
		  </TR>
		</table>
	  </TD>
	</TR>
</TABLE>
</form>
</body>
</html>
