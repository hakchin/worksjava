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
<title>ȸ�����</title>
<STYLE TYPE="text/css">
<!--
body { font-family: ����, Verdana; font-size: 9pt}
td   { font-family: ����, Verdana; font-size: 9pt; text-decoration: none; color: #000000; BACKGROUND-POSITION: left top; BACKGROUND-REPEAT: no-repeat;}
-->
.formbox {
	BACKGROUND-COLOR: #F0F0F0; FONT-FAMILY: "Verdana", "Arial", "Helvetica", "����"; FONT-SIZE:9pt
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
	msg = "== ��Ͻ� ������ ���� ==\n\n";
	if(form.user_name.value=="")
		msg += "ȸ�� ������ �Է��ϼ���.\n\n";
	
	if(form.user_id.value=="")
		msg += "ȸ��ID�� �Է��ϼ���.\n\n";
	else if(form.user_id.value.length < 5)
		msg += "ȸ��ID�� 5�� �̻� �Է��ϼž� �մϴ�.\n\n";
	else if(!a_or_d(form.user_id.value))
		msg += "ȸ��ID�� �����̳� ���ڷ� �Է��ϼž� �մϴ�.\n\n";
	if(form.passwd.value=="")
		msg += "��й�ȣ�� �Է��ϼ���.\n\n";
	else if(form.passwd.value.length < 5)
		msg += "��й�ȣ�� 4�� �̻� �Է��ϼž� �մϴ�.\n\n";
	else if(!a_or_d(form.passwd.value))
		msg += "��й�ȣ�� �����̳� ���ڷ� �Է��ϼž� �մϴ�.\n\n";
		
	if(form.passwd.value != form.repasswd.value)
		msg += "��й�ȣ�� ��й�ȣȮ���� ���� ���� ���� �ʽ��ϴ�.\n\n";
		
	if(form.job_type.selectedIndex ==0 )
		msg += "������ �����ϼ���.\n\n";
		
	tel =form.tel1.value + form.tel2.value + form.tel3.value;
	if(tel=="")
		msg += "��ȭ��ȣ�� �Է��ϼ���.\n\n";
	else if(!tel_check(tel))
		msg += "��ȭ��ȣ���� ���ڿ� '(', ')' �׸��� '-'�� ����� �� �ֽ��ϴ�.\n\n";
    zip = form.zip1.value + form.zip2.value;
    if(zip=="")
       msg += "�����ȣ�� �Է��ϼ���.\n\n";
    else if(!postal_check(zip))
       msg += "�����ȣ���� ���ڸ� �Է��� �� �ֽ��ϴ�.\n\n"  ;
	
	if(form.address.value=="") {
		msg += "�ּҸ� �Է��ϼ���.\n\n";
	}

	if (form.e_mail.value=="") {
		msg += "E-mail �ּҸ� �Է��ϼ���.\n\n";
	}
	
	if(msg == "== ��Ͻ� ������ ���� ==\n\n") { 
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
              <td align=center bgcolor="#7AAAD5"><FONT COLOR="#FFFFFF"><b>�ڱ���������&nbsp;</b>
              </td>
              <td align=right BORDER="0" HSPACE="0" VSPACE="0"><img src=u_b03.gif></td>
            </tr>
          </table>
          <table cellpadding=3 cellspacing=1 border=0 width=100%>
            <tr>
              <td width=110 bgcolor=#EFF4F8>&nbsp;ȸ�� ����<font color=red>&nbsp;*</font></td>
              <TD BGCOLOR=WHITE>
                <input type=text name="user_name" size=30 maxlength=20 value="<%=user_name%>">������ ��ĭ���� �Է��ϼ���.
              </td>
            </tr>
            <tr>
              <TD BGCOLOR="#EFF4F8">&nbsp;�ֹε�Ϲ�ȣ<font color=red>&nbsp;*</font></td>
              <TD BGCOLOR=WHITE>
                <input type=text name=security_id1 size=6 maxlength=6 value="<%=security_id1%>"> - 
                <input type=text name=security_id2 size=7 maxlength=7 value="<%=security_id2%>">
              </td>
            </tr>
            <tr>
              <TD BGCOLOR="#EFF4F8">&nbsp;ȸ�� ID<font color=red>&nbsp;*</font></td>
              <TD BGCOLOR=WHITE>
                <table cellspacing=0 cellpadding=0>
                  <tr>
                    <td align=absmiddle>
                      <input type=text name=user_id size=12 maxlength=16 value="<%=user_id%>" readonly style="width:120">
                    </td>
                    <td>
                   		���̵�� ������ �� �����ϴ�.
                    </td>
                  </tr>
                </table>
              </td>
            </tr>
            <tr>
              <TD BGCOLOR="#EFF4F8">&nbsp;��й�ȣ<font color=red>&nbsp;*</font></td>
              <TD BGCOLOR=WHITE>
               <input type=password name=passwd size=8 maxlength=12 style="width:80" value="<%=passwd%>">
                 6~12�� �̳��� �����̳� ���ڸ� �����մϴ�.
              </td>
            </tr>
            <tr>
              <TD BGCOLOR="#EFF4F8">&nbsp;��й�ȣȮ��<font color=red>&nbsp;*</font></td>
              <TD BGCOLOR=WHITE><input type=password name=repasswd size=8 maxlength=12 value="<%=passwd%>" style="width:80">��й�ȣ Ȯ���� ���ؼ� ��й�ȣ�� �ѹ� �� �Է����ּ���. </td>
            </tr>
            <tr>
              <TD BGCOLOR="#EFF4F8">&nbsp;�ּұ���<font color=red>&nbsp;*</font></td>
              <TD BGCOLOR=WHITE>
                <input type=radio name="addr_gubun" value="1" <%if(addr_gubun.equals("1")){%>checked <%}%>>����(�б�)
                <input type=radio name="addr_gubun" value="2" <%if(addr_gubun.equals("2")){%>checked<%}%>>����
              </td>
            </tr>
            <tr>
              <TD BGCOLOR="#EFF4F8">&nbsp;�����ȣ<font color=red>&nbsp;*</font></td>
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
             <TD BGCOLOR="#EFF4F8">&nbsp;�ּ�<font color=red>&nbsp;*</font></td>
             <TD BGCOLOR=WHITE>
              <input type=text name=address size=50 maxlength=100 value="<%=address%>">
             </td>
           </tr>
           <tr>
               <TD BGCOLOR="#EFF4F8">&nbsp;��ȭ��ȣ<font color=red>&nbsp;*</font></td>
                <TD BGCOLOR=WHITE>
                  <input type=text name=tel1 size=4 maxlength=4 value="<%=tel1%>">
                   - 
                  <input type=text name=tel2 size=4 maxlength=4 value="<%=tel2%>">
                   -
                  <input type=text name=tel3 size=4 maxlength=4 value="<%=tel3%>">
                </td>
              </tr>
              <tr> 
                <TD BGCOLOR="#EFF4F8">&nbsp;�޴���ȭ</td>
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
                <TD BGCOLOR="#EFF4F8">&nbsp;��������<font color=red>&nbsp;*</font></td>
                <TD BGCOLOR=WHITE>
                  <input type=radio name="open_yn" value="Y" <% if(open_yn.equals("Y")){%> checked <%}%>>�� 
                  <input type=radio name="open_yn" value="N" <% if(open_yn.equals("N")){ %> checked <% } %>>�ƴϿ�
                </td>
              </tr>
              <tr>
                <TD BGCOLOR="#EFF4F8">&nbsp;����<font color=red>&nbsp;*</font></td>
                <TD BGCOLOR=WHITE>
                  <select name=job_type class="formbox">
 					<option value="0">�����ϼ��� ---
 					<option value="ȸ���" <%if(job_type.equals("ȸ���")){%>selected<%}%>>ȸ���
 					<option value="����������" <%if(job_type.equals("����������")){%>selected<%}%>>����������
 					<option value="�����л�" <%if(job_type.equals("�����л�")){%>selected<%}%>>�����л�
 					<option value="�Ϲ��ڿ���" <%if(job_type.equals("�Ϲ��ڿ���")){%>selected<%}%>>�Ϲ��ڿ���
 					<option value="������" <%if(job_type.equals("������")){%>selected<%}%>>������
 					<option value="�Ƿ���" <%if(job_type.equals("�Ƿ���")){%>selected<%}%>>�Ƿ���
 					<option value="������" <%if(job_type.equals("������")){%>selected<%}%>>������
 					<option value="����,���,������" <%if(job_type.equals("����,���,������")){%>selected<%}%>>����.���/������
 					<option value="��,��,����,������" <%if(job_type.equals("��,��,����,������")){%>selected<%}%>>��/��/����/������
 					<option value="�ֺ�" <%if(job_type.equals("�ֺ�")){%>selected<%}%>>�ֺ�
 					<option value="����" <%if(job_type.equals("����")){%>selected<%}%>>����
 					<option value="��Ÿ" <%if(job_type.equals("��Ÿ")){%>selected<%}%>>��Ÿ
		  		  </select>
				</td>                
              </tr>
              <tr>
                <TD BGCOLOR="#EFF4F8">&nbsp;�ڱ�Ұ�<font color=red>&nbsp;</font></td>
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
