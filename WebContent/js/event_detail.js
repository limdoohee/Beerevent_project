/**
 * 
 */

$(document).ready(function(){
	$('#store_detail').click(function(){
		window.open(this.href, 'testWindow', 'width=900, height=350, top=200, left=300', '_blank');
		return false;
	});
});