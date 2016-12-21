app.controller("loginController",function($scope,$location,$window,loginService,toastFactory){
	
	$scope.isShowMessage = false;
	$scope.errorMessage = "";
//	"Kullanıcı adı veya şifre hatalı.";
	
	if (loginService.isLogin()) {
		$location.path('/index.jsp');
	}
	
	$scope.login = function(){
		
		if (!$scope.loginForm.$valid) {
			$scope.errorMessage = "Kullanıcı adı veya şifre boş olamaz.";
			$scope.isShowMessage = true;
		}else{
			var promise = loginService.login($scope.j_username, $scope.j_password);
			 
			 promise.then(function(data) {
				 $scope.isShowMessage = false;
//				 $location.path('/');
				 $window.location = "index.jsp"
			 }, function(message) {
				$scope.errorMessage = message;
				$scope.isShowMessage = true;
			 });
		}
	};
	
	$scope.registration = function(){
		$window.location = "index.jsp#/kayit"
	}
	
	$scope.forgotPassword = function(){
		$window.location = "index.jsp#/sifremiunuttum"
	}
});