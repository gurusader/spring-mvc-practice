<%@ page pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>show post list</title>

	<link rel="stylesheet" href="<c:url value="/webjars/bootstrap/3.3.7/dist/css/bootstrap.min.css"/>"/>
	<script src="<c:url value="/webjars/jquery/3.2.0/dist/jquery.min.js"/>"></script>
	<script src="<c:url value="/webjars/bootstrap/3.3.7/dist/js/bootstrap.min.js"/>"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>

			<div class="col-md-8">
				<header>
					<h3>show post list</h3>
				</header>

				<table class="table table-condensed">
					<tr>
						<th>number</th>
						<th>title</th>
						<th>writer</th>
						<th>reg date</th>
						<th>rev date</th>
						<th>view count</th>
					</tr>

					<c:forEach var="postVo" items="${postList}">
						<tr>
							<td>${postVo.postNo}</td>
							<td><a href="showPost?postNo=${postVo.postNo}">${postVo.postTitle}</a></td>
							<td>${postVo.postWriter}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${postVo.postRegDate}"/></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${postVo.postRevDate}"/></td>
							<td>${postVo.postViewCnt}</td>
						</tr>
					</c:forEach>
				</table>

				<a href="showWritePostForm" class="btn btn-primary">write post</a>
			</div>

			<div class="col-md-2"></div>
		</div>
	</div>
</body>

</html>
