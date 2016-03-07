<!-- 
		자바 몰라도 jsp한다.
		작성자: 박정우
		예제 ex-7-3.jsp
		선언문과 표현식에 대해서
-->
<%-- 문자열을 저장하기 위해 string형으로 str을 선언한 후 저장한다. --%>
<%! String str = "Hello Jsp"; %>
<%-- 정수들을 저장하기 위해 int형으로 number을 선언한 후 저장한다. --%>
<%! int number = 7; %>
<%-- 두 정수를 받아서 더한 후 호출한 곳으로 그 결과 값을 보내준다. --%>
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
<font size=3 color=blue><%= /* str에 저장된 Hello Jsp를 화면에 보여줍니다. 
                            */ str %></font>
<p>
<font size=3 color=red><%= /* number에 저장된 7을 화면에 보여줍니다. 
                           */ number %></font>
<p>
<font size=3 color=black><%= /* 두 수의 합을 계산하는 메소드를 호출합니다. 
                             */ factorial(3,7)%></font> 
</body>
</html>