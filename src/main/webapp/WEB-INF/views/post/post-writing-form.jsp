<%@ include file="../include/header.jsp" %>

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

<%@ include file="../include/footer.jsp" %>