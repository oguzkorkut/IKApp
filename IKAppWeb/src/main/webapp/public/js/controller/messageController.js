app.controller('messageController',function($scope,$location,loginService,userService){
	
	$scope.messageDtos = [
		{id:5,name: "test",lastname:"test2",position:"skdkkd"}
		
	];
	
	
//	$scope.message = {};
//	
	var user = loginService.getUser();
//	
//	var promise = userService.getPositionsByUserId(user.id);
//	
//	promise.then(function success(data) {
//		if (Utils.isArray(data)) {
//			$scope.positionDtos = data;
//		}else{
//			$scope.positionDtos = null;
//		}
//			
//	}, function error(message) {
//		toastFactory.openDialog(this, 'Hata','Başvuruların alınması sırasında bir hata oluştu. Hata:' + message);
//	});
	
	
	
	$scope.userCV = function($index,message){
		var path = '/kullaniciDetayi/' + user.id; 
		$location.path(path);
	}
	
//	$scope.detail = function($index,message){
//		var path = '/userDetail/' + user.id; 
//		$location.path(path);
//	}
//	
	$scope.apply = function($index,message){
		var path = '/userDetail/' + user.id; 
		$location.path(path);
	}
	
});