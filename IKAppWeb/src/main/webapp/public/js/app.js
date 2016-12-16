var app = angular.module('app',['ui.router','ngMaterial','ngResource','ngAnimate', 'ngSanitize', 'ui.bootstrap','ngMessages','material.svgAssetsCache']);

app.run(function($rootScope,$state,$http){
	$rootScope.$state = $state;
	
	$http.defaults.headers.common.Accept="applcation/json";
});
