<%@ page contentType="text/xml; charset=euc-kr" %>
<%@ page language="java" import="java.sql.*,java.util.*,javax.servlet.http.* "%>
<%!
Connection DB_Connection() throws ClassNotFoundException, SQLException,Exception{ 
  String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
  Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection conn=DriverManager.getConnection(url,"SCOTT","TIGER");
  return conn;
}
%><%
Connection      conn = DB_Connection();
Statement       stmt = null;
ResultSet       rs = null;
String no= request.getParameter("movie_no");
String strTitle=new String();
String strImage=new String();
String strGrade= new String();
String strTime=new String();
String strDirector=new String();
String strActor1=new String();
String strActor2=new String();
String strActor3=new String();
String strStory=new String();
String strName0=new String();
String strName1=new String();
String strName2=new String();
String strName3=new String();
String sql="select  title,image,grade,time,director,actor1,actor2,actor3,story from movie where movie_no='"+no+"'";
String sql2=" ";
  try{
    stmt = conn.createStatement();
    rs = stmt.executeQuery(sql);
    while(rs.next()){
      strTitle=rs.getString(1);
      strImage=rs.getString(2);
      strGrade=rs.getString(3);
      strTime=rs.getString(4);
      strDirector=rs.getString(5);
      strActor1=rs.getString(6);
      strActor2=rs.getString(7);
      strActor3=rs.getString(8);
      strStory=rs.getString(9);    
}
    if(strDirector!=" "){
      sql2="select name from pf_person "+" where key='"+strDirector+"'";
      rs = stmt.executeQuery(sql2);
      if(rs.next()){
        strName0=rs.getString(1);
      }else{
        strName0=" ";
      }
    }
    if(strActor1!=" "){
      sql2=" select name from pf_person "+" where key='"+strActor1+"'";
      rs = stmt.executeQuery(sql2);
      if(rs.next()){
      strName1=rs.getString(1);
    }else{
      strName1=" ";
    }
  }
  if(strActor2!=" "){
    sql2=" select name from pf_person "+	" where key='"+strActor2+"'";
    rs = stmt.executeQuery(sql2);
    if(rs.next()){
      strName2=rs.getString(1);
    }else{
      strName2=" ";
    }
  }
  if(strActor3!=" "){
    sql2=" select name from pf_person "+	" where key='"+strActor3+"'";
    rs = stmt.executeQuery(sql2);
  if(rs.next()){
    strName3=rs.getString(1);
  }else{
    strName3=" ";
  }
}
  stmt.close();
  rs.close();
}catch(SQLException e){  
}
%>
<?xml version="1.0" encoding="euc-kr" ?>
<?xml-stylesheet type="text/xsl" href="pf_movie.xsl" ?>
<list>
  <movie>
    <title><%=strTitle%></title>
    <image><%=strImage%></image>
    <grade><%=strGrade%></grade>
    <time><%=strTime%></time>
    <director><%=strName0%></director>
    <director_url>pf_person.jsp?key=<%=strDirector%></director_url>
    <actor1><%=strName1%></actor1>
    <actor1_url>pf_person.jsp?key=<%=strActor1%></actor1_url>
    <actor2><%=strName2%></actor2>
    <actor2_url>pf_person.jsp?key=<%=strActor2%></actor2_url>
    <actor3><%=strName3%></actor3>
    <actor3_url>pf_person.jsp?key=<%=strActor3%></actor3_url>
    <story><%=strStory%></story>
  </movie>
</list>