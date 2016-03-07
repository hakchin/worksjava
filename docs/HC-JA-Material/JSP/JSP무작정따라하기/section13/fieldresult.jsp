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
내가 좋아하는 분야는 <%= checksresult%> 입니다
</body>
</html>

