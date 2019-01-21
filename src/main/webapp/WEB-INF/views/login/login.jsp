<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" ng-app="confUsuarios">
  <%@include file="../layout/header.jsp"%>

  <body class="login" >
    <div ng-controller="usuarioController">
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>
      

      <div class="login_wrapper">
          <div  class="animate form login_form">
          <section class="login_content">
             <%--<c:url var="loginUrl" value="/login" />--%>
                <form action="login" method="post" class="form-horizontal">
              <h1>Login Form</h1>
              <div>
                <input type="text" class="form-control" placeholder="Usuario" required="true" name="ssoId" />
              </div>
              <div>
                <input type="password" class="form-control" placeholder="Contraseña" required="true" name="password"/>
              </div>
              <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
              <div>
                    <input type="submit" class="form-control btn btn-block btn-primary btn-default" 
                           style="margin-left: 0 !important" value="Log in">
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">No tienes una cuenta?
                    <a href="#signup" class="to_register"> Crear una cuenta </a>
                </p>
                
                <p class="change_link">Olvidó su contraseña?
                    <a href="cambiar-password" > Cambiar contraseña </a>
                </p>

                <div class="clearfix"></div>
                <br />
              </div>
            </form>
          </section>
        </div>
              
        <div id="register" class="animate form registration_form">
          <section class="login_content">
            <form>
              <h1>Create Account</h1>
              <div>
                <input type="text" class="form-control" placeholder="usuario" required="" ng-model="nuevoUsuario.ssoId" />
              </div>
              <div>
                <input type="text" class="form-control" placeholder="Username" required="" ng-model="nuevoUsuario.firstName" />
              </div>
              <div>
                <input type="text" class="form-control" placeholder="Lastname" required="" ng-model="nuevoUsuario.lastName" />
              </div>
              <div>
                <input type="email" class="form-control" placeholder="Email" required="" ng-model="nuevoUsuario.email" />
              </div>
              <div>
                <input type="password" class="form-control" placeholder="Password" required="" ng-model="nuevoUsuario.password"/>
              </div>
              
              <div>
                    <input type="submit" class="form-control btn btn-block btn-primary btn-default" 
                           style="margin-left: 0 !important" value="Submit" ng-click="crearUsuario(nuevoUsuario)">
              </div>
<!--              <div>
                <a class="btn btn-default submit" href="index.html">Submit</a>
              </div>-->

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">Already a member ?
                    <a href="#signin" class="to_register"> Log in </a>
                </p>

                <div class="clearfix"></div>
                <br />

<!--                <div>
                  <h1><i class="fa fa-paw"></i> Gentelella Alela!</h1>
                  <p>©2016 All Rights Reserved. Gentelella Alela! is a Bootstrap 3 template. Privacy and Terms</p>
                </div>-->
              </div>
            </form>
          </section>
        </div>

      </div>
    </div>
              
    <%--<%@include file="../layout/footer.jsp"%>--%>
    <script src="resources/angularjs/angular.js"></script>
	<script src="resources/angularjs/home.js"></script>
    <script src="resources/angularjs/confUsuarios.js"></script>
    <!-- close container body and main container -->

  </body>
</html>
