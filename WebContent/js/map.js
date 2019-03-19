$(document).ready(function (){
var container = document.getElementById('map');
	var options = {
		center: new daum.maps.LatLng(37.536290, 126.988457),
		level: 3
	};
	
	// 지도를 생성합니다
	var map = new daum.maps.Map(container, options);
	
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new daum.maps.services.Geocoder();
	
	var imageSrc = './img/pin.png',
	// 마커이미지의 주소입니다    
    imageSize = new daum.maps.Size(46, 51), 
    // 마커이미지의 크기입니다
    imageOption = {offset: new daum.maps.Point(23,55)}; 
	// 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
	
	// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
	var markerImage = new daum.maps.MarkerImage(imageSrc, imageSize, imageOption);
	
	$.ajax({
		
		url : 'store_map_marker.do',
		dataType : 'json',
		  success : function(rdata){
			  $(rdata).each(function(index,item){
				  
				  // 주소로 좌표를 검색합니다
					geocoder.addressSearch( item.store_location, function(result, status) {

					    // 정상적으로 검색이 완료됐으면 
					     if (status === daum.maps.services.Status.OK) {
					        var coords = new daum.maps.LatLng(result[0].y, result[0].x);
					     
					        var array = new Array();
					        array[index] =[result[0].y, result[0].x];
					        // 결과값으로 받은 위치를 마커로 표시합니다
					        var marker = new daum.maps.Marker({
					            map: map,
					            position: coords,
					            image : markerImage
					        });

					        // 인포윈도우로 장소에 대한 설명을 표시합니다
					       var  infowindow = new daum.maps.InfoWindow({
					          content:  item.store_name
					        });
					     }	//if
					     
					     
					       //37.53361691256002
					       //126.99322500999894
					        // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
						    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
						    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
						    daum.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
						    daum.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
					        
						    $("#quickSearchResultBox").on('mouseover','li ',function(){
					    	//	location2 = $(this).text();
						    	turn= $(this).index();
//					    		alert(turn)
//					    		alert(array[turn])
					    		//var markerPosition  =  array[turn];
					    		
					    		// 마커를 생성합니다
					    		//var marker = new daum.maps.Marker({
					    		//    position: markerPosition
					    		//});
							   	//infowindow.setContent(content);
							    //infowindow.open(map, marker);	
					    	})
					    	
					    	  $("#quickSearchResultBox").on('mouseout','li ',function(){
					    	//	location2 = $(this).text();
					    		//name2 = $(this).prev().text();
					    		  	
						       
					    	})
						    
						 // 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
							function makeOverListener(map, marker, infowindow) {
							    return function() {
							    //	var content = '<div style="padding:5px;z-index:1;">' +"ssss" + '</div>';
							   // 	infowindow.setContent(content);
							        infowindow.open(map, marker);
							    };
							}

							// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
							function makeOutListener(infowindow) {
							    return function() {
							        infowindow.close();
							    };
							}
						    
					        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
					        //map.setCenter(coords);
					   
					});   
				});
			  
		  } //success
	}); //ajax

		 // 검색 목록
    	function listData() {
    		var data = $("#quickSearchResultBox").serialize(); 
            // Ajax를 수행합니다.
            $.ajax({
               url : 	'store_map_list.do',
               data : data,
               dataType : 'json',
               success : function(rdata){
                   var output = '';
        	   $(rdata).each(function (index, item) { 
                   output += '<li>';
                   output += '    <strong>' + item.store_name + '</strong>';
                   output += '    <span>' + item.store_location + '</span>';
                   output += '    <p>' + item.store_tel + '</p>';
                   output += '</li>';
               });//each end
                   $('#quickSearchResultBox').append(output);
        }//success end
        
        });//ajax end
        
    }//function end
	
    // 초기 화면에 데이터를 표시합니다.
    	listData();
    	
    	
	
}); //ready