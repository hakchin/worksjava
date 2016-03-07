<%@ page language="java" import="java.util.*" %>
<%
String book[]=new String[5];
for(int k=0;k<5;k++){
	book[k]="";
}
String userid="";
Cookie[] cookies = request.getCookies();
for ( int i = 0; i < cookies.length; i++ ) {
	if (cookies[i].getName().equals("userid") == true){
		userid = cookies[i].getValue();
	}
	for(int j=0;j<5;j++){
	    String bookname="book"+Integer.toString(j);
		if (cookies[i].getName().equals(bookname) == true){
			book[j] = cookies[i].getValue();
		}
	}
}
%>
<html>
<head>
<script language="javascript">
function go_first_list(){
	location.href="first_list.jsp";
}
function del_baguni(bookid){
	var id='<%=userid%>';
	var bid=bookid
	document.del_baguni.elements[bid].value="del";
	document.del_baguni.submit();
}
</script>
</head>
<body>
<table>
<tr>
  <td colspan=3 align=center><font color=red><b>장바구니에 담은 서적</b></font></td>
 </tr>
    <tr>
      <td width=300> <b>제목</b></font>
      </td>
      <td width=150> <b>가격</b>
      </td>
      <td width=150> <b> 장바구니 제외하기</b>
      </td>
    </tr>
<%
if(book[0].equals("put")){
%>
    <tr>
      <td> <font color=blue>자바를 잡아라</font></td>
      <td>10,000원</td>
      <td> <a href="javascript:del_baguni('0')">[장바구니 제외하기]</a></td>
    </tr>
<%
}
if(book[1].equals("put")){
%>
    <tr>
      <td> <font color=blue>골방에서 배우는 JSP</font></td>
      <td>15,000원</td>
      <td> <a href="javascript:del_baguni('1')">[장바구니 제외하기]</a></td>
    </tr>
<%
}
if(book[2].equals("put")){
%>
    <tr>
      <td> <font color=blue>JSP 무작정 따라잡기</font></td>
      <td>20,000원</td>
      <td> <a href="javascript:del_baguni('2')">[장바구니 제외하기]</a></td>
    </tr>
<%
}
if(book[3].equals("put")){
%>
    <tr>
      <td> <font color=blue>자바 몰라도 JSP 한다</font></td>
      <td>25,000원</td>
      <td> <a href="javascript:del_baguni('3')">[장바구니 제외하기]</a></td>
    </tr>
<%
}
if(book[4].equals("put")){
%>
    <tr>
      <td> <font color=blue>JSP로 쇼핑몰 구축하기</font></td>
      <td>30,000원</td>
      <td> <a href="javascript:del_baguni('4')">[장바구니 제외하기]</a></td>
    </tr>
<%
}
%>
    <tr>
      <td colspan=3 align=center>
       <a href="javascript:go_first_list()">[쇼핑 계속하기]</a> &nbsp;&nbsp;
       <a href="buy_result.jsp">[주문하기]</a>
      </td>
    </tr>
</table>
<form name="del_baguni" method="post" action="put_baguni.jsp">
<%
 for(int i=0;i<=4;i++){
%>
<input type=hidden name="book<%=i%>" >
<%
 }
%>
<input type=hidden name="userid" value="<%=userid%>">
</form>
</body>
</html>