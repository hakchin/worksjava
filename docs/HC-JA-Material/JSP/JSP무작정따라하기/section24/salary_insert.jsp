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
PreparedStatement pstmt=null;

String name=request.getParameter("name");	
	   name = TO_DB(name);
String position =request.getParameter("pos");	
String sql=" insert into salary "+
		   " values('"+name+
		   "','"+position+
		   "',?)";
int salary=0;
	try{
    	pstmt = conn.prepareStatement(sql);
    	if(position.equals("1")){//아르바이트
    		salary=80;
    	}else if(position.equals("2")){//사원
    		salary=120;
    	}else if(position.equals("3")){//대리
    		salary=140;
    	}else if(position.equals("4")){//과장
    		salary=160;
    	}else if(position.equals("5")){//부장
    		salary=180;
    	}else if(position.equals("6")){//이사
    		salary=200;
    	}else if(position.equals("7")){//사장
    		salary=250;
    	}
    	pstmt.setInt(1,salary);
    	pstmt.executeUpdate();
    	pstmt.close();
    }catch(SQLException e){
    }
%>
<html>
<head>
<script language="Javascript">
function alrim(){
	alert("성공적으로 등록하였습니다.")
	location.href="salary_insert_form.jsp";
}
</script>
</head>
<body onload="alrim();">
</body>
</html>
