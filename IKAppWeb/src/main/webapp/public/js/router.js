'use strict';
app.config(function($stateProvider,$urlRouterProvider){
	
	$urlRouterProvider.otherwise('/');
	
	
	$stateProvider 
		.state('/',{
			url:'/',
			templateUrl:'public/template/home.html',
			controller:'mainController',
		    authenticate: false
		})
		.state('login',{
			url:'/login',
			templateUrl:'public/template/login.html',
			controller:'loginController',
		    authenticate: false
		})
		.state('/kayit',{
			url:'/kayit',
			templateUrl:'public/template/registration.html',
			controller:'registrationController',
		    authenticate: false
		})
		.state('profil',{
			url:'/profil',
			templateUrl:'public/template/profile.html',
			controller:'profileController',
		    authenticate: true
		})
		.state('ayarlar',{
			url:'/ayarlar',
			templateUrl:'public/template/settings.html',
			controller:'settingsController',
		    authenticate: true
		});
		
	
//	 $urlRouterProvider.otherwise(function($injector,$location) {
////		 window.location.href = 'login.jsp';
////		 $state.go('accessdenied');
//	 });
	

	 
});
