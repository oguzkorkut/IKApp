app.controller('applicationController',function($scope, $uibModal,ikModalService,Utils,toastFactory,userService,loginService){
	
	$scope.positionDtos = [];
	
	$scope.position = {};
	
	var user = loginService.getUser();
	
	var promise = userService.getPositionsByUserId(user.id);
	
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
		
		var promise = userService.applyPositionByPositionId(position.id);
		
		promise.then(function success(value) {
			toastFactory.openDialog(this, 'Bilgi','Başvuru alındı.');
			$scope.positionDtos.splice($index, 1);
		}, function error(message) {
			toastFactory.openDialog(this, 'Hata','Başvurunun alınması sırasında bir hata oluştu. Hata:' + message);
		});
		
		
	}
	
});