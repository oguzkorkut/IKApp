app.directive("headerDetail", function(){
	return {
		scope: {},
		restrict: "E",
		templateUrl: "public/template/header.jsp",
		controller: function($scope,$location,loginService) {
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
