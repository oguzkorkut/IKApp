'use strict';
app.config(function($stateProvider,$urlRouterProvider,blockUIConfig){
	
	
	blockUIConfig.message = 'Lütfen bekleyin!..';
	
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
		.state('kayit',{
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
		.state('basvuru',{
			url:'/basvuru',
			templateUrl:'public/template/application.html',
			controller:'applicationController',
		    authenticate: true
		})
		.state('pozisyon',{
			url:'/pozisyon',
			templateUrl:'public/template/position.html',
			controller:'positionController',
		    authenticate: true
		})
		.state('mesaj',{
			url:'/mesaj',
			templateUrl: 'public/template/message.html',
			controller : 'messageController',
			authenticate: true
		})
		.state('kullaniciDetayi',{
			url:'/kullaniciDetayi/:userId',
			templateUrl: 'public/template/userDetail.html',
			controller : 'userDetailController',
			authenticate: true
		})
		.state('ayarlar',{
			url:'/ayarlar',
			templateUrl:'public/template/settings.html',
			controller:'settingsController',
		    authenticate: true
		});
	
	
	
	 //false yapıldigi durumlarda servis cagrilarindan once blockUI.start(); ile baslatilip cagri bittikten sonrada blockUI.stop(); ile durdurulmalidir.
	blockUIConfig.autoBlock = true;
		
	
//	 $urlRouterProvider.otherwise(function($injector,$location) {
////		 window.location.href = 'login.jsp';
////		 $state.go('accessdenied');
//	 });
	

	 
});
