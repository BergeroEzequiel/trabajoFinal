<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" ng-app="detalleAlerta">
<%@include file="../layout/template.jsp"%>

<!-- page content -->
<div class="right_col" role="main" ng-controller="historicosController">
    <div class="">
        <div class="page-title">

            <div class="clearfix"></div>

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>
                            Datos Históricos<small></small>
                        </h2>
                        <div class="clearfix"></div>
                    </div>


                    <div class="x_content">
                        <div class="col-md-7" ng-controller="chartController">
                            <canvas id="myChart" style="display: inline-block; width: 478px; height: 125px; vertical-align: top;"></canvas>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<!-- /page content -->

<%@include file="../layout/footer.jsp"%>
<script src="resources/angularjs/historicos.js"></script>
<!-- close container body and main container -->
</div>
</div>
</body>
</html>