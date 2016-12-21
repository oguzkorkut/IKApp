'use strict';
app.factory("toastFactory", function($mdDialog) {
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
	 
	 return {
		 openDialog : openDialog
	 }
});