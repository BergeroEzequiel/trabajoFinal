<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" ng-app="home">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Menhit</title>

    <!-- Bootstrap -->
    <link href="<c:url value="/resources/vendors/bootstrap/dist/css/bootstrap.min.css" />" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<c:url value="/resources/vendors/font-awesome/css/font-awesome.min.css" />" rel="stylesheet">
    <!-- NProgress -->
    <link href="<c:url value="/resources/vendors/nprogress/nprogress.css" />" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="<c:url value="/resources/vendors/bootstrap-daterangepicker/daterangepicker.css" />" rel="stylesheet">
    <!-- iCheck -->
    <link href="<c:url value="/resources/vendors/iCheck/skins/flat/green.css" />" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="<c:url value="/resources/build/css/custom.min.css" />" rel="stylesheet">
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.html" class="site_title"><i class="fa fa-bolt"></i> <span>Menhit</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->

            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="/trabajoFinal">Paneles Solares</a></li>
                      <li><a href="index2.html">Aerogeneradores</a></li>
                      <li><a href="index3.html">Termotanques Solares</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-sitemap"></i> Nodos <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="form.html">Estado Nodo</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-bell-o"></i> Alertas <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                    </ul>
                  </li>
                  <li><a><i class="fa fa-wrench"></i> Mantenimiento <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="tables.html">Tables</a></li>
                      <li><a href="tables_dynamic.html">Table Dynamic</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-bar-chart-o"></i>Históricos<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="chartjs.html">Chart JS</a></li>
                      <li><a href="chartjs2.html">Chart JS2</a></li>
                      <li><a href="morisjs.html">Moris JS</a></li>
                      <li><a href="echarts.html">ECharts</a></li>
                      <li><a href="other_charts.html">Other Charts</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-group"></i>Usuarios<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                    </ul>
                  </li>
                  <li><a><i class="fa fa-cogs"></i>Configuración<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="variables">Variables</a></li>
                      <li><a href="">Alertas</a></li>
                    </ul>
                  </li>
                </ul>
              </div>
              
            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav" ng-controller="userController">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="images/img.jpg" alt="">{{nombre}}
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="javascript:;"> Profile</a></li>
                    <li>
                      <a href="javascript:;">
                        <span class="badge bg-red pull-right">50%</span>
                        <span>Settings</span>
                      </a>
                    </li>
                    <li><a href="javascript:;">Help</a></li>
                    <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                  </ul>
                </li>

                <li role="presentation" class="dropdown">
                  <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                    <i class="fa fa-envelope-o"></i>
                    <span class="badge bg-green">1</span>
                  </a>
                  <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <div class="text-center">
                        <a>
                          <strong>Ver todos los mensajes</strong>
                          <i class="fa fa-angle-right"></i>
                        </a>
                      </div>
                    </li>
                  </ul>
                </li>
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        
        <div class="right_col" role="main" ng-controller="homeController">
          <div class="">
            <div class="row top_tiles">
              <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="tile-stats">
                  <div class="icon"><i class="fa fa-flash"></i></div>
                  <div class="count">{{potenciasTotales.potenciaContinua | number:2}}</div>
                  <h3>Potencia Continua</h3>
                  <p>Lorem ipsum psdea itgum rixt.</p>
                </div>
              </div>
              <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="tile-stats">
                  <div class="icon"><i class="fa fa-feed"></i></div>
                  <div class="count">{{potenciasTotales.potenciaInterna| number:2}}</div>
                  <h3>Potencia Interna</h3>
                  <p>Lorem ipsum psdea itgum rixt.</p>
                </div>
              </div>
              <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="tile-stats">
                  <div class="icon"><i class="fa fa-plug"></i></div>
                  <div class="count">{{potenciasTotales.potenciaRed | number:2}}</div>
                  <h3>Potencia Red</h3>
                  <p>Lorem ipsum psdea itgum rixt.</p>
                </div>
              </div>
              <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="tile-stats">
                  <div class="icon"><i class="fa fa-thermometer"></i></div>
                  <div class="count">29°C</div>
                  <h3>Temperatura</h3>
                  <p>Lorem ipsum psdea itgum rixt.</p>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-md-8">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Seguimiento de la potencia entregada</h2>
                    <div class="filter">
                      <div id="reportrange" class="pull-right" style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
                        <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                        <span>December 30, 2014 - January 28, 2015</span> <b class="caret"></b>
                      </div>
                    </div>
                    <div class="clearfix"></div>
                  </div>

                  <div class="x_content">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                      <div class="demo-container" style="height:280px">
                        <div id="echart_line" style="height:350px;"></div>
                      </div>
                      <div class="tiles">


                      </div>

                    </div>

                    <div class="col-md-3 col-sm-12 col-xs-12">
                      <div>


                      </div>
                    </div>

                  </div>
                </div>
              </div>

              <!-- Alertas -->
              <div class="col-md-4">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Alertas <small>Sessions</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Settings 1</a>
                          </li>
                          <li><a href="#">Settings 2</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content bs-example-popovers" ng-controller="alertasController">
					<div  ng-repeat="alerta in alertas">
                    <div class="alert alert-success alert-dismissible fade in" role="alert">
                      <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">Ã—</span>
                      </button>
                      <strong>{{alerta.descripcion}}</strong> {{alerta.variableAfectada}}
                      <p>Nodo afectado: {{alerta.nodoAfectado}} 
                      Umbral Superado: {{alerta.umbralSuperado}}
                      Valor: {{alerta.valor}}
                      </p>.
                    </div>
                  	</div>
                    

                  </div>
                </div>
              </div>
            </div>



            <div class="row">
              <div class="col-md-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Weekly Summary <small>Activity shares</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Settings 1</a>
                          </li>
                          <li><a href="#">Settings 2</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">

                    <div class="row" style="border-bottom: 1px solid #E0E0E0; padding-bottom: 5px; margin-bottom: 5px;">
                      <div class="col-md-7" style="overflow:hidden;">
                        <span class="sparkline_one" style="height: 160px; padding: 10px 25px;">
                                      <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
                                  </span>
                        <h4 style="margin:18px">Weekly sales progress</h4>
                      </div>

                      <div class="col-md-5">
                        <div class="row" style="text-align: center;">
                          <div class="col-md-4">
                            <canvas class="canvasDoughnut" height="110" width="110" style="margin: 5px 10px 10px 0"></canvas>
                            <h4 style="margin:0">Bounce Rates</h4>
                          </div>
                          <div class="col-md-4">
                            <canvas class="canvasDoughnut" height="110" width="110" style="margin: 5px 10px 10px 0"></canvas>
                            <h4 style="margin:0">New Traffic</h4>
                          </div>
                          <div class="col-md-4">
                            <canvas class="canvasDoughnut" height="110" width="110" style="margin: 5px 10px 10px 0"></canvas>
                            <h4 style="margin:0">Device Share</h4>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

          </div>
        </div>
        <!-- /page content -->

      </div>
    </div>
  </body>


        <!-- footer content -->
        <footer>
          <div class="pull-right">
            Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->

    <!-- jQuery -->
    <script src="<c:url value="/resources/vendors/jquery/dist/jquery.min.js"/>"></script>
    <!-- Bootstrap -->
    <script src="<c:url value="/resources/vendors/bootstrap/dist/js/bootstrap.min.js"/>"></script>
    <!-- FastClick -->
    <script src="<c:url value="/resources/vendors/fastclick/lib/fastclick.js"/>"></script>
    <!-- NProgress -->
    <script src="<c:url value="/resources/vendors/nprogress/nprogress.js"/>"></script>
    <!-- Chart.js -->
    <script src="<c:url value="/resources/vendors/Chart.js/dist/Chart.min.js"/>"></script>
    <!-- jQuery Sparklines -->
    <script src="<c:url value="/resources/vendors/jquery-sparkline/dist/jquery.sparkline.min.js"/>"></script>
    <!-- Flot -->
    <script src="<c:url value="/resources/vendors/Flot/jquery.flot.js"/>"></script>
    <script src="<c:url value="/resources/vendors/Flot/jquery.flot.pie.js"/>"></script>
    <script src="<c:url value="/resources/vendors/Flot/jquery.flot.time.js"/>"></script>
    <script src="<c:url value="/resources/vendors/Flot/jquery.flot.stack.js"/>"></script>
    <script src="<c:url value="/resources/vendors/Flot/jquery.flot.resize.js"/>"></script>
    <!-- Flot plugins -->
    <script src="<c:url value="/resources/vendors/flot.orderbars/js/jquery.flot.orderBars.js"/>"></script>
    <script src="<c:url value="/resources/vendors/flot-spline/js/jquery.flot.spline.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/flot.curvedlines/curvedLines.js"/>"></script>
    <!-- DateJS -->
    <script src="<c:url value="/resources/vendors/DateJS/build/date.js"/>"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="<c:url value="/resources/vendors/moment/min/moment.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/bootstrap-daterangepicker/daterangepicker.js"/>"></script>
    <!-- NProgress -->
    <script src="<c:url value="/resources/vendors/nprogress/nprogress.js"/>"></script>
    <!-- ECharts -->
    <script src="<c:url value="/resources/vendors/echarts/dist/echarts.min.js"/>"></script>
    <!-- iCheck -->
    <script src="<c:url value="/resources/vendors/iCheck/icheck.min.js"/>"></script>

    <!-- Custom Theme Scripts -->
    <script src="<c:url value="/resources/build/js/custom.min.js"/>"></script>
    <script src="resources/angularjs/angular.js"></script>
	<script src="resources/angularjs/home.js"></script>	
  </body>
</html>
