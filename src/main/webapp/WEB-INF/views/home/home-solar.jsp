<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" ng-app="home">
<%@include file="../layout/template.jsp"%>

<!-- page content -->
<div class="right_col" role="main" ng-controller="homeController">
	<div class="">
		<div class="row top_tiles">
			<div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="tile-stats">
					<div class="icon">
						<i class="fa fa-flash"></i>
					</div>
					<div class="count">{{potenciasTotales.potenciaContinua |
						number:2}}</div>
					<h3>Potencia Continua</h3>
					<p>Lorem ipsum psdea itgum rixt.</p>
				</div>
			</div>
			<div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="tile-stats">
					<div class="icon">
						<i class="fa fa-feed"></i>
					</div>
					<div class="count">{{potenciasTotales.potenciaInterna|
						number:2}}</div>
					<h3>Potencia Interna</h3>
					<p>Lorem ipsum psdea itgum rixt.</p>
				</div>
			</div>
			<div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="tile-stats">
					<div class="icon">
						<i class="fa fa-plug"></i>
					</div>
					<div class="count">{{potenciasTotales.potenciaRed |
						number:2}}</div>
					<h3>Potencia Red</h3>
					<p>Lorem ipsum psdea itgum rixt.</p>
				</div>
			</div>
			<div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="tile-stats">
					<div class="icon">
						<i class="fa fa-thermometer"></i>
					</div>
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
							<div id="reportrange" class="pull-right"
								style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
								<i class="glyphicon glyphicon-calendar fa fa-calendar"></i> <span>December
									30, 2014 - January 28, 2015</span> <b class="caret"></b>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>

					<div class="x_content">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="demo-container" style="height: 280px">
								<div id="echart_line" style="height: 350px;"></div>
							</div>
							<div class="tiles"></div>

						</div>

						<div class="col-md-3 col-sm-12 col-xs-12">
							<div></div>
						</div>

					</div>
				</div>
			</div>

			<!-- Alertas -->
			<div class="col-md-4">
				<div class="x_panel">
					<div class="x_title">
						<h2>
							Alertas <small>Sessions</small>
						</h2>
						<ul class="nav navbar-right panel_toolbox">
							<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
							</li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-expanded="false"><i
									class="fa fa-wrench"></i></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#">Settings 1</a></li>
									<li><a href="#">Settings 2</a></li>
								</ul></li>
							<li><a class="close-link"><i class="fa fa-close"></i></a></li>
						</ul>
						<div class="clearfix"></div>
					</div>
					<div class="x_content bs-example-popovers"
						ng-controller="alertasController">
						<div ng-repeat="alerta in alertas">
							<div class="alert alert-dismissible fade in"
								role="alert"
                                                                ng-class="{
                                                                    'alerta-critica': (alerta.criticidad.prioridad === 'Critica'),
                                                                    'alerta-alta': (alerta.criticidad.prioridad === 'Alta'),
                                                                    'alerta-media': (alerta.criticidad.prioridad === 'Media'),
                                                                    'alerta-baja': (alerta.criticidad.prioridad === 'Baja')
                                                                }">
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									<span aria-hidden="true">Ã—</span>
								</button>
								<strong>{{alerta.descripcion}}</strong>
								{{alerta.variableAfectada}}
								<p>Nodo afectado: {{alerta.nodo.modulo + alerta.nodo.numero}} Criticidad:
									{{alerta.criticidad.prioridad}} Hora: {{alerta.hora}}</p>
								.
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
						<h2>
							Weekly Summary <small>Activity shares</small>
						</h2>
						<ul class="nav navbar-right panel_toolbox">
							<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
							</li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-expanded="false"><i
									class="fa fa-wrench"></i></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#">Settings 1</a></li>
									<li><a href="#">Settings 2</a></li>
								</ul></li>
							<li><a class="close-link"><i class="fa fa-close"></i></a></li>
						</ul>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">

						<div class="row"
							style="border-bottom: 1px solid #E0E0E0; padding-bottom: 5px; margin-bottom: 5px;">
							<div class="col-md-7" style="overflow: hidden;">
								<span class="sparkline_one"
									style="height: 160px; padding: 10px 25px;">
									<canvas width="200" height="60"
										style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
								</span>
								<h4 style="margin: 18px">Weekly sales progress</h4>
							</div>

							<div class="col-md-5">
								<div class="row" style="text-align: center;">
									<div class="col-md-4">
										<canvas class="canvasDoughnut" height="110" width="110"
											style="margin: 5px 10px 10px 0"></canvas>
										<h4 style="margin: 0">Bounce Rates</h4>
									</div>
									<div class="col-md-4">
										<canvas class="canvasDoughnut" height="110" width="110"
											style="margin: 5px 10px 10px 0"></canvas>
										<h4 style="margin: 0">New Traffic</h4>
									</div>
									<div class="col-md-4">
										<canvas class="canvasDoughnut" height="110" width="110"
											style="margin: 5px 10px 10px 0"></canvas>
										<h4 style="margin: 0">Device Share</h4>
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

<%@include file="../layout/footer.jsp"%>
<script src="resources/angularjs/home.js"></script>
	<!-- close container body and main container -->
	</div>
</div>
</body>
</html>