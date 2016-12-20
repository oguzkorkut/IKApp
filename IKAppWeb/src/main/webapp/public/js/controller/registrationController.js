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
			 }, function(message) {
				 console.log("error")
			 });
		}
	 };
	 
	 
	 $scope.saveEducation=function(){
		 
		 if ($scope.registrationForm.registrationFormEducation.$valid) {
			 
			 var index;
			 if(typeof ($scope.user.educationDtos) == 'undefined'){
				 $scope.user["educationDtos"]=[];
				 $scope.education['index'] = 0;
			 }else{
				 $scope.education['index'] = $scope.user.educationDtos[$scope.user.educationDtos.length -1 ].index + 1;
			 }
			
			 
			 $scope.user.educationDtos.push($scope.education);
			 $scope.education = {}
			 $scope.registrationForm.registrationFormEducation.$setPristine();
		 }else{
			 openDialog(this, 'Hata','Eğitim bilgileri eksik. Bilgileri kontrol ediniz.');
		 }
		 
	 }
	 
	 $scope.removeEducation = function(education){
		 if(typeof ($scope.user.educationDtos) != 'undefined'){
			 $scope.user.educationDtos.splice(education.index, 1); 
		 }
	 }
	 
	 $scope.saveLanguage=function(){
		 
		 if ($scope.registrationForm.registrationFormLanguage.$valid) {
			 if(typeof ($scope.user.languageDtos) == 'undefined'){
				 $scope.user["languageDtos"]=[];
				 $scope.language['index'] = 0;
			 }else{
				 $scope.language['index'] = $scope.user.languageDtos[$scope.user.languageDtos.length -1 ].index + 1;
			 }
			 
			 $scope.user.languageDtos.push($scope.language);
			 $scope.language = {};
			 $scope.registrationForm.registrationFormLanguage.$setPristine();
		 }else{
			 openDialog(this, 'Hata','Dil bilgileri eksik. Bilgileri kontrol ediniz.');
		 }
		 
	 }
	 
	 $scope.removeLanguage = function(language){
		 if(typeof ($scope.user.languageDtos) != 'undefined'){
			 $scope.user.languageDtos.splice(language.index, 1); 
		 }
	 }
	 
	 $scope.saveExperience=function(){
		 
		 if ($scope.registrationForm.registrationFormExperience.$valid) {
			 if(typeof ($scope.user.experienceDtos) == 'undefined'){
				 $scope.user["experienceDtos"]=[];
				 $scope.experience['index'] = 0;
			 }else{
				 $scope.experience['index'] = $scope.user.experienceDtos[$scope.user.experienceDtos.length -1 ].index + 1;
			 }
			 
			 $scope.user.experienceDtos.push($scope.experience);
			 $scope.experience = {};
			 $scope.registrationForm.registrationFormExperience.$setPristine();
		 }else{
			 openDialog(this, 'Hata','İş deneyimleri eksik. Bilgileri kontrol ediniz.');
		 }
	 }
	 
	 $scope.removeExperience = function(experience){
		 if(typeof ($scope.user.experienceDtos) != 'undefined'){
			 $scope.user.experienceDtos.splice(experience.index, 1); 
		 }
	 }
	 
	 $scope.saveCertificate=function(){
		 
		 if ($scope.registrationForm.registrationFormCertificate.$valid) {
			 if(typeof ($scope.user.certificateDtos) == 'undefined'){
				 $scope.user["certificateDtos"]=[];
				 $scope.certificate['index'] = 0;
			 }else{
				 $scope.certificate['index'] = $scope.user.certificateDtos[$scope.user.certificateDtos.length -1 ].index + 1;
			 }
			 
			 $scope.user.certificateDtos.push($scope.certificate);
			 $scope.certificate = {};
			 $scope.registrationForm.registrationFormCertificate.$setPristine();
		 }else{
			 openDialog(this, 'Hata','Sertifika bilgileri eksik. Bilgileri kontrol ediniz.');
		 }
	 }
	 
	 $scope.removeCertificate = function(certificate){
		 if(typeof ($scope.user.certificateDtos) != 'undefined'){
			 $scope.user.certificateDtos.splice(certificate.index, 1); 
		 }
	 }
	 
	 $scope.saveReferance=function(){
		 
		 if ($scope.registrationForm.registrationFormReference.$valid) {
			 if(typeof ($scope.user.referenceDtos) == 'undefined'){
				 $scope.user["referenceDtos"]=[];
				 $scope.reference['index'] = 0;
			 }else{
				 $scope.reference['index'] = $scope.user.referenceDtos[$scope.user.referenceDtos.length -1 ].index + 1;
			 }
			 
			 $scope.user.referenceDtos.push($scope.reference);
			 $scope.reference={};
			 $scope.registrationForm.registrationFormReference.$setPristine();
		 }else{
			 openDialog(this, 'Hata','Referans bilgileri eksiktir. Bilgileri kontrol ediniz.');
		 }
		 
	 }
	 
	 $scope.removeReference = function(reference){
		 if(typeof ($scope.user.referenceDtos) != 'undefined'){
			 $scope.user.referenceDtos.splice(reference.index, 1); 
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

