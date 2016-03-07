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
String TO_DB(String str) throws Exception
{
   if(str==null)
   {
   return null;
   }
   return new String(str.getBytes("8859_1"),"KSC5601");
}
%>
<%
Connection      conn = DB_Connection();
Statement       stmt = null;
ResultSet rs = null;
String first_yn="Y";
Vector v_sido_name = new Vector();
Vector v_gugun_name = new Vector();
Vector v_dong_name = new Vector();
Vector v_start_bunji = new Vector();
Vector v_end_bunji = new Vector();
Vector v_bigo = new Vector();
Vector v_zip1 = new Vector();
Vector v_zip2 = new Vector();

if(request.getParameter("first_yn").equals("Y")){
	first_yn="Y";
}else{
	first_yn="N";
}
String address="";
if(first_yn.equals("N")){
		address=request.getParameter("address");
		address = TO_DB(address);
String sql = " select sido_name,gugun_name,nvl(dong_name,' '), nvl(start_bunji,' '),nvl(end_bunji,' '),"+
			 " nvl(bigo,' '), substr(zipcode,1,3),substr(zipcode,4,6) "+
			 " from post "+
			 " where sido_name like '%"+address+"%' "+
			 " or gugun_name like '%"+address+"%' "+
			 " or dong_name like '%"+address+"%' "+
			 " or bigo like '%"+address+"%' ";
	try{
    	stmt = conn.createStatement();
    	rs = stmt.executeQuery(sql);
    	while(rs.next()){
    		v_sido_name.addElement(rs.getString(1));
    		v_gugun_name.addElement(rs.getString(2));
    		v_dong_name.addElement(rs.getString(3));
    		v_start_bunji.addElement(rs.getString(4));
    		v_end_bunji.addElement(rs.getString(5));
    		v_bigo.addElement(rs.getString(6));
    		v_zip1.addElement(rs.getString(7));
    		v_zip2.addElement(rs.getString(8));
    	}
    	stmt.close();
    }catch(SQLException e){
    }
}
%>
<HTML>
<HEAD>
<TITLE>우편번호 찾기</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<STYLE TYPE="text/css">
<!--
body { font-family: 돋움, Verdana; font-size: 9pt}
td   { font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color: #000000}
a    { font-family: 돋움, Verdana; color: #000000; text-decoration: none}
     a:link { font-family:돋움; font-size:9pt; text-decoration:none}
     a:visited { font-family:돋움; font-size:9pt; text-decoration:none}
     a:hover { font-family:돋움; text-decoration:underline }
-->
</STYLE>
<SCRIPT>
function check()
{
	if (document.inquiry.address.value == "")
	{
		alert("동이름을 입력하세요");
		document.inquiry.address.focus();
		return false;
	}
}

function sendaddr(code1,code2,sido_name,gugun_name,dong_name,bigo){
	var address = sido_name+" "+gugun_name+" "+dong_name+" "+bigo;
	opener.document.form_name.zip1.value=code1;
	opener.document.form_name.zip2.value=code2;
	opener.document.form_name.address.value=address;
	self.close();
}
</SCRIPT>
</HEAD>

<BODY BGCOLOR="#FFFFFF" onLoad="document.inquiry.address.focus();">
<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
  <TR BGCOLOR=#7AAAD5>
    <td align=left><img src=u_b02.gif></td>
    <td align=center><FONT COLOR="#FFFFFF"><b>우편번호 찾기</FONT></td>
    <td align=right><img src=u_b03.gif></td>
  </tr>
</table>

<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330><TR><TD BGCOLOR=#948DCF>
  <TABLE CELLPADDING=0 CELLSPACING=1 BORDER=0 WIDTH=330><TR><TD>
    <TABLE BORDER=0 CELLSPACING=0 CELLPADDING=3 WIDTH=100% BGCOLOR=#FFFFFF>
    <FORM NAME="inquiry" METHOD="post" ACTION="post.jsp" onSubmit="return check();">
      <TR>
        <TD ALIGN=CENTER><br>
          동이름 입력 : <INPUT NAME="address" TYPE="text" style="width:120">
          <INPUT TYPE="image" src="u_bt08.gif" hspace=10
          onclick= "return check();">
        </TD>
      </TR>
      <TR>
        <TD ALIGN=CENTER>
        ※검색 후, 아래 우편번호를 클릭하면 자동으로 입력됩니다.
        </TD>
      </TR>
 <%
 if(first_yn.equals("N")){
 	for(int j=0;j<v_sido_name.size();j++){
 %>
      <TR>
        <TD>
          <a href="javascript:sendaddr('<%=v_zip1.elementAt(j)%>','<%=v_zip2.elementAt(j)%>','<%=v_sido_name.elementAt(j)%>','<%=v_gugun_name.elementAt(j)%>','<%=v_dong_name.elementAt(j)%>','<%=v_bigo.elementAt(j)%>');">
          <%=v_zip1.elementAt(j)%>-<%=v_zip2.elementAt(j)%> <%=v_sido_name.elementAt(j)%>&nbsp;<%=v_gugun_name.elementAt(j)%>&nbsp;<%=v_dong_name.elementAt(j)%>&nbsp;<%=v_bigo.elementAt(j)%>
          <%
           if(v_start_bunji.elementAt(j).toString().trim().length()>0)
            {
          %>
          <%=v_start_bunji.elementAt(j)%>∼ <%=v_end_bunji.elementAt(j)%>
          <%
            }
          %>
          </a>
        </TD>
      </TR>
 <%
   }
 }
 %>
 <input type="hidden" name="first_yn" value="N" >
    </FORM>
    </TABLE>
  </TD></TR></TABLE>
</TD></TR></TABLE>

<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
  <TR BGCOLOR=#7AAAD5>
    <td align=left><img src=u_b04.gif></td>
    <td align=right><img src=u_b05.gif></td>
  </tr>
  <tr>
    <td colspan=2 align=center>
      <a href="#" onClick='self.close()'>
      <img src=u_bt13.gif border=0 vspace=5></a>
    </td>
  </tr>
</table>
</BODY>
</HTML>
