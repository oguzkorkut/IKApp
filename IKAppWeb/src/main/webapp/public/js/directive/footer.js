//app.directive('appDetail',function(){
//	return {
//		scope:{},
//		restrict:'E',
//		templateUrl:'assets/js/directive/appDetail.html',
//		link:function(scope,elem,attrs){
//			scope.buttonText='Detay';
//			scope.enabled = false;
//			scope.details=function(){
//				elem.toggleClass('btn-active');
//				if (scope.enabled) {
//					scope.buttonText='Detay';
//					scope.enabled = false;
//				}else{
//					scope.buttonText='incelendi';
//					scope.enabled = true;
//				}
//			}
//		}
//	}
//});
app.directive("footerDetail", function(){
	return {
		scope: {},
		restrict: "E",
		templateUrl: "public/template/footer.html"
	}
})