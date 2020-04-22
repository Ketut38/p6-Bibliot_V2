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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    <c:forEach items="${foundWorks}" var="work">
<ul>
    <li>${work.title}</li>
    <li><fmt:formatDate value="${work.publicationDate.toGregorianCalendar().time}" pattern="dd/MM/yyyy" /></li>
    <li>${work.bookDescription}</li>
	<li> <a href="${pageContext.request.contextPath}/borrow/<c:out value="${work.id}"/> ">Emprunter ce livre</a></li>
	<c:if test = "${work.reservable}"><li>
	  <a href="${pageContext.request.contextPath}/doReservation/<c:out value="${work.id}"/> ">Reserver ce livre </a>
      </li></c:if>
    <li>Réservations en cours: <b>${work.reservationRealized}</b></li>
</ul>
<hr>
    </c:forEach>


</body>
</html>



