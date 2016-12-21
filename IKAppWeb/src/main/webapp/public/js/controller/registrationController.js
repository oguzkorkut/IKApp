app.controller('RegistrationController', function ($scope, $mdToast, $mdDialog,constantService,userService) {

	 $scope.user = {
	 };
//	 $scope.genderList = ('Erkek Kadın').split(' ').map(function(value) {
//			        return {value: value};
//			      });
//	 
	 $scope.educationLevel = constantService.getEducationLevelList();
	 
	 $scope.gradingSystem = constantService.getGradingSystemList();
	 
	 
	 //formlar
	 $scope.education ={}
	 $scope.language ={}
	 $scope.experience ={}
	 $scope.certificate ={}
	 $scope.reference ={}
	 
	 $scope.save= function(e){
		 
		 var isValid = true;
		 
		 if (!$scope.registrationForm.registrationFormPersonal.$valid) {
			  openDialog(e, 'Hata','Kişisel bilgilerde eksik veya hatalı alanlar var.');
			  isValid = false;
		 }else if (!$scope.registrationForm.registrationFormAddress.$valid) {
			 openDialog(e, 'Hata','İletişim adresini giriniz.');
			  isValid = false;
		 }
		 
		 if (isValid) {
			 
			 var promise = userService.save($scope.user);
			 
			 promise.then(function(data) {
					console.log("success");
					openDialog(e, 'Bilgi','Bilgileriniz anımıştır. Süreci login olarak takip edebilirsiniz.');
			 }, function(message) {
				 console.log("error")
			 });
		}
	 };
	 
	 
	 $scope.saveEducation=function(){
		 
		 if ($scope.registrationForm.registrationFormEducation.$valid) {
			 
			 if(typeof ($scope.user.educationDtos) == 'undefined'){
				 $scope.user["educationDtos"]=[];
			 }
			
			 
			 $scope.user.educationDtos.push($scope.education);
			 $scope.education = {}
			 $scope.registrationForm.registrationFormEducation.$setPristine();
		 }else{
			 openDialog(this, 'Hata','Eğitim bilgileri eksik. Bilgileri kontrol ediniz.');
		 }
		 
	 }
	 
	 $scope.removeEducation = function($index,education){
		 if(typeof ($scope.user.educationDtos) != 'undefined'){
			 $scope.user.educationDtos.splice($index, 1); 
		 }
	 }
	 
	 $scope.saveLanguage=function(){
		 
		 if ($scope.registrationForm.registrationFormLanguage.$valid) {
			 if(typeof ($scope.user.languageDtos) == 'undefined'){
				 $scope.user["languageDtos"]=[];
			 }
			 
			 $scope.user.languageDtos.push($scope.language);
			 $scope.language = {};
			 $scope.registrationForm.registrationFormLanguage.$setPristine();
		 }else{
			 openDialog(this, 'Hata','Dil bilgileri eksik. Bilgileri kontrol ediniz.');
		 }
		 
	 }
	 
	 $scope.removeLanguage = function($index,language){
		 if(typeof ($scope.user.languageDtos) != 'undefined'){
			 $scope.user.languageDtos.splice($index, 1); 
		 }
	 }
	 
	 $scope.saveExperience=function(){
		 
		 if ($scope.registrationForm.registrationFormExperience.$valid) {
			 if(typeof ($scope.user.experienceDtos) == 'undefined'){
				 $scope.user["experienceDtos"]=[];
			 }
			 
			 $scope.user.experienceDtos.push($scope.experience);
			 $scope.experience = {};
			 $scope.registrationForm.registrationFormExperience.$setPristine();
		 }else{
			 openDialog(this, 'Hata','İş deneyimleri eksik. Bilgileri kontrol ediniz.');
		 }
	 }
	 
	 $scope.removeExperience = function($index,experience){
		 if(typeof ($scope.user.experienceDtos) != 'undefined'){
			 $scope.user.experienceDtos.splice($index, 1); 
		 }
	 }
	 
	 $scope.saveCertificate=function(){
		 
		 if ($scope.registrationForm.registrationFormCertificate.$valid) {
			 if(typeof ($scope.user.certificateDtos) == 'undefined'){
				 $scope.user["certificateDtos"]=[];
			 }
			 
			 $scope.user.certificateDtos.push($scope.certificate);
			 $scope.certificate = {};
			 $scope.registrationForm.registrationFormCertificate.$setPristine();
		 }else{
			 openDialog(this, 'Hata','Sertifika bilgileri eksik. Bilgileri kontrol ediniz.');
		 }
	 }
	 
	 $scope.removeCertificate = function($index,certificate){
		 if(typeof ($scope.user.certificateDtos) != 'undefined'){
			 $scope.user.certificateDtos.splice($index, 1); 
		 }
	 }
	 
	 $scope.saveReferance=function(){
		 
		 if ($scope.registrationForm.registrationFormReference.$valid) {
			 if(typeof ($scope.user.referenceDtos) == 'undefined'){
				 $scope.user["referenceDtos"]=[];
			 }
			 
			 $scope.user.referenceDtos.push($scope.reference);
			 $scope.reference={};
			 $scope.registrationForm.registrationFormReference.$setPristine();
		 }else{
			 openDialog(this, 'Hata','Referans bilgileri eksiktir. Bilgileri kontrol ediniz.');
		 }
		 
	 }
	 
	 $scope.removeReference = function($index,reference){
		 if(typeof ($scope.user.referenceDtos) != 'undefined'){
			 $scope.user.referenceDtos.splice($index, 1); 
		 }
	 }
	 
	 function openDialog(e,title,message){
			 $mdDialog
	          .show($mdDialog
	            .alert()
	            .title(title)
	            .textContent(message)
	            .ariaLabel('More info')
	            .ok('Kapat')
	            
	          )
	          .then(function() {
	        	  
	          });
	 };
});

