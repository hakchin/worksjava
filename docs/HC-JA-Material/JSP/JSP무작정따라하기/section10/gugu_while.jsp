<table border=1>
<%
int sum=0;
int i=1;
int j=1;
while(i<=9)
{
  j=1;
  while(j<=9)
  {
  sum = i*j;
%>
<tr>
  <td><%=i%> * <%=j%> = <%=sum%>
  </td> 
</tr>
<%
   j++;
  }
  i++;
}
%>
</table>
 