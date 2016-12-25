app.factory("cacheService", function($cookies) {
	
	function setCookieByUserModel(userModel) {
		$cookies.putObject("userModel", userModel);
	}
	
	function getUserModelByCookie() {
		var userModel  = $cookies.getObject("userModel");
		return userModel;
	}
	
	function clearUserModelByCookie(){
		 $cookies.remove("userModel");
	}
	
	return{
		setCookieByUserModel:setCookieByUserModel,
		getUserModelByCookie:getUserModelByCookie,
		clearUserModelByCookie:clearUserModelByCookie
	}
})