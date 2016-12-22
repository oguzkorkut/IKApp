'use strict';
var app = angular.module('app',['ui.router','ngMaterial','ngResource','ngAnimate', 'ngSanitize', 'ui.bootstrap','ngMessages','material.svgAssetsCache','ngCookies']);

app.run(function($rootScope,$state,$http,loginService){
	$rootScope.$state = $state;
	
//	$http.defaults.headers.common.Accept="applcation/json";
	
	//Form Data olarak gönderir
//	$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
//	$http.defaults.headers.post["Content-Type"] = "applcation/json";
	
	$rootScope.$on("$stateChangeStart", function(event, toState, toParams, fromState, fromParams){
		 
		    if (toState.authenticate){
			     var promise = loginService.isLogin();
		    	 promise.then(function(data) {
//					 $window.location = "index.jsp";
				 }, function(message) {
					 $state.transitionTo("login");
//					 $window.location = "login.jsp";
					 event.preventDefault();
				 });
//		      $state.transitionTo("/");
		    }
		  });
});
