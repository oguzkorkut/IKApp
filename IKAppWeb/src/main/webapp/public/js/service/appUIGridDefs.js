'use strict';
app.factory("appGridColumnDefs", function($q,$http,$window) {
	
	function applicationGrisColumnDef(){
		
		var columDefs =  [
		    { name:'id',displayName:'Sıra', width:50 , enableCellEdit : false},
		    { name:'name', displayName:'Adı',width:100, enableCellEdit : false},
		    { name:'lastname', displayName:'Soyad',width:100 , enableCellEdit : false},
		    { name:'position', displayName:'Başvurulan Pozisyon',width:100 , cellTemplate:"public/template/partials/ui-grid/ui-grid-hyperlink.html"},
		    { name:'cv', displayName:'cv',width:100 , enableCellEdit : false},
		  ];
		
		return columDefs;
	};
	
	
	return {
		applicationGrisColumnDef : applicationGrisColumnDef
	};
});



app.factory("uiGridGridOptions", function() {
	
	var gridOptions = {};
	
	gridOptions["enableCellEditOnFocus"] = false;
	gridOptions["enableColumnResizing"] = true;
	gridOptions["enableFiltering"] = false;
	gridOptions["enableGridMenu"] = true;
	gridOptions["showGridFooter"] = true;
	gridOptions["showColumnFooter"] = true;
	gridOptions["fastWatch"] = false;
	gridOptions["enableRowSelection"] = false;
	gridOptions["multiSelect"]  = false;
	gridOptions["selectWithCheckboxOnly"]= false;
	gridOptions["enableFullRowSelection"]= false;
	
	
	function getDefaultUIGridOptions(dataSetName) {
		gridOptions["data"] = dataSetName;
		
		return gridOptions;
	}
	
	function getUIGridOptions(dataSetName,options){
		gridOptions["data"] = dataSetName;
		
		gridOptions["enableCellEditOnFocus"] = typeof options["enableCellEditOnFocus"] != undefined ? options["enableCellEditOnFocus"] :  false;
		gridOptions["enableColumnResizing"] = typeof options["enableColumnResizing"] != undefined ? options["enableColumnResizing"] :  true;
		gridOptions["enableFiltering"] = typeof options["enableFiltering"] != undefined ? options["enableFiltering"] : false;
		gridOptions["enableGridMenu"] = typeof options["enableGridMenu"] != undefined ? options["enableGridMenu"] :  true;
		gridOptions["showGridFooter"] = typeof options["showGridFooter"] != undefined ? options["showGridFooter"] :  true;
		gridOptions["showColumnFooter"] = typeof options["showColumnFooter"] != undefined ? options["showColumnFooter"] :  true;
		gridOptions["fastWatch"] = typeof options["fastWatch"] != undefined ? options["fastWatch"] :  false;
		gridOptions["enableRowSelection"] = typeof options["enableCellEditOnFocus"] != undefined ? options["enableCellEditOnFocus"] :  false;
		gridOptions["multiSelect"]  = typeof options["multiSelect"] != undefined ? options["multiSelect"] :  false;
		gridOptions["selectWithCheckboxOnly"]= typeof options["selectWithCheckboxOnly"] != undefined ? options["selectWithCheckboxOnly"] :  false;
		gridOptions["enableFullRowSelection"]= typeof options["enableFullRowSelection"] != undefined ? options["enableFullRowSelection"] :  false;
		
		return gridOptions;
	}
	
	return {
		getDefaultUIGridOptions : getDefaultUIGridOptions,
		getUIGridOptions : getUIGridOptions
	}
});
