<HTML>
<HEAD>
<SCRIPT LANGUAGE="javascript">
function write()
{
	form=document.write_form;
		if (form.title.value == "")
	{
		alert("������ �Է��ϼ���.");
		form.title.focus();
	}
	else if (form.content.value == "")
	{
		alert("������ �Է��ϼ���.");
		document.write_form.content.focus();
	}
	else
	{
	 document.write_form.submit();
	 }
}
</SCRIPT>
</HEAD>
<BODY>
<TABLE BORDER="0" WIDTH="650" CELLPADDING="0" CELLSPACING="0" ALIGN="CENTER">
    <TR BGCOLOR="#D4A15A">
     <TD COLSPAN=4>
     <TABLE border=0 align=center><TR><TD>
     <FONT COLOR="#000000">
     <B>������ ȭ��</B></FONT>
     </TD></TR></TABLE>
     </td>
    </TR>
</TABLE>
<TABLE BORDER="0" WIDTH="650" CELLPADDING="0" CELLSPACING="0" ALIGN="CENTER" BGCOLOR="#D4A15A">
 <TR><TD>
  <TABLE BORDER="0" WIDTH="650" CELLPADDING="0" CELLSPACING="1" ALIGN="CENTER">
  <FORM NAME="write_form" METHOD="post" ACTION="view_content.jsp">
    <TR>
     <TD BGCOLOR="#FDF5EA" ALIGN="CENTER" width=60>�� ��</TD>
     <TD BGCOLOR="#FFFFFF">&nbsp;<INPUT type="text" NAME="title" MAXLENGTH=100 STYLE="WIDTH:98%"></TD>
    </TR>
    <TR>
     <TD BGCOLOR="#FDF5EA" ALIGN="CENTER">�� ��</TD>
     <TD BGCOLOR="#FFFFFF">
     &nbsp;<TEXTAREA NAME="content" ROWS="15" STYLE="WIDTH:99%"></TEXTAREA>
     </TD>
    </TR>
    </FORM>
  </TABLE></TD></TR>
 </TABLE>
 <TABLE width=650>
 <TR><TD align=center>
 	<a href="javascript:write();">[���]</a>
 </TD></TR>
 </TABLE>
 </BODY>
</HTML>
