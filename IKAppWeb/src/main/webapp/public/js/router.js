
app.config(function($stateProvider,$urlRouterProvider){
	
	$urlRouterProvider.otherwise('/');
	
	
	$stateProvider 
		.state('/',{
			url:'/',
			templateUrl:'public/template/home.html',
			controller:'MainController'
		})
		.state('/applications',{
			url:'/applications',
			templateUrl:'public/template/applications.html',
			controller:'ApplicationController'
		})
		.state('profil',{
			url:'/profil',
			templateUrl:'public/template/profile.html',
			controller:'ProfileController'
		})
		.state('ayarlar',{
			url:'/ayarlar',
			templateUrl:'public/template/settings.html',
			controller:'SettingsController'
		});
		
	
});