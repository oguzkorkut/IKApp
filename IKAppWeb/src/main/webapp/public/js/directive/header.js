app.directive("headerDetail", function(){
	return {
		scope: {},
		restrict: "E",
		templateUrl: "public/template/header.jsp",
		controller: function($scope,$location,loginService) {
			
			$scope.getClass = function(path){
				if ($location.path() == path) {
					return true;
				}else{
					return false;
				}
			}
			
			$scope.isLogged = function(){
				
				var user = loginService.getUser();
		    	if (user == null) {
		    		 return "loggedOut"
				}else if(user.roleDtos[0] === 'PERSONNEL'){
					return "loggedInPERSONNEL";
				}else if(user.roleDtos[0] === 'HR'){
					return "loggedInIK";
				}else if(user.roleDtos[0] === 'ADMIN'){
					return "loggedInMANAGER";
				}
			}
			
//			$scope.isShowHeader = true;
//			
//			if ($location.$$path == '/login') {
//				$scope.isShowHeader = false;
//			}
			
			
		}
//		,
//		link: function($scope, element, attrs,$location) {
//			$scope.isShowHeader = true;
//			
//			if ($location.$$path == '/login') {
//				$scope.isShowHeader = false;
//			}
//		}
	}
})