app.factory("constantService", function() {
	
	function getEducationLevelList() {
		var educationLevelList = [
			 {code:'0',value:'Lise'},
			 {code:'1',value:'Lisans'},
			 {code:'2',value:'Yüksek Lisans'},
			 {code:'3',value:'Doktora'},
			
			 ];
		return educationLevelList;
	};
	
	function getGradingSystemList() {
		var  gradingSystemList=[
			 {code:'0',value:'4'},
			 {code:'1',value:'5'},
			 {code:'2',value:'10'},
			 {code:'3',value:'100'},
		 ];
		
		return gradingSystemList;
	};
	
	
	return {
		getEducationLevelList:getEducationLevelList,
		getGradingSystemList :getGradingSystemList
	}
});


	 
	