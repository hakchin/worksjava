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

Vector v_name = new Vector();
Vector v_position = new Vector();
Vector v_salary = new Vector();
%>
<html>
<head>
<title>�޿� �����ֱ� </title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
</head>
<%
String sql = " select name,position,salary "+
			 " from salary";
	try{
    	stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        
        while(rs.next()){
        	v_name.addElement(rs.getString(1));
        	v_position.addElement(rs.getString(2));
        	v_salary.addElement(Integer.toString(rs.getInt(3)));
    	}
    	stmt.close();
        rs.close();
    }catch(SQLException e){
    }
%>
<body>
<table width="300" border="1" cellspacing="0" cellpadding="2" bordercolorlight="#173E7C" bordercolordark="white">
  <tr>
    <td width=100 align=center><b>�̸�</b></td>
    <td width=100 align=center><b>��å</b></td>
    <td width=100 align=center><b>����</b></td>
  </tr>
<%
 	for(int j=0;j<v_name.size();j++)
    {
%>
   <tr>
      <td align=center><%=v_name.elementAt(j)%></td>
      <td align=center><% if (v_position.elementAt(j).toString().equals("1")){%>
      		�Ƹ�����Ʈ��
          <%}%>
          <% if (v_position.elementAt(j).toString().equals("2")){%>
      		���
          <%}%>
          <% if (v_position.elementAt(j).toString().equals("3")){%>
      		�븮
          <%}%>
          <% if (v_position.elementAt(j).toString().equals("4")){%>
      		����
          <%}%>
          <% if (v_position.elementAt(j).toString().equals("5")){%>
      		����
          <%}%>
          <% if (v_position.elementAt(j).toString().equals("6")){%>
      		�̻�
          <%}%>
          <% if (v_position.elementAt(j).toString().equals("7")){%>
      		����
          <%}%>
      </td>
      <td align=center><%=v_salary.elementAt(j)%>����</td>
   </tr>
<%
       }
%>
</table>
</body>
</html>
