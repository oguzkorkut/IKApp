app.controller("loginController",function($scope,$location,$window,loginService,toastFactory){
	
	$scope.isShowMessage = false;
	$scope.errorMessage = "";
//	"Kullanıcı adı veya şifre hatalı.";
	
	var promise = loginService.isLogged();

	promise.then(function success(data) {
		console.log("kullanici login");
		$location.path('/');
//		$window.location = "index.jsp";
	}, function error(message) {
//			$window.location = "index.jsp"
	});
	
	
	$scope.login = function(){
		
		if (!$scope.loginForm.$valid) {
			$scope.errorMessage = "Kullanıcı adı veya şifre boş olamaz.";
			$scope.isShowMessage = true;
		}else{
			var promise = loginService.login($scope.j_username, $scope.j_password);
			 
			 promise.then(function(data) {
				 $scope.isShowMessage = false;
				 $location.path('/');
//				 $window.location = "index.jsp";
			 }, function(message) {
				$scope.errorMessage = message;
				$scope.isShowMessage = true;
			 });
		}
	};
	
	$scope.registration = function(){
		$location.path('/kayit');
//		$window.location = "index.jsp#/kayit"
	}
	
	$scope.forgotPassword = function(){
		 $location.path('/sifremiunuttum');
//		$window.location = "index.jsp#/sifremiunuttum"
	}
});

app.controller("RedirectloginController", function($scope,$window) {
//	$location.path('/login');
//	$window.location = "login.jsp";
})