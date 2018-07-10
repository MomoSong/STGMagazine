<!-- sitemesh 사용을 위한 설정 파일 -->
<!-- 작성자 : 이영환 -->
<!-- 작성일 : 2018.04.19 -->
<!-- 1. web.xml에 filter를 지정해야 한다 -->
<!-- 2. sitemesh.xml 설정: parser, mapper를 지정 -->
<!-- 3. decorators.xml 설정: 꾸미기에 대한 설정 - 구체적인 uri 적용 -->
<!-- 4. default_decorator.jsp: decorators.xml 설정한 JSP를 만든다.(*) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	System.out.println("default_decorator.jsp:" + request.getContextPath());
	pageContext.setAttribute("absUri", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>

    <!-- Bootstrap core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/4-col-portfolio.css" rel="stylesheet">
    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Magazine<decorator:title /></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
header, footer {
	background: AntiqueWhite;
}

pre {
	background: white;
	border: 0px;
}

/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}

.carousel-inner img {
	width: 100%; /* Set width to 100% */
	margin: auto;
	min-height: 200px;
}

/* Hide the carousel text when the screen is less than 600 pixels wide */
@media ( max-width : 600px) {
	.carousel-caption {
		display: none;
	}
}

article {
	min-height: 795px;
}

#welcome {
	color: grey;
	margin: 0 auto;
}

.selected {background-color:red; }

</style>

<script>
$(document).ready(function(e){
	  $(".navbar-nav.ml-auto li").click(function(){
	    $(this).append('<span class="sr-only">(current)</span>');
	 });
	});

</script>

<decorator:head />
</head>
<body>
	 <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="http://localhost:8080/STG/views/main.do">STG Magazine</a>
        <button class="navbar-toggler" id="navBtn" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a id="rb" class="nav-link" href="http://localhost:8080/STG/views/main.do">레드옴므B</a>
            </li>
            <li class="nav-item">
              <a id="rn" class="nav-link" href="http://localhost:8080/STG/views/redHommeNew.do">레드옴므N</a>
            </li>
            <li class="nav-item">
              <a id="db" class="nav-link" href="http://localhost:8080/STG/views/dAnswerBest.do">디앤써B</a>
            </li>
            <li class="nav-item">
              <a id="dn" class="nav-link" href="http://localhost:8080/STG/views/dAnswerNew.do">디앤써N</a>
            </li>
            <li class="nav-item">
              <a id="drugb" class="nav-link" href="http://localhost:8080/STG/views/drugHommeBest.do">드럭옴므B</a>
            </li>
            <li class="nav-item">
              <a id="drugn" class="nav-link" href="http://localhost:8080/STG/views/drugHommeNew.do">드럭옴므N</a>
            </li>
            <li class="nav-item">
              <a id="eb" class="nav-link" href="http://localhost:8080/STG/views/elhommeBest.do">엘옴므B</a>
            </li>
            <li class="nav-item">
              <a id="en" class="nav-link" href="http://localhost:8080/STG/views/elhommeNew.do">엘옴므N</a>
            </li>
            <li class="nav-item">
              <a id="sb" class="nav-link" href="http://localhost:8080/STG/views/showpinBest.do">쇼핀B</a>
            </li>
            <li class="nav-item">
              <a id="sn" class="nav-link" href="http://localhost:8080/STG/views/showpinNew.do">쇼핀S</a>
            </li>
            <li class="nav-item">
              <a id="enuffb" class="nav-link" href="http://localhost:8080/STG/views/enuffBest.do">이너프너프B</a>
            </li>
            <li class="nav-item">
              <a id="enuffn" class="nav-link" href="http://localhost:8080/STG/views/enuffNew.do">이너프너프N</a>
            </li>
            <li class="nav-item">
              <a id="lb" class="nav-link" href="http://localhost:8080/STG/views/lookpineBest.do">룩파인B</a>
            </li>
            <li class="nav-item">
              <a id="ln" class="nav-link" href="http://localhost:8080/STG/views/lookpineNew.do">룩파인N</a>
            </li>
            <li class="nav-item">
              <a id="mn" class="nav-link" href="http://localhost:8080/STG/views/modernifNew.do">모던이프N</a>
            </li>
            <li class="nav-item">
              <a id="lb" class="nav-link" href="http://localhost:8080/STG/views/locobasicBest.do">로코베이직<a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="http://asclo.com/" target="_blank">애즈클로<a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
	
	<article>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
		<decorator:body />
	</article>
	
	    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; STG 2018</p>
      </div>
      <!-- /.container -->
    </footer>
</body>
</html>