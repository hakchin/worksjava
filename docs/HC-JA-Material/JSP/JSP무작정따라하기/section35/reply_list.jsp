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
Statement       stmt1 = null;
ResultSet       rs = null;
ResultSet       rs1 = null;

String search_word=request.getParameter("search_word");
  if(search_word==null) search_word="";
  else search_word=TO_DB(search_word);
String search_gubun=request.getParameter("search_gubun");
  if(search_gubun==null) search_gubun="0";

String str_c_page=request.getParameter("str_c_page");
  if(str_c_page ==null ) str_c_page = "1";
  int c_page = Integer.parseInt(str_c_page);

Vector v_articleid = new Vector();
Vector v_title = new Vector();
Vector v_write_date = new Vector();
Vector v_user_name = new Vector();
Vector v_hits = new Vector();
Vector v_type = new Vector();

String sql1 = " select count(articleid) "+
			  " from board "+
			  " where 1=1 ";

String sql2 = " select count(articleid) "+
			  " from board "+
			  " where to_char(write_date,'yyyymmdd') = to_char(sysdate,'yyyymmdd')";

String sql3 = " select distinct(a.articleid) "+
			  " from (select * from board "+
			 " where type='I') a, "+
			 " (select * from board where type='R') b"+
	         " where 1=1";
	
String sub1 =" and title like '%"+search_word+"%'";
String sub1_1 =" and a.title like '%"+search_word+"%'";
String sub1_2= " and a.articleid = b.parent_articleid(+)";
String sub2 = " and user_name like '%"+search_word+"%'";
String sub2_1= " and a.user_name like '%"+search_word+"%'";
			
if(search_gubun.equals("1")){
	sql1 = sql1 +sub1;
	sql2 = sql2 +sub1;
	sql3 = sql3 +sub1_1+sub1_2+" order by a.articleid desc ";
}else if(search_gubun.equals("2")){
	sql1 = sql1 +sub2;
	sql2 = sql2 +sub2;
	sql3 = sql3 +sub2_1+sub1_2+" order by a.articleid desc ";
}else{
	sql3  = sql3 +sub1_2+" order by a.articleid desc ";
}

int total_cnt=0;
int today_cnt=0;
int list_num = 10;
int t_page=0;
int page_num = 5;
int t_page_gubun = 1;
int c_page_gubun = 1;
int pre_page = 0;
int next_page = 0;

	try{
    	stmt = conn.createStatement();
    	stmt1 = conn.createStatement();
        rs = stmt.executeQuery(sql1);

        if(rs.next()){
        	total_cnt = rs.getInt(1);
        }
        rs = stmt.executeQuery(sql2);
        if(rs.next()){
        	today_cnt = rs.getInt(1);
        }
        rs = stmt.executeQuery(sql3);
        int k=0;
        int j=0;

        while(rs.next()){
            if(k<c_page*list_num){
            	String sql4 =" select articleid,nvl(title,' '),to_char(write_date,'yyyy/mm/dd hh:mi'), "+
            				 " nvl(user_name,' '), hits,type from board"+
            				 "	START WITH	articleid in("+rs.getString(1)+") "+
							 " CONNECT BY  parent_articleid = prior articleid ";
				
            	rs1 = stmt1.executeQuery(sql4);
            	while(rs1.next()){
        			k++;
        			if(k <= c_page*list_num && k > (c_page-1)*list_num ){
        				j++;
        				v_articleid.addElement(Integer.toString(rs1.getInt(1)));
        				v_title.addElement(rs1.getString(2));
        				v_write_date.addElement(rs1.getString(3));
        				v_user_name.addElement(rs1.getString(4));
        				v_hits.addElement(Integer.toString(rs1.getInt(5)));
        				v_type.addElement(rs1.getString(6));
        			}
        		}
        	}else{
        		break;
        	}
    	}
    	
    	if((total_cnt%list_num)==0){
			t_page = total_cnt/list_num;
		} else {
		   	t_page = (total_cnt/list_num)+1;
		}
    	stmt.close();
        rs.close();
        stmt1.close();
        rs1.close();
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
		alert("검색어를 입력하세요!");
		form.search_word.focus();
		return ;
	}
	form.action = "reply_list.jsp";
	form.submit();
}

function readContents(articlenum){
	document.go_read.articleid.value = articlenum;
	document.go_read.action ="../section32/read.jsp";
	document.go_read.submit();

}
function go_page(page)
{
 document.go_page.str_c_page.value = page;
 document.go_page.submit();
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
		<% if(total_cnt==0)
		{
		%>
		<tr>
	  	  <td>
	  		검색결과가 없습니다.
	  	  </td>
	   </tr>
	  <%
		}else{
	
			for(int j=0;j<v_articleid.size();j++){
			  if(v_type.elementAt(j).toString().equals("I")){
		%>
		
		  <tr bgcolor=ffffff onMouseOver=this.style.backgroundColor='#FFF8DE'  onMouseOut=this.style.backgroundColor='#FFFFFF'>
			 <td width=60 align=center bgcolor="#eff4fa"><%=v_articleid.elementAt(j)%>
			 </td>
			 <td width=330 align="left">&nbsp;
			   <a href="javascript:readContents(<%=v_articleid.elementAt(j)%>)">
			     <%=v_title.elementAt(j)%></a>
			  </td>
			 <td width=100 align=center><%=v_write_date.elementAt(j)%></td>
			 <td width=100 align=center><%=v_user_name.elementAt(j)%></td>
			 <td width=60 align=center><%=v_hits.elementAt(j)%></td>
		  </tr>
		  <%
		    }else{
		  %>
		  <tr bgcolor=ffffff onMouseOver=this.style.backgroundColor='#FFF8DE'  onMouseOut=this.style.backgroundColor='#FFFFFF'>
			 <td width=60 align=center bgcolor="#eff4fa">&nbsp;
			 </td>
			 <td width=330 align="left">&nbsp;
			   <img src="reply.gif" board=0>
			   <a href="javascript:readContents(<%=v_articleid.elementAt(j)%>)">
			     <%=v_title.elementAt(j)%></a>
			  </td>
			 <td width=100 align=center><%=v_write_date.elementAt(j)%></td>
			 <td width=100 align=center><%=v_user_name.elementAt(j)%></td>
			 <td width=60 align=center><%=v_hits.elementAt(j)%></td>
		  </tr>
		<%		}
			}
		}
		%>
		</table>
		<!-- 페이징 -->
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
       <%		
	    if((t_page%page_num)==0)
	    {
	    	t_page_gubun = t_page/page_num;
	    } else {
	    	t_page_gubun = (t_page/page_num)+1;
	    }
	    if((c_page%page_num)==0) c_page_gubun = c_page/page_num;
	    else c_page_gubun = (c_page/page_num)+1;
%>
<%
	if(total_cnt >0){
		if(c_page_gubun==1 && c_page_gubun == t_page_gubun)
		{
			for(int l=1;l<=t_page;l++)
			{
%>
          <a href="javascript:go_page(<%=l%>)">[
          <%
          if(c_page==l) out.print("<b>");
          %>
          <%=l%>
          <%
          if(c_page==l) out.print("</b>");
          %>
          ]</a>
          	
<%
			}
		}
%>

<%
		if(c_page_gubun==1 && c_page_gubun != t_page_gubun)
		{
			for(int l=1;l<=page_num;l++)
			{
%>
          <a href="javascript:go_page(<%=l%>)">[
          <%
          if(c_page==l) out.print("<b>");
          %>
          <%=l%>
          <%
          if(c_page==l) out.print("</b>");
          %>
          ]</a>
          	
<%
			}
		next_page = c_page_gubun*page_num+1;
			
%>
        <a href="javascript:go_page(<%=next_page%>)"> ▶</a>
<%
		}
%>
  <!--  //-->
<%
		if(c_page_gubun!=1 && c_page_gubun != t_page_gubun)
		{
		pre_page = (c_page_gubun-1)*page_num-4;
%>


		<a href="javascript:go_page(<%=pre_page%>)">◀</a>
<%
			for(int l=(c_page_gubun-1)*page_num+1;l<=c_page_gubun*page_num;l++)
			{
%>


          <a href="javascript:go_page(<%=l%>)">[
          <%
          if(c_page==l) out.print("<b>");
          %>
          <%=l%>
          <%
          if(c_page==l) out.print("</b>");
          %>
          ]</a>
          	
<%
			}
		next_page = c_page_gubun*page_num+1;
%>
			<a href="javascript:go_page(<%=next_page%>)">▶</a>
<%
		}
%>

<%
		if(c_page_gubun!=1 && c_page_gubun == t_page_gubun)
		{
		pre_page = (c_page_gubun-1)*page_num-4;
%>
	 <a href="javascript:go_page(<%=pre_page%>)">◀</a>

<%
			for(int l=(c_page_gubun-1)*page_num+1;l<=t_page;l++)
			{
%>
        <a href="javascript:go_page(<%=l%>)">[
        <%
          if(c_page==l) out.print("<b>");
          %>
          <%=l%>
          <%
          if(c_page==l) out.print("</b>");
          %>
        ]</a>
          	
<%
			}
		}
	}
%>			
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

<form name="go_read" method="post">
	<input type=hidden name=articleid>
</form>
<form name="go_page" method="post">
	<input type=hidden name=str_c_page>
	<input type=hidden name=search_gubun value="<%=search_gubun%>">
	<input type=hidden name=search_word value="<%=search_word%>">
</form>
	</td>
</tr>
</table>
</body>
</html>
