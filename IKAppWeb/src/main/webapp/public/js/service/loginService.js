'use strict';
app.factory("loginService", function($q,$http, $location,toastFactory,cacheService,Utils) {
	
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
					if (response.data.success) {
						cacheService.setCookieByUserModel(response.data.user);
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
//			$window.location = "login.jsp"
		}, function(response) {
			toastFactory.openDialog(this, "HATA", response.statusText);
		});

	};
	
	function isLogged() {
		var deferred=$q.defer();
			
		$http({
			method: "GET",
			url:"http://localhost:8090/appik/services/user/isLogged"
		}).then(function success(response) {
//				$location.path('login');
			if (response.data.checked) {
				deferred.resolve(response.data);
			}else{
				cacheService.clearUserModelByCookie();
				deferred.reject(response.statusText);
			}
			
		}, function(response) {
			var userModel = cacheService.getUserModelByCookie();
			
			if (!userModel) {
				cacheService.clearUserModelByCookie();	
			}
			
			deferred.reject(response.statusText);
		});
			
		return deferred.promise;
	};
	
	function getUser(){
		var user = cacheService.getUserModelByCookie();
		
		if (Utils.isNotBlank(user)) {
			return user;
		} else {
			return null;
		}
	}
	
	return {
		login : login,
		logout : logout,
		isLogged: isLogged,
		getUser : getUser
	}
	
})