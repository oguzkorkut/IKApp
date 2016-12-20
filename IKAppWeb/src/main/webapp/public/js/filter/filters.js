app.filter('EducationLevelFilter', function () {
  return function (index) {
	  
	  	if (index == 0) {
	  		return "Lise";
		} else  if (index == 1) {
			return "Lisans";
		}else  if (index == 2) {
			return "Yüksek Lisans";
		}else  if (index == 3) {
			return "Doktora";
		}
	  
	  return "";
  };
});


app.filter("GradeSystemFilter", function() {
	return function (index) {
		
	  	if (index == 4) {
	  		return "4'lük sistem";
		} else  if (index == 5) {
			return "5'lik sistem";
		}else  if (index == 10) {
			return "10'luk sistem";
		}else  if (index == 100) {
			return "100'luk sistem";
		}
	  
	  return "";
	}
});

app.filter("RWSLevelFilter", function() {
	return function (index) {
		
	  	if (index == 0) {
	  		return "Başlangıç";
		} else  if (index == 1) {
			return "Orta";
		}else  if (index == 2) {
			return "İyi";
		}
	  
	  return "";
	}
});



