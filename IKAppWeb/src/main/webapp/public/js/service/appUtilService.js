app.factory("Utils", function() {
	return{
		isBlank : function(obj){
			return  !angular.isDefined(obj) || obj===null;
		},
		isNotBlank : function(obj){
			return angular.isDefined(obj) || obj != null ;
		},
		isArray : function(objs) {
			return angular.isArray(objs);
		},
		 openDocumentNewWindow : function(text, status) {
			if(isNotBlank(text)) {
				var newWindow = window.open(text);
				$(newWindow.location).attr('href',text);
			}
		 },
		 openDocument : function(text, status) {
				$(location).attr('href',text);
		 },
		 validateEmail : function($email){
				var emailRegex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
				 return emailRegex.test( $email);
		 },
		 myDateFormatter : function(currentDate){
			 
				if(typeof currentDate == 'undefined'  || currentDate == "&#160;" || currentDate.length < 8){
					return "";
				}
				var dateStr = currentDate ;
				var date;
				if(typeof(currentDate) == 'string') {
					if( dateStr.length<15){
						var index = currentDate.indexOf("/"); 
						if(index == -1){
							dateStr = currentDate.split("-"); 
						}else{
							dateStr = currentDate.split("/"); 
						}
						if(dateStr[2].length == 4 ){
							return dateStr[0] + '/' + dateStr[1] + '/' + dateStr[2] ;
						}else{
							return dateStr[2] + '/' + dateStr[1] + '/' + dateStr[0] ;
						}
						
					}else {
						return dateStr.replace(/(\d{4})\-(\d{2})\-(\d{2})/,'$3/$2/$1').split("T")[0];
					}
				}else{
					date =currentDate;
				}
				
				var d = date.getDate(); 
				var m = date.getMonth()+1;//January is 0! 
				var y = date.getFullYear();  
				if(d<10){d='0'+d} 
				if(m<10){m='0'+m} 

				return d+'/'+m+'/'+y;
			},
			parseQueryString : function(url){
				 var objURL = {};

				 url.replace(
				        new RegExp( "([^?=&]+)(=([^&]*))?", "g" ),
				        function( $0, $1, $2, $3 ){
				            objURL[ $1 ] = $3;
				        }
				    );
				    return objURL;
			}
	}
});