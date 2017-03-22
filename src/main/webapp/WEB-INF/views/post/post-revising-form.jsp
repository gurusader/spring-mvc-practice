<%@ page pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>post revising form</title>

	<link rel="stylesheet" href="<c:url value="/webjars/bootstrap/3.3.7/dist/css/bootstrap.min.css"/>"/>
	<script src="<c:url value="/webjars/jquery/3.2.0/dist/jquery.min.js"/>"></script>
	<script src="<c:url value="/webjars/bootstrap/3.3.7/dist/js/bootstrap.min.js"/>"></script>
</head>

<body>
	<div class="container-fluid">
		<h3>post revising form</h3>

		<form action="revisePost" method="post">
			<div class="form-group">
				<label>number<input type="text" name="postNo" class="form-control" value="${postVo.postNo}" readonly="readonly"/></label>
			</div>

			<div class="form-group">
				<label>writer<input type="text" name="postWriter" class="form-control" value="${postVo.postWriter}" readonly="readonly"/></label>
			</div>

			<div class="form-group">
				<label>title<input type="text" name="postTitle" class="form-control" value="${postVo.postTitle}"/></label>
			</div>

			<div class="form-group">
				<label>text<textarea name="postText" rows="3" class="form-control">${postVo.postText}</textarea></label>
			</div>

			<div class="btn-group">
				<button type="submit" class="btn btn-primary">submit</button>
				<a href="showPostDetail?postNo=${postVo.postNo}" class="btn btn-warning">cancel</a>
			</div>
		</form>
	</div>
</body>

</html>
