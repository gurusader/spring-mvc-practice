<%@ page pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="utf-8"/>

	<title>write post</title>
</head>

<body>
	<h3>write post</h3>

	<form method="post">
		<label>title: <input type="text" name="postTitle"/></label><br/>
		<label>text: <textarea name="postText" rows="3"></textarea></label><br/>
		<label>writer: <input type="text" name="postWriter"/></label><br/>
		<button type="submit">submit</button>
	</form>
</body>

</html>
