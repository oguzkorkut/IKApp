<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="app" >
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>App</title>

<link href="public/css/bootstrap-3.3.7/bootstrap.css" rel="stylesheet" />
<link href="public/css/bootstrap-3.3.7/bootstrap-responsive.css" rel="stylesheet" />
<link href="public/css/bootstrap-3.3.7/bootstrap-theme.css" rel="stylesheet" />
<link rel="stylesheet" href="public/css/custom.css">
<link rel="stylesheet" type="text/css" href="public/css/font-awesome/font-awesome-4.2.0.css" />

<link href="public/css/ui-grid-4.0.0/ui-grid.min.css"  rel="stylesheet" />

<link href="public/css/angular-block-ui/angular-block-ui.min.css" rel="stylesheet" />


<link rel="stylesheet" href="public/css/angular-material.min.css" />

<link href="public/css/ik.css" rel="stylesheet" />

<script type="text/javascript" src="public/js/lib/angular.min.js"></script>
<script type="text/javascript" src="public/js/lib/angular-ui-router-0.3.1.js"></script>
<script type="text/javascript" src="public/js/lib/angular-animate.min.js"></script>
<script type="text/javascript" src="public/js/lib/angular-sanitize-1.5.8/angular-sanitize.js"></script>
<script type="text/javascript" src="public/js/lib/ui-bootstrap-tpls-2.3.1/ui-bootstrap-tpls.js"></script>
<script type="text/javascript" src="public/js/lib/angular-aria.min.js"></script>
<script type="text/javascript" src="public/js/lib/angular-material.min.js"></script>
<script type="text/javascript" src="public/js/lib/angular-messages-1.5.8/angular-messages.min.js"></script>
<script type="text/javascript" src="public/js/lib/angular-touch-1.5.8/angular-touch.min.js"></script>
<script type="text/javascript" src="public/js/lib/angular-resource-1.5.8.js"></script>
<script type="text/javascript" src="public/js/lib/angular-cookies.js"></script>
<script type="text/javascript" src="public/js/lib/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="public/js/lib/angular-1.5.8/i18n/angular-locale_tr.js"></script>
<script type="text/javascript" src="public/js/lib/angular-1.5.8/i18n/angular-locale_en.js"></script>
<script type="text/javascript" src="public/js/lib/svg-assets-cache-114/svg-assets-cache.js"></script>


<!-- <script type="text/javascript" src="public/js/lib/angular-resource-1.5.8/angular-resource-1.5.8.js"></script> -->

<script type="text/javascript" src="public/js/lib/angular-block-ui/angular-block-ui.min.js"></script>

<!-- PDF -->
<script type="text/javascript" src="public/js/lib/grunt-scripts/csv.js"></script>
<script type="text/javascript" src="public/js/lib/grunt-scripts/pdfmake.js"></script>
<script type="text/javascript" src="public/js/lib/grunt-scripts/vfs_fonts.js"></script>

<!-- UI-GRID -->
<script type="text/javascript" src="public/js/lib/ui-grid-4.0.0/ui-grid.min.js"></script>

<script type="text/javascript" src="public/js/lib/angular-block-ui/angular-block-ui.min.js"></script>

<script type="text/javascript" src="public/js/lib/bootstrap-3.3.7/bootstrap.js"></script>

<script data-main="public/js/Main" src="public/js/lib/appUtils.js"></script>

<!-- app -->
<script type="text/javascript" src="public/js/app.js"></script>

<!-- Controller -->
<script type="text/javascript" src="public/js/controller/controllers.js"></script>
<script type="text/javascript" src="public/js/controller/registrationController.js"></script>
<script type="text/javascript" src="public/js/controller/loginController.js"></script>
<script type="text/javascript" src="public/js/controller/applicationController.js"></script>
<script type="text/javascript" src="public/js/controller/messageController.js"></script>
<script type="text/javascript" src="public/js/controller/profileController.js"></script>
<script type="text/javascript" src="public/js/controller/positionController.js"></script>
<script type="text/javascript" src="public/js/controller/userDetailController.js"></script>
<script type="text/javascript" src="public/js/controller/taskController.js"></script>

<script type="text/javascript" src="public/js/controller/toast.js"></script>

<!-- Router -->
<script type="text/javascript" src="public/js/router.js"></script>

<!-- Directive -->
<script type="text/javascript" src="public/js/directive/footer.js"></script>
<script type="text/javascript" src="public/js/directive/header.js"></script>

<!-- Service -->
<script type="text/javascript" src="public/js/service/constantService.js"></script>
<script type="text/javascript" src="public/js/service/userService.js"></script>
<script type="text/javascript" src="public/js/service/cacheService.js"></script>
<script type="text/javascript" src="public/js/service/loginService.js"></script>
<script type="text/javascript" src="public/js/service/coreService.js"></script>
<script type="text/javascript" src="public/js/service/model/ikModalFactory.js"></script>
<script type="text/javascript" src="public/js/service/appUtilService.js"></script>
<script type="text/javascript" src="public/js/service/appUIGridDefs.js"></script>

<!-- Filter -->
<script type="text/javascript" src="public/js/filter/filters.js"></script>


<style type="text/css">
.main-dive{
    	/* margin: 20px; */
    }
    html {
            overflow: scroll;
            height: 100%;
             overflow-y: scroll;
  			width: 100%;
        }
        
       body {
            overflow: scroll;
             overflow-y: scroll;
        }
</style>
</head>
<body >
 <div class="main-dive" >

	<!-- header -->
	<header-detail></header-detail>
	<!-- <ng-include src="public/template/header.html"></ng-include> -->
	
	<!-- body -->
	<ui-view></ui-view>
	
	<!-- footer -->
	<!-- <ng-include src="public/template/footer.html"></ng-include> -->
	<footer-detail></footer-detail>
</div>
     


</body>
</html>
