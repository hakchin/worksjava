<%
Cookie[] get_visitor = request.getCookies();
String str_vis="0";
int i_vis=0;
for ( int i = 0; i < get_visitor.length; i++ ) {
   if (get_visitor[i].getName().equals("visit") == true){
	 str_vis = get_visitor[i].getValue();
    }
}
i_vis = Integer.parseInt(str_vis)+1;
str_vis = Integer.toString(i_vis);
Cookie set_visitor = new Cookie("visit",str_vis);
set_visitor.setMaxAge(7*24*60*60);
response.addCookie(set_visitor);
%>
<html>
당신은 <font color=red><b><%=str_vis%></b></font>번째 방문하였습니다.
</html>
