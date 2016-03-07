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
		if(!form.passwd.value){
			alert("암호를 입력하세요");
			form.passwd.focus();
			return ;
		}
		if(!form.user_name.value){
			alert("이름을 입력하세요");
			form.user_name.focus();
			return ;
		}
		if(!form.description.value){
			alert("내용을 입력하세요.");
			form.description.focus();
			return;
		}
		form.submit();
	}
	</script>
	</head>
	<body  topmargin=0 leftmargin=0>
	<form name=bbs_form method=post action="write.jsp">
	<TABLE WIDTH="730" BORDER="0" CELLSPACING="0" CELLPADDING="0">
	  <TR>
	    <TD ALIGN=CENTER><br><br>
	      <TABLE BORDER="0" WIDTH="650" CELLPADDING="0" CELLSPACING="0" ALIGN="CENTER">
			<tr bgcolor="#7baad6" valign="top"  height=20>
			  <TD WIDTH="20"><IMG SRC="j_b19.gif" VSPACE="0" HSPACE="0" ALIGN="LEFT"></TD>
			  <TD WIDTH=610 ALIGN="CENTER" VALIGN="BOTTOM"><FONT COLOR="#FFFFFF"><B>
						자유게시판 게시물 작성</B></FONT>
	     	   </TD>
			   <TD WIDTH="20"><IMG SRC="j_b20.gif" ALIGN="RIGHT" VSPACE="0" HSPACE="0"></TD>
	        </tr>
			<tr>
				<td align=center width=650 colspan=3>
				<table border=0 cellspacing=1 cellpadding=0 bgcolor=#7BAAD6 width=650>
					<tr>
					   <td width=100 align=center bgcolor="#eff4fa">등록자</td>
					   <td width=225 bgcolor=ffffff>&nbsp;<input type="text" name="user_name" size=20 maxlength="10" value=""></td>
					   <td width=100 align=center bgcolor="#eff4fa">암호</td>
					   <td width=225 bgcolor=ffffff>&nbsp;
					   <input type="password" name="passwd" size=20 maxlength="10" value="" >
					   </td>
					</tr>	
					<tr>
					   <td width=100 align=center bgcolor="#eff4fa">제 목</td>
					   <td width=550 colspan=3 bgcolor=ffffff>&nbsp;<input type="text" name="title" size=76 maxlength=50></td>
					</tr>	
					<tr>
					   <td width=100 align=center bgcolor="#eff4fa">E-mail</td>
					   <td width=550 colspan=3 bgcolor=ffffff>&nbsp;<input type="text" name="e_mail" size=76 maxlength=50></td>
					</tr>	
					<tr>
					   <td width=100 align=center bgcolor="#eff4fa">홈페이지</td>
					   <td width=550 colspan=3 bgcolor=ffffff>&nbsp;http://<input type="text" name="home_url" size=70 maxlength=50></td>
					</tr>	
					<tr>
					   <td width=100 align=center bgcolor="#eff4fa">내 용</td>
					   <td width=550 colspan=3 bgcolor=ffffff>
					   <table>
					      <tr>
					         <td bgcolor=ffffff width=550><textarea cols=76 rows=17 name="description"></textarea></td>
					      </tr>
					   </table>
					   </td>
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
	   <input type="hidden" name="type"   value="I">
	</form>
	</body>
	</html>
