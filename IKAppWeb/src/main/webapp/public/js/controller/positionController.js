app.controller('positionController',function($scope, $uibModal,ikModalService,Utils,toastFactory,userService){


	
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
	
	
	$scope.save = function(){
		if ($scope.positionForm.$valid) {
			
			
			if (Utils.isNotBlank($scope.position.id)) {
				var addPromise = userService.updatePosition($scope.position);
				
				addPromise.then(function success(data) {
					toastFactory.openDialog(this, 'Bilgi','Pozisyonun güncellenedi.');
					
					angular.forEach($scope.positionDtos, function(item, key) {
						if (item.id == $scope.position.id) {
							var target = {};
							
							angular.copy( $scope.position, target); 
							
							$scope.positionDtos[key] = target;
							
							$scope.position = {}
						}
					});
				}, function error(message) {
					 toastFactory.openDialog(this, 'Hata','Pozisyonun güncellenmesi sırasında bir hata oluştu. Hata' + message);
				});
			}else{
				
				var addPromise = userService.addPosition($scope.position);
				
				addPromise.then(function success(data) {
					if(typeof $scope.positionDtos == 'undefined' || $scope.positionDtos == null){
						 $scope.positionDtos = [];
					 }
					 $scope.positionDtos.push(data);
					 $scope.position = {}
					 $scope.positionForm.$setPristine();
				}, function error(message) {
					 toastFactory.openDialog(this, 'Hata','Pozisyonun eklenmesi sırasında bir hata oluştu. Hata' + message);
				});
				 
				
			}
			
			
			
			 
		 }else{
			 toastFactory.openDialog(this, 'Hata','Lütfen tüm alanları doldurunuz.');
		 }
	};
	
	$scope.update = function($index,item){
		
		$scope.position = item;
		
	};
	
	$scope.delete = function($index,position){
		var deletePromise = userService.deletePosition(position.id);
		
		deletePromise.then(function success(value) {
			toastFactory.openDialog(this, 'Bilgi','Pozisyonun silindi.');
			
			angular.forEach($scope.positionDtos, function(item, key) {
				if (item.id == position.id) {
					$scope.positionDtos.splice(key, 1);
				}
			});
			
		}, function error(message) {
			toastFactory.openDialog(this, 'Hata','Pozisyonun silinmesi sırasında bir hata oluştu. Hata' + message);
		});
		
	}
	
});

