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
String id_yn=" ";
String sql = " select count(user_id) "+
			 " from user_info"+
			 " where user_id='"+user_id+"'";
	try{
    	stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        
        int cnt=0;
        if(rs.next()){
        	cnt=rs.getInt(1);
        }
        if(cnt>0) id_yn="Y";
        else id_yn="N";
    	stmt.close();
        rs.close();
    }catch(SQLException e){
    }
%>
<HTML>
<HEAD>
<TITLE>������� ���̵� üũ�մϴ�.</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<STYLE TYPE="text/css">
<!--
body { font-family: ����, Verdana; font-size: 9pt}
td   { font-family: ����, Verdana; font-size: 9pt; text-decoration: none; color: #000000} 
--->
</STYLE>
<SCRIPT>
function check_id()
{
	/* ID �ߺ� üũ 
	 */
	var user_id;
	var tmp_url;

	user = document.id_ch.user_id.value;
	if (user == "") 
	{
		alert("���̵� �Է��ϼ���.");
		return false;
	}
	else if (user.length < 5 || user.length > 16)
	{
		alert("���̵�� 5�� �̻� 16�� ���� �Դϴ�.");
		return false;
	}
	else if(!a_or_d(document.id_ch.user_id.value))
	{
		alert("���̵�� �����̳� ���ڷ� �Է��ϼž� �մϴ�.")
		return false;
	}

	location.href='id_check.jsp?user_id=' + user;
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
function win_close(){
	opener.document.form_name.user_id.value='<%=user_id%>'
	self.close();
}
</SCRIPT>
</HEAD>
<BODY bgcolor="#FFFFFF">
<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
  <TR BGCOLOR=#7AAAD5>
    <td align=left><img src=u_b02.gif></td>
    <td align=center><FONT COLOR="#FFFFFF"><b>���̵� �ߺ� üũ</FONT></td>
    <td align=right><img src=u_b03.gif></td>
  </tr>
</table>
<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
<TR BGCOLOR=#948DCF>
  <TD>
    <TABLE CELLPADDING=4 CELLSPACING=1 BORDER=0 WIDTH=330>
  	  <TR BGCOLOR="#FFFFFF">
        <TD ALIGN="center">
        <%
          if(id_yn.equals("N")){
        %>
          <br><FONT FACE="����"><B>��� �����մϴ�.</B></FONT><br>
         <BR><FONT COLOR="#483cae"><b><%=user_id%></b></FONT>�� ���� ������ ���� ���̵��Դϴ�.
         <BR><FONT COLOR="#483cae"><b><%=user_id%></b></FONT>�� ����ϼŵ� �˴ϴ�.
         <%
         	}else{
         %>
         <br><font face="����"><b>�˼��մϴ�</b></font><br>
    	<BR><FONT COLOR="#483cae"><b><%=user_id%></b></FONT>�� �̹� ��� ���� ���̵��Դϴ�<br>
    	�ٸ� ���̵� ����Ͽ� �ֽʽÿ�.
    	<%
    		}
    	%>
         <form name=id_ch onsubmit="return false;"> 
           <INPUT NAME=user_id type=text size=16 maxlength=16>
      	   <input type=image src=u_bt08.gif border=0 vspace=0
      		onClick='check_id()'>
  		</form>
        </TD>
      </TR>
    </TABLE>
 </TD>
</TR>
</TABLE>

<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
  <TR BGCOLOR=#7AAAD5>
    <td align=left><img src=u_b04.gif></td>
    <td align=right><img src=u_b05.gif></td>
  </tr>
  <tr>
    <td colspan=3 align=center>
      <a href="#" onClick='win_close()'>
      <img src=u_bt13.gif border=0 vspace=5></a>
    </td>
  </tr>
</table>
</BODY>
</HTML>