<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	ArrayList<String> ar = (ArrayList<String>)request.getAttribute("elhommeBest");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>STG.com</title>

    <!-- Bootstrap core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/4-col-portfolio.css" rel="stylesheet">
    
</head>
<body>


 

<!-- Page Content -->
    <div class="container">

      <!-- Page Heading -->
      <h1 class="my-4">엘 옴므 베스트 
      </h1>
      <div class="row">
<%
	for(int i = 0; i < ar.size(); i+=3){
%>	
      
        <div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
          <div class="card h-100">
            <a href="<%=ar.get(i)%>" target="_blank"><img class="card-img-top" src="<%=ar.get(i+1) %>" alt=""></a>
            <div class="card-body">
              <h4 class="card-title">
              </h4>
              <p class="card-text"><%=ar.get(i+2) %></p>
            </div>
          </div>
        </div>
<%		
	}
%>     
      </div>
      <!-- /.row -->


    </div>
    <!-- /.container -->



    <!-- Bootstrap core JavaScript -->
    <script src="../vendor/jquery/jquery.min.js"></script>
    <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>