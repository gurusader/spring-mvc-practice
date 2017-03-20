<%@ page pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="utf-8"/>

	<title>show post list</title>

	<style type="text/css">
		table, tr, th, td {
			border: 1px solid black;
		}

		table {
			border-collapse: collapse;
		}
	</style>
</head>

<body>
	<header>
		<h3>show post list</h3>
	</header>

	<table>
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

	<a href="writePost">write post</a>
</body>

</html>
