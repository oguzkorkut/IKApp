<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Haber Sitesi</title>

<link href="public/css/bootstrap-3.3.7/bootstrap.css" rel="stylesheet" />
<link href="public/css/bootstrap-3.3.7/bootstrap-responsive.css" rel="stylesheet" />
<link href="public/css/bootstrap-3.3.7/bootstrap-theme.css" rel="stylesheet" />
<link rel="stylesheet" href="public/css/custom.css">


<link rel="stylesheet" href="public/css/angular-material.min.css" />

<link href="public/css/ik.css" rel="stylesheet" />

    
<style type="text/css">
.main-dive{
    	margin: 20px;
    }
</style>
</head>
<body ng-app="app"  >

 <div class="main-dive">

	<!-- header -->
	<header-detail></header-detail>
	<!-- <ng-include src="public/template/header.html"></ng-include> -->
	
	<!-- body -->
	<ui-view></ui-view>
	
	<!-- footer -->
	<!-- <ng-include src="public/template/footer.html"></ng-include> -->
	<footer-detail></footer-detail>
</div>
     


<script type="text/javascript" src="public/js/lib/angular.min.js"></script>
<script type="text/javascript" src="public/js/lib/angular-ui-router-0.3.1.js"></script>
<script type="text/javascript" src="public/js/lib/angular-animate.min.js"></script>
<script type="text/javascript" src="public/js/lib/angular-sanitize-1.5.8/angular-sanitize.js"></script>
<script type="text/javascript" src="public/js/lib/ui-bootstrap-tpls-2.3.1/ui-bootstrap-tpls.js"></script>
<script type="text/javascript" src="public/js/lib/angular-aria.min.js"></script>
<script type="text/javascript" src="public/js/lib/angular-material.min.js"></script>
<script type="text/javascript" src="public/js/lib/angular-messages-1.5.8/angular-messages.min.js"></script>
<script type="text/javascript" src="public/js/lib/angular-resource-1.5.8.js"></script>
<script type="text/javascript" src="public/js/lib/angular-cookies.js"></script>
<script type="text/javascript" src="public/js/lib/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="public/js/lib/angular-1.5.8/i18n/angular-locale_tr.js"></script>

<script type="text/javascript" src="public/js/lib/bootstrap-3.3.7/bootstrap.js"></script>


<!-- app -->
<script type="text/javascript" src="public/js/app.js"></script>

<!-- Controller -->
<script type="text/javascript" src="public/js/controller/controllers.js"></script>
<script type="text/javascript" src="public/js/controller/registrationController.js"></script>

<!-- Router -->
<script type="text/javascript" src="public/js/router.js"></script>

<!-- Directive -->
<script type="text/javascript" src="public/js/directive/footer.js"></script>
<script type="text/javascript" src="public/js/directive/header.js"></script>
</body>
</html>