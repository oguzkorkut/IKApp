app.controller('userDetailController',function($scope, $uibModal,ikModalService,Utils,toastFactory,userService,loginService){
	
	$scope.userDetail = null;
	
//	 $scope.$watch('userDetail.profileDto.birthDate', function() {
//		 $scope.userDetail.profileDto.birthDate = new Date(userDetail.profileDto.birthDate)
//	 });
	
	var user = loginService.getUser();
	
	var promise = userService.getUserDetailById(user.id);
	
	promise.then(function success(data) {
		if (data.profileDto.birthDate || data.profileDto.birthDate) {
			data.profileDto.birthDate = new Date(data.profileDto.birthDate);
		}
		$scope.userDetail = data;
	}, function error(message) {
		toastFactory.openDialog(this, 'Hata','Kullanici detayının alınması sırasında bir hata oluştu. Hata:' + message);
	});
	
	
	
});