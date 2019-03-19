/**
 * 
 */

/*$(document).ready(function() {*/
$(document).on('scroll',function(){
    var divTag = $('div');
    var divTop = divTag.offset().top;
    var scrollTop = $(document).scrollTop();
    if(scrollTop>divTop+100){
        //만약에 header에 fixed 클래스가 없을경우 if문 실행.
        //클래스가 있는데도 실행이 되면 계속 헤더가 사라지고 페이딩이 되어버리기 때문에 불편합니다
        if(!$('header').hasClass('fixed')){
            $('header').hide().fadeIn(10,function(){
                $(this).addClass('fixed');
            });
        }
    }else{
        //반면에 이건 header가 fixed 클래스를 가지고 있을때에만 실행
        //fixed값이 없는데도 실행이 된다면 스크롤바가 윗부분에 있을때 계속 페이드아웃이 됩니다
        if($('header').hasClass('fixed')){
            $('header').fadeOut(10,function(){
                $('header').removeClass('fixed');
            });
            //ES6의 promise 함수를 이용합니다.promise란 이 코드는 저 위의 코드의 실행이 끝났을때 실행이 되게 하는 것입니다. 
            $('header').promise().done(function(){
                $(this).fadeIn();
            });
        }
    }
});