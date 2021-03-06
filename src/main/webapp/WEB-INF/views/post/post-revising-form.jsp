<%@ include file="../include/header.jsp" %>

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

<form id="var-form">
	<input type="hidden" name="postNo" value="${postVo.postNo}"/>
	<input type="hidden" name="currentPageNo" value="${postPageCriteria.currentPageNo}"/>
	<input type="hidden" name="contentsPerPage" value="${postPageCriteria.contentsPerPage}"/>
	<input type="hidden" name="searchType" value="${postPageCriteria.searchType}"/>
	<input type="hidden" name="searchKeyword" value="${postPageCriteria.searchKeyword}"/>
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

<%@ include file="../include/footer.jsp" %>
