app.factory("ikModalService", function($uibModal) {

	function openModel(size, template, params,targetController) {
		 return $uibModal.open({
	          animation: true,
	          templateUrl: template || 'public/template/partials/model/default.html',
	          controller: targetController,
	          size: size,
	          resolve: {
	            params: function() {
	              return params;
	            }
	          }
	        });
	}
 return {
      openModel:openModel 
    };
});