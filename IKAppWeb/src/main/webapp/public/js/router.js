
app.config(function($stateProvider,$urlRouterProvider){
	
	$urlRouterProvider.otherwise('/');
	
	
	$stateProvider 
		.state('/',{
			url:'/',
			templateUrl:'public/template/home.html',
			controller:'MainController'
		})
		.state('/kayit',{
			url:'/kayit',
			templateUrl:'public/template/registration.html',
			controller:'RegistrationController'
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
