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
  <td colspan=3 align=center><font color=red><b>��ٱ��Ͽ� ���� ����</b></font></td>
 </tr>
    <tr>
      <td width=300> <b>����</b></font>
      </td>
      <td width=150> <b>����</b>
      </td>
      <td width=150> <b> ��ٱ��� �����ϱ�</b>
      </td>
    </tr>
<%
if(book[0].equals("put")){
%>
    <tr>
      <td> <font color=blue>�ڹٸ� ��ƶ�</font></td>
      <td>10,000��</td>
      <td> <a href="javascript:del_baguni('0')">[��ٱ��� �����ϱ�]</a></td>
    </tr>
<%
}
if(book[1].equals("put")){
%>
    <tr>
      <td> <font color=blue>��濡�� ���� JSP</font></td>
      <td>15,000��</td>
      <td> <a href="javascript:del_baguni('1')">[��ٱ��� �����ϱ�]</a></td>
    </tr>
<%
}
if(book[2].equals("put")){
%>
    <tr>
      <td> <font color=blue>JSP ������ �������</font></td>
      <td>20,000��</td>
      <td> <a href="javascript:del_baguni('2')">[��ٱ��� �����ϱ�]</a></td>
    </tr>
<%
}
if(book[3].equals("put")){
%>
    <tr>
      <td> <font color=blue>�ڹ� ���� JSP �Ѵ�</font></td>
      <td>25,000��</td>
      <td> <a href="javascript:del_baguni('3')">[��ٱ��� �����ϱ�]</a></td>
    </tr>
<%
}
if(book[4].equals("put")){
%>
    <tr>
      <td> <font color=blue>JSP�� ���θ� �����ϱ�</font></td>
      <td>30,000��</td>
      <td> <a href="javascript:del_baguni('4')">[��ٱ��� �����ϱ�]</a></td>
    </tr>
<%
}
%>
    <tr>
      <td colspan=3 align=center>
       <a href="javascript:go_first_list()">[���� ����ϱ�]</a> &nbsp;&nbsp;
       <a href="buy_result.jsp">[�ֹ��ϱ�]</a>
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