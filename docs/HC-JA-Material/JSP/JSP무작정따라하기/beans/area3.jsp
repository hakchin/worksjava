<%@ page contentType="text/html; charset=EUC-KR" %> 
<jsp:useBean id="PI" class="firstBean.PI_Bean" scope="page"/>
<jsp:setProperty name="PI" property="a" param="newA"/>


������ :&nbsp;<jsp:getProperty name="PI" property="PI"/><br>
������ :&nbsp;<jsp:getProperty name="PI" property="a"/>&nbsp;<br>
���� ������&nbsp;<%=PI.area()%>&nbsp;