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
  <td colspan=2 align=center><font color=red><b>�ֹ��Ͻ� ����</b></font></td>
 </tr>
    <tr>
      <td width=300> <b>����</b></font></td>
      <td width=150> <b>����</b>
      </td>
    </tr>
<%
if(book[0].equals("put")){
    sum+=10000;
%>
    <tr>
      <td> <font color=blue>�ڹٸ� ��ƶ�</font></td>
      <td>10,000��</td>
    </tr>
<%
}
if(book[1].equals("put")){
	sum+=15000;
%>
    <tr>
      <td> <font color=blue>��濡�� ���� JSP</font></td>
      <td>15,000��</td>
    </tr>
<%
}
if(book[2].equals("put")){
	sum+=20000;
%>
    <tr>
      <td> <font color=blue>JSP ������ �������</font></td>
      <td>20,000��</td>
    </tr>
<%
}
if(book[3].equals("put")){
	sum+=25000;
%>
    <tr>
      <td> <font color=blue>�ڹ� ���� JSP �Ѵ�</font></td>
      <td>25,000��</td>
    </tr>
<%
}
if(book[4].equals("put")){
	sum+=30000;
%>
    <tr>
      <td> <font color=blue>JSP�� ���θ� �����ϱ�</font></td>
      <td>30,000��</td>
    </tr>
<%
}
%>
    <tr>
      <td colspan=2><br>
        �ֹ��Ͻ� ������ <font color=red>�Ѿ���</font><b> <%=sum%></b>���Դϴ�. <br>
        �Ա�Ȯ�� �� ����Ͽ� �帮�ڽ��ϴ�.
      </td>
    </tr>
</table>
</body>
</html>