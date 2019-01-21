<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" ng-app="confUsuarios">
  <%@include file="../layout/header.jsp"%>

  <body class="login" >
    <div ng-controller="usuarioController">
        <div class="login_wrapper">

        <section class="login_content">
            <form>
              <h1>Cambiar contraseña</h1>
              <div>
                <input type="text" class="form-control" placeholder="usuario" required="" ng-model="usuarioPassword.ssoId" />
              </div>
              <div>
                <input type="password" class="form-control" placeholder="Old Password" required="" ng-model="usuarioPassword.password"/>
              </div>
              <div>
                <input type="password" class="form-control" placeholder="New Password" required="" ng-model="usuarioPassword.passwordNuevo"/>
              </div>
              
              <div>
                    <input type="submit" class="form-control btn btn-block btn-primary btn-default" 
                           style="margin-left: 0 !important" value="Submit" ng-click="cambiarPassword(usuarioPassword)">
              </div>
<!--              <div>
                <a class="btn btn-default submit" href="index.html">Submit</a>
              </div>-->

              <div class="clearfix"></div>

              <div class="separator">
              </div>
              
            </form>
            </section>
            </div>
    </div>
              
    <%--<%@include file="../layout/footer.jsp"%>--%>
    <script src="resources/angularjs/angular.js"></script>
	<script src="resources/angularjs/home.js"></script>
    <script src="resources/angularjs/confUsuarios.js"></script>
    <!-- close container body and main container -->

  </body>
</html>
