app.controller('userDetailController',function($scope, $uibModal,ikModalService,Utils,toastFactory,userService,loginService){
	
	$scope.userDetail = null;
	
	var user = loginService.getUser();
	
	var promise = userService.getUserDetailById(user.id)
	
	promise.then(function success(data) {
		$scope.userDetail = data;
	}, function error(message) {
		toastFactory.openDialog(this, 'Hata','Kullanici detayının alınması sırasında bir hata oluştu. Hata:' + message);
	})
	
});