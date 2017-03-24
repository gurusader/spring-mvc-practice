<%@ page pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<title>${postVo.postTitle}</title>

	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>

	<link rel="stylesheet" href="<c:url value="/webjars/bootstrap/3.3.7/dist/css/bootstrap.min.css"/>"/>
	<script src="<c:url value="/webjars/jquery/3.2.0/dist/jquery.min.js"/>"></script>
	<script src="<c:url value="/webjars/bootstrap/3.3.7/dist/js/bootstrap.min.js"/>"></script>

	<script src="<c:url value='/resources/js/move.js'/>"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>

			<div class="col-md-8">
				<header>
					<h3>post detail</h3>
				</header>

				<div class="panel panel-default">
					<div class="panel-heading">${postVo.postTitle}</div>

					<div class="panel-body">
						${postVo.postWriter}
						<hr/>
						${postVo.postText}
					</div>
				</div>

				<button type="button" id="rev-post-btn" class="btn btn-primary">revise post</button>
				<button type="button" id="del-post-btn" class="btn btn-danger">delete post</button>
				<button type="button" id="show-post-list-btn" class="btn btn-warning pull-right">show post list</button>
			</div>

			<div class="col-md-2"></div>
		</div>
	</div>

	<form id="varForm">
		<input type="hidden" name="postNo" value="${postVo.postNo}"/>
		<input type="hidden" name="currentPageNo" value="${pageCriteria.currentPageNo}"/>
		<input type="hidden" name="contentsPerPage" value="${pageCriteria.contentsPerPage}"/>
	</form>

	<script>
		$(function(){
			var varForm = $("#varForm");

			$("#rev-post-btn").on("click", function (){
				doSubmit(varForm, {action: "showPostRevisingForm"})
			});

			$("#del-post-btn").on("click", function () {
				if(confirm("delete post?")) {
					doSubmit(varForm, {action: "deletePost", method: "post"});
				}
			});

			$("#show-post-list-btn").on("click", function () {
				varForm.children("input[name=postNo]").remove();
				doSubmit(varForm, {action: "showPostList"});
			});
		});
	</script>
</body>

</html>
