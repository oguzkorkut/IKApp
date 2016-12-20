app.factory("userService", function($q,$http) {
	
	var config = {
            headers : {
                'Content-Type':'application/json',
                'X-FRAME-OPTIONS' : 'SAMEORIGIN'
            }
        }
	//'application/x-www-form-urlencoded;charset=utf-8;'
	
	function save(user) {
		
		var deferred=$q.defer();
//
//		$http({
//			method : "POST",
//			url : "http://localhost:8090/appik/services/user/save",
//			data: user,
//			headers: {
//		            'Content-Type': 'application/json'
//		   }
//		}).then(function mySucces(response) {
//			console.log(response.data);
//			deferred.resolve(response.data);
//		}, function myError(response) {
//			console.error(response.statusText);
//			deferred.reject(response.statusText);
//		});
		
		$http({
			method : "POST",
			url : "http://localhost:8090/appik/services/user",
			headers : {
				'X-FRAME-OPTIONS' : 'SAMEORIGIN',
				'Content-Type' : 'application/json;charset=UTF-8'
			},	
			data : user
		}).then(
				function mySucces(response) {
					console.log(response.data);
					deferred.resolve(response.data);

				}, function myError(response) {
					console.error(response.statusText);
					deferred.reject(response.statusText);
				});
		
		
//		$http.post("http://localhost:8090/appik/services/user/save", user,config).then(function(response){
//			console.log(response.data);
//			deferred.resolve(response.data);
//		},function(response){
//			console.error(response.statusText);
//			deferred.reject(response.statusText);
//		});
		
		return deferred.promise;
	}
	
	return{
		save:save
	}
	
});


