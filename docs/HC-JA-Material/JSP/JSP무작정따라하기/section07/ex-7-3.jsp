<!-- 
		�ڹ� ���� jsp�Ѵ�.
		�ۼ���: ������
		���� ex-7-3.jsp
		���𹮰� ǥ���Ŀ� ���ؼ�
-->
<%-- ���ڿ��� �����ϱ� ���� string������ str�� ������ �� �����Ѵ�. --%>
<%! String str = "Hello Jsp"; %>
<%-- �������� �����ϱ� ���� int������ number�� ������ �� �����Ѵ�. --%>
<%! int number = 7; %>
<%-- �� ������ �޾Ƽ� ���� �� ȣ���� ������ �� ��� ���� �����ش�. --%>
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
<font size=3 color=blue><%= /* str�� ����� Hello Jsp�� ȭ�鿡 �����ݴϴ�. 
                            */ str %></font>
<p>
<font size=3 color=red><%= /* number�� ����� 7�� ȭ�鿡 �����ݴϴ�. 
                           */ number %></font>
<p>
<font size=3 color=black><%= /* �� ���� ���� ����ϴ� �޼ҵ带 ȣ���մϴ�. 
                             */ factorial(3,7)%></font> 
</body>
</html>