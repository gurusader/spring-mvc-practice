<%@ page pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>

	<title>post writing form</title>

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
					<h3>write post</h3>
				</header>

				<form action="writePost" method="post">
					<div class="form-group">
						<label>title<input type="text" name="postTitle" class="form-control"/></label>
					</div>

					<div class="form-group">
						<label>text<textarea name="postText" rows="3" class="form-control"></textarea></label>
					</div>

					<div class="form-group">
						<label>writer<input type="text" name="postWriter" class="form-control"/></label>
					</div>

					<button type="submit" class="btn btn-primary">submit</button>
					<button type="button" id="cancel-btn" class="btn btn-warning">cancel</button>
				</form>
			</div>
		</div>
	</div>

	<form id="varForm">
		<input type="hidden" name="currentPageNo" value="${postPageCriteria.currentPageNo}"/>
		<input type="hidden" name="contentsPerPage" value="${postPageCriteria.contentsPerPage}"/>
		<input type="hidden" name="searchType" value="${postPageCriteria.searchType}"/>
		<input type="hidden" name="searchKeyword" value="${postPageCriteria.searchKeyword}"/>
	</form>

	<script>
		$(function() {
			$("#cancel-btn").on("click", function() {
				doSubmit($("#varForm"), {action: "showPostList"});
			});
		});
	</script>
</body>

</html>
