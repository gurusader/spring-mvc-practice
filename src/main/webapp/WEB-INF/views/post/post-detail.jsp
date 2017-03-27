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
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<header>
					<h3>post detail</h3>
				</header>

				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="panel-title">
							${postVo.postTitle}
						</div>
					</div>

					<div class="panel-body">
						${postVo.postWriter}
						<hr/>
						${postVo.postText}
					</div>
				</div>

				<button type="button" id="rev-post-btn" class="btn btn-primary">revise post</button>
				<button type="button" id="del-post-btn" class="btn btn-danger">delete post</button>
				<button type="button" id="show-post-list-btn" class="btn btn-warning pull-right">show post list</button>

				<div class="well">
					<form id="reply-writing-form" class="form-inline">
						<div class="form-group">
							<label>text: <input type="text" name="replyText" class="form-control"/></label>
						</div>

						<div class="form-group">
							<label>writer: <input type="text" name="replyWriter" class="form-control"/></label>
						</div>

						<button type="button" id="write-reply-btn" class="btn btn-primary">submit</button>
					</form>

					<ul id="reply-list" class="list-group"></ul>

					<nav id="reply-pagination" class="text-center"></nav>
				</div>
			</div>
		</div>
	</div>

	<form id="varForm">
		<input type="hidden" name="postNo" value="${postVo.postNo}"/>
		<input type="hidden" name="currentPageNo" value="${postPageCriteria.currentPageNo}"/>
		<input type="hidden" name="contentsPerPage" value="${postPageCriteria.contentsPerPage}"/>
		<input type="hidden" name="searchType" value="${postPageCriteria.searchType}"/>
		<input type="hidden" name="searchKeyword" value="${postPageCriteria.searchKeyword}"/>
	</form>

	<script>
		$(function () {
			var varForm = $("#varForm");

			$("#rev-post-btn").on("click", function () {
				doSubmit(varForm, {action: "showPostRevisingForm"})
			});

			$("#del-post-btn").on("click", function () {
				if (confirm("delete post?")) {
					doSubmit(varForm, {action: "deletePost", method: "post"});
				}
			});

			$("#show-post-list-btn").on("click", function () {
				varForm.children("input[name=postNo]").remove();
				doSubmit(varForm, {action: "showPostList"});
			});
		});

		$(getAllReplyList());

		function getAllReplyList(pageNo) {
			pageNo = (pageNo == undefined ? 1 : pageNo);

			$.getJSON("<c:url value='/reply/list/${postVo.postNo}/" + pageNo + "'/>", function (result) {
				var str = "";
				$(result.replyVoList).each(function () {
					str += "<li data-replyNo='" + this.replyNo + "' class='list-group-item'>" + this.replyText + ": " + this.replyWriter
						+ "<button type='button' class='btn btn-primary btn-xs pull-right'>delete</button></li>";
				});

				$("#reply-list").html(str);

				makeReplyPagination(result.pageMaker);
			});
		}

		function makeReplyPagination(pageMaker) {
			var str = "<ul class='pagination'>";

			if (pageMaker.pre) {
				str += "<li><a href='" + (pageMaker.firstPageNo - 1) + "'><span class='glyphicon glyphicon-chevron-left'></span></a></li>";
			}

			for (var i = pageMaker.firstPageNo; i <= pageMaker.lastPageNo; i++) {
				var active = (i == pageMaker.pageCriteria.currentPageNo ? "class='active'" : "");
				str += "<li " + active + "><a href='" + i + "'>" + i + "</a></li>";
			}

			if (pageMaker.next) {
				str += "<li><a href='" + (pageMaker.lastPageNo + 1) + "'><span class='glyphicon glyphicon-chevron-right'></span></a></li>";
			}

			str += "</ul>";

			$("#reply-pagination").html(str);

			$("#reply-pagination").on("click", "ul > li > a", function (event) {
				event.preventDefault();
				getAllReplyList($(this).attr("href"));
			});
		}

		$("#write-reply-btn").on("click", function () {
			var writingForm = $("#reply-writing-form");
			var replyText = writingForm.find("input[name='replyText']");
			var replyWriter = writingForm.find("input[name='replyWriter']");

			if (replyText.val() == "") {
				alert("input text.");
			} else {
				$.ajax({
					type: "post",
					url: "<c:url value='/reply/write'/>",
					headers: {
						"Content-Type": "application/json",
						"X-HTTP-Method-Override": "post"
					},
					dataType: "text",
					data: JSON.stringify({
						postNo: "${postVo.postNo}",
						replyText: replyText.val(),
						replyWriter: replyWriter.val()
					}),
					success: function (result) {
						if (result == "SUCCESS") {
							getAllReplyList(1);
							replyText: replyText.val("");
							replyWriter: replyWriter.val("");
						}
					}
				});
			}
		});

		$("#reply-list").on("click", "li > button", function () {
			var replyNo = $(this).parent().attr("data-replyNo");

			if (confirm("delete reply?")) {
				$.ajax({
					type: "delete",
					url: "<c:url value='/reply/delete/" + replyNo + "'/>",
					headers: {
						"Content-Type": "application/json",
						"X-HTTP-Method-Override": "delete"
					},
					dataType: "text",
					success: function (result) {
						if (result == "SUCCESS") {
							getAllReplyList(1);
						}
					}
				});
			}
		});
	</script>
</body>

</html>
