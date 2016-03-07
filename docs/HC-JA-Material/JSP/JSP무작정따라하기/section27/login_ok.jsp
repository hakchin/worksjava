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
String req_passwd = request.getParameter("passwd");
String passwd="";
String joining_time="";
String last_login_time="no";

String login_ok=" ";
String sql = " select passwd,to_char(joining_time,'yyyy/mm/dd'), "+
			" nvl(to_char(last_login_time,'yyyy/mm/dd hh:mi'),'no')"+
			 " from user_info"+
			 " where user_id='"+user_id+"'";
String sql2 = " update user_info "+
			  " set last_login_time = sysdate"+
			  " where user_id='"+user_id+"'";
	try{
    	stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        
        if(rs.next()){
        	passwd = rs.getString(1);
        	joining_time = rs.getString(2);
        	last_login_time = rs.getString(3);
        	if(passwd.equals(req_passwd)) {
        		login_ok="Y";
        		stmt.executeUpdate(sql2);
        	}
        	else {
        		login_ok="N";
        	}
        }else{
        	login_ok="N";
        }
        
    	stmt.close();
        rs.close();
    }catch(SQLException e){
    }
%>
<HTML>
<HEAD>
<TITLE>본 싸이트에 오신 것을 환영합니다..</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<STYLE TYPE="text/css">
<!--
body { font-family: 돋움, Verdana; font-size: 9pt}
td   { font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color: #000000} 
--->
</STYLE>
<SCRIPT>
function login_ok(){
	var ok_yn='<%=login_ok%>';
	if(ok_yn!='Y'){
		alert("아이디가 존재 하지않거나 비밀번호가 틀립니다.")
		history.go(-1);
	}
}
</SCRIPT>
</HEAD>

<BODY bgcolor="#FFFFFF" onload="login_ok();">
<%if (login_ok.equals("Y"))
{
%>
<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
  <TR BGCOLOR=#7AAAD5>
    <td align=left><img src=h_b02.gif></td>
    <td align=center><FONT COLOR="#FFFFFF"><b>로그인 성공</b></FONT></td>
    <td align=right><img src=f_b03.gif></td>
  </tr>
</table>
<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
<TR BGCOLOR=#948DCF>
  <TD>
    <TABLE CELLPADDING=4 CELLSPACING=1 BORDER=0 WIDTH=330>
  	  <TR BGCOLOR="#FFFFFF">
        <TD ALIGN="center">
          <%=user_id%>님 환영합니다.<br><br>
          회원가입 날짜:<%=joining_time%><br><br>
          <%
          	if(last_login_time.equals("no")){
          %>
          	첫번째 방문을 환영합니다.<br><br>
          <%
          	}else{
          %>
           마지막 로그인 시간:<%=last_login_time%><br><br>
          <%
          	}
          %>
        </TD>
      </TR>
    </TABLE>
 </TD>
</TR>
</TABLE>

<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
  <TR BGCOLOR=#7AAAD5>
    <td align=left><img src=h_b04.gif></td>
    <td align=right><img src=h_b05.gif></td>
  </tr>
</table>
<br><br>
<table cellpadding=0 cellspacing=0 border=0 width=330>
  <tr>
    <td align="center">
      <a href="javascript:view_userinfo();">[자기정보수정]</a>
    </td>
  </tr>
</table>
<script>
function view_userinfo(){
	document.view_userinfo.submit();
}
</script>
<form name="view_userinfo" action="view_userinfo.jsp">
  <input type="hidden" name="user_id" value="<%=user_id%>">  
</form>
<%
}
%>
</BODY>
</HTML>
