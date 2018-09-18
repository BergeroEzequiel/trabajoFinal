<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" ng-app="confAlertas">
<%@include file="../layout/template.jsp"%>

<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">

			<div class="clearfix"></div>

			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>
							Configuración de alertas<small></small>
						</h2>
						<div class="clearfix"></div>
					</div>

					<div class="x_content" ng-controller="criticidadController">

						<div class="table-responsive">
							<table class="table table-striped table-bordered bulk_action">
								<thead>
									<tr class="headings">

										<th class="column-title">Prioridad</th>
										<th class="column-title">Período de tiempo</th>
										<th class="column-title">Cantidad de repeticiones</th>
										<th class="column-title no-link last"><span class="nobr">Acción</span>
										</th>
									</tr>
								</thead>

								<tbody>
									<tr class="even pointer" ng-repeat="criticidad in criticidades">
										<td class=" ">{{criticidad.prioridad}}</td>
										<td class=" ">{{criticidad.periodoTiempo}}</td>
										<td><span ng-hide="criticidad.editMode">{{criticidad.cantidadRepeticiones}}</span>
											<input numbers-only type="text" name="cantRepeticiones"
											ng-show="criticidad.editMode" class="form-control"
											ng-model="criticidad.cantidadRepeticiones" placeholder=""
											required="" /></td>
										<td class="last"><a href="" ng-hide="criticidad.editMode"
											ng-click="editCriticidad(criticidad)">Editar</a> <a href=""
											ng-show="criticidad.editMode"
											ng-click="updateCriticidad(criticidad)">Guardar</a>
											<a href="" ng-show="criticidad.editMode"
											ng-click="cancel(criticidad)">Cancelar</a></td>

									</tr>
								</tbody>
							</table>
						</div>


					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->

<%@include file="../layout/footer.jsp"%>
<script src="resources/angularjs/confAlertas.js"></script>
	<!-- close container body and main container -->
	</div> 
</div>
</body>
</html>