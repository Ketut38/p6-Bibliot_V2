<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false"%>


<html>
<head>
    <title>borrowList</title>
</head>



<%@ include file="/WEB-INF/jsp/headers.jsp" %>

<c:out value="${msg}"/>

 <h1>Liste de vos emprunts</h1>
 
<hr>
    <c:forEach items="${memberborrowList}" var="borrow">
<ul>
    <li>Numero d'emprûnt: <strong>${borrow.id}</strong></li>
    <li>Statut: <strong>${borrow.status}</strong></li>
    <li>Titre du livre: <strong>${borrow.workTitle}</strong></li>
    <li>Date du début de l'emprunt: <b><fmt:formatDate value="${borrow.startBorrowDate.toGregorianCalendar().time}" pattern="dd-MM-yyyy"/></b></li>
    <li>Date de fin: <b><fmt:formatDate value="${borrow.endBorrowDate.toGregorianCalendar().time}" pattern="dd-MM-yyyy"/> </b></li>
    
    <c:if test="${borrow.status ne 'Prolongé' && borrow.status ne 'Rendu' }">
		<li> <a href="${pageContext.request.contextPath}/extendBorrow/<c:out value="${borrow.id}"/> ">Rallonger la durée d'emprunt</a></li>
    </c:if>
    <c:if test="${borrow.status ne 'Rendu' }">
	    <li> <a href="${pageContext.request.contextPath}/borrowToEnd/<c:out value="${borrow.id}"/> "> <b>Rendre le livre</b></a></li>
	</c:if>

</ul>
<hr>
    </c:forEach>


</body>
</html>



