<HTML>
<HEAD>
</HEAD>
<%@ page language="java" import="java.util.*" %>
<%
	String title=request.getParameter("title");
	String content=request.getParameter("content");
%>
<BODY>
<TABLE BORDER="0" WIDTH="600" CELLPADDING="0" CELLSPACING="0" ALIGN="CENTER">
    <TR BGCOLOR="#D4A15A">
     <TD>
     <TABLE border=0 align=center><TR><TD>
     <FONT COLOR="#000000">
     <B>�����Ͻ� �����Դϴ�.</B></FONT>
     </TD></TR></TABLE>
     </td>
    </TR>
</TABLE>

<TABLE BORDER="0" WIDTH="600" CELLPADDING="0" CELLSPACING="0" ALIGN="CENTER" BGCOLOR="#D4A15A">
 <TR><TD>
  <TABLE BORDER="0" WIDTH="600" CELLPADDING="3" CELLSPACING="1" ALIGN="CENTER">
    <TR>
     <TD BGCOLOR="#FDF5EA" ALIGN="CENTER" width=60>�� ��</TD>
     <TD BGCOLOR="#FFFFFF" width=540>&nbsp;<%=title%></TD>
    </TR>
    <TR>
     <TD BGCOLOR="#FDF5EA" ALIGN="CENTER">�� ��</TD>
     <TD BGCOLOR="#FFFFFF"><%=content%></TD> 
    </TR>
  </TABLE></TD></TR>
 </TABLE><br>
 <TABLE BORDER="0" WIDTH="600" CELLPADDING="0" CELLSPACING="0" ALIGN="CENTER" BGCOLOR="#D4A15A">
 <TR><TD>
  <TABLE BORDER="0" WIDTH="600" CELLPADDING="3" CELLSPACING="1" ALIGN="CENTER">
    <TR>
     <TD BGCOLOR="#FDF5EA">���� ����Ʈ�� ������ ������ ���� ���� �� �ּż� �����մϴ�.
      �����Ͻ� ������ �����ڰ� ���� �ð� �ȿ� ó���� �帮�ڽ��ϴ�.
     </TD>
    </TR>
  </TABLE></TD></TR>
 </TABLE>
 </BODY>
</HTML>