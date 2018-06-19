<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" ng-app="confUmbrales">
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
							Configuraci�n de umbrales<small></small>
						</h2>
						<div class="clearfix"></div>
					</div>

					<div class="x_content" ng-controller="umbralController">

						<div class="table-responsive">
							<table class="table table-striped table-bordered bulk_action">
								<thead>
									<tr class="headings">

										<th class="column-title">Nombre de la Variable</th>
										<th class="column-title">Fecha Ultima Modificaci�n</th>
										<th class="column-title">Valor M�nimo</th>
										<th class="column-title">Valor M�ximo</th>
										<th class="column-title">Unidad Medida</th>
										<th class="column-title">Criticidad</th>
										<th class="column-title">Activar Alertas</th>
										<th class="column-title no-link last"><span class="nobr">Acci�n</span>
										</th>
									</tr>
								</thead>

								<tbody>
									<tr class="even pointer" ng-repeat="umbral in umbrales">
										<td class=" ">{{
											getHumanRedableName(umbral.nombreVariable) }}</td>
										<td class=" ">{{umbral.ultimaModificacion}}</td>
										<td><span ng-hide="umbral.editMode">{{umbral.valorMin}}</span>
											<input numbers-only type="text" name="valorMin"
											ng-show="umbral.editMode" class="form-control"
											ng-model="umbral.valorMin" placeholder="Valor M�nimo"
											required="" /></td>
										<td><span ng-hide="umbral.editMode">{{umbral.valorMax}}</span>
											<input numbers-only type="text" name="valorMax"
											ng-show="umbral.editMode" class="form-control"
											ng-model="umbral.valorMax" placeholder="Valor M�ximo"
											required="" /></td>
										<td><span ng-hide="umbral.editMode">{{umbral.unidadMedida.nombre}}</span>
											<select ng-show="umbral.editMode" ng-model="umbral.unidadMedida"
												ng-options="um.nombre for um in medidas track by um.id">
										</select></td>
										<td><span ng-hide="umbral.editMode">{{umbral.criticidad.prioridad}}</span>
											<select ng-show="umbral.editMode" ng-model="umbral.criticidad"
												ng-options="crit.prioridad for crit in criticidades track by crit.id">
										</select></td>
										<td class="a-center"><input ng-hide="umbral.editMode"
											type="checkbox" disabled="disabled" class="flat"
											ng-checked="umbral.activo"> <input type="checkbox"
											ng-show="umbral.editMode" class="flat"
											ng-checked="umbral.activo" ng-model="umbral.activo">
										</td>
										<td class="last"><a href="" ng-hide="umbral.editMode"
											ng-click="editUmbral(umbral)">Editar</a> <a href=""
											ng-show="umbral.editMode"
											ng-click="updateUmbral(umbral)">Guardar</a>
											<a href="" ng-show="umbral.editMode"
											ng-click="cancel(umbral)">Cancelar</a></td>

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
<script src="resources/angularjs/confUmbrales.js"></script>
<!-- close container body and main container -->
</div>
</div>
</body>
</html>