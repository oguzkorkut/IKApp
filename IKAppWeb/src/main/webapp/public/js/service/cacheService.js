app.factory("cacheService", function($cookies) {
	
	function setCookieByUserModel(userModel) {
		$cookies.put("userModel", userModel);
	}
	
	function getUserModelByCookie() {
		var userModel  = $cookies.get("userModel");
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