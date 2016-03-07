<%@ page contentType="text/html; charset=KSC5601" %>
<%@ page language="java" import="java.sql.*,java.util.*,javax.servlet.http.* "%>
<%!
Connection DB_Connection() throws ClassNotFoundException, SQLException,Exception
{
  String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
  Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection conn=DriverManager.getConnection(url,"scott","tiger");
  return conn;
}
%>
<%
Connection      conn = DB_Connection();
Statement       stmt = null;
ResultSet       rs = null;

String user_id= request.getParameter("user_id");

String user_name="";
String security_id1="";
String security_id2="";
String passwd="";
String addr_gubun="";
String zip1="";
String zip2="";
String address="";
String tel1="";
String tel2="";
String tel3="";
String hand_tel1="";
String hand_tel2="";
String hand_tel3="";
String e_mail="";
String open_yn="";
String job_type="";
String intro="";

String sql = " select user_name,security_id1,security_id2,passwd, "+//4
			 " addr_gubun, zip1,zip2,address,"+//8
			 " tel1,tel2,tel3,"+//11
			 " hand_tel1,hand_tel2,hand_tel3, "+//14
			 " e_mail,open_yn,job_type, "+//17
			 " intro "+//18
			 " from user_info"+
			 " where user_id='"+user_id+"'";
	try{
    	stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        
        if(rs.next()){
        	user_name=rs.getString(1);
        	security_id1 = rs.getString(2);	
        	security_id2 = rs.getString(3);	
        	passwd = rs.getString(4);	
        	addr_gubun = rs.getString(5);	
        	zip1 = rs.getString(6);	
        	zip2 = rs.getString(7);	
        	address = rs.getString(8);	
        	tel1 = rs.getString(9);	
        	tel2 = rs.getString(10);	
        	tel3 = rs.getString(11);	
        	hand_tel1 = rs.getString(12);	
        	hand_tel2 = rs.getString(13);	
        	hand_tel3 = rs.getString(14);	
        	e_mail = rs.getString(15);	
        	open_yn = rs.getString(16);	
        	job_type = rs.getString(17);	
        	intro = rs.getString(18);	
        }
    	stmt.close();
        rs.close();
    }catch(SQLException e){
    }
%>
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
var msg;

function form_check()
{
	var tel = "";
	var zip = "";
	var form = document.form_name;
	msg = "== 등록시 미진한 사항 ==\n\n";
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
	
	if(msg == "== 등록시 미진한 사항 ==\n\n") { 
		form.action="update_info.jsp";		
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
              <td align=center bgcolor="#7AAAD5"><FONT COLOR="#FFFFFF"><b>자기정보수정&nbsp;</b>
              </td>
              <td align=right BORDER="0" HSPACE="0" VSPACE="0"><img src=u_b03.gif></td>
            </tr>
          </table>
          <table cellpadding=3 cellspacing=1 border=0 width=100%>
            <tr>
              <td width=110 bgcolor=#EFF4F8>&nbsp;회원 성명<font color=red>&nbsp;*</font></td>
              <TD BGCOLOR=WHITE>
                <input type=text name="user_name" size=30 maxlength=20 value="<%=user_name%>">성명은 빈칸없이 입력하세요.
              </td>
            </tr>
            <tr>
              <TD BGCOLOR="#EFF4F8">&nbsp;주민등록번호<font color=red>&nbsp;*</font></td>
              <TD BGCOLOR=WHITE>
                <input type=text name=security_id1 size=6 maxlength=6 value="<%=security_id1%>"> - 
                <input type=text name=security_id2 size=7 maxlength=7 value="<%=security_id2%>">
              </td>
            </tr>
            <tr>
              <TD BGCOLOR="#EFF4F8">&nbsp;회원 ID<font color=red>&nbsp;*</font></td>
              <TD BGCOLOR=WHITE>
                <table cellspacing=0 cellpadding=0>
                  <tr>
                    <td align=absmiddle>
                      <input type=text name=user_id size=12 maxlength=16 value="<%=user_id%>" readonly style="width:120">
                    </td>
                    <td>
                   		아이디는 변경할 수 없습니다.
                    </td>
                  </tr>
                </table>
              </td>
            </tr>
            <tr>
              <TD BGCOLOR="#EFF4F8">&nbsp;비밀번호<font color=red>&nbsp;*</font></td>
              <TD BGCOLOR=WHITE>
               <input type=password name=passwd size=8 maxlength=12 style="width:80" value="<%=passwd%>">
                 6~12자 이내의 영문이나 숫자만 가능합니다.
              </td>
            </tr>
            <tr>
              <TD BGCOLOR="#EFF4F8">&nbsp;비밀번호확인<font color=red>&nbsp;*</font></td>
              <TD BGCOLOR=WHITE><input type=password name=repasswd size=8 maxlength=12 value="<%=passwd%>" style="width:80">비밀번호 확인을 위해서 비밀번호를 한번 더 입력해주세요. </td>
            </tr>
            <tr>
              <TD BGCOLOR="#EFF4F8">&nbsp;주소구분<font color=red>&nbsp;*</font></td>
              <TD BGCOLOR=WHITE>
                <input type=radio name="addr_gubun" value="1" <%if(addr_gubun.equals("1")){%>checked <%}%>>직장(학교)
                <input type=radio name="addr_gubun" value="2" <%if(addr_gubun.equals("2")){%>checked<%}%>>자택
              </td>
            </tr>
            <tr>
              <TD BGCOLOR="#EFF4F8">&nbsp;우편번호<font color=red>&nbsp;*</font></td>
              <TD BGCOLOR=WHITE>
                <table cellspacing=0 cellpadding=0>
                  <tr>
                    <td>
                  	  <input type=text name=zip1 size=3 maxlength=3 value="<%=zip1%>">-
                  	  <input type=text name=zip2 size=3 maxlength=3 value="<%=zip2%>">
                    </td>
                 </tr>
               </table>
             </td>
           </tr>
           <tr>
             <TD BGCOLOR="#EFF4F8">&nbsp;주소<font color=red>&nbsp;*</font></td>
             <TD BGCOLOR=WHITE>
              <input type=text name=address size=50 maxlength=100 value="<%=address%>">
             </td>
           </tr>
           <tr>
               <TD BGCOLOR="#EFF4F8">&nbsp;전화번호<font color=red>&nbsp;*</font></td>
                <TD BGCOLOR=WHITE>
                  <input type=text name=tel1 size=4 maxlength=4 value="<%=tel1%>">
                   - 
                  <input type=text name=tel2 size=4 maxlength=4 value="<%=tel2%>">
                   -
                  <input type=text name=tel3 size=4 maxlength=4 value="<%=tel3%>">
                </td>
              </tr>
              <tr> 
                <TD BGCOLOR="#EFF4F8">&nbsp;휴대전화</td>
                <TD BGCOLOR=WHITE>
                  <input type=text name=hand_tel1 size=4 maxlength=4 value="<%=hand_tel1%>">
                   - 
                  <input type=text name=hand_tel2 size=4 maxlength=4 value="<%=hand_tel2%>">
                   - 
                  <input type=text name=hand_tel3 size=4 maxlength=4 value="<%=hand_tel3%>">
                </td>
              </tr>
              <tr>
                <TD BGCOLOR="#EFF4F8">&nbsp;E-mail
                	<font color=red>&nbsp;*</font>
                </td>
                <td bgcolor=WHITE valign=middle>
                  <input type=text name=e_mail size=30 maxlength=30 value="<%=e_mail%>">
                </td>
              </tr>
              <tr>
                <TD BGCOLOR="#EFF4F8">&nbsp;공개여부<font color=red>&nbsp;*</font></td>
                <TD BGCOLOR=WHITE>
                  <input type=radio name="open_yn" value="Y" <% if(open_yn.equals("Y")){%> checked <%}%>>예 
                  <input type=radio name="open_yn" value="N" <% if(open_yn.equals("N")){ %> checked <% } %>>아니오
                </td>
              </tr>
              <tr>
                <TD BGCOLOR="#EFF4F8">&nbsp;직업<font color=red>&nbsp;*</font></td>
                <TD BGCOLOR=WHITE>
                  <select name=job_type class="formbox">
 					<option value="0">선택하세요 ---
 					<option value="회사원" <%if(job_type.equals("회사원")){%>selected<%}%>>회사원
 					<option value="연구전문직" <%if(job_type.equals("연구전문직")){%>selected<%}%>>연구전문직
 					<option value="교수학생" <%if(job_type.equals("교수학생")){%>selected<%}%>>교수학생
 					<option value="일반자영업" <%if(job_type.equals("일반자영업")){%>selected<%}%>>일반자영업
 					<option value="공무원" <%if(job_type.equals("공무원")){%>selected<%}%>>공무원
 					<option value="의료인" <%if(job_type.equals("의료인")){%>selected<%}%>>의료인
 					<option value="법조인" <%if(job_type.equals("법조인")){%>selected<%}%>>법조인
 					<option value="종교,언론,에술인" <%if(job_type.equals("종교,언론,에술인")){%>selected<%}%>>종교.언론/예술인
 					<option value="농,축,수산,광업인" <%if(job_type.equals("농,축,수산,광업인")){%>selected<%}%>>농/축/수산/광업인
 					<option value="주부" <%if(job_type.equals("주부")){%>selected<%}%>>주부
 					<option value="무직" <%if(job_type.equals("무직")){%>selected<%}%>>무직
 					<option value="기타" <%if(job_type.equals("기타")){%>selected<%}%>>기타
		  		  </select>
				</td>                
              </tr>
              <tr>
                <TD BGCOLOR="#EFF4F8">&nbsp;자기소개<font color=red>&nbsp;</font></td>
                <TD BGCOLOR=WHITE>
                  <textarea cols=65 rows=5 name="intro"><%=intro%></textarea>
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
