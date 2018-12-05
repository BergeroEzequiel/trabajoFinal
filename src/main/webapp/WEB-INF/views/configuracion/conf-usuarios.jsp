<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" ng-app="confUsuarios">
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
							Configuración de usuarios<small></small>
						</h2>
						<div class="clearfix"></div>
					</div>

					<div class="x_content" ng-controller="usuarioController">

						<div class="table-responsive">
							<table class="table table-striped table-bordered bulk_action">
								<thead>
									<tr class="headings">

										<th class="column-title">Usuario</th>
										<th class="column-title">Nombre</th>
										<th class="column-title">Apellido</th>
										<th class="column-title">Email</th>
										<th class="column-title">Estado</th>
										<th class="column-title">Rol</th>
										<th class="column-title no-link last"><span class="nobr">Acción</span>
										</th>
									</tr>
								</thead>

								<tbody>
									<tr class="even pointer" ng-repeat="usuario in usuarios">
										<td class=" ">{{usuario.ssoId}}</td>
										<td class=" ">{{usuario.firstName}}</td>
                                                                                <td class=" ">{{usuario.lastName}}</td>
                                                                                <td class=" ">{{usuario.email}}</td>
                                                                                
                                                                                <td><span ng-hide="usuario.editMode">{{usuario.estado.descripcion}}</span>
											<select ng-show="usuario.editMode" ng-model="usuario.estado"
												ng-options="estado.descripcion for estado in estados track by estado.id">
										</select></td>
                                                                                
                                                                                <td><span ng-hide="usuario.editMode">{{usuario.userProfile.type}}</span>
											<select ng-show="usuario.editMode" ng-model="usuario.userProfile"
												ng-options="rol.type for rol in roles track by rol.id">
										</select></td>
                                                                                
										<td class="last"><a href="" ng-hide="usuario.editMode"
											ng-click="editUsuario(usuario)">Editar</a> 
                                                                                    <a href="" ng-show="usuario.editMode"
											ng-click="updateUsuario(usuario)">Guardar</a>
                                                                                    <a href="" ng-show="usuario.editMode"
											ng-click="cancel(usuario)">Cancelar</a></td>

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
<script src="resources/angularjs/confUsuarios.js"></script>
<!-- close container body and main container -->
</div>
</div>
</body>
</html>