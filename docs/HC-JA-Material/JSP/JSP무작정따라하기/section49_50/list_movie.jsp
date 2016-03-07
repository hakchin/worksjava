<%@ page contentType="text/xml; charset=euc-kr" %>
<%@ page language="java" import="java.sql.*,java.util.*,javax.servlet.http.* "%>
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
Vector v_no=new Vector();
Vector v_title= new Vector();
Vector v_image=new Vector();
Vector v_grade= new Vector();
Vector v_time=new Vector();
Vector v_director=new Vector();
Vector v_actor1=new Vector();
Vector v_actor2=new Vector();
Vector v_actor3=new Vector();
Vector v_name0=new Vector();
Vector v_name1=new Vector();
Vector v_name2=new Vector();
Vector v_name3=new Vector();
String sql1 = "select movie_no,title,grade,time,director,actor1,actor2,actor3 from movie";
String sql2 = " ";
  try{
    stmt = conn.createStatement();
      rs = stmt.executeQuery(sql1);        
      while(rs.next()){
        v_no.addElement(rs.getString(1));
        v_title.addElement(rs.getString(2));
        v_grade.addElement(rs.getString(3));
        v_time.addElement(rs.getString(4));
        v_director.addElement(rs.getString(5));
        v_actor1.addElement(rs.getString(6));		
        v_actor2.addElement(rs.getString(7));
        v_actor3.addElement(rs.getString(8));
      }
      for(int j=0;j<v_no.size();j++){
        sql2=" select name from pf_person "+" where key='"+v_director.elementAt(j).toString()+"'";
        rs = stmt.executeQuery(sql2);
        if(rs.next()){
          v_name0.addElement(rs.getString(1));
        }else{
          v_name0.addElement(" ");
        }
        sql2=" select name from pf_person "+" where key='"+v_actor1.elementAt(j).toString()+"'";
        rs = stmt.executeQuery(sql2);
        if(rs.next()){
          v_name1.addElement(rs.getString(1));
        }else{
          v_name1.addElement(" ");
        }
        sql2=" select name from pf_person "+" where key='"+v_actor2.elementAt(j).toString()+"'";
        rs = stmt.executeQuery(sql2);
        if(rs.next()){
         v_name2.addElement(rs.getString(1));
        }else{  
          v_name2.addElement(" ");
        }
        sql2=" select name from pf_person "+" where key='"+v_actor3.elementAt(j).toString()+"'";
        rs = stmt.executeQuery(sql2);
        if(rs.next()){
          v_name3.addElement(rs.getString(1));
        }else{
          v_name3.addElement(" ");
        }
      } 
        stmt.close();
        rs.close();
    }catch(SQLException e){
  }
%>
<?xml version="1.0" encoding="euc-kr" ?>
<?xml-stylesheet type="text/xsl" href="list_movie.xsl" ?>
<list>
<%for(int i=0;i<v_title.size();i++){%>
  <movie>
    <title><%=v_title.elementAt(i)%></title>
    <title_url>pf_movie.jsp?movie_no=<%=v_no.elementAt(i)%></title_url>
    <grade><%=v_grade.elementAt(i)%></grade>
    <time><%=v_time.elementAt(i)%></time>
    <director><%=v_name0.elementAt(i)%></director>
    <director_url>pf_person.jsp?key=<%=v_director.elementAt(i)%></director_url>
    <actor1><%=v_name1.elementAt(i)%></actor1>
    <actor1_url>pf_person.jsp?key=<%=v_actor1.elementAt(i)%></actor1_url>
    <actor2><%=v_name2.elementAt(i)%></actor2>
    <actor2_url>pf_person.jsp?key=<%=v_actor2.elementAt(i)%></actor2_url>
    <actor3><%=v_name3.elementAt(i)%></actor3>
    <actor3_url>pf_person.jsp?key=<%=v_actor3.elementAt(i)%></actor3_url>
  </movie>
<%}%>
</list>