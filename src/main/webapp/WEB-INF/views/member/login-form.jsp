<%@ page pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<title>main</title>

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
					<h3>login</h3>
				</header>

				<form action="<c:url value='/member/login'/>" method="post">
					<div class="form-group">
						<label>ID<input type="text" name="memberId" class="form-control"/></label>
					</div>

					<div class="form-group">
						<label>PASSWORD<input type="text" name="memberPassword" class="form-control"/></label>
					</div>

					<button type="submit" class="btn btn-primary">submit</button>
					<button type="button" id="cancel-btn" class="btn btn-warning">cancel</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>
