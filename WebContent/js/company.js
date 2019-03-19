$(function(){
	$(".fade-in-out").addClass("scroll");
	
	$(window).scroll(function() {
		var scroll = $(window).scrollTop();
		if (scroll >= 550) {
			$(".txt_box > p").addClass("scroll");
		}
	});
});