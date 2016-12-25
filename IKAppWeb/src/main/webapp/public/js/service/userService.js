'use strict';
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
	
	function getApplications(){
		var deferred = $q.defer();
		
		$http({
			method: "GET",
			url:"http://localhost:8090/appik/services/user/getApplications",
			params: params
		}).then(function success(response) {
			deferred.resolve(response.data);
		}, function(response) {
			deferred.reject(response.statusText);
		});
		
		return deferred.promise;
	}
	
	function getPositions(){
		var deferred = $q.defer();
		
		$http({
			method: "GET",
			url:"http://localhost:8090/appik/services/user/getPositions"
		}).then(function success(response) {
			deferred.resolve(response.data);
		}, function(response) {
			deferred.reject(response.statusText);
		});
		
		return deferred.promise;
	}
	
	function addPosition(position){
		var deferred=$q.defer();
		
		$http({
			method : "POST",
			url : "http://localhost:8090/appik/services/user/addPosition",
			headers : {
				'X-FRAME-OPTIONS' : 'SAMEORIGIN',
				'Content-Type' : 'application/json;charset=UTF-8'
			},	
			data : position
		}).then(
			function mySucces(response) {
				deferred.resolve(response.data);
			}, function myError(response) {
				deferred.reject(response.statusText);
		});
		
		return deferred.promise;
	}
	function deletePosition(id){
		var deferred=$q.defer();
		
		$http({
			method : "DELETE",
			url : "http://localhost:8090/appik/services/user/deletePosition/" + id,
			headers : {
				'X-FRAME-OPTIONS' : 'SAMEORIGIN',
				'Content-Type' : 'application/json;charset=UTF-8'
			}	
		}).then(
			function mySucces(response) {
				deferred.resolve(response.data);
			}, function myError(response) {
				deferred.reject(response.statusText);
		});
		
		return deferred.promise;
	}
	function updatePosition(position){
		var deferred=$q.defer();
		
		$http({
			method : "PUT",
			url : "http://localhost:8090/appik/services/user/updatePosition",
			headers : {
				'X-FRAME-OPTIONS' : 'SAMEORIGIN',
				'Content-Type' : 'application/json;charset=UTF-8'
			},	
			data : position
		}).then(
			function mySucces(response) {
				deferred.resolve(response.data);
			}, function myError(response) {
				deferred.reject(response.statusText);
		});
		
		return deferred.promise;
	}
	
	function getPositionsByUserId(id){
		var deferred = $q.defer();
		
		var data ={
				userId : id
		}
		$http({
			method: "GET",
			url:"http://localhost:8090/appik/services/user/getPositionsByUserId",
			headers : {
				'X-FRAME-OPTIONS' : 'SAMEORIGIN',
				'Content-Type' : 'application/json;charset=UTF-8'
			},	
			params : data
		}).then(function success(response) {
			deferred.resolve(response.data);
		}, function(response) {
			deferred.reject(response.statusText);
		});
		
		return deferred.promise;
	}
	
	function applyPositionByPositionId(id){
		 var deferred = $q.defer();
		 
		 $http({
			 method: "POST",
			 url : "http://localhost:8090/appik/services/user/applyPositionByPositionId/" + id,
				headers : {
					'X-FRAME-OPTIONS' : 'SAMEORIGIN',
					'Content-Type' : 'application/json;charset=UTF-8'
			 }
			 
		 }).then(function success(response) {
				deferred.resolve(response.data);
		}, function(response) {
			deferred.reject(response.statusText);
		});
		return deferred.promise;
	}
	
	function getUserDetailById(id){
		var deferred = $q.defer();
		
		var data ={
				userId : id
		}
		$http({
			method: "GET",
			url:"http://localhost:8090/appik/services/user/getUserDetailById",
			headers : {
				'X-FRAME-OPTIONS' : 'SAMEORIGIN',
				'Content-Type' : 'application/json;charset=UTF-8'
			},	
			params : data
		}).then(function success(response) {
			deferred.resolve(response.data);
		}, function(response) {
			deferred.reject(response.statusText);
		});
		
		return deferred.promise;
	}
	return{
		save:save,
		getApplications:getApplications,
		getPositions: getPositions,
		addPosition : addPosition,
		deletePosition: deletePosition,
		updatePosition:updatePosition,
		applyPositionByPositionId : applyPositionByPositionId,
		getPositionsByUserId : getPositionsByUserId,
		getUserDetailById : getUserDetailById
	}
	
});


