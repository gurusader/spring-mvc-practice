$(function() {
	$("a.link").on("click", function(event) {
		event.preventDefault();
	});
});

function doSubmit(form, attributes) {
	form.attr(attributes);
	form.submit();
}
