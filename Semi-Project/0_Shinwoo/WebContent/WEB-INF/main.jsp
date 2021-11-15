<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신우대학교 메인</title>
<!-- 제이쿼리 불러오기 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://fontawesome.com/v5.15/icons/search?style=solid"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>

<style>
	header {
	height : 70px; 
	background : #aacec2; padding : 30px;
	font-size : 45px; font-weight : bold;
	padding-top: 10px; padding-bottom: 0px; z-index:1;
	}
	
	header a {text-decoration : none; color : #404040;z-index:1;}
	
	nav li{display: inline-block; font-size: 20px; text-align : center;  padding-right: 10px;
	font-weight: bold; z-index:1;}
	
  	nav{
  		height : 80px; background : #aacec2;  position:absolute;
  		position: sticky;
  		padding-top: 5px; padding-bottom: 0px; 
  		text-align : center; top: -20px;z-index:1;
  		padding-right: 80px;}
	
	.header-item a {text-align : center; text-decoration : none; color : #404040;
	display : block; padding : 10px 0px 0px 40px; line-height: 45px; }
	
	body {background-image: url('#');
  		background-repeat: no-repeat;
  		background-position: center;
  		background-size: cover;
      	margin: 0;
    	padding: 0;}
	
	li> a:hover{color : white;}
	
	#news{/*margin : margin-left auto; margin-right: auto;*/
		margin-left:100px; margin-right:100px;
		text-align: justify; padding-top: 100px;}
			
	table img {display:block; margin:auto;}		

	#news tr td {padding : 5px;}
	table a{text-decoration : none; color : black;}
	table span {font-weight : bold; font-size : 20px;}
	main { padding : 0px;}

	#wholewhole{width:auto; background-color: #2980B9;}
	#wholeslide-div{width:1130px; height:350px; padding-left: 100px; padding-right: 100px;background-color: #2980B9;margin: 0 auto;}
	#slider-div{width:1130px; height:300px; background-color:#2980B9; padding-top:20px; padding-right:0px;}
	.bookimage{width:95%; height:auto; margin-top:35px; margin-left:20px;  max-width: 90%; height:auto; display: block;
	 			box-shadow: 0 11px 11px rgba(0,0,0,0.22), 0 9px 9px rgba(0,0,0,0.27);
  				transition: all 0.3s cubic-bezier(.25,.8,.25,1);
  				border-radius: 6.5%;
  			}
  	.bookimage:hover{box-shadow: 0 14px 28px rgba(0,0,0,0.25), 0 10px 10px rgba(0,0,0,0.22); transform:scale(1.08); top: 0; left: 0; opacity: 0.915;}
	.book-div{width:400px; height:300px; padding:0px 40px 0px 0px;}
	
	.center{text-align: center;}
	#searchForm{display: inline-block; width: 430px; height: 40px; border: solid #aacec2 4px;}
	#searchOption{width: 20%; height: 40px; border: 0px; padding-right: 14px;}
	#searchText{width:60%; height: 40px; border: 0px; background: none;}
	#searchButton{width: 60px; height: 40px; border: 0px;}
	#latestBook{display: none;}
	.order{cursor: pointer;}
	.left{padding-left: 20%;}
  	ul.ul1{list-style: none; width: 1000px; margin: 0 auto;}
	img.bookimg{
		padding-bottom: 10px; 
		cursor: pointer; 
		display: inline-block; 
		margin: 0 auto; 
		max-width: 100%;
		align: center;
		width: 150px; height: 230px;
	}
	li.booklist{display: list-item; float: left; width: 25%; padding-top: 10px;}
	.listop{
		text-decoration-line: none; 
		color: #666; 
		font-weight: bolder; 
		overflow: hidden; 
		word-break: break-all;
	  	display: block;
		width: 170px;
	}
	.bookName{width:148px; max-height: 30px;}
	.centerBook{justify-content: center; padding: 0px; margin: 0 auto;}
	
	#newsdiv{padding-top : 500px;}
	#footerdiv{height:200px; background:lightgray; text-align:center;}
	
</style>
</head>

<body>
	<header><a href ="http://www.naver.com">   신우대학교</a>
		<input type ="submit" value = "로그인" style=" float:right; width : 80px; height : 40px;
		 background-color : #5D5E60; color : white; font-weight : bold; border-radius: 5px;" >
		<a href ="http://www.naver.com"></a>
	</header>
	
	<nav class ="nav" >	
		<ul>
			<li class = "header-item"><a href ="http://www.naver.com">도서관 소개</a></li>
			<li class = "header-item"><a href ="http://www.naver.com">도서신청</a></li>
			<li class = "header-item"><a href ="http://www.naver.com">마이페이지</a></li>
		</ul>
	</nav>

	<main>
   		<div id="wholewhole">
   			<div id = "wholeslide-div">
        		<div id="slider-div">
        		<div class="book-div"><a href="https://www.naver.com"><img src="sample/image/book1.png" class="bookimage"></a></div>
        		<div class="book-div"><a href="https://www.naver.com"><img src="sample/image/book2.png"class="bookimage"></a></div>
        		<div class="book-div"><a href="https://www.naver.com"><img src="sample/image/book3.png"class="bookimage"></a></div>
	            <div class="book-div"><a href="https://www.naver.com"><img src="sample/image/book4.png"class="bookimage"></a></div>
	            <div class="book-div"><a href="https://www.naver.com"><img src="sample/image/book5.png"class="bookimage"></a></div>
	            <div class="book-div"><a href="https://www.naver.com"><img src="sample/image/book1.png"class="bookimage"></a></div>
	            <div class="book-div"><a href="https://www.naver.com"><img src="sample/image/book2.png"class="bookimage"></a></div>
	            <div class="book-div"><a href="https://www.naver.com"><img src="sample/image/book3.png"class="bookimage"></a></div>
	            <div class="book-div"><a href="https://www.naver.com"><img src="sample/image/book4.png"class="bookimage"></a></div>
	            <div class="book-div"><a href="https://www.google.com"><img src="sample/image/book5.png"class="bookimage"></a></div>
       			</div>
   			</div>
   		</div>
	<script>
    $(function(){
      $('#slider-div').slick({
          slide: 'div',      
          infinite : true,      
          slidesToShow : 3,        
          slidesToScroll : 1,        
          speed : 4000,    
          arrows : true,        
          dots : true,       
          autoplay : true,            
          autoplaySpeed : 5000,        
          pauseOnHover : false,      
          vertical : false,        
          prevArrow : "<button type='button' class='slick-prev'>Previous</button>",      
          nextArrow : "<button type='button' class='slick-next'>Next</button>",      
          dotsClass : "slick-dots",    
          draggable : true,     
          
          responsive: [ 
              {  
                  breakpoint: 960, 
                  settings: {
                      slidesToShow:3
                  } 
              },
              { 
                  breakpoint: 768,
                  settings: {    
                      slidesToShow:2
                  } 
              }
          ]

      });
    })
    
	</script>
	<br><br><br>
		
	<form class="center" name="search">
	<div id="searchForm" class="center">
		<select id="searchOption">
			<option value="title" selected>도서명</option>
			<option value="author">저자</option>
		</select>
		<input type="search" id="searchText">
		<button id="searchButton" type="submit" title="검색" style="background:none;">
			<i class="fas fa-search fa-lg" style="background:none; color:#2980b9;"></i>
		</button>
	</div>
	<br><br>
	<hr width=60%>
	</form>
	<br><br>
	
	
	<form name="bookList">
		<div id="listDiv" class="left">
			<a onclick="bookOrder(this);" class="order"><b>인기순</b></a>&nbsp;
			<a onclick="bookOrder(this);" class="order"><b>최신순</b></a>
			<script>
				function bookOrder(book){
					if(book.innerText == "인기순"){
						document.getElementById("bestBook").style.display = "block";
						document.getElementById("latestBook").style.display = "none";
					} else if(book.innerText == "최신순") {
						document.getElementById("bestBook").style.display = "none";
						document.getElementById("latestBook").style.display = "block";
					}
						
				}
			</script>
		</div>
		<br>
		<div id="bestLatest">
			<div id="bestBook" class="centerBook">
				<ul class="ul1">
					<li class="booklist">
						<a class="listop" href="http://www.yes24.com/Product/Goods/91065309">
							<img class="bookimg" src="http://image.yes24.com/goods/91065309/M" alt="달러구트 꿈 백화점"><br>
						</a>
						<span class="bookName">
						<a class="listop" href="http://www.yes24.com/Product/Goods/91065309">
							달러구트 꿈 백화점
						</a>
						</span>
					</li>
					<li class="booklist">
						<a href="http://www.yes24.com/Product/Goods/93888691">
							<img class="bookimg" src="http://image.yes24.com/goods/93888691/M" alt="2030 축의 전환"><br>
						</a>
						<span class="bookName">
							<a class="listop" href="http://www.yes24.com/Product/Goods/93888691">2030 축의 전환</a>
						</span>
					</li>
					<li class="booklist">
						<a href="http://www.yes24.com/Product/Goods/67362730">
							<img class="bookimg" src="http://image.yes24.com/goods/67362730/M" alt="해커스 토익 기출 보카"><br>
						</a>
						<span class="bookName">
							<a class="listop" href="http://www.yes24.com/Product/Goods/67362730">해커스 토익 기출 보카</a>
						</span>
					</li>
					<li class="booklist">
						<a href="http://www.yes24.com/Product/Goods/16384156">
							<img class="bookimg" src="http://image.yes24.com/goods/16384156/M" alt="이토록 공부가 재미있어지는 순간"><br>
						</a>
						<span class="bookName">
						<a class="listop" href="http://www.yes24.com/Product/Goods/16384156">이토록 공부가 재미있어지는 순간</a>
						</span>
						<br>
					</li>
					<li class="booklist">
						<a href="http://www.yes24.com/Product/Goods/91065309">
							<img class="bookimg" src="http://image.yes24.com/goods/91065309/M" alt="달러구트 꿈 백화점"><br>
						</a>
						<span class="bookName">
						<a class="listop" href="http://www.yes24.com/Product/Goods/91065309">
							달러구트 꿈 백화점
						</a>
						</span>
					</li>
					<li class="booklist">
						<a href="http://www.yes24.com/Product/Goods/93888691">
							<img class="bookimg" src="http://image.yes24.com/goods/93888691/M" alt="2030 축의 전환"><br>
						</a>
						<span class="bookName">
							<a class="listop" href="http://www.yes24.com/Product/Goods/93888691">2030 축의 전환</a>
						</span>
					</li>
					<li class="booklist">
						<a href="http://www.yes24.com/Product/Goods/67362730">
							<img class="bookimg" src="http://image.yes24.com/goods/67362730/M" alt="해커스 토익 기출 보카"><br>
						</a>
						<span class="bookName">
							<a class="listop" href="http://www.yes24.com/Product/Goods/67362730">해커스 토익 기출 보카</a>
						</span>
					</li>
					<li class="booklist">
						<a href="http://www.yes24.com/Product/Goods/16384156">
							<img class="bookimg" src="http://image.yes24.com/goods/16384156/M" alt="이토록 공부가 재미있어지는 순간"><br>
						</a>
						<span class="bookName">
							<a class="listop" href="http://www.yes24.com/Product/Goods/16384156">이토록 공부가 재미있어지는 순간</a>
						</span>
					</li>
				</ul>
			</div>
			<div id="latestBook" class="centerBook">
				<ul class="ul1">
					<li class="booklist">
						<a href="http://www.yes24.com/Product/Goods/16384156">
							<img class="bookimg" src="http://image.yes24.com/goods/16384156/M" alt="이토록 공부가 재미있어지는 순간"><br>
						</a>
						<span class="bookName">
							<a class="listop" href="http://www.yes24.com/Product/Goods/16384156">이토록 공부가 재미있어지는 순간</a>
						</span>
					</li>
					<li class="booklist">
						<a href="http://www.yes24.com/Product/Goods/67362730">
							<img class="bookimg" src="http://image.yes24.com/goods/67362730/M" alt="해커스 토익 기출 보카"><br>
						</a>
						<span class="bookName">
							<a class="listop" href="http://www.yes24.com/Product/Goods/67362730">해커스 토익 기출 보카</a>
						</span>
					</li>
					<li class="booklist">
						<a href="http://www.yes24.com/Product/Goods/93888691">
							<img class="bookimg" src="http://image.yes24.com/goods/93888691/M" alt="2030 축의 전환"><br>
						</a>
						<span class="bookName">
							<a class="listop" href="http://www.yes24.com/Product/Goods/93888691">2030 축의 전환</a>
						</span>
					</li>
					<li class="booklist">
						<a href="http://www.yes24.com/Product/Goods/16384156">
							<img class="bookimg" src="http://image.yes24.com/goods/16384156/M" alt="이토록 공부가 재미있어지는 순간"><br>
						</a>
						<span class="bookName">
							<a class="listop" href="http://www.yes24.com/Product/Goods/16384156">이토록 공부가 재미있어지는 순간</a>
						</span>
						<br>
					</li>
					<li class="booklist">
						<a href="http://www.yes24.com/Product/Goods/91065309">
							<img class="bookimg" src="http://image.yes24.com/goods/91065309/M" alt="달러구트 꿈 백화점"><br>
						</a>
						<span class="bookName">
						<a class="listop" href="http://www.yes24.com/Product/Goods/91065309">
							달러구트 꿈 백화점
						</a>
						</span>
					</li>
					<li class="booklist">
						<a href="http://www.yes24.com/Product/Goods/67362730">
							<img class="bookimg" src="http://image.yes24.com/goods/67362730/M" alt="해커스 토익 기출 보카"><br>
						</a>
						<span class="bookName">
							<a class="listop" href="http://www.yes24.com/Product/Goods/67362730">해커스 토익 기출 보카</a>
						</span>
					</li>
					<li class="booklist">
						<a href="http://www.yes24.com/Product/Goods/93888691">
							<img class="bookimg" src="http://image.yes24.com/goods/93888691/M" alt="2030 축의 전환"><br>
						</a>
						<span class="bookName">
							<a class="listop" href="http://www.yes24.com/Product/Goods/93888691">2030 축의 전환</a>
						</span>
					</li>
					<li class="booklist">
						<a href="http://www.yes24.com/Product/Goods/91065309">
							<img class="bookimg" src="http://image.yes24.com/goods/91065309/M" alt="달러구트 꿈 백화점"><br>
						</a>
						<span class="bookName">
						<a class="listop" href="http://www.yes24.com/Product/Goods/91065309">
							달러구트 꿈 백화점
						</a>
						</span>
					</li>
				</ul>
			</div>
		</div>
	</form>
	
	
	
	 <table id = "news" >
	 	<tr>
		 	<td colspan = 2 ><img width = "500px" height = "300px" src = "sample/image/오징어.jpg" >
		 	<a href ="http://news.unn.net/"></a></td>
		 	<td colspan = 2><br><a href ="http://www.naver.com">
		 	<br><span>00대, 다음달  11일 ‘오징어게임’ 000 미술감독 초청 특강 </span><br> 
		 	채경선 감독은 상명대 예술대학 무대미술전공 99학번으로 제48회 대종상영화제, 2015년 제52회 대종상영화제에서 미술상을 수상했다.이날 채경선 감독은 후배들을 대상으로 영화미술 분야에 대한 특강과 대학생활에 대한 조언을 이야기할 예정이다.
		 	</a></td>
	 	</tr>
	 	<tr>
		 	<td>
			 	<a href ="http://www.lecturernews.com/news/articleView.html?idxno=78830">
			 	<img width = "250px" height = "200px" src = "sample/image/북콘서트.jpg" >
			 	</a>
				<br><a href ="http://www.lecturernews.com/news/articleView.html?idxno=78830">
				<br><span>00대학교 도서관,‘000 작가’초청 북 콘서트 마련.</span><br><br>[한국강사신문 김순복 기자] 00대학교는 지역민들과의 소통을 통해 지역과 동행하기 위해 노력하고 있는 00대학교 도서관이 『완전한 행복』의 정유정 작가를 초청, 지역민과 함께하는 북 콘서트를 개최한다고 21일 밝혔다.</a>
		 	</td>
		 	<td>
			 	<a href ="http://www.naver.com">
			 	<img width = "250px" height = "200px" src = "sample/image/시설.jpg" >
			 	</a>
				<br><a href ="http://www.naver.com">
				<br><span>00대학교 중앙도서관 '학생 중심 공간'으로 새단장</span><br><br>국립 00대학교는 교내 중앙도서관에 학생 중심의 개방·공유형 창의·융합 학습공간과 취·창업 지원 공간 플랫폼 등 교육혁신 인프라를 구축했다고 28일 밝혔다.이번 교육혁신 인프라 구축은 포스트 코로나에 대비한 미래교육체제 전환의 하나로 추진했다.</a>
		 	</td>
		 	<td>
			 	<a href ="http://www.lecturernews.com/news/articleView.html?idxno=78656">
			 	<img width = "250px" height = "200px" src = "sample/image/고대.jpg" >
			 	</a>
				<br><a href ="http://www.lecturernews.com/news/articleView.html?idxno=78656">
				<br><span>00대학교 도서관, 000도서관과 공동 프로젝트 영상 공개</span><br><br>00대학교는 본교 도서관과 000도서관이 10개월에 걸쳐 진행된 영상 제작 공동프로젝트를 마치고 10월 1일 한국어와 프랑스어로 함께 제작한 영상을 동시에 공개했다고 19일 밝혔다. 영상은 양 기관 홈페이지 및 유튜브 채널에서 볼 수 있다.</a>
		 	</td><br>
		 	<td>
			 	<a href ="http://mobile.busan.com/view/busan/view.php?code=2021102109330915828">
			 	<img width = "250px" height = "200px" src = "sample/image/과학.jpg" ></a>
				<br><a href ="http://mobile.busan.com/view/busan/view.php?code=2021102109330915828">
				<br><span>00대 도서관 「PNU SF Day」 강연회 [과학, SF를 만나다] 개최</span><br><br> 부산대학교 도서관(관장 설문원·문헌정보학과 교수)은 28일 오후 2시부터 교내 중앙도서관 1층 복합문화공간에서 「PNU SF Day」 강연회 ‘과학, SF를 만나다’를 ‘인간과 바이러스의 오징어게임?’이라는 주제로 개최한다고 21일 밝혔다.</a>
		 	</td>
	 	</tr> 
	 </table>
	<br><br>
	</main>
	<footer>
		<div id="footerdiv">footer</div>
	</footer>
</body>
</html>