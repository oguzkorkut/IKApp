app.controller('taskController',function($scope,$location,loginService,userService,toastFactory,Utils ){
	

	
	$scope.tasks = [];

	var promise = userService.getTasks();
	
	promise.then(function success(data) {
		if (Utils.isArray(data)) {
			$scope.tasks = data;
		}else{
			$scope.tasks = null;
		}
			
	}, function error(message) {
		toastFactory.openDialog(this, 'Hata','Başvuruların alınması sırasında bir hata oluştu. Hata:' + message);
	});
	
	$scope.userCV = function($index,task){
		var path = '/kullaniciDetayi/' + task.applierId; 
		$location.path(path);
	}
	

	$scope.apply = function($index,task){
		
			var result = {
				result : true,
				comment : task.comment,
				historyId:task.id
			}
			callDecisionService(result, $index);
		
	}
	
	$scope.reject = function($index,task){
		
		if (Utils.isNotBlank(task.comment)) {
			var result = {
					result : true,
					comment : task.comment,
					historyId:task.id
				}
				callDecisionService(result, $index);
		}else{
			toastFactory.openDialog(this, 'Bilgi','Açıklama giriniz.');
		}
	}
	
	function callDecisionService(result,$index){
		
		var promise = userService.decisionService(result);
		
		promise.then(function success(data) {
			if (data.checked) {
				$scope.tasks.splice($index, 1); 
			}else{
				toastFactory.openDialog(this, 'Bilgi','Karar kaydı yapılamadı. Nedeni:' + data.value);
			}
				
		}, function error(message) {
			toastFactory.openDialog(this, 'Hata','Kararın kaydedilmesi sırasında bir hata oluştu. Hata:' + message);
		});
	}
	
	
});