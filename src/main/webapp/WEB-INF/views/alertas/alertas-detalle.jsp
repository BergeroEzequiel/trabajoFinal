<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" ng-app="detalleAlerta">
<%@include file="../layout/template.jsp"%>

<!-- page content -->
<div class="right_col" role="main" ng-controller="detalleAlertaController">
    <div class="">
        <div class="page-title">

            <div class="clearfix"></div>

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>
                            Detalle de alertas<small></small>
                        </h2>
                        <div class="clearfix"></div>
                        <div class="filter">
                            <div id="reportrange" class="pull-right"
                                 style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
                                <i class="glyphicon glyphicon-calendar fa fa-calendar"></i> <span></span> <b class="caret"></b>
                            </div>
                            <select class="pull-center" ng-options="crit.prioridad for crit in criticidades track by crit.id" 
                                    ng-model="criticidadSeleccionada">
                                <option value="">Todas</option>   
                            </select>
                            <select class="pull-left" ng-options="nodo.modulo + ' ' + nodo.numero for nodo in nodos track by nodo.id" 
                                    ng-model="nodoSeleccionado">
                                <option value="">Todos</option> 
                            </select>
                        </div>
                        
                        <div class="clearfix"></div>
                    </div>

                   

                        <div class="table-responsive">
                            <table class="table table-striped table-bordered bulk_action">
                                <thead>
                                <tr class="headings">

                                    <th class="column-title">Descripción</th>
                                    <th class="column-title">Variable Afectada</th>
                                    <th class="column-title">Valor</th>
                                    <th class="column-title">Umbral max</th>
                                    <th class="column-title">Umbral min</th>
                                    <th class="column-title">Nodo</th>
                                    <th class="column-title">Criticidad</th>
                                    <th class="column-title">Fecha</th>
                                    <th class="column-title">Hora</th>
                                    <th class="column-title no-link last"><span class="nobr">Acción</span>
                                    </th>
                                </tr>
                                </thead>
                                    
                                <tbody>
                                    <tr class="even pointer" ng-repeat="alerta in alertas">
                                        <td class=" ">{{alerta.descripcion}}</td>
                                        <td class=" ">{{getHumanRedableName(alerta.variableAfectada)}}</td>
                                        <td class=" ">{{alerta.valor}}</td>
                                        <td class=" ">{{alerta.umbralSuperado.valorMax}}</td>
                                        <td class=" ">{{alerta.umbralSuperado.valorMin}}</td>
                                        <td class=" ">{{alerta.nodo.modulo + ' ' + alerta.nodo.numero}}</td>
                                        <td class=" ">{{alerta.criticidad.prioridad}}</td>
                                        <td class=" ">{{alerta.fecha | date:'dd/MM/yyyy'}}</td>
                                        <td class=" ">{{alerta.hora}}</td>
                                    </tr>

                                </tbody>
                            </table>
                        </div>
                        
                    
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /page content -->

<%@include file="../layout/footer.jsp"%>
<script src="resources/angularjs/detalleAlerta.js"></script>
    <!-- close container body and main container -->
    </div>
</div>
</body>
</html>