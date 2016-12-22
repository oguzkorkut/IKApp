<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="custom-bootstrap-menu" class="navbar navbar-default navbar-fixed-top bg-faded ikFooter" style="position: inherit;margin-bottom:0px;" role="navigation" ng-show="!getClass('/login')" >
	
    <div class="container-fluid container">
        <div class="navbar-header">
        	<a class="brand" href="#/">
	           <img src="public/images/people.png" > Test	
	        </a>
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-menubuilder">
            		<span class="sr-only">İK</span>
            		<span class="icon-bar"></span>
            		<span class="icon-bar"></span>
            		<span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse navbar-menubuilder" >
            <!-- <ul class="nav navbar-nav navbar-left nav-pills" >
            	<li ng-class="{'active':getClass('/applications')}"><a href="#/applications">Test1</a></li>
               	
                <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle">Test2<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#kariyer">Test2-1</a></li>
                    </ul>
				</li>
            </ul> -->
            <!-- <li ng-class="{'active':getClass('/customers')}"><a href="#/ikdetail">Haber Sitesi Ekle</a></li> -->
            
           	<ul class="nav navbar-nav navbar-right" >
	            <li ng-class="{'active':getClass('/kayit')}"><a href="#kayit">Kayıt Ol</a></li>
	            <li class="divider"></li>
	            <li><a href="#login">Giriş Yap</a></li>
             </ul>
             
         	<!-- <ul class="nav navbar-nav navbar-right" ng-show="false">
               <li class="dropdown">
                   <a href="#" data-toggle="dropdown" class="dropdown-toggle">OÃ„Å¸uz Korkut <b class="caret"></b></a>
                   <ul class="dropdown-menu">
                       <li><a href="#">Profil</a></li>
                       <li><a href="#">Ayarlar</a></li>
                       <li class="divider"></li>
                       <li><a href="#">ÃƒÆ’Ã¢â‚¬Â¡Ãƒâ€žÃ‚Â±kÃƒâ€žÃ‚Â±Ãƒâ€¦Ã…Â¸</a></li>
                   </ul>
               </li>
           	</ul>  -->
            </div>
        </div>
    </div>
