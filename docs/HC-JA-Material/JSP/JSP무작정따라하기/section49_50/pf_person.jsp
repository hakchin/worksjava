<%@ page contentType="text/xml;charset=euc-kr" %>
<%@ page language="java" import="java.sql.*,java.util.*,java.net.*,javax.servlet.http.* "%>
<%!
Connection DB_Connection() throws ClassNotFoundException, SQLException,Exception
{
  String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
  Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection conn=DriverManager.getConnection(url,"SCOTT","TIGER");
  return conn;
}
%>
<%
Connection      conn = DB_Connection();
Statement       stmt = null;
ResultSet       rs = null;
String key= request.getParameter("key");			
String strName=new String();
String strPhoto=new String();
String strStartwork= new String();
String strStartyear=new String();
String strBirth=new String();
String strWorks=new String();
String sq = "select  name,photo,startwork,startyear,birth,works from pf_person where key='"+key+"'";

  try{
  stmt = conn.createStatement();
  rs = stmt.executeQuery(sq);
  while(rs.next()){
    strName=rs.getString(1);
    strPhoto=rs.getString(2);
    strStartwork=rs.getString(3);
    strStartyear=rs.getString(4);
    strBirth=rs.getString(5);
    strWorks=rs.getString(6);
  }
  stmt.close();
  rs.close();
}catch(SQLException e){
}
%>
<?xml version="1.0" encoding="euc-kr" ?>
<?xml-stylesheet type="text/xsl" href="pf_person.xsl" ?>
<list>
  <person>
    <name><%=strName%></name>
    <photo><%=strPhoto%></photo>
    <startwork><%=strStartwork%></startwork>
    <startyear><%=strStartyear%></startyear>
    <birth><%=strBirth%></birth>
    <works><%=strWorks%></works>
  </person>
</list>
