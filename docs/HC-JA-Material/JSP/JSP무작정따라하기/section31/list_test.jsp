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

String search_word=request.getParameter("search_word");
	   if(search_word==null) search_word="";
	   else search_word=TO_DB(search_word);
String search_gubun=request.getParameter("search_gubun");
	  if(search_gubun==null) search_gubun="0";

Vector v_articleid = new Vector();
Vector v_title = new Vector();
Vector v_write_date = new Vector();
Vector v_user_name = new Vector();
Vector v_hits = new Vector();

String sql1 = " select count(articleid) "+
			  " from board "+
			  " where 1=1 ";

String sql2 = " select count(articleid) "+
			  " from board "+
			  " where to_char(write_date,'yyyymmdd') = to_char(sysdate,'yyyymmdd')";

String sql3 = " select "+
			  " articleid,title,to_char(write_date,'yyyy/mm/dd hh:mi'),user_name,hits "+
			 " from board "+
			 " where 1=1 ";
			
String sub1 =" and title like '%"+search_word+"%'";
String sub2 =" and user_name like '%"+search_word+"%'";

if(search_gubun.equals("1")){
	sql1 = sql1 +sub1;
	sql2 = sql2 +sub1;
	sql3 = sql3 +sub1+" order by articleid desc ";
}else if(search_gubun.equals("2")){
	sql1 = sql1 +sub2;
	sql2 = sql2 +sub2;
	sql3 = sql3 +sub2+" order by articleid desc ";
}else{
	sql3  = sql3 +" order by articleid desc ";
}
int total_cnt=0;
int today_cnt=0;
	try{
    	stmt = conn.createStatement();
        rs = stmt.executeQuery(sql1);

        if(rs.next()){
        	total_cnt = rs.getInt(1);
        }
        rs = stmt.executeQuery(sql2);
        if(rs.next()){
        	today_cnt = rs.getInt(1);
        }
        rs = stmt.executeQuery(sql3);
        while(rs.next()){
        	v_articleid.addElement(Integer.toString(rs.getInt(1)));
        	v_title.addElement(rs.getString(2));
        	v_write_date.addElement(rs.getString(3));
        	v_user_name.addElement(rs.getString(4));
        	v_hits.addElement(Integer.toString(rs.getInt(5)));
    	}
    	stmt.close();
        rs.close();
    }catch(SQLException e){
    }
%>
<html>
<head>
<STYLE TYPE="text/css" MEDIA="screen">
body  { font-size: 12px; font-family: 굴림; text-decoration: none; color: black }
th		{ font-size: 12px; font-family: 굴림; text-decoration: none; color: white }
td		{ font-size: 12px; font-family: 굴림; text-decoration: none; color: black }
a 		{ font-family: "굴림", "Verdana"; color: #000000; text-decoration: none }
  			a:link { font-family:굴림; font-size:9pt; text-decoration:none;}
  			a:visited { font-family:굴림; font-size:9pt; text-decoration:none;}
  			a:hover { font-family:굴림; text-decoration:underline ;}

</STYLE>

<script language="javascript">

function searchData(){
var form = document.board_search;
	if(!form.search_word.value){
		alert("검색어를 입력하여 주십시오");
		form.search_word.focus();
		return ;
	}
	form.action = "list_test.jsp";
	form.submit();
}

</script>
</head>
<body  topmargin=0 leftmargin=0>
<form name=board_search method=post>
<br>
<table width=730 border=0 cellspacing=0 cellpadding=0>
<tr>
	<td width=730 align=center>
		<table width=650 border=0 cellspacing=0 cellpadding=0>
		<tr height=20>
			<td width=10>&nbsp;</td>
			<td align=left  colspan=2>게시판 이름 : <font color="#0000FF">[자유게시판]</font></td>
			<td align=right colspan=3>등록 : <font color="#0000FF"><%=today_cnt%>/<%=total_cnt%></font>
			(오늘/전체)
			</font></td>
			<td width=10>&nbsp;</td>
		</tr>
		</table>
		<table width=650 border=0 cellspacing=0 cellpadding=0>
		<tr bgcolor="#7baad6" height=21>
				<td width=10  valign=bottom align="left"><img src="j_b19.gif" border="0" align=absmiddle></td>
				<th width=50  valign=bottom align=center>번호</th>
				
					<th width=330 valign=bottom align=center>제목</th>
					<th width=100 valign=bottom align=center>날짜</th>
					<th width=100 valign=bottom align=center>글쓴이</th>
					<th width=50  valign=bottom align=center>조회수</th>
						
				<td width=10  valign=bottom align= right><img src="j_b20.gif" border="0" align=absmiddle></td>
		</tr>
		</table>
		<!-- 내  용 -->
		<table width=650 bgcolor=#7BAAD6 cellpadding=4 cellspacing=1 border=0>
		<%
			for(int j=0;j<v_articleid.size();j++){
		%>
		  <tr bgcolor=ffffff onMouseOver=this.style.backgroundColor='#FFF8DE'  onMouseOut=this.style.backgroundColor='#FFFFFF'>
			 <td width=60 align=center bgcolor="#eff4fa"><%=v_articleid.elementAt(j)%>
			 </td>
			 <td width=330 align="left">&nbsp;
			     <%=v_title.elementAt(j)%>
			  </td>
			 <td width=100 align=center><%=v_write_date.elementAt(j)%></td>
			 <td width=100 align=center><%=v_user_name.elementAt(j)%></td>
			 <td width=60 align=center><%=v_hits.elementAt(j)%></td>
		  </tr>
		<%
			}
		%>
		</table>
		
		<table width=650 BGCOLOR=000000 border=0 cellpadding=0 cellspacing=0>
		<tr  bgcolor="#7baad6" height=5>
		    <td colspan=4 align="center" valign="bottom">
		      <img src="j_b04.gif" border="0" align="left" hspace="0" vspace="0">
		      <img src="j_b05.gif" border="0" align="right" hspace="0" vspace="0">
		    </td>
		</tr>
		<tr BGCOLOR=FFFFFF>
			<td width=10>&nbsp;</td>
			<td width=450  align=center valign=middle height=30>
			
			</td>

			<td width=180 height=30 valign=middle align=right>
			  <a href="../section30/write_form.jsp"><img src="m_bt10.gif" border=0 align=absmiddle></a>
			</td>
			<td width=10>&nbsp;</td>
		</tr>

		<tr BGCOLOR=FFFFFF>
			<td width=10>&nbsp;</td>
			<td align=left width=630 colspan=2 valign=bottom>
			<img src="bg_01.gif" border=0 align=absmiddle>
			<select name=search_gubun>
				<option value="1">제목</option>
				<option value="2">작성자</option>
			</select>
			<img src="bg_02.gif" border=0 align=absmiddle>
			<input type="text" name="search_word" maxlength=20>
			<input type="image" src="m_bt05.gif" align=absmiddle name="submit_search" value="찾기" onclick="return searchData()">
			</td>
			<td width=10>&nbsp;</td>
		</tr>
		</table>
</form>

	</td>
</tr>
</table>
</body>
</html>
