<%@ page pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>show post</title>

	<link rel="stylesheet" href="<c:url value="/webjars/bootstrap/3.3.7/dist/css/bootstrap.min.css"/>"/>
	<script src="<c:url value="/webjars/jquery/3.2.0/dist/jquery.min.js"/>"></script>
	<script src="<c:url value="/webjars/bootstrap/3.3.7/dist/js/bootstrap.min.js"/>"></script>
</head>

<body>
	<div class="container-fluid">
		<h3>show post</h3>

		<form>
			<div class="form-group">
				<label>title<input type="text" name="postTitle" class="form-control" value="${postVo.postTitle}" readonly="readonly"/></label><br/>
			</div>

			<div class="form-group">
				<label>text<input type="text" name="postText" class="form-control" value="${postVo.postText}" readonly="readonly"/></label><br/>
			</div>

			<div class="form-group">
				<label>writer<input type="text" name="postWriter" class="form-control" value="${postVo.postWriter}" readonly="readonly"/></label><br/>
			</div>
		</form>

		<button type="button" id="deletePostButton" class="btn btn-danger">delete post</button>
	</div>

	<form id="varForm">
		<input type="hidden" name="postNo" value="${postVo.postNo}"/>
	</form>

	<script>
		$(document).ready(function(){
			var varForm = $("#varForm");

			$("#deletePostButton").on("click", function () {
				varForm.attr({action: "deletePost", method: "post"});
				varForm.submit();
			});
		});
	</script>
</body>

</html>
