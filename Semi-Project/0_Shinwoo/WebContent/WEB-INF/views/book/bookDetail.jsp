<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>도서 상세</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="manifest" href="site.webmanifest">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

    <!-- CSS here -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="assets/css/slicknav.css">
    <link rel="stylesheet" href="assets/css/flaticon.css">
    <link rel="stylesheet" href="assets/css/progressbar_barfiller.css">
    <link rel="stylesheet" href="assets/css/gijgo.css">
    <link rel="stylesheet" href="assets/css/animate.min.css">
    <link rel="stylesheet" href="assets/css/animated-headline.css">
    <link rel="stylesheet" href="assets/css/magnific-popup.css">
    <link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/css/themify-icons.css">
    <link rel="stylesheet" href="assets/css/slick.css">
    <link rel="stylesheet" href="assets/css/nice-select.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/all.min.css">

    <style>
        #currentMenu {
            color: white;
            padding: 20px;
            padding-left: 2.5%;
            font-size: 30px;
            font-weight: 700;
        }

        #login {
            margin: 20px;
        }

        .reqTitle {
            padding-top: 5px;
            padding-bottom: 3px;
            display: block;
        }

        .bottomBtn {
            float: right;
            padding-top: 20px;
        }
        .bottomBtn input {
            margin: 10px;
        }

        .noneList {
            list-style: none;
        }

        .fa-check-circle {
            color: #6785FF;
        }

        .section-top-border {
            padding-top: 30px;
            padding-bottom: 30px;
        }
        
        #homeNav{padding-left: 150px; padding-top: 15px;}
        #homeNav>a{color: #666;}
        .bookInfo{padding-left: 150px; padding-top: 25px; position: relative;}
        #detail_simple{position: relative;}
        #detail_simple>a{position: absolute;}
        #ebookTag{
        	cursor: default;
        	font-size: 13px;
	        text-align: center; 
	        width: 75px; 
	        height: 23px; 
	        color: white; 
	        background: rgba(102, 102, 102, 0.7); 
	        z-index: 999;
        }
        #bookName{padding-left: 330px; text-decoration: none;}
        #title{color: black;}
        .simpleInfo{
        	font-size: 13px; 
        	color: #666;
        	cursor: default;
        }
        #epub{
        	text-align: center;
        	display: inline-block;
        	width: 40px;
        	border-radius: 10%;
        	font-size: 8px; 
        	background: lightgray; 
        	color: black;
        	cursor: default;
        }
        #borrow{
        	text-align: center;
        	display: inline-block;
        	width: 120px;
        	height: 42px;
        	padding-top: 10px;
        	padding-bottom: 10px;
        	margin-top: 25px;
        	border-radius: 7%;
        	border: 0px;
        	background: #2980b9;
        	color: white;
        	font-size: 15px;
			font-weight: bold;
			cursor: pointer;
        }
        #count{
        	display: inline-block;
        	text-align: center;
        	margin-left: 15px;
        	padding-top: 10px;
        	padding-bottom: 10px;
        	padding-left: 10px;
        	padding-right: 10px;
        	border-radius: 7%;
        	font-size: 15px;
         	font-weight: bold;
         	background: lightgray;
        	color: dimgray;
        	cursor: default;
        }
        #tabBar{position: relative; display: inline-block; text-align: center; margin: 0 auto;}
        #barLi{list-style: none; display: inline-block; margin: 0 auto;}
        #tab1{float: left;}
        #bookIntro{
        	display: inline-block; 
        	width: 100px;
        	padding-top: 7px;
        	padding-bottom: 7px;
        	float: left;
        	background: #aacec2;
        	color: white;
        	font-weight: bold;
        	border: 1px solid dimgray;
        	border-radius: 5%;
        	cursor: default;
        }
        #contents{
        	background: #f8f8f8;
        	color: dimgray;
        }
        #bookIntro{border: 2px solid lightgray;}
        #introduce{
        	margin-left: 150px;
        	margin-right: 150px;
        	padding-bottom: 25px;
        	text-align: left;
        	color: dimgray;
        }
        #separate{
        	margin: 150px;
        	width: 950px;
        	margin-top: 0px; 
        	margin-bottom: 25px;
        }
        hr{border-bottom: #888;}
    </style>
</head>

<body>
    <!-- ? Preloader Start -->
    <div id="preloader-active">
        <div class="preloader d-flex align-items-center justify-content-center">
            <div class="preloader-inner position-relative">
                <div class="preloader-circle"></div>
                <div class="preloader-img pere-text">
                    <img src="assets/img/logo/loder.png" alt="">
                </div>
            </div>
        </div>
    </div>
    <!-- Preloader Start -->
    <header>
        <!-- Header Start -->
        <div class="header-area">
            <div class="main-header header-sticky">
                <!-- Logo -->
                <div class="header-left">
                    <div class="logo">
                        <a href="index.html"><img src="assets/img/logo/logo.png" alt=""></a>
                    </div>
                    <div class="menu-wrapper  d-flex align-items-center">
                        <!-- Main-menu -->
                        <div class="main-menu d-none d-lg-block">
                            <nav>
                                <ul id="navigation">
                                    <li><a href="index.html">도서관 소개</a></li>
                                    <li><a href="about.html">도서 신청 확인</a></li>
                                    <li><a href="services.html">회원 목록</a></li>
                                    <li><a href="blog.html">도서 대출 목록</a></li>
                                    <li class="active"><a href="contact.html">도서 관리</a></li>
                                    <li><a href="contact.html">독후감</a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
                <div class="header-right d-none d-lg-block">
                    <a href="#" class="header-btn1"><img src="assets/img/icon/bell.png" alt=""></a>
                    <button type="button" class="genric-btn primary circle" id="login">로그인</button>
                </div>
            </div>
        </div>
        <!-- Header End -->
    </header>
    <main>
        <!--? Hero Start -->
        <div class="slider-area2 section-bg2 hero-overly" style="background-color: #6785FF; height: 100px;">
            <div class="slider-height2 d-flex align-items-center" style="background-color: #6785FF; height: 100px;">
                <h2 id="currentMenu">상세 보기</h2>
            </div>
        </div>

        <!--? Start Align Area -->
        <div class="whole-wrap">
            <div class="container box_1170">
                <div class="section-top-border">
                    <div class="row">
                        <div id="homeNav">
			    			<a id="btn_home" href="./main/main.html" role="button">홈</a> > 
			    			<a id="btn_category" href="" role="button" name="category">소설/희곡</a> > <a>상세보기</a>
			    		</div>
			    	</div>
					   	<hr>
					<div class="row">
					   	<div id="detail_simple" class="bookInfo">
					   		<a id="bookImg"><img src="http://image.yes24.com/goods/77223021/M"></a>
					   		<a id="ebookTag">전자책</a>
					   	</div>
					   	<div id="bookName">
					   		<a id="title" name="bookTitle"><b>지구에서 한아뿐</b></a>
					   		<br>
					   		<hr style="margin-top: 10px; margin-bottom: 20px; width: 250px;">
					   		<span class="simpleInfo"><b>글쓴이 &nbsp;&nbsp; </b></span><span class="simpleInfo" name="author">정세랑</span>
					   		<br>
					   		<span class="simpleInfo"><b>출판사 &nbsp;&nbsp; </b></span><span class="simpleInfo" name="publisher">난다</span>
					   		<br>
					   		<span class="simpleInfo"><b>출간일 &nbsp;&nbsp; </b></span><span class="simpleInfo" name="release">2019.07.31</span>
					   		<br>
					   		<span class="simpleInfo"><b>제공형태(크기): &nbsp;&nbsp;</b></span><span id="epub" name="epub">ePUB</span><span class="simpleInfo"> 16M</span>
					   		<br>
					   		<form onclick="borrow(returnDay);" id="borrow">대출하기</form>
					   		<div id="count">대출   &nbsp;&nbsp; <span id="currentNum">0</span> / 2</div>
					   		<script>
					   			function rtDay(date) {
					   				var today = new Date();
					  				var twoWeeks = new Date(today.setDate(today.getDate() + 14));
									
					  				var year = twoWeeks.getFullYear();
					  				var month = (1 + twoWeeks.getMonth());
					  				var day = twoWeeks.getDate();
					  				return year + '-' + month + '-' + day;
					   			}
									var returnDay = rtDay(new Date());
					  				console.log(returnDay);
						  		function borrow(returnDay){
					   				alert('도서가 대출되었습니다.\n' + returnDay + ' 까지 이용하실 수 있습니다.');
							  		var cur = document.getElementById('currentNum').innerHTML;
							  		var borrow = document.getElementById('borrow');
							  		if(cur < 2){
							  			cur = Number(cur) + 1;
							  			document.getElementById('currentNum').innerHTML = cur;
							  			borrow.innerText = '대출중';
							  			borrow.onclick = null;
							  		}
						  		}
					   		</script>
					   	</div>
					   		<br><br>
					   	<div id="tabBar" class="bookInfo">
					 		<span id="bookIntro">책 소개</span><br>
					   	</div>
					   	<hr id="separate">
					   	<fieldset>
							<div id="introduce" name="bookProfile">
								사랑을 위해 2만 광년을 날아온 외계인!<br><br>
							
								자신의 사랑이 우주에서 단 하나뿐임을 바라는 연인들을 위한 이야기 『지구에서 한아뿐』. SF, 로맨스, 호러, 스릴러 등 장르의 경계를 넘나드는 작가 정세랑의 소설이다. 
								친환경 디자이너 한아와 그녀의 외계인 남자친구 경민의 알콩달콩하면서도 범우주적인 사랑 이야기를 그리고 있다.<br><br>
							
								지구 환경을 지키기 위해 저탄소 생활을 하는 디자이너 한아. 그녀에게는 경민이라는 남자친구가 있다. 경민은 자신이 하고 싶은 대로 살면서 늘 한아를 기다리게 하는 자유로운 영혼이다. 
								캐나다로 별똥별을 보기 위해 여행을 떠난 경민에게 연락이 없던 어느 날, 한아는 캐나다에 소형 운석이 떨어지면서 큰 폭발이 있었다는 뉴스를 본다. 
								경민을 걱정하는 한아 앞에 며칠 뒤 아무렇지도 않은 듯 경민이 나타나지만, 평소와 달리 지나치게 다정해진 그를 보고 한아의 의심은 커져만 가는데….
							</div>
					   	</fieldset>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Align Area -->
    </main>
    <footer>
        <!-- Footer Start-->
        <div class="footer-area footer-padding">
            <div class="container">
                <div class="row d-flex justify-content-between">
                    <div class="col-xl-4 col-lg-4 col-md-4 col-sm-6">
                        <div class="single-footer-caption mb-50">
                            <div class="single-footer-caption mb-30">
                                <!-- logo -->
                                <div class="footer-logo mb-35">
                                    <a href="index.html"><img src="assets/img/logo/logo2_footer.png" alt=""></a>
                                </div>
                                <div class="footer-tittle">
                                    <div class="footer-pera">
                                        <p>(C)SHINWOO UNIVERSITY LIBRARY ALL RIGHTS RESERVED</p>
                                    </div>
                                </div>
                                <!-- social -->
                                <div class="footer-social">
                                    <a href="#"><i class="fab fa-twitter"></i></a>
                                    <a href="https://bit.ly/sai4ull"><i class="fab fa-facebook-f"></i></a>
                                    <a href="#"><i class="fab fa-pinterest-p"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-lg-4 col-md-4 col-sm-6">
                        <div class="single-footer-caption mb-50">
                            <div class="footer-tittle">
                                <h4>Services </h4>
                                <ul>
                                    <li><a href="#">- 주요 전화번호</a></li>
                                    <li><a href="#">- 개인정보처리방침</a></li>
                                    <li><a href="#">- 무단수집거부</a></li>
                                    <li><a href="#">- 원격지원</a></li>
                                    <li><a href="#">- 찾아오는길</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-lg-4 col-md-4 col-sm-6">
                        <div class="single-footer-caption mb-50">
                            <div class="footer-tittle">
                                <h4>Contact</h4>
                                <ul>
                                    <li class="number"><a href="#">(02) 123-4567</a></li>
                                    <li><a href="#">shinwoo@university.kr</a></li>
                                    <li><a href="#">서울시 강남구 역삼로</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- footer-bottom area -->
        <div class="footer-bottom-area section-bg2" data-background="assets/img/gallery/footer-bg.png">
            <div class="container">
                <div class="footer-border">
                    <div class="row d-flex align-items-center">
                        <div class="col-xl-12 ">
                            <div class="footer-copy-right text-center">
                                <p>
                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                    Copyright &copy;
                                    <script>document.write(new Date().getFullYear());</script> All rights reserved |
                                    This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a
                                        href="https://colorlib.com" target="_blank">Colorlib</a>
                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer End-->
    </footer>
    <!-- Scroll Up -->
    <div id="back-top">
        <a title="1:1 문의" href="#"><i class="fas fa-question"></i></a>
    </div>
    <script>
        $(function () {
            var now = new Date();
            var year = now.getFullYear();
            var month = now.getMonth() + 1;
            var date = now.getDate();
            $('input[name=reqDate]').val(year + '-' + month + '-' + date);
            console.log(now);
        });
    </script>
    <!-- JS here -->

    <script src="./assets/js/vendor/modernizr-3.5.0.min.js"></script>
    <!-- Jquery, Popper, Bootstrap -->
    <script src="./assets/js/vendor/jquery-1.12.4.min.js"></script>
    <script src="./assets/js/popper.min.js"></script>
    <script src="./assets/js/bootstrap.min.js"></script>
    <!-- Jquery Mobile Menu -->
    <script src="./assets/js/jquery.slicknav.min.js"></script>

    <!-- Jquery Slick , Owl-Carousel Plugins -->
    <script src="./assets/js/owl.carousel.min.js"></script>
    <script src="./assets/js/slick.min.js"></script>
    <!-- One Page, Animated-HeadLin -->
    <script src="./assets/js/wow.min.js"></script>
    <script src="./assets/js/animated.headline.js"></script>
    <script src="./assets/js/jquery.magnific-popup.js"></script>

    <!-- Date Picker -->
    <script src="./assets/js/gijgo.min.js"></script>
    <!-- Nice-select, sticky -->
    <script src="./assets/js/jquery.nice-select.min.js"></script>
    <script src="./assets/js/jquery.sticky.js"></script>

    <!-- counter , waypoint,Hover Direction -->
    <script src="./assets/js/jquery.counterup.min.js"></script>
    <script src="./assets/js/waypoints.min.js"></script>
    <script src="./assets/js/jquery.countdown.min.js"></script>
    <script src="./assets/js/hover-direction-snake.min.js"></script>

    <!-- contact js -->
    <script src="./assets/js/contact.js"></script>
    <script src="./assets/js/jquery.form.js"></script>
    <script src="./assets/js/jquery.validate.min.js"></script>
    <script src="./assets/js/mail-script.js"></script>
    <script src="./assets/js/jquery.ajaxchimp.min.js"></script>

    <!-- Jquery Plugins, main Jquery -->
    <script src="./assets/js/plugins.js"></script>
    <script src="./assets/js/main.js"></script>
    <script src="./assets/js/all.min.js"></script>

</body>

</html>