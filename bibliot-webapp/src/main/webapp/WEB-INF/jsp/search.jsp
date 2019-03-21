<!doctype html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false"%>

<%@ include file="/WEB-INF/jsp/headers.jsp" %>
	<c:out value="${msg}"></c:out>
	<h1>Recherche d'oeuvres</h1>
	

	<form action="${contextPath}/doSearch" method="post">
		Recherche par Auteur : <input type="text" name="searchText"><br>
		<input type="reset"> <input type="submit">
	</form> 
</body>
</html>