app.controller('RegistrationController', function ($scope, $mdToast, $mdDialog,constantService,userService) {

	 $scope.user = {};
//	 $scope.genderList = ('Erkek Kadın').split(' ').map(function(value) {
//			        return {value: value};
//			      });
//	 
	 $scope.educationLevel = constantService.getEducationLevelList();
	 
	 $scope.gradingSystem = constantService.getGradingSystemList();
	 
	 
	 $scope.save=function(e,userModel){
		 
		 var isValid = true;
		 
		 if (!$scope.registrationForm.registrationFormPersonal.$valid) {
			  openDialog(e, 'Kişisel bilgilerde eksik veya hatalı alanlar var.');
			  isValid = false;
		 }else if (!$scope.registrationForm.registrationFormAddress.$valid) {
			 openDialog(e, 'İletişim adresini giriniz.');
			  isValid = false;
		 }
		 
		 if (isValid) {
			 
			 var promise = userService.save(userModel);
			 
			 promise.then(function(data) {
					console.log("success");
			 }, function(message) {
				 console.log("error")
			 });
		}
//		 else if (!$scope.registrationForm.registrationFormEducation.$valid) {
//			 openDialog(e, 'Eğitim bilgilerinizi giriniz.');
//			  isValid = false;
//		 }
//		 else if (!$scope.registrationForm.registrationFormLanguage.$valid) {
//			 openDialog(e, 'Yabancı dil bilgilerini giriniz');
//			  isValid = false;
//		 }
//		 else if (!$scope.registrationForm.registrationFormExperience.$valid) {
//			 openDialog(e, 'Kişisel bilgilerde eksik veya hatalı alanlar var.');
//			  isValid = false;
//		 }
//		 else if (!$scope.registrationForm.registrationFormCertificate.$valid) {
//			 openDialog(e, 'Kişisel bilgilerde eksik veya hatalı alanlar var.');
//			  isValid = false;
//		 }
//		 else if (!$scope.registrationForm.registrationFormReference.$valid) {
//			 openDialog(e, 'Kişisel bilgilerde eksik veya hatalı alanlar var.');
//			  isValid = false;
//		 }
		 
	 };
	 
	 function openDialog(e,message){
			 $mdDialog
	          .show($mdDialog
	            .alert()
	            .title('Hata')
	            .textContent(message)
	            .ariaLabel('More info')
	            .ok('Kapat')
	            .targetEvent(e)
	          )
	          .then(function() {
	        	  
	          });
	 };
});

