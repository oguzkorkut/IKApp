'use strict';
app.config(function($stateProvider,$urlRouterProvider){
	
	$urlRouterProvider.otherwise('/');
	
	
	$stateProvider 
		.state('/',{
			url:'/',
			templateUrl:'public/template/home.html',
			controller:'MainController',
		    	authenticate: false
		})
		.state('login',{
			url:'/login',
			templateUrl:'public/template/login.html',
			controller:'RedirectloginController',
		    	authenticate: false
		})
		.state('kayit',{
			url:'/kayit',
			templateUrl:'public/template/registration.html',
			controller:'RegistrationController',
		    	authenticate: false
		})
		.state('profil',{
			url:'/profil',
			templateUrl:'public/template/profile.html',
			controller:'ProfileController',
		    	authenticate: true
		})
		.state('ayarlar',{
			url:'/ayarlar',
			templateUrl:'public/template/settings.html',
			controller:'SettingsController',
		    	authenticate: true
		});
		
	
//	 $urlRouterProvider.otherwise(function($injector,$location) {
////		 window.location.href = 'login.jsp';
////		 $state.go('accessdenied');
//	 });
	

	 
});
