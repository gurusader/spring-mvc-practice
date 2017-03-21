<%@ page pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="utf-8"/>

	<title>show post</title>

	<script src="<c:url value="/webjars/jquery/3.2.0/dist/jquery.min.js"/>"></script>
</head>

<body>
	<h3>show post</h3>

	<label>title: <input type="text" name="postTitle" value="${postVo.postTitle}" readonly="readonly"/></label><br/>
	<label>text: <input type="text" name="postText" value="${postVo.postText}" readonly="readonly"/></label><br/>
	<label>writer: <input type="text" name="postWriter" value="${postVo.postWriter}" readonly="readonly"/></label><br/>

	<button type="button" id="deletePostButton">delete post</button>

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
