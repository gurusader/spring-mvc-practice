<%@ page pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>

<head>
	<title>post list</title>

	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>

	<link rel="stylesheet" href="<c:url value="/webjars/bootstrap/3.3.7/dist/css/bootstrap.min.css"/>"/>
	<script src="<c:url value="/webjars/jquery/3.2.0/dist/jquery.min.js"/>"></script>
	<script src="<c:url value="/webjars/bootstrap/3.3.7/dist/js/bootstrap.min.js"/>"></script>

	<script src="<c:url value='/resources/js/move.js'/>"></script>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<header>
					<nav class="navbar navbar-inverse">
						<div class="container-fluid">
							<ul class="nav navbar-nav pull-right">
								<li>
									<c:set var="isLogin" value="${sessionScope.loginMember ne null}"/>
									<a href="<c:url value='/member/${isLogin ? "logout" : "showLoginForm"}'/>">
										${isLogin ? "Log Out" : "Log In"}
									</a>
								</li>
							</ul>
						</div>
					</nav>
				</header>
