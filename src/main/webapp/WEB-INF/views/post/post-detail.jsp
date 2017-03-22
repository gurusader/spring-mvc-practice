<%@ page pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>${postVo.postTitle}</title>

	<link rel="stylesheet" href="<c:url value="/webjars/bootstrap/3.3.7/dist/css/bootstrap.min.css"/>"/>
	<script src="<c:url value="/webjars/jquery/3.2.0/dist/jquery.min.js"/>"></script>
	<script src="<c:url value="/webjars/bootstrap/3.3.7/dist/js/bootstrap.min.js"/>"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>

			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading">${postVo.postTitle}</div>

					<div class="panel-body">
						${postVo.postWriter}
						<hr/>
						${postVo.postText}
					</div>
				</div>

				<a href="showPostRevisingForm?postNo=${postVo.postNo}" class="btn btn-primary">revise post</a>
				<button type="button" id="deletePostButton" class="btn btn-danger">delete post</button>
				<a href="showPostList" class="btn btn-warning pull-right">show post list</a>
			</div>

			<div class="col-md-2"></div>
		</div>
	</div>

	<script>
		$(document).ready(function(){
			$("#deletePostButton").on("click", function () {
				if(confirm("delete post?")) {
					var form = $("<form></form>");
					form.attr({action: "deletePost", method: "post"});
					form.append($("<input type='hidden' name='postNo' value='${postVo.postNo}'/>"));
					form.appendTo("body");
					form.submit();
				}
			});
		});
	</script>
</body>

</html>
