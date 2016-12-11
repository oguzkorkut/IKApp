<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <title>Giriş</title>
  <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">  
  <link rel="stylesheet" href="public/css/login.css">  
      
      
</head>

<script type="text/javascript">
	function doOnSubmit() {
	
		if ($.isBlank($('#j_username').val())
				|| $.isBlank($('.j_password').val())) {
	
			showToastrFunc("error","","Kullanıcı adı veya şifre hatalı!");
	
			return false;
		}
		/* $('#j_username').val(encodeURIComponent($('#j_username').val()));
		$('#j_password').val(encodeURIComponent($('.j_password').val())); */
		return true;
	}

</script>
<body>
  <div class="form">      
      <ul class="tab-group">
        <li class="tab active"><a href="#signup">Üye Kayıt</a></li>
        <li class="tab"><a href="#login">Üye Girişi</a></li>
      </ul>      
      <div class="tab-content">
        <div id="signup">   
          
          <form action="/" method="post">
          
          <div class="top-row">
            <div class="field-wrap">
              <label>
                Ad<span class="req">*</span>
              </label>
              <input type="text" required autocomplete="off" />
            </div>
        
            <div class="field-wrap">
              <label>
                Soyad<span class="req">*</span>
              </label>
              <input type="text"required autocomplete="off"/>
            </div>
          </div>

          <div class="field-wrap">
            <label>
              Email <span class="req">*</span>
            </label>
            <input type="email"required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Şifre <span class="req">*</span>
            </label>
            <input type="password"required autocomplete="off"/>
          </div>
		  
		  <div class="field-wrap">
            <label>
              Şifre Tekrar<span class="req">*</span>
            </label>
            <input type="password"required autocomplete="off"/>
          </div>		  
          
	          <button type="submit" id="registerBtn" class="button button-block registerBtn">ÜYE OL</button>
          </form>

        </div>
        
        <div id="login">   
          <h1>Hoşgeldiniz</h1>
          
          <form  method="POST" action="<%=request.getContextPath()%>/giris" onSubmit="return doOnSubmit()">
          
            <div class="field-wrap">
            <label>
              Email <span class="req">*</span>
            </label>
            <input type="email" class="j_username" id="j_username" required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Şifre <span class="req">*</span>
            </label>
            <input type="password" class="j_password" id="j_password" required autocomplete="off"/>
          </div>		  
          
          <p class="forgot"><a href="#">Şifremi Unuttum?</a></p>
          
          <button type="submit" id="loginBtn" class="button button-block loginBtn">GİRİŞ YAP</button>
          
          </form>

        </div>
        
      </div><!-- tab-content -->
      
</div> <!-- /form -->
  	
<!-- <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script> -->
  <script src="public/js/lib/jquery-3.1.1.min.js"></script>
  <script src="public/js/lib/toastr/toastr.js"></script>
  <script src="public/js/lib/login.js"></script>
  <script src="public/js/lib/appUtils.js"></script>
  
</body>
</html>
