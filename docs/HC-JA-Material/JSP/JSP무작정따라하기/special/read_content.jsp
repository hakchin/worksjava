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
String no = request.getParameter("no");
String title="";
String start_date="";
String e_mail ="";
String content = "";
String temp_content="";
String sql1 = " select nvl(title,' '),start_date,content"+
  	   " from schedule"+
	   " where no ="+no;
   try{
       stmt = conn.createStatement();
        rs = stmt.executeQuery(sql1);
        
        if(rs.next()){
        	title = rs.getString(1);
        	start_date= rs.getString(2);
        	content = rs.getString(3);
        }
        
        StringTokenizer st = new StringTokenizer(content,"\n");
        while(st.hasMoreTokens()){
        	temp_content = temp_content +st.nextToken()+"<br>";
        }
        content = temp_content;
       stmt.close();
        rs.close();
    }catch(SQLException e){
    	System.out.println(e.getMessage());
    	
    }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=euc-kr">
<STYLE TYPE="text/css">
  TD {font-family:"µ¸¿ò", "Verdana";font-size:9pt}
BODY {font-family: "µ¸¿ò", "Verdana"; font-size: 9pt}
a    { font-family: µ¸¿ò, Verdana; color: #asefgg; text-decoration: none}
a:hover { font-family:µ¸¿ò; text-decoration:underline }
</STYLE>
</head>
<body bgcolor="white" text="black" link="blue" vlink="purple" alink="red" leftmargin="0" topmargin="0">
<br><br>
<ul>
   <ul>
    	<table border="0" bordercolor=red width="570" cellpadding="0" cellspacing="0">
    	  <tr bgcolor="#aad3c9">
     	   <td colspan=6 background="cb_pt02.gif" align="center">
     	     <img src="cb_left02.gif" vspace="0" hspace="0" align="left">
     	     <img src="cb_right02.gif" align="right" vspace="0" hspace="0">
     		<table border=0 cellpadding="0" cellspacing="0">
     		</table>
     		</td>
    	       </tr>
  		</table>
       <table width="570" border="1" cellspacing="0" cellpadding="0" bordercolorlight="#000000" bordercolordark="#ffffff">
            <tr>
                <td width="570" colspan="2" bgcolor="#fff3e5"><p>&nbsp;</p>
                    <p align="center"><font size="3"><b>¸í &nbsp;&nbsp;Äª : <%=title%></b></font></p>
                    <p align="center"><font size="2">³¯ &nbsp;&nbsp;Â¥ : <%=start_date%></font></p>
                        <table border=0 cellpadding="10" cellspacing="10" bordercolordark="black"  bordercolorlight="black">
                                <tr>
                                    <td width="480" height="13" bgcolor="#f7e0c3" ><%=content%></td>
                            </tr>
                        </table>
		</ul><p>&nbsp;</td>
            </tr>
            </table>
            <table border="0" width="570" cellpadding="0" cellspacing="0">
 	   <tr bgcolor="#aad3c9">
  	     <td background="cb_pt03.gif" align=center vspace="30">
  	   	<img src="cb_left03.gif" align="left" vspace="0" hspace="0">
  	   	<img src="cb_right03.gif" align="right" vspace="0" hspace="0">
  	     </td>
  	  </tr>
  	</table>
  	  <p align=center><a href="javascript:history.go(-1)">[¸ñ·Ïº¸±â]</a></p>
        </ul>
    </ul>
</body>
</html>
