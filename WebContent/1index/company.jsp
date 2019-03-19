<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>사이트 소개</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/company.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.3.1.js"></script>
<script src="js/jquery-1.12.4.min.js"></script>
<script src="js/company.js"></script>
</head>
<body>
<div id="wrap">
	<div id="container">
		<jsp:include page="../header.jsp"/>
		<div id="main">
			<div id="content">
			
				<div class="story_row1">
					<h3 class="story_tit">COMPANY STORY</h3>
					<h1>A G O B</h1>
					<h2>A Glass Of Beer</h2>
					<p class="fade-in-out">
						'A Glass Of Beer' <span>맥주 한 잔, 퇴근 후 고된 피로를 풀어주는 행복의 대명사</span>이죠.<br>
						여기, 나에게 행복이 되는 것을 여러 브랜드와 함께 배우고 나눌 수 있는 커뮤니티 사이트를 소개합니다.<br>
						<br>
						AGOB는 맥주에 대한 열정을 가진 사람들의 집단입니다. 하지만, 꼭 맥주 전문가들만 있는 것은 아닙니다. <br>
						생소할 수 있는 수제맥주에 대한 다양성과 신선함을 불어 넣고자 매일매일 열정을 다해서 일하고 있습니다. <br>
						AGOB는 수제맥주의 매력을 전파하기 위해 <span>관련 행사를 소개하고 교육 사업등을 전개</span>하고 있습니다. <br>
						판매자는 개별 등록을 함으로써 자신있는 수제맥주에 대해 자랑스럽게 알려 줄 수 있는 기회를 제공합니다.<br>
						소비자는 지역별, 형태별로 나뉘어져 있는 수제맥주와 관련된 이벤트를 제공받음으로써 편리하게 참가할 수 있습니다.
					</p>
				</div> 
				
				<div class="story_row2">
					<div class="img_section">
						<div class="bg"></div>
						<div class="color_box"></div>
					</div>
					<div class="txt_box">
						<h1>What's craft beer?</h1>
						<p>
						수제 맥주는 다품종 소량 생산을 하는 맥주로 맥아, 물, 홉, 효모 네 가지로 만들어지는 소규모 브루워리에서 만들어지는 맥주입니다.
						전통적인 맥주를 만들기도 하지만 주로 맥주마다 다양한 특색을 부여하기 위해 부가적인 재료를 투입하여 다양하고 독특한 맥주를 제조하기도 합니다.
						제조 방법에 따라 기존에 볼 수 없었던 새로운 스타일의 맥주를 개발하기도 하며, 브루워리 마다 개성 있는 맥주를 생산하기도 합니다.
						기존의 국내 맥주 시장은 대기업 맥주 회사들이 비슷한 스타일의 맥주를 제조하였기 때문에 소비자는 제한된 범위에서 맥주를 선택해 왔습니다. 
						하지만 수제 맥주의 등장으로 소비자는 기존의 획일화된 맛의 맥주에서 다양한 선택을 하여 본인의 입맛에 맞는 맥주를 선택할 수 있게 되었습니다.
						</p>
					</div>
				</div>
				
				<div class="story_row3">
				<h1>수제맥주의 기본이 되는 맥주의 종류</h1>
				
				<div class="story_box">
				<div class="box_container">
               		<div class="descript"><img src="./img/ale.jpg" alt=""></div>
              		<div class="txt_box">
                    	<h3 class="main_tit2">Ale Beer<span>에일맥주</span></h3>
               			<h3 class="flavor">Flavor<span>과일,꽃향기가 풍부하며 다소 약한 탄산과 쓴맛</span></h3>
                    	<p>맥주의 분류에서 가장 큰 범주는 에일, 라거로 나뉩니다. 둘은 발효법에 따라서 정해지죠.에일 맥주는 상대적으로 고온인 15~24도씨 에서 발효시킨 맥주인 상면발효맥주 중 하나에요
                    	2~300년 전에 맥주라고 부르던 음료는 주로 이 에일을 의미합니다. 맥주 애호가들이 특히 좋아하는 종류로, 독일과 함께 맥주로 손꼽히는 영구에서는 맥주를 beer대신 ale이라고 부를 만큼 대중적인 인기를 가지고 있습니다.</p>
                	</div>
                </div>
            	</div>
            	
            	<div class="story_box">
            	<div class="box_container">
               		<div class="descript"><img src="./img/lager.jpg" alt=""></div>
            		<div class="txt_box">
                    	<h3 class="main_tit2">Larger Beer<span>라거맥주</span></h3>
                    	<h3 class="flavor">Flavor<span>가벼운 맛에 강한 탄산감이 가져다주는 청량함과 깔끔함</span></h3>
                    	<p>하면발효맥주를 의미하는 라거는 보통9~15도씨 온도에서 만들어져서 일정하게 낮은 온도를 유지해주는 냉장시설이 필요합니다. 짧은 역사에도 불구하고 대중적인 맥주로 자리 잡아 우리가 아는 국내브랜드의 맥주들은 대부분 라거이죠.
                    	지금은 없어졌지만 맥주는 물,보리,홉만 가지고 만들어야 된다는 과거 독일의 맥주 순수령때문에 우리가 알고있는 독일 맥주 대부분이 바로 라거 맥주입니다.</p>
                	</div>
                </div>
            	</div>
            	
            	<div class="story_box">
            	<div class="box_container">
               		<div class="descript"><img src="./img/dark.jpg" alt=""></div>
              		<div class="txt_box">
                    	<h3 class="main_tit2">Dark Beer<span>흑맥주</span></h3>
                    	<h3 class="flavor">Flavor<span>크리미하면서 묵직한 목넘김과 풍부한 맛과 진한 향</span></h3>
                    	<p>흑맥주는 다크 라거와 스타우트가 대표적으로 알려저 있어요. 보리를 탈 정도로 볶아서 만들기 때문에 독특한 검은 빛깔이 탄생하는데 초콜릿,커피를 연상시키는 풍미가 바로 이 과정에서 만들어집니다.
                    	발효과정에는 정해진 방법이 없어서 라거와 에일 모두에서 다양한 흑맥주를 볼 수 있습니다.</p>
                	</div>
                </div>
            	</div>
            	</div>
            	
			</div> <%-- content --%>
		</div> <%-- main --%>
	</div> <%-- container --%>
</div> <%-- wrap --%>
</body>
</html>