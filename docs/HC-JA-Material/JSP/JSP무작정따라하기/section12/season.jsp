<html>
<head><title>radio 버튼을 이용한 설문 조사</title>
</head>
<body>
가장 좋아하는 계절은?
<p>
<form name=syberpoll method=post action=./result.jsp>
<input type=radio name=season value=spring checked>봄<br>
<input type=radio name=season value=summer>여름<br>
<input type=radio name=season value=autumn>가을<br>
<input type=radio name=season value=winter>겨울<br>
<input type=submit value="투표">
</form>
</body>
</html>