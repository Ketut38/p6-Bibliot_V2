<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false"%>


<html>
<head>
    <title>resultsByAuthor</title>
</head>
<body>

<c:out value="${msg}"/>

<%@ include file="/WEB-INF/jsp/headers.jsp" %>

    <c:forEach items="${foundWorks}" var="work">
<ul>
    <li>${work.title}</li>
    <li>${work.publicationDate}</li>
    <li>${work.bookDescription}</li>
	<li> <a href="${pageContext.request.contextPath}/borrow/<c:out value="${work.id}"/> ">Emprunter ce livre</a></li>
</ul>
<hr>
    </c:forEach>


</body>
</html>



