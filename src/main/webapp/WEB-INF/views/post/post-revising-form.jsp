<%@ page pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<title>post revising form</title>

	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>

	<link rel="stylesheet" href="<c:url value="/webjars/bootstrap/3.3.7/dist/css/bootstrap.min.css"/>"/>
	<script src="<c:url value="/webjars/jquery/3.2.0/dist/jquery.min.js"/>"></script>
	<script src="<c:url value="/webjars/bootstrap/3.3.7/dist/js/bootstrap.min.js"/>"></script>

	<script src="<c:url value='/resources/js/move.js'/>"></script>
</head>

<body>
	<div class="container-fluid">
		<h3>post revising form</h3>

		<form id="revising-form">
			<div class="form-group">
				<label>writer<input type="text" name="postWriter" class="form-control" value="${postVo.postWriter}" readonly="readonly"/></label>
			</div>

			<div class="form-group">
				<label>title<input type="text" name="postTitle" class="form-control" value="${postVo.postTitle}"/></label>
			</div>

			<div class="form-group">
				<label>text<textarea name="postText" rows="3" class="form-control">${postVo.postText}</textarea></label>
			</div>

			<button type="button" id="submit-btn" class="btn btn-primary">submit</button>
			<button type="button" id="cancel-btn" class="btn btn-warning">cancel</button>
		</form>
	</div>

	<form id="var-form">
		<input type="hidden" name="postNo" value="${postVo.postNo}"/>
		<input type="hidden" name="currentPageNo" value="${pageCriteria.currentPageNo}"/>
		<input type="hidden" name="contentsPerPage" value="${pageCriteria.contentsPerPage}"/>
	</form>

	<script>
		$(function() {
			var varForm = $("#var-form");

			$("#submit-btn").on("click", function() {
				var revisingForm = $("#revising-form");
				varForm.children().appendTo(revisingForm);
				doSubmit(revisingForm, {action: "revisePost", method: "post"});
			});

			$("#cancel-btn").on("click", function() {
				doSubmit(varForm, {action : "showPostDetail"});
			});
		});
	</script>
</body>

</html>
