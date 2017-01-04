app.controller('messageController',function($scope,$location,loginService,userService,toastFactory,Utils){
	
	$scope.messageDtos = [];
	
	
	var promise = userService.getMessages();
	
	promise.then(function success(data) {
		if (Utils.isArray(data)) {
			$scope.messageDtos = data;
		}else{
			$scope.messageDtos = [];
		}
			
	}, function error(message) {
		toastFactory.openDialog(this, 'Hata','Mesajların alınması sırasında bir hata oluştu. Hata:' + message);
	});
	
});