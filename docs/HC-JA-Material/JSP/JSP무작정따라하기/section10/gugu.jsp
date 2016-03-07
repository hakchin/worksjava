<table border=1>
<%
int sum=0;
for(int i=1;i<=9;i++)
{
  for(int j=1;j<=9;j++)
  {
  sum = i*j;
%>
<tr>
  <td><%=i%> * <%=j%> = <%=sum%>
  </td> 
</tr>
<%
  }
}
%>
</table>
 