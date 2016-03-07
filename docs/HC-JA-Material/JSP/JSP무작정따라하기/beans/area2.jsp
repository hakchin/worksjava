<%@ page contentType="text/html; charset=EUC-KR" %> 
<jsp:useBean id="PI" class="firstBean.PI_Bean" scope="page"/>
<jsp:setProperty name="PI" property="a" value="1"/>


원주율 :&nbsp;<jsp:getProperty name="PI" property="PI"/><br>
반지름 :&nbsp;<jsp:getProperty name="PI" property="a"/>&nbsp;<br>
원의 면적은&nbsp;<%=PI.area()%>&nbsp;