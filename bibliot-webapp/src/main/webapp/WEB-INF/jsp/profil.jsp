<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ include file="/WEB-INF/jsp/headers.jsp" %>


<div class="container">
  <div class="row">
    <div class="col-md-6 img">
      <img src="https://cdn-images-1.medium.com/max/1068/1*-S78iSFaDtxqWvqj_4NM6w.jpeg"  alt="" class="img-rounded">
    </div>
    <div class="col-md-6 details">
      <blockquote>
        <h5>Bienvenue ${memberConnected.name} !</h5>
        <small><cite title="Source Title">Un membre de la bibliothèque  <i class="icon-map-marker"></i></cite></small>
      </blockquote>
      <p>
        ${memberConnected.mailAdress} <br>
      </p>
    </div>
  </div>
</div>
	
</body>
</html>