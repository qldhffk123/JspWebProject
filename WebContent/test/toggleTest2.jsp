<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>DailyT 홈페이지입니다.</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/nav.css">
<link rel="stylesheet" href="../css/home.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<style>




</style>

<script>

$(document).ready(function(){  
  		  
		$(".nav-item2").hover(function() { //마우스를 topnav에 오버시
			$(this).parent().find(".detail-nav2").slideDown('normal').show(); 
			$(this).parent().hover(function() {  
			}, function(){  
				$(this).parent().find(".detail-nav2").slideUp('fast'); //subnav에서 마우스 벗어났을 시 원위치시킴  
			});  
		});  
	  
	});

$(document).ready(function(){  
	$(".nav-item3").hover(function() { //마우스를 topnav에 오버시
		$(this).parent().find(".detail-nav3").slideDown('normal').show(); 
		$(this).parent().hover(function() {  
		}, function(){  
			$(this).parent().find(".detail-nav3").slideUp('fast'); //subnav에서 마우스 벗어났을 시 원위치시킴  
		});  
	});  
});  

$(document).ready(function(){  
	  
	$(".nav-item4").hover(function() { //마우스를 topnav에 오버시
		$(this).parent().find(".detail-nav4").slideDown('normal').show(); 
		$(this).parent().hover(function() {  
		}, function(){  
			$(this).parent().find(".detail-nav4").slideUp('fast'); //subnav에서 마우스 벗어났을 시 원위치시킴  
		});  
	});  
  
});  

$(document).ready(function(){  
	  
	$(".nav-item5").hover(function() { //마우스를 topnav에 오버시
		$(this).parent().find(".detail-nav5").slideDown('normal').show(); 
		$(this).parent().hover(function() {  
		}, function(){  
			$(this).parent().find(".detail-nav5").slideUp('fast'); //subnav에서 마우스 벗어났을 시 원위치시킴  
		});  
	});  
  
});  
	
</script>

</head>
<body>
	<div class="container-fluid">
		<!-- 로그인, 회원가입, 장바구니 내비게이션 -->
		<div class="nav1">
			<ul class="nav justify-content-end">
				<li class="nav-item"><a class="nav-link" href="#">로그인</a></li>
				<li class="nav-item"><a class="nav-link" href="#">회원가입</a></li>
				<li class="nav-item"><a class="nav-link" href="#"><i class="fas fa fa-shopping-cart"></i></a></li>
			</ul>
		</div>
		<!-- 브랜드 스토리, 정기구독, 단품, 도구, 이벤트 내비게이션 -->
		<div class="nav2">
			<nav class="navbar navbar-menu navbar-expand-sm">
			
				<ul class="navbar-nav">
					<li class="nav-item">
     				 	<a class="nav-link" href="#"><img src="../img/dailyT-100px.png" alt="logo" style="width: 50px;"></a>
   					</li>
			    	<li class="nav-item2 col-md-4">
			    		<a class="nav-link" href="#">브랜드 스토리</a>
     				 	<ul class="detail-nav2">
     				 		<li><a class="detail-nav-link" href="#">브랜드 스토리</a></li>
     				 		<li><a class="detail-nav-link" href="#">쇼룸</a></li>  				 		
     				 	</ul>
   					</li>
    				<li class="nav-item3 col-md-4">
      					<a class="nav-link" href="#">정기구독</a>
     				 	<ul class="detail-nav3">
     				 		<li><a class="detail-nav-link" href="#">시즌 구독</a></li>
     				 		<li><a class="detail-nav-link" href="#">정기 구독</a></li>  				 		
     				 	</ul>      					
    				</li>
    				<li class="nav-item4 col-md-4">
      					<a class="nav-link" href="#">단품</a>
     				 	<ul class="detail-nav4">
     				 		<li><a class="detail-nav-link" href="#">홍차</a></li>
     				 		<li><a class="detail-nav-link" href="#">녹차</a></li>
     				 		<li><a class="detail-nav-link" href="#">백차</a></li>  				 		
     				 	</ul>      					
    				</li>
    				<li class="nav-item5 col-md-4">
      					<a class="nav-link" href="#">도구</a>
     				 	<ul class="detail-nav5">
     				 		<li><a class="detail-nav-link" href="#">스타터팩</a></li>
     				 		<li><a class="detail-nav-link" href="#">다구</a></li>		 		
     				 	</ul>       					
    				</li>
    				<li class="nav-item  col-md-4">
      					<a class="nav-link" href="#">이벤트</a>
    				</li>
				</ul>
  
			</nav>
		</div>
	</div>
	
	<div class="container-fluid">
    <div id="demo" class="carousel slide" data-ride="carousel">

  <!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>

  <!-- The slideshow -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="../img/text-banner-exam1.png" alt="banner1">
    </div>
    <div class="carousel-item">
      <img src="../img/text-banner-exam2.png" alt="banner2">
    </div>
    <div class="carousel-item">
      <img src="../img/text-banner-exam3.png" alt="banner3">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>

</div>
    </div>
    
    

</body>
</html>