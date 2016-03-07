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

String search_name=request.getParameter("search_name");
	   if(search_name==null) search_name="";
	   else search_name=TO_DB(search_name);
Vector v_no = new Vector();
Vector v_name = new Vector();
Vector v_addr = new Vector();
Vector v_home_tel_no = new Vector();
Vector v_com_tel_no = new Vector();
Vector v_hand_tel_no = new Vector();
%>
<html>
<head>
<title>주소록 보여주기 </title>
<script language="JavaScript">
function search_name(){
	document.search.submit();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
</head>
<%
String sql = " select no,name,addr,home_tel_no,"+
			 " com_tel_no,hand_tel_no "+
			 " from address"+
			 " where name like '%"+search_name+"%'";
	
	try{
    	stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        
        while(rs.next()){
        	v_no.addElement(Integer.toString(rs.getInt(1)));
        	v_name.addElement(rs.getString(2));
        	v_addr.addElement(rs.getString(3));
        	v_home_tel_no.addElement(rs.getString(4));
        	v_com_tel_no.addElement(rs.getString(5));
        	v_hand_tel_no.addElement(rs.getString(6));
    	}
    	stmt.close();
        rs.close();
    }catch(SQLException e){
    }
%>
<body>
<table width="550" border="1" cellspacing="0" cellpadding="2" bordercolorlight="#173E7C" bordercolordark="white">
  <tr>
    <td width=50 align=center>번호</td>
    <td width=80 align=center>이름</td>
    <td width=120 align=center>주소</td>
    <td width=100 align=center>집전화번호</td>
    <td width=100 align=center>회사전화번호</td>
    <td width=100 align=center>핸드폰</td>
  </tr>
<%
 	for(int j=0;j<v_no.size();j++)
    {
%>
   <tr>
      <td align=center><%=v_no.elementAt(j)%></td>
      <td><%=v_name.elementAt(j)%></td>
      <td><%=v_addr.elementAt(j)%></td>
      <td><%=v_home_tel_no.elementAt(j)%></td>
      <td><%=v_com_tel_no.elementAt(j)%></td>
      <td><%=v_hand_tel_no.elementAt(j)%></td>
   </tr>
<%
       }
%>
</table>
<form name="search" method="post" action="addr_list.jsp">
<table width=550>
  <tr>
    <td>  찾는이름:
          <input type="text" name="search_name" size=10> &nbsp;
          <a href="javascript:search_name();">[조회]</a>
     </td>
   </tr>
</table>    
</form>
</body>
</html>
