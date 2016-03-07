<%! String str = "Hello Jsp"; %>
<%! int number = 7; %>
<%! public static int factorial(int x, int y)
		{
			int result;
			result = x + y;
			return result;
		}
%>
<html>
<head><title>jsp</title>
</head>
<body>
<font size=3 color=blue><%= str %></font>
<p>
<font size=3 color=red><%= number %></font>
<p>
<font size=3 color=black><%= factorial(3,7) %></font>
</body>
</html>