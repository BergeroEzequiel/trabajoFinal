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
                        <div class="filter">
                            <div id="reportrange" class="pull-right"
                                 style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
                                <i class="glyphicon glyphicon-calendar fa fa-calendar"></i> <span></span> <b class="caret"></b>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>

                    <div class="x_content" ng-controller="">

                        <div class="table-responsive">
                            <table class="table table-striped table-bordered bulk_action">
                                <thead>
                                <tr class="headings">

                                    <th class="column-title">M�dulo</th>
                                    <th class="column-title">N�mero</th>
                                    <th class="column-title">Descripci�n</th>
                                    <th class="column-title">Activo</th>
                                    <th class="column-title no-link last"><span class="nobr">Acci�n</span>
                                    </th>
                                </tr>
                                </thead>

                                <tbody>

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
<script src="resources/angularjs/detalleAlerta.js"></script>
    <!-- close container body and main container -->
    </div>
</div>
</body>
</html>