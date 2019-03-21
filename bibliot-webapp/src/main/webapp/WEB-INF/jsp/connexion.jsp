
<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Connexion · P3</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/sign-in/">

    <!-- Bootstrap core CSS -->
<link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="resources/css/signin.css" rel="stylesheet">
      <link href="resources/css/bootstrap.css" rel="stylesheet">
  </head>
 

  <body class="text-center">

	
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <form:form  action="${contextPath}/authentificate"  method="post" class="form-signin">
		<c:if test="${msg eq 'Vous êtes deconnecté' }">
			<div class="alert alert-success">
				<strong>Bravo!</strong> Vous vous êtes deconnecté.
			</div>
		</c:if>
		<img class="mb-4" src="resources/css/Logo_OpenClassrooms.png" alt="" width="72" height="72"> 
		  <h1 class="h3 mb-3 font-weight-normal">Connexion</h1>
		  
		  <label for="inputLogin" class="sr-only">Login</label>
		  
		  <input type="text" id="input" class="form-control" name="user" placeholder="username" required autofocus>
		  
		  <label for="inputPassword" class="sr-only">Password</label>
		  
		  <input type="password" id="input" class="form-control" name="password" placeholder="password" required>
		  
		  
		  <div class="checkbox mb-3">
		    <label>
		      <input type="checkbox" value="remember-me"> Se souvenir de moi
		    </label>
		  </div> 
		  
		  <button class="btn btn-lg btn-primary btn-block" type="submit">Se connecter</button>
		  
		  <p class="mt-5 mb-3 text-muted">&copy; OC-P3-ABBES™ 2018-2019</p>
	</form:form>
	
	
	
</body>
</html>















<%-- <html>
<head>
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    <link href="resources/css/tuto.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Login</title>
</head>

<body>

<c:out value="${msg}"/>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<form:form  action="${contextPath}/authentificate"  method="post">
		<input type="text" id="input" name="user" placeholder="username">
		<input type="text" id="input" name="password" placeholder="password">
		<input type="submit" id="input" value="Submit">
	</form:form>
	
</body>
</html> --%>