<%@ page contentType="text/html; charset=EUC-KR" %>	
<jsp:useBean	id="SQL_Manager"class="javaBean.QueryManager"	scope="session" />	
<jsp:useBean	id="DB_con"class="javaBean.JDBCcon" scope="application" />	
<jsp:useBean	id="insert" class="javaBean.writeBean" scope="page"	 />	
<jsp:setProperty name="insert" property="*"/>	

<% SQL_Manager.setConnection(DB_con.getConnection()); %>	
<% SQL_Manager.update(insert.getInsert());%>	

		<html>
			<head><title>�۾��� Ȯ��</title></head>
			<script language="javascript">
			  function go_list(){
			  	alert("���� ���������� ��ϵǾ����ϴ�.")
				location.href="list.jsp?pg_count=0";
			  }
			</script>
			<body onload="go_list();">
			</body>
		</html>