<%@ include file="../include/header.jsp" %>

<div id="search-field" class="form-group form-inline">
	<label>search type:
		<select name="search-type" class="form-control">
			<option>title</option>
			<option ${pageMaker.pageCriteria.searchType eq "text" ? "selected" : ""}>text</option>
			<option ${pageMaker.pageCriteria.searchType eq "writer" ? "selected" : ""}>writer</option>
		</select>
	</label>

	<label>keyword: <input type="text" name="search-keyword" value="${pageMaker.pageCriteria.searchKeyword}" class="form-control"/></label>
	<button type="button" id="search-btn" class="btn btn-primary">search</button>
</div>

<table class="table table-condensed">
	<tr>
		<th>number</th>
		<th>title</th>
		<th>writer</th>
		<th>reg date</th>
		<th>view count</th>
	</tr>

	<c:forEach var="postVo" items="${postVoList}">
		<tr>
			<td>${postVo.postNo}</td>
			<td><a href="${postVo.postNo}" class="link post-detail-link">${postVo.postTitle}</a></td>
			<td>${postVo.postWriter}</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${postVo.postRegDate}"/></td>
			<td>${postVo.postViewCnt}</td>
		</tr>
	</c:forEach>
</table>

<nav class="text-center">
	<ul class="pagination">
		<c:if test="${pageMaker.pre}">
			<li>
				<a href="${pageMaker.firstPageNo - 1}" class="link page-link">
					<span class="glyphicon glyphicon-chevron-left"></span>
				</a>
			</li>
		</c:if>

		<c:forEach var="i" begin="${pageMaker.firstPageNo}" end="${pageMaker.lastPageNo}">
			<li class="${i == pageMaker.pageCriteria.currentPageNo ? 'active' : ''}">
				<a href="${i}" class="link page-link">${i}</a>
			</li>
		</c:forEach>

		<c:if test="${pageMaker.next}">
			<li>
				<a href="${pageMaker.lastPageNo + 1}" class="link page-link">
					<span class="glyphicon glyphicon-chevron-right"></span>
				</a>
			</li>
		</c:if>
	</ul>
</nav>

<button id="write-post-btn" class="btn btn-primary">write post</button>

<form id="var-form">
	<input type="hidden" name="postNo"/>
	<input type="hidden" name="currentPageNo" value="${pageMaker.pageCriteria.currentPageNo}" class="page-criteria"/>
	<input type="hidden" name="contentsPerPage" value="${pageMaker.pageCriteria.contentsPerPage}" class="page-criteria"/>
	<input type="hidden" name="searchType" value="${pageMaker.pageCriteria.searchType}" class="post-page-criteria"/>
	<input type="hidden" name="searchKeyword" value="${pageMaker.pageCriteria.searchKeyword}" class="post-page-criteria"/>
</form>

<script>
$(function() {
	var varForm = $("#var-form");

	$("#search-btn").on("click", function() {
		if($("#search-field input[name=search-keyword]").val() == ""){
			alert("input keyword.");
		} else {
			varForm.children("input:not(.post-page-criteria)").remove();
			varForm.children("input[name=searchType]").val($("#search-field select[name=search-type]").val());
			varForm.children("input[name=searchKeyword]").val($("#search-field input[name=search-keyword]").val());
			doSubmit(varForm, {action : "showPostList"});
		}
	});

	$("a.post-detail-link").on("click", function() {
		varForm.children("input[name=postNo]").val($(this).attr("href"));
		doSubmit(varForm, {action : "showPostDetail"});
	});

	$("a.page-link").on("click", function() {
		varForm.children("input[name=postNo]").remove();
		varForm.children("input[name=currentPageNo]").val($(this).attr("href"));
		doSubmit(varForm, {action : "showPostList"});
	});

	$("#write-post-btn").on("click", function() {
		varForm.children("input[name=postNo]").remove();
		varForm.children("input[name=currentPageNo]").val("${pageMaker.pageCriteria.currentPageNo}");
		doSubmit(varForm, {action : "showPostWritingForm"});
	});
});
</script>

<%@ include file="../include/footer.jsp" %>