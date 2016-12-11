function openDocumentNewWindow(text, status) {
	if($.isNotBlank(text)) {
		var newWindow = window.open(text);
		$(newWindow.location).attr('href',text);
	}	
};

function openDocument(text, status) {
	$(location).attr('href',text);
};

/**
 * usage : $.isBlank(obj)
 * returns true if obj is null, undefined, false, a whitespace character, an empty string
 */
(function($){
	  $.isBlank = function(obj){
	    return (typeof obj === 'undefined' || typeof obj === 'null' || obj !== obj || $.trim(obj) === "");
	  };
})(jQuery);


/**
 * usage : $.isNotBlank(obj)
 * returns true if obj is not null, not undefined, not false, not a whitespace character, not an empty string
 */
(function($){
	  $.isNotBlank = function(obj){
	    return!($.isBlank(obj));
	  };
})(jQuery);

var validateEmail = function($email){
	var emailRegex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	 return emailRegex.test( $email);
};


//ie de gelen date formatini d/m/y,d-m-y gibi date formatina cevrilmesi islemini yapiyor
var mySimpleDateFormatter = function(currentDate){
	
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
				return new Date(dateStr[2],parseInt(dateStr[1],10)-1, dateStr[0]) ;
			}else{
				return new Date(dateStr[0] , parseInt(dateStr[1],10)-1 , dateStr[2]) ;
			}
			
		}else {
			//"25/03/2014"
			var str = dateStr.replace(/(\d{4})\-(\d{2})\-(\d{2})/,'$3/$2/$1').split("T")[0].split("/");
			return new Date(str[2],parseInt(str[1],10) -1,str[0]);
		}
	}else{
		date =currentDate;
	}
	var d = date.getDate(); 
	var m = date.getMonth()+1;//January is 0! 
	var y = date.getFullYear();  
	if(d<10){d='0'+d} 
	if(m<10){m='0'+m} 

	return new Date(y, parseInt(m,10)-1, d);
};



//ie de farkli date formatlarini d/M/y formatinda return ediyor
var myDateFormatter = function(currentDate){
	 
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
};


var parseQueryString = function(url){
	 var objURL = {};

	 url.replace(
	        new RegExp( "([^?=&]+)(=([^&]*))?", "g" ),
	        function( $0, $1, $2, $3 ){
	            objURL[ $1 ] = $3;
	        }
	    );
	    return objURL;
};



var  showToastrFunc = function(shortCutFunction,title, msg) {

    var location = "";
    if ("error" === shortCutFunction) {
    	location = "toast-top-center";
//        location = "toast-top-right";
    } else if ("success" == shortCutFunction) {
        location = "toast-top-center";
    } else if ("info" == shortCutFunction) {
        location = "toast-top-right";
    } else if ("warning" == shortCutFunction) {
        location = "toast-top-right";
    } else {
        location = "toast-top-right";
    }

    toastr.options = {
    	"closeButton": true,
        "closeButton": false,
        "debug": false,
        "newestOnTop": false,
        "progressBar": false,
        "positionClass": location,
        "preventDuplicates": false,
        "onclick": null,
        "showDuration": "30000",
        "hideDuration": "10000",
        "timeOut": "50000",
        "extendedTimeOut": "10000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    }
    
    toastr[shortCutFunction](title, msg);
};