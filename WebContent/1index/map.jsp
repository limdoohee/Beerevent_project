<%--store_map.do --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>스토어찾기</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/map.css" rel="stylesheet" type="text/css">
<link href="css/common.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.3.1.js"></script>
<script src="js/jquery-1.12.4.min.js"></script>
<script src="js/map.js"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=adfc3e859db695a55ef49965a93c2cd2&libraries=services,clusterer,drawing"></script>
</head>
<body>
<div id="wrap">
	<div id="container">
		<jsp:include page="../header.jsp"/>
		<div id="main">
			<div id="content">
			
			<div class="store_height_wrap">
				<form method="post">
					<fieldset>
						<legend></legend>
							<div class="store_map_layer">
								<section class="find_store_wrap" style="height: 118px;">
									<header class="find_store_header">
										<h2 class="btn_find_store">매장찾기</h2>
									</header>
									<article class="find_store_cont" style="display: block;">
										<article class="store_map_layer_cont" style="display: block;">
<!-- 											<header class="quick_search"> -->
<!-- 												<h3 class="on"><a href="javascript:void(0);">퀵 검색</a></h3> -->
<!-- 											</header> -->
											<article>
												<div class="quick_search_input">
													<div class="quick_search_inner">
														<input placeholder="매장명 또는 주소" title="퀵 검색" type="text" name="quickSearchText" id="quickSearchText">
														<a href="#" class="quickSearchBtn">검색</a>
													</div>
												</div>
<!-- 												<div class="result_num_wrap myStoreInfo"> -->
<!-- 													검색결과 없는 경우 -->
<!-- 													strong>검색 결과</strong>(<span class="en t_006633">0</span>개) -->
<!-- 													검색결과 있는 경우 -->
<%-- 													<strong class="quickSearchResultCtn"></strong> (검색 결과 <span class="en t_006633 resultCtnNumberTab1"><c:if test="${listcount > 0 }">${listcount }</c:if></span>개)<br> --%>
<!-- 												</div> -->
												<div class="result_list_wrap">
													<!-- 검색결과 없는 경우 -->
													<!--p class="no_result">검색 결과가 없습니다.</p-->
													<!-- 검색결과 있는 경우 -->
													<div class="result_list scrollbar-inner quickScrollWrap mCustomScrollbar _mCS_1">
														<div id="mCSB_1" class="mCustomScrollBox mCS-light mCSB_vertical mCSB_inside" tabindex="0">
														<div id="mCSB_1_container" class="mCSB_container" style="position:relative; top:0; left:0;" dir="ltr">
														<ul id="quickSearchResultBox">
														
														</ul>
														</div>
														<div id="mCSB_1_scrollbar_vertical" class="mCSB_scrollTools mCSB_1_scrollbar mCS-light mCSB_scrollTools_vertical" style="display: block;">
															<div class="mCSB_draggerContainer">
																<div id="mCSB_1_dragger_vertical" class="mCSB_dragger" style="position: absolute; min-height: 30px; top: 0px; display: block; height: 29px; max-height: 284px;" oncontextmenu="return false;">
																	<div class="mCSB_dragger_bar" style="line-height: 30px;"></div>
																</div>
																<div class="mCSB_draggerRail"></div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</article>
											
											
<!-- 											<header class="loca_search" > -->
<!-- 												<h3 ><a href="javascript:void(0);">지역 검색</a></h3> -->
<!-- 											</header> -->
											<article style="display:none;">
												<div class="loca_step1">
													<div class="loca_step1_ttl">STEP 1 : 시/도를 선택해 주세요.</div>
													<div class="loca_step1_cont">
														<ul class="sido_arae_box">
															<li><a href="javascript:void(0);" class="set_sido_cd_btn" data-sidocd="01">서울</a></li>
															<li><a href="javascript:void(0);" class="set_sido_cd_btn" data-sidocd="08">경기</a></li>
															<li><a href="javascript:void(0);" class="set_sido_cd_btn" data-sidocd="02">광주</a></li>
															<li><a href="javascript:void(0);" class="set_sido_cd_btn" data-sidocd="03">대구</a></li>
															<li><a href="javascript:void(0);" class="set_sido_cd_btn" data-sidocd="04">대전</a></li>
															<li><a href="javascript:void(0);" class="set_sido_cd_btn" data-sidocd="05">부산</a></li>
															<li><a href="javascript:void(0);" class="set_sido_cd_btn" data-sidocd="06">울산</a></li>
															<li><a href="javascript:void(0);" class="set_sido_cd_btn" data-sidocd="07">인천</a></li>
															<li><a href="javascript:void(0);" class="set_sido_cd_btn" data-sidocd="09">강원</a></li>
														</ul>
													</div>
												</div>
												<div class="loca_step2">
													<div class="loca_step2_ttl">STEP 2 : 구/군을 선택해 주세요.</div>
													<div class="result_num_wrap3"><a class="btn_prev" href="javascript:void(0);">앞으로</a><strong class="sidoSelectName">서울</strong></div>
													<div class="loca_step2_cont">
														<div class="loca_step2_frame scrollbar-inner mCustomScrollbar _mCS_2 mCS_no_scrollbar">
														<div id="mCSB_2" class="mCustomScrollBox mCS-light mCSB_vertical mCSB_inside" tabindex="0">
														<div id="mCSB_2_container" class="mCSB_container mCS_y_hidden mCS_no_scrollbar_y" style="position:relative; top:0; left:0;" dir="ltr">
															<ul class="gugun_arae_box">
															<%-- 구/군 리스트 --%>
															</ul>
														</div><div id="mCSB_2_scrollbar_vertical" class="mCSB_scrollTools mCSB_2_scrollbar mCS-light mCSB_scrollTools_vertical" style="display: none;">
														<div class="mCSB_draggerContainer"><div id="mCSB_2_dragger_vertical" class="mCSB_dragger" style="position: absolute; min-height: 30px; top: 0px;" oncontextmenu="return false;">
														<div class="mCSB_dragger_bar" style="line-height: 30px;"></div>
														</div>
														<div class="mCSB_draggerRail"></div>
														</div>
														</div>
														</div>
														</div>
													</div>
												</div>
												<div class="loca_step3">
													<div class="result_num_wrap">
														<!-- 검색결과 없는 경우 -->
														<!--strong>검색 결과</strong>(<span class="en t_006633">0</span>개)-->
														<!-- 검색결과 있는 경우 -->
														<strong class="gugunSelectName"></strong> (검색 결과 <span class="en t_006633 sidoSetResult">0</span>개)
													</div>
													<div class="result_list_wrap">
														<!-- 검색결과 없는 경우 -->
														<!--p class="no_result">검색 결과가 없습니다.</p-->
														<!-- 검색결과 있는 경우 -->
														<div class="result_list scrollbar-inner mCustomScrollbar _mCS_3 mCS_no_scrollbar">
														<div id="mCSB_3" class="mCustomScrollBox mCS-light mCSB_vertical mCSB_inside" tabindex="0">
														<div id="mCSB_3_container" class="mCSB_container mCS_y_hidden mCS_no_scrollbar_y" style="position:relative; top:0; left:0;" dir="ltr">
															<ul class="quickSearchResultBoxSidoGugun">
															</ul>
														</div>
														<div id="mCSB_3_scrollbar_vertical" class="mCSB_scrollTools mCSB_3_scrollbar mCS-light mCSB_scrollTools_vertical" style="display: none;">
														<div class="mCSB_draggerContainer">
														<div id="mCSB_3_dragger_vertical" class="mCSB_dragger" style="position: absolute; min-height: 30px; top: 0px;" oncontextmenu="return false;">
														<div class="mCSB_dragger_bar" style="line-height: 30px;"></div>
														</div>
														<div class="mCSB_draggerRail"></div>
														</div>
														</div>
														</div>
														</div>
													</div>
												</div>
											</article>
										</article>
									</article>
								</section>
							</div>
						</fieldset>
					</form>
				</div>
				
				<div id="map" style="width:100%;  height: -webkit-fill-available; overflow:hidden;  position: fixed;"></div>
			</div>
		</div>
	</div>
</div>
</body>
</html>