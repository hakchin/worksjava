<html>
<head>
<title>checkbox test</title>
<body>
<%
	String[] checks = request.getParameterValues("field");
	String checksresult = "";
	for(int i=0;i<checks.length;i++)
	{
		checksresult = checksresult + checks[i] + " ";	
	} 
%>
���� �����ϴ� �оߴ� <%= checksresult%> �Դϴ�
</body>
</html>

