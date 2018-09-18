<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" ng-app="confNodos">
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

					<div class="x_content" ng-controller="nodosController">

						<div class="table-responsive">
							<table class="table table-striped table-bordered bulk_action">
								<thead>
									<tr class="headings">

										<th class="column-title">Módulo</th>
										<th class="column-title">Número</th>
										<th class="column-title">Descripción</th>
										<th class="column-title">Activo</th>
										<th class="column-title no-link last"><span class="nobr">Acción</span>
										</th>
									</tr>
								</thead>

								<tbody>
									<tr class="even pointer" ng-repeat="nodo in nodos">
										<td><span ng-hide="nodo.editMode">{{nodo.modulo}}</span>
											<select ng-show="nodo.editMode" ng-model="nodo.modulo"
												ng-options="modulo for modulo in modulos">
											</select></td>
										<td class=" ">{{nodo.numero}}</td>
										<td><span ng-hide="nodo.editMode">{{nodo.descripcion}}</span>
											<input type="text" name="descripcion"
											ng-show="nodo.editMode" class="form-control"
											ng-model="nodo.descripcion" placeholder=""
											required="" /></td>
										<td class="a-center"><input ng-hide="nodo.editMode"
											type="checkbox" disabled="disabled" class="flat"
											ng-checked="nodo.activo"> <input type="checkbox"
											ng-show="nodo.editMode" class="flat"
											ng-checked="nodo.activo" ng-model="nodo.activo">
										</td>
										<td class="last"><a href="" ng-hide="nodo.editMode"
											ng-click="editNodos(nodo)">Editar</a> <a href=""
											ng-show="nodo.editMode"
											ng-click="updateNodo(nodo)">Guardar</a>
											<a href="" ng-show="nodo.editMode"
											ng-click="cancel(nodo)">Cancelar</a></td>

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
<script src="resources/angularjs/confNodos.js"></script>
	<!-- close container body and main container -->
	</div> 
</div>
</body>
</html>