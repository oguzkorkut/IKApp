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


<link rel="stylesheet" href="public/css/angular-material.min.css" />


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
<script type="text/javascript" src="public/js/lib/svg-assets-cache-114/svg-assets-cache.js"></script>

<script type="text/javascript" src="public/js/lib/bootstrap-3.3.7/bootstrap.js"></script>

<!-- app -->
<script type="text/javascript" src="public/js/app.js"></script>

<!-- Controller -->
<script type="text/javascript" src="public/js/controller/controllers.js"></script>
<script type="text/javascript" src="public/js/controller/registrationController.js"></script>
<script type="text/javascript" src="public/js/controller/loginController.js"></script>


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

<!-- Filter -->
<script type="text/javascript" src="public/js/filter/filters.js"></script>

</head>
<body ng-controller="loginController">
	<div id="mainContainer">
		<div class="login-container">
			<div class="login-card">
				<div class="login-form">
					<form name="loginForm"  method="POST"  class="form-horizontal">
								<div class="alert alert-danger" ng-show="isShowMessage">
									<p>{{errorMessage}}</p>
								</div>
							<div class="input-group input-sm">
								<label class="input-group-addon" for="j_username"><i class="fa fa-user"></i></label>
								<input type="text" class="form-control" id="j_username" name="j_username" ng-model="j_username" placeholder="E-Posta" required autocomplete="off"  >
							</div>
							<div class="input-group input-sm">
								<label class="input-group-addon" for="j_password"><i class="fa fa-lock"></i></label> 
								<input type="password" class="form-control" id="j_password" name="j_password" ng-model="j_password" placeholder="Şifre" required autocomplete="off">
							</div>
							<div class="form-actions">
								<div class="input-group input-sm">
									<button type="button" id="loginBtn"  class="btn btn-primary login-btn loginBtn" ng-click="login();" >GİRİŞ YAP</button>
									<button type="button" id="registrationBtn" ng-click="registration();" class="btn btn-primary login-btn ">KAYIT OL</button>
											&nbsp;<a id='loginForgotPassword' ng-click="forgotPassword();" class="user-link">Şifremi Unuttum</a>
	                          	</div>
                          	
							</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	



</body>
</html>
