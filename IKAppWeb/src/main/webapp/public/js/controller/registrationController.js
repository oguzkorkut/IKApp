app.controller('RegistrationController', function ($scope) {

	 $scope.user = {};
	 
	 $scope.genderList = ('Erkek Kadın').split(' ').map(function(value) {
			        return {value: value};
			      });
	 
//	 	 id;
//		 beginDate;
//		 department;
//		 educationLevel;
//		 endDate;
//		 grade;
//		 gradeSystem;
//		 phoneNumber;
//		 schoolName;

	 $scope.educationLevel = [
		 {code:'0',value:'Lise'},
		 {code:'1',value:'Lisans'},
		 {code:'2',value:'Yüksek Lisans'},
		 {code:'3',value:'Doktora'},
		
		 ];
	 
	 $scope.gradingSystem=[
		 {code:'0',value:'4'},
		 {code:'1',value:'5'},
		 {code:'2',value:'10'},
		 {code:'3',value:'100'},
	 ]
			  
});

