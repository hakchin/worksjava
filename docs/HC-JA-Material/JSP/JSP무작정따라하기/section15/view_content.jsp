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
     <B>건의하신 내용입니다.</B></FONT>
     </TD></TR></TABLE>
     </td>
    </TR>
</TABLE>

<TABLE BORDER="0" WIDTH="600" CELLPADDING="0" CELLSPACING="0" ALIGN="CENTER" BGCOLOR="#D4A15A">
 <TR><TD>
  <TABLE BORDER="0" WIDTH="600" CELLPADDING="3" CELLSPACING="1" ALIGN="CENTER">
    <TR>
     <TD BGCOLOR="#FDF5EA" ALIGN="CENTER" width=60>제 목</TD>
     <TD BGCOLOR="#FFFFFF" width=540>&nbsp;<%=title%></TD>
    </TR>
    <TR>
     <TD BGCOLOR="#FDF5EA" ALIGN="CENTER">내 용</TD>
     <TD BGCOLOR="#FFFFFF"><%=content%></TD> 
    </TR>
  </TABLE></TD></TR>
 </TABLE><br>
 <TABLE BORDER="0" WIDTH="600" CELLPADDING="0" CELLSPACING="0" ALIGN="CENTER" BGCOLOR="#D4A15A">
 <TR><TD>
  <TABLE BORDER="0" WIDTH="600" CELLPADDING="3" CELLSPACING="1" ALIGN="CENTER">
    <TR>
     <TD BGCOLOR="#FDF5EA">저희 사이트에 관심을 가지고 좋은 건의 해 주셔서 감사합니다.
      건의하신 내용은 관리자가 빠른 시간 안에 처리해 드리겠습니다.
     </TD>
    </TR>
  </TABLE></TD></TR>
 </TABLE>
 </BODY>
</HTML>