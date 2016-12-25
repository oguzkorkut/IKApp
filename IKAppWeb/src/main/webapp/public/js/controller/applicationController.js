app.controller('applicationController',function($scope, $uibModal,ikModalService,Utils,toastFactory,userService){
	
	$scope.positionDtos = [];
	
	$scope.position = {};
	
	var promise = userService.getPositions();
	
	promise.then(function success(data) {
		if (Utils.isArray(data)) {
			$scope.positionDtos = data;
		}else{
			$scope.positionDtos = null;
		}
			
	}, function error(message) {
		toastFactory.openDialog(this, 'Hata','Pozisyonların alınması sırasında bir hata oluştu. Hata:' + message);
	});
	
	$scope.apply = function($index,position){
		
	}
	
});