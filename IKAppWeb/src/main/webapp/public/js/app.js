var app = angular.module('app',['ui.router','ngMaterial','ngResource','ngAnimate']);

app.run(function($rootScope,$state,$http){
	$rootScope.$state = $state;
	
	$http.defaults.headers.common.Accept="applcation/json";
});
