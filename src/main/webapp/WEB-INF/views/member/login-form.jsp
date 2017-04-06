<%@ include file="../include/header.jsp" %>

<form action="<c:url value='/member/login'/>" method="post">
	<div class="form-group">
		<label>ID<input type="text" name="memberId" class="form-control"/></label>
	</div>

	<div class="form-group">
		<label>PASSWORD<input type="text" name="memberPassword" class="form-control"/></label>
	</div>

	<button type="submit" class="btn btn-primary">submit</button>
</form>

<%@ include file="../include/footer.jsp" %>
