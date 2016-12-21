'use strict';
app.factory("loginService", function($q,$http, $location,toastFactory,cacheService) {
	
	function login(userName,password){
		var deferred=$q.defer();
		var userModel = {
			j_username: userName,
	    	j_password : password
		}
//		$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
		$http({
			method : "POST",
			url : "http://localhost:8090/appik/login",
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			    transformRequest: function(obj) {
			        var str = [];
			        for(var p in obj)
			        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        return str.join("&");
			},
//			headers : {
//				'X-FRAME-OPTIONS' : 'SAMEORIGIN',
//				'Content-Type' : 'application/json;charset=UTF-8'
//			},
//			$httpParamSerializerJQLike(userModel)
			data : userModel
		}).then(function success(response) {
					console.log(response.data);
					if (response.data.isSuccess) {
						cacheService.setCookieByUserModel(response.data);
						deferred.resolve(response.data);
					}else{
						deferred.reject(response.data.errorMessage);
					}
				}, function error(response) {
					if (typeof response.data != undefined) {
						deferred.reject(response.data.errorMessage);
					}else{
						deferred.reject(response.statusText);
					}
				});
		
		return deferred.promise;
	};
	
	function logout (){
		$http({
			method: "GET",
			url:"http://localhost:8090/appik/logout"
		}).then(function success(response) {
			cacheService.clearUserModelByCookie();
			$location.path('/login');
		}, function(response) {
			toastFactory.openDialog(this, "HATA", response.statusText);
		});

	};
	
	function isLogged() {
		var userModel = cacheService.getUserModelByCookie();

		if (userModel) {
			return true;
		}
		return false;
	};
	
	return {
		login : login,
		logout : logout,
		isLogin: isLogged
	}
	
})