<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Haber Sitesi</title>

<link href="public/css/bootstrap-3.3.7/bootstrap.css" rel="stylesheet" />
<link href="public/css/bootstrap-3.3.7/bootstrap-responsive.css" rel="stylesheet" />
<link href="public/css/bootstrap-3.3.7/bootstrap-theme.css" rel="stylesheet" />

<link href="public/css/ik.css" rel="stylesheet" />

<!--  <link href="public/css/tempBootsrapt/bootstrap.min.css" rel="stylesheet" />
    <link href="public/css/tempBootsrapt/bootstrap-responsive.min.css" rel="stylesheet" />
    <link href="public/css/tempBootsrapt/customerManagementStyles.css" rel="stylesheet" /> -->
    
<style type="text/css">
.bs-example{
    	margin: 20px;
    }
</style>
</head>
<body ng-app="MainApp"  >

 <div class="bs-example">
	<div id="custom-bootstrap-menu" class="navbar navbar-default navbar-fixed-top bg-faded ikFooter" role="navigation">

	    <div class="container-fluid container">
	        <div class="navbar-header">
	        	<a class="brand" href="#/">
		           <img src="public/images/people.png" alt="logo"> Haber Sitesi
		        </a>
	            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-menubuilder">
	            		<span class="sr-only">Toggle navigation</span>
	            		<span class="icon-bar"></span>
	            		<span class="icon-bar"></span>
	            		<span class="icon-bar"></span>
	            </button>
	        </div>
	        <div class="collapse navbar-collapse navbar-menubuilder" >
	            <ul class="nav navbar-nav navbar-left nav-pills"  data-ng-controller="NavbarController">
	            	<li data-ng-class="{'active':getClass('/applications')}"><a href="#/applications">Uygulamaları Yönet</a></li>
	               	<li data-ng-class="{'active':getClass('/customers')}"><a href="#/ikdetail">Haber Sitesi Ekle</a></li>
	                <li class="dropdown">
	                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">Detay <b class="caret"></b></a>
	                        <ul class="dropdown-menu">
	                            <li><a href="#">Haber Siteleri</a></li>
	                            <li><a href="#">Ülker</a></li>
	                            <li><a href="#">Uygulama Yayınları</a></li>
	                        </ul>
	                    </li>
	            </ul>
	             <ul class="nav navbar-nav navbar-right">
	                    <li class="dropdown">
	                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">Oğuz Korkut <b class="caret"></b></a>
	                        <ul class="dropdown-menu">
	                            <li><a href="#">Profilim</a></li>
	                            <li><a href="#">Ayarlar</a></li>
	                            <li class="divider"></li>
	                            <li><a href="#">Çıkış</a></li>
	                        </ul>
	                    </li>
	                </ul>
	            </div>
	        </div>
	    </div>
</div>
     <div id="footer">
        <div class="navbar navbar-fixed-bottom ikFooter" style="background-image: linear-gradient(to bottom,#fff,#f2f2f2)">
            <div class="navbar-inner">
                <div class="container">
                    <footer>
                        <div class="row">
                            <div class="span4">
                                Created by Oğuz Korkut
                            </div>
                            <div class="span4">
                                Facebook: <a href="https://www.facebook.com/oguzkrkt">@oguzkorkut</a>
                            </div>
                            <div class="span4">
                                Blog: <a href="http://oguzkorkut.com/">oguzkorkut.com</a>
                            </div>
                        </div>
                   </footer>
                </div>
            </div>
        </div>
    </div>



<script type="text/javascript" src="public/js/lib/angular.min.js"></script>
<script type="text/javascript" src="public/js/lib/angular-ui-router-0.3.1.js"></script>
<script type="text/javascript" src="public/js/lib/jquery-3.1.1.min.js"></script>

<script type="text/javascript" src="public/js/lib/bootstrap-3.3.7/bootstrap.js"></script>

<script type="text/javascript" src="public/js/lib/angular-1.5.8/i18n/angular-locale_tr.js"></script>

<script type="text/javascript" src="public/js/app.js"></script>

<!-- Controller -->
	 <script type="text/javascript" src="public/js/controller/controllers.js"></script>
</body>
</html>