app.factory("userService", function($q,$http) {
	
	var config = {
            headers : {
                'Content-Type':'application/json' 
            }
        }
	//'application/x-www-form-urlencoded;charset=utf-8;'
	
	function save(user) {
		
		var deferred=$q.defer();
		
		$http.post("services/user", user, config).then(function(response){
			console.log(response.data);
			deferred.resolve(response.data);
		},function(response){
			console.error(response.statusText);
			deferred.reject(response.statusText);
		});
		
		return deferred.promise;
	}
	
	return{
		save:save
	}
	
});


