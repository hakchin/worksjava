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
ResultSet       rs = null;

String user_id=request.getParameter("user_id");
String search_gubun="0";
       search_gubun=request.getParameter("search_gubun");
       if(search_gubun==null) search_gubun="0";
String search_name=request.getParameter("search_name");
	   if(search_name==null) search_name="";
	   else search_name=TO_DB(search_name);

Vector v_user_id = new Vector();
Vector v_user_name = new Vector();
Vector v_security_id1 = new Vector();
Vector v_security_id2 = new Vector();
Vector v_addr_gubun = new Vector();
Vector v_address = new Vector();
Vector v_tel1 = new Vector();
Vector v_tel2 = new Vector();
Vector v_tel3 = new Vector();
Vector v_open_yn = new Vector();
Vector v_job_type = new Vector();
%>
<html>
<head>
<title>ȸ����� �����ֱ�</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<STYLE TYPE="text/css">
<!--
body { font-family: ����, Verdana; font-size: 9pt}
td   { font-family: ����, Verdana; font-size: 9pt; text-decoration: none; color: #000000} 
--->
</STYLE>
<script language="JavaScript">
function search_name(){
	document.search.submit();
}
function go_del(del_id){
	document.go_del.del_id.value=del_id;
 var id='<%=user_id%>';
 if(id=='webmaster'){
 	del=confirm("������ �����Ͻðڽ��ϱ�");
 	if(del){
 		document.go_del.submit();
 	}
 }else{
 	alert("webmaster���� ������ �� �ֽ��ϴ�.");
 }
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
</head>
<%
String sql = " select user_id,user_name,security_id1,security_id2,"+
		 " addr_gubun,address, "+
		 " tel1,tel2,tel3, "+
		 " open_yn,job_type "+
		 " from user_info";

	if(search_gubun.equals("1")){
		 sql=sql+" where user_name like '%"+search_name+"%'";
	}else if(search_gubun.equals("2")){
		 sql=sql+" where address like '%"+search_name+"%'";
	}

	try{
    	stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        
        while(rs.next()){
        	v_user_id.addElement(rs.getString(1));
        	v_user_name.addElement(rs.getString(2));
        	v_security_id1.addElement(rs.getString(3));
        	v_security_id2.addElement(rs.getString(4));
        	v_addr_gubun.addElement(rs.getString(5));
        	v_address.addElement(rs.getString(6));
        	v_tel1.addElement(rs.getString(7));
        	v_tel2.addElement(rs.getString(8));
        	v_tel3.addElement(rs.getString(9));
        	v_open_yn.addElement(rs.getString(10));
        	v_job_type.addElement(rs.getString(11));
    	}
    	stmt.close();
        rs.close();
    }catch(SQLException e){
    }
%>
<body>
<table width="550" border="1" cellspacing="0" cellpadding="2" bordercolorlight="#173E7C" bordercolordark="white">
  <tr>
    <td width=50 align=center>ID</td>
    <td width=80 align=center>�̸�</td>
    <td width=120 align=center>�ּ�</td>
    <td width=100 align=center>�ֹε�Ϲ�ȣ</td>
    <td width=100 align=center>��ȭ��ȣ</td>
    <td width=100 align=center>����</td>
    <td width=100 align=center>��������</td>
    
  </tr>
<%
 	for(int j=0;j<v_user_id.size();j++)
    {
%>
   <tr>
      <td align=center><%=v_user_id.elementAt(j)%></td>
      <td align=center><%=v_user_name.elementAt(j)%></td>
      <td width=300><% if(v_open_yn.elementAt(j).toString().equals("Y")){ %>
      	  <%=v_address.elementAt(j)%>(
          <%if(v_addr_gubun.elementAt(j).toString().equals("1")){%> ȸ�� <%}%>
          <%if(v_addr_gubun.elementAt(j).toString().equals("2")){%> �� <%}%>)
          <%}%><br>
      </td>
      <td align=center>
        <%if(user_id.equals("webmaster")){%>
        <%=v_security_id1.elementAt(j)%>-<%=v_security_id2.elementAt(j)%>
        <br>
        <%}else{%>
        <%=v_security_id1.elementAt(j)%>-*******
        <br>
        <%}%>
      </td>
      <td align=center>
      	<% if(v_open_yn.elementAt(j).toString().equals("Y")){ %>
        <%=v_tel1.elementAt(j)%>-<%=v_tel2.elementAt(j)%>-<%=v_tel3.elementAt(j)%>
        <%}%><br>
       </td>
      <td align=center>
      <% if(v_open_yn.elementAt(j).toString().equals("Y")){ %>
       <%=v_job_type.elementAt(j)%>
      <%}%><br>
      </td>
      <td align=center><a href="javascript:go_del('<%=v_user_id.elementAt(j)%>')">[����]</a></td>
   </tr>
<%
       }
%>
</table>
<form name="search" method="post" action="user_list.jsp">
<table width=550>
  <tr>
    <td>
      <select name="search_gubun">
        <option value="1">�̸� </option>
        <option value="2">�ּ� </option>
        
    </td>
    <td>  ã���̸�:
          <input type="text" name="search_name" size=10> &nbsp;
          <input type=hidden name="user_id" value="<%=user_id%>">
          <a href="javascript:search_name();">[��ȸ]</a>
     </td>
   </tr>
</table>    
</form>
<form name="go_del" method="post" action="user_delete.jsp">
<input type=hidden name="del_id" value="">
<input type=hidden name="user_id" value="<%=user_id%>">
</form>
</body>
</html>
