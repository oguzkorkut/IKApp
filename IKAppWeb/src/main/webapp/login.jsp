<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>Giriş</title>
		
		<link href="public/css/bootstrap-3.3.7/bootstrap.css" rel="stylesheet" />
		<link rel="stylesheet" href="public/css/login2.css">
		<link rel="stylesheet" type="text/css" href="public/css/font-awesome-4.2.0.css" />
		<!-- http://localhost:8090/appik/public/css/fonts/fontawesome-webfont.woff?v=4.2.0 --> 
		
		<script data-main="public/js/Main" src="public/js/lib/jquery-3.1.1.min.js"></script>
		<script data-main="public/js/Main" src="public/js/lib/jquery.cookie-1.4.1.js"></script>
		<script data-main="public/js/Main" src="public/js/lib/login.js"></script>
		<script data-main="public/js/Main" src="public/js/lib/appUtils.js"></script>
			
		<script type="text/javascript">
			function doOnSubmit() {
			
				if ($.isBlank($('#j_username').val())
						|| $.isBlank($('#j_password').val())) {
			
					showToastrFunc("error","","Kullanıcı adı veya şifre hatalı!");
			
					return false;
				}
				/* $('#j_username').val(encodeURIComponent($('#j_username').val()));
				$('#j_password').val(encodeURIComponent($('.j_password').val())); */
				return true;
			}
		
		</script>
	</head>

	<body>
		<div id="mainWrapper">
			<div class="login-container">
				<div class="login-card">
					<div class="login-form">
						<form  method="POST"  action="<%=request.getContextPath()%>/giris" class="form-horizontal" onSubmit="return doOnSubmit()">
							  <%
								if (request.getAttribute("errorCode") != null) {
									String errorCode = request.getAttribute("errorCode").toString();
									String message = request.getAttribute("errorMessage") == null
											? "Hata"
											: request.getAttribute("errorMessage").toString();
								%>
									<%-- <script type="text/javascript">
								     showErrorMessage('','<%=errorCode%>');
									</script> --%>
									<div class="alert alert-danger">
										<p>Kullanıcı adı veya şifre hatalı</p>
									</div>
								<%
									}
								%>
								<div class="input-group input-sm">
									<label class="input-group-addon" for="j_username"><i class="fa fa-user"></i></label>
									<input type="text" class="form-control" id="j_username" name="j_username" placeholder="E-Posta" required autocomplete="off">
								</div>
								<div class="input-group input-sm">
									<label class="input-group-addon" for="j_password"><i class="fa fa-lock"></i></label> 
									<input type="password" class="form-control" id="j_password" name="j_password" placeholder="Şifre" required autocomplete="off">
								</div>
								<!-- <div class="input-group input-sm">
	                              <input type="button"
										class="btn btn-block btn-primary btn-default" value="Şifremi Unuttum">
	                            </div> -->
								<div class="form-actions">
									<!-- <input type="submit"
										class="btn btn-block btn-primary btn-default" value="Log in"> -->
									<div class="input-group input-sm">
										<button type="submit" id="loginBtn" class="btn btn-primary login-btn loginBtn">GİRİŞ YAP</button>
										<button type="button" class="btn btn-primary login-btn registrationBtn">KAYIT OL</button>
												&nbsp;<a id='loginForgotPassword' href="<%=request.getContextPath()%>/#sifremiUnuttum" class="user-link">Şifremi Unuttum</a>
		                          	</div>
	                          	
								</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>