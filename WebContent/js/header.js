$(window).scroll(function() {
	var scroll = $(window).scrollTop();
	var div = $('<div></div>').attr({
		id: 'adddiv'
		});
	//console.log(scroll);
	if (scroll >= 87) {
		//console.log('a');
		$("#nav").addClass("fixed");
		//$("#usermenu").attr("display","none");
		//$("#usermenu").hide();
		//$(div).insertBefore("#header");
		$("#main").css("top","43px");
		} else {
		//console.log('a');
		$("#nav").removeClass("fixed");
		//$("#usermenu").attr("display","inline-block");
		//$("#usermenu").show();
		$("#main").css("top","0");
	}
});