/**
 * Uyarı mesajları
 */
app.controller("toastController", function($scope, $mdToast, $mdDialog) {
	
	var isDialogToastOpen = false;
	$scope.alertMessage = "";
	
//	$scope.$on('isDialogToastOpen', function (event, value,message) {
//		isDialogToastOpen = value;
//		alertMessage = message;
//	});
	
	$scope.closeToast = function() {
//        if (isDialogToastOpen) return;

        $mdToast
          .hide()
          .then(function() {
        	  isDialogToastOpen = false;
          });
      };
	
});