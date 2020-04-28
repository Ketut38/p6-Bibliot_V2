<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false"%>


<html>
<head>
    <title>reservationPage</title>
</head>



<%@ include file="/WEB-INF/jsp/headers.jsp" %>

<c:out value="${msg}"/>

 <h1>Liste de vos Reservations</h1>
 
<hr>
    <c:forEach items="${ReservationList}" var="reservation">
<ul>
    
    <li>Statut: <strong>${reservation.status}</strong></li>
    <li>Id de l'oeuvre: <strong>${reservation.workId}</strong></li>
    <li>Date de réservation: <b><fmt:formatDate value="${reservation.startDate.toGregorianCalendar().time}" pattern="dd-MM-yyyy"/></b></li>
    
    <%-- <c:if test="${reservation.status ne 'Terminée' }">
		<li> <a href="${pageContext.request.contextPath}/cancelReservation/<c:out value="${reservation.id}"/> ">Annuler la réservation</a></li>
    </c:if>
    <c:if test="${borrow.status == 'En attente' }">
	    <li> <a href="${pageContext.request.contextPath}/borrowToEnd/<c:out value="${reservation.id}"/> "> <b>Confirmer la réservation</b></a></li>
	</c:if> --%>

</ul>
<hr>
    </c:forEach>


</body>
</html>