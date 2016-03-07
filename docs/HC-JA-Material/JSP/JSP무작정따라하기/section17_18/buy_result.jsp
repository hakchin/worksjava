<%@ page language="java" import="java.util.*" %>
<%
String book[]=new String[5];
int sum=0;
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
<body>
<table width=450>
<tr>
  <td colspan=2 align=center><font color=red><b>주문하신 서적</b></font></td>
 </tr>
    <tr>
      <td width=300> <b>제목</b></font></td>
      <td width=150> <b>가격</b>
      </td>
    </tr>
<%
if(book[0].equals("put")){
    sum+=10000;
%>
    <tr>
      <td> <font color=blue>자바를 잡아라</font></td>
      <td>10,000원</td>
    </tr>
<%
}
if(book[1].equals("put")){
	sum+=15000;
%>
    <tr>
      <td> <font color=blue>골방에서 배우는 JSP</font></td>
      <td>15,000원</td>
    </tr>
<%
}
if(book[2].equals("put")){
	sum+=20000;
%>
    <tr>
      <td> <font color=blue>JSP 무작정 따라잡기</font></td>
      <td>20,000원</td>
    </tr>
<%
}
if(book[3].equals("put")){
	sum+=25000;
%>
    <tr>
      <td> <font color=blue>자바 몰라도 JSP 한다</font></td>
      <td>25,000원</td>
    </tr>
<%
}
if(book[4].equals("put")){
	sum+=30000;
%>
    <tr>
      <td> <font color=blue>JSP로 쇼핑몰 구축하기</font></td>
      <td>30,000원</td>
    </tr>
<%
}
%>
    <tr>
      <td colspan=2><br>
        주문하신 서적의 <font color=red>총액은</font><b> <%=sum%></b>원입니다. <br>
        입금확인 후 우송하여 드리겠습니다.
      </td>
    </tr>
</table>
</body>
</html>