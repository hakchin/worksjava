<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>회원등록</title>
<STYLE TYPE="text/css">
<!--
body { font-family: 돋움, Verdana; font-size: 9pt}
td   { font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color: #000000; BACKGROUND-POSITION: left top; BACKGROUND-REPEAT: no-repeat;}
-->
.formbox {
	BACKGROUND-COLOR: #F0F0F0; FONT-FAMILY: "Verdana", "Arial", "Helvetica", "돋움"; FONT-SIZE:9pt
} 
--->
</STYLE>
<script language="javascript">
<!--

function check_id()
{
	/* ID 중복 체크 
	 */
	var user_id;
	var tmp_url;

	user_id = document.form_name.user_id.value;
	if (user_id == "") 
	{
		alert("아이디를 입력하세요.");
		document.form_name.user_id.focus();
		return;
	}
	else if (user_id.length < 5 || user_id.length > 16)
	{
		alert("아이디는 5자 이상 16자 이하 입니다.");
		document.form_name.user_id.focus();
		return;
	}
	else if(!a_or_d(document.form_name.user_id.value)) {
		alert("아이디는 영문이나 숫자로 입력하셔야 합니다.");
		document.form_name.user_id.focus();
		return;
	}

	tmp_url = 'id_check.jsp?user_id=' + user_id;
	id_win = window.open(tmp_url, 'id_check', 'toolbar=no width=340 height=230 status=no');
	return;
}

var msg;

function form_check()
{
	var tel = "";
	var zip = "";
	var form = document.form_name;
	msg = "== 등록 시 미진한 사항 ==\n\n";
	if(form.user_name.value=="")
		msg += "회원 성명을 입력하세요.\n\n";
	
	if(form.user_id.value=="")
		msg += "회원ID를 입력하세요.\n\n";
	else if(form.user_id.value.length < 5)
		msg += "회원ID는 5자 이상 입력하셔야 합니다.\n\n";
	else if(!a_or_d(form.user_id.value))
		msg += "회원ID는 영문이나 숫자로 입력하셔야 합니다.\n\n";
	if(form.passwd.value=="")
		msg += "비밀번호를 입력하세요.\n\n";
	else if(form.passwd.value.length < 5)
		msg += "비밀번호는 4자 이상 입력하셔야 합니다.\n\n";
	else if(!a_or_d(form.passwd.value))
		msg += "비밀번호는 영문이나 숫자로 입력하셔야 합니다.\n\n";
		
	if(form.passwd.value != form.repasswd.value)
		msg += "비밀번호와 비밀번호확인의 값이 서로 같지 않습니다.\n\n";
		
	if(form.job_type.selectedIndex ==0 )
		msg += "직업을 선택하세요.\n\n";
		
	tel =form.tel1.value + form.tel2.value + form.tel3.value;

	if(tel=="")
		msg += "전화번호를 입력하세요.\n\n";
	else if(!tel_check(tel))
		msg += "전화번호에는 숫자와 '(', ')' 그리고 '-'만 사용할 수 있습니다.\n\n";

    zip = form.zip1.value + form.zip2.value;
    if(zip=="")
       msg += "우편번호를 입력하세요.\n\n";
    else if(!postal_check(zip))
       msg += "우편번호에는 숫자만 입력할 수 있습니다.\n\n"  ;
	
	if(form.address.value=="") {
		msg += "주소를 입력하세요.\n\n";
	}

	if (form.e_mail.value=="") {
		msg += "E-mail 주소를 입력하세요.\n\n";
	}
	if(check_digit(form.security_id1.value+form.security_id2.value) == false){
	   msg += "주민등록번호를 정확히 입력하세요.\n\n";
	}
	
	if(msg == "== 등록 시 미진한 사항 ==\n\n") { 
		form.action="userinfo_insert.jsp";		
		form.submit();
	}
	else 
	{
		alert(msg);
		return;
	}
}

function a_or_d(str)
{
	lower_str = str.toLowerCase();
	
	for(i=0; i<lower_str.length; i++)
	{
		ch = lower_str.charAt(i);
		if(((ch < 'a') || (ch > 'z')) && ((ch < '0') ||(ch > '9')))
			return 0;
	}
	return 1;
}


function tel_check(str)
{
	lower_str = str.toLowerCase();
	
	for(i=0; i<lower_str.length; i++)
	{
		ch = lower_str.charAt(i);	
		if(( ch != '(') && ( ch != ')' ) && ( ch !='-' ) && ((ch < '0') || (ch > '9')))
			return 0;
	}
	return 1;
}

function postal_check(str)
{
	lower_str = str.toLowerCase();
	
	for(i=0; i<lower_str.length; i++)
	{
		ch = lower_str.charAt(i);		
		if((ch < '0') || (ch > '9'))
			return 0;
	}
	return 1;
}

function makeArray(n)
{
	this.length = n;
	for(var i=1; i<=n; i++)
		this[i] = 0;
	return this;
}

num = new makeArray(13);
digit = new makeArray(12);

digit[1] = 2
digit[2] = 3
digit[3] = 4
digit[4] = 5
digit[5] = 6
digit[6] = 7
digit[7] = 8
digit[8] = 9
digit[9] = 2
digit[10] = 3
digit[11] = 4
digit[12] = 5
function check_digit(str)
{
	//사람이 입력한 주민등록 번호를 배열에 넣는다.
	for(j=1; j<=13; j++){
	     num[j] = parseInt(str.charAt(j-1),10)	
	}
	
	sum = 0;
	//check_digit와 번호를 연산한다.
	for(i=1; i<=12; i++){
		sum += digit[i] * num[i];
	}
	
	temp = sum%11
	
	check_digit_num1 = temp;
	check_digit_num2 = num[13];
		
	if(check_digit_num1 == 0){
		if(check_digit_num2 == 1)
			return true;
		else
			return false;
	}
	else if(check_digit_num1 == 1){
		if(check_digit_num2 == 0)
			return true;
		else
			return false;
	}
	else if((11-check_digit_num1) == check_digit_num2) return true;
	else return false;
}

function post_win()
{
       win_post = window.open('post.jsp?first_yn=Y',"post","toolbar=no ,width=370 ,height=300 ,directories=no,status=yes,scrollbars=yes,menubar=no");

}


//-->
</script>
</head>

<body bgcolor="#FFFFFF" LEFTMARGIN=0  TOPMARGIN=0 >
<form name=form_name method=post>
<table border=0 cellpadding=0 cellspacing=0 border=0 width=730 valign=top>
  <tr><td align=center><br>                            
    <table cellpadding=0 cellspacing=0 border=0 width=650 align=center>       
      <tr>
        <td bgcolor="#7AAAD5">            
          <table cellpadding=0 cellspacing=0 border=0 width=100%>
            <tr bgcolor=#7AAAD5>
              <td align=left BORDER="0" HSPACE="0" VSPACE="0"><img src="u_b02.gif"></td>
              <td align=center bgcolor="#7AAAD5"><FONT COLOR="#FFFFFF"><b>사용자등록&nbsp;</b><font color=black>(</font><font color=red>&nbsp;*&nbsp;</font><font color=black>표시항목은 반드시 입력하십시요.)</font></FONT></td>
              <td align=right BORDER="0" HSPACE="0" VSPACE="0"><img src=u_b03.gif></td>
            </tr>
          </table>
          <table cellpadding=3 cellspacing=1 border=0 width=100%>
            <tr>
              <td width=110 bgcolor=#EFF4F8>&nbsp;회원 성명<font color=red>&nbsp;*</font></td>
              <TD BGCOLOR=WHITE>
                <input type=text name=user_name size=30 maxlength=20 value="">성명은 빈칸없이 입력하세요.
              </td>
            </tr>
            <tr>
              <TD BGCOLOR="#EFF4F8">&nbsp;주민등록번호<font color=red>&nbsp;*</font></td>
              <TD BGCOLOR=WHITE>
                <input type=text name=security_id1 size=6 maxlength=6 value=""> - 
                <input type=text name=security_id2 size=7 maxlength=7 value="">
              </td>
            </tr>
            <tr>
              <TD BGCOLOR="#EFF4F8">&nbsp;회원 ID<font color=red>&nbsp;*</font></td>
              <TD BGCOLOR=WHITE>
                <table cellspacing=0 cellpadding=0>
                  <tr>
                    <td align=absmiddle>
                      <input type=text name=user_id size=12 maxlength=16 value="" style="width:120">
                    </td>
                    <td>
                      <a href="#" onClick="return check_id();">
                  		<img src="u_bt01.gif" hspace=2 border=0 name=img1  align=absmiddle></a>
                   		5~16자 이내의 영문이나 숫자만 가능합니다.
                  	</td>
                  </tr>
                </table>
              </td>
            </tr>
            <tr>
              <TD BGCOLOR="#EFF4F8">&nbsp;비밀번호<font color=red>&nbsp;*</font></td>
              <TD BGCOLOR=WHITE>
               <input type=password name=passwd size=8 maxlength=12 style="width:80">
                 6~12자 이내의 영문이나 숫자만 가능합니다.
              </td>
            </tr>
            <tr>
              <TD BGCOLOR="#EFF4F8">&nbsp;비밀번호확인<font color=red>&nbsp;*</font></td>
              <TD BGCOLOR=WHITE><input type=password name=repasswd size=8 maxlength=12 value="" style="width:80">비밀번호 확인을 위해서 비밀번호를 한번 더 입력해주세요. </td>
            </tr>
            <tr>
              <TD BGCOLOR="#EFF4F8">&nbsp;주소구분<font color=red>&nbsp;*</font></td>
              <TD BGCOLOR=WHITE>
                <input type=radio name="addr_gubun" value="1" checked>직장(학교)
                <input type=radio name="addr_gubun" value="2">자택
              </td>
            </tr>
            <tr>
              <TD BGCOLOR="#EFF4F8">&nbsp;우편번호<font color=red>&nbsp;*</font></td>
              <TD BGCOLOR=WHITE>
                <table cellspacing=0 cellpadding=0>
                  <tr>
                    <td>
                  	  <input type=text name=zip1 size=3 maxlength=3 >-
                  	  <input type=text name=zip2 size=3 maxlength=3>
                  	</td>
                  	 <td>
			      	   <a href="javascript:post_win()" onClick="return post_win()">
      				   <img src="u_bt07.gif" hspace=2 border=0 name=img2 align=absmiddle></a>
 					</td>

                 </tr>
               </table>
             </td>
           </tr>
           <tr>
             <TD BGCOLOR="#EFF4F8">&nbsp;주소<font color=red>&nbsp;*</font></td>
             <TD BGCOLOR=WHITE>
              <input type=text name=address size=50 maxlength=100 value="">
             </td>
           </tr>
           <tr>
               <TD BGCOLOR="#EFF4F8">&nbsp;전화번호<font color=red>&nbsp;*</font></td>
                <TD BGCOLOR=WHITE>
                  <input type=text name=tel1 size=4 maxlength=4 value="">
                   - 
                  <input type=text name=tel2 size=4 maxlength=4 value="">
                   -
                  <input type=text name=tel3 size=4 maxlength=4 value="">
                </td>
              </tr>
              <tr> 
                <TD BGCOLOR="#EFF4F8">&nbsp;휴대전화</td>
                <TD BGCOLOR=WHITE>
                  <input type=text name=hand_tel1 size=4 maxlength=4 value="">
                   - 
                  <input type=text name=hand_tel2 size=4 maxlength=4 value="">
                   - 
                  <input type=text name=hand_tel3 size=4 maxlength=4 value="">
                </td>
              </tr>
              <tr>
                <TD BGCOLOR="#EFF4F8">&nbsp;E-mail
                	<font color=red>&nbsp;*</font>
                </td>
                <td bgcolor=WHITE valign=middle>
                  <input type=text name=e_mail size=30 maxlength=30 value="">
                </td>
              </tr>
              <tr>
                <TD BGCOLOR="#EFF4F8">&nbsp;공개여부<font color=red>&nbsp;*</font></td>
                <TD BGCOLOR=WHITE>
                  <input type=radio name="open_yn" value="Y" checked>예 
                  <input type=radio name="open_yn" value="N">아니오
                </td>
              </tr>
              <tr>
                <TD BGCOLOR="#EFF4F8">&nbsp;직업<font color=red>&nbsp;*</font></td>
                <TD BGCOLOR=WHITE>
                  <select name=job_type class="formbox">
 					<option value="0">선택하세요 ---
 					<option value="회사원">회사원
 					<option value="연구전문직">연구전문직
 					<option value="교수학생">교수학생
 					<option value="일반자영업">일반자영업
 					<option value="공무원">공무원
 					<option value="의료인">의료인
 					<option value="법조인">법조인
 					<option value="종교,언론,에술인">종교.언론/예술인
 					<option value="농,축,수산,광업인">농/축/수산/광업인
 					<option value="주부">주부
 					<option value="무직">무직
 					<option value="기타">기타
				  </select>
				</td>                
              </tr>
              <tr>
                <TD BGCOLOR="#EFF4F8">&nbsp;자기소개<font color=red>&nbsp;</font></td>
                <TD BGCOLOR=WHITE>
                  <textarea cols=65 rows=5 name="intro"></textarea>
                </td>
              </tr>
            </table>

            <table cellpadding=0 cellspacing=0 border=0 width=100%>
              <tr bgcolor=#7AAAD5>
                <td valign=bottom>
                  <img src=u_b04.gif align=left hspace=0 vspace=0 border=0>
                </td>
                <td align=center></td>
                <td valign=bottom>
                  <img src=u_b05.gif align=right hspace=0 vspace=0 border=0>
                </td>
              </tr>
              <tr bgcolor=#ffffff>
                <td colspan=3 align=center>
                  <a href="javascript:form_check(this.form);">
                  <img src=u_bt06.gif vspace=3 border=0 name=img3></a>
                  <a href="javascript:document.form_name.reset();">
                  <img src=u_bt05.gif border=0 hspace=10 vspace=3 name=img4></a>
                </td>
              </tr>
            </table> 
          </td>
        </tr>
      </td>
    </tr>
</table>
</form>
</body>
</html>
