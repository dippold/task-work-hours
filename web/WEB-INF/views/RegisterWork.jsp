<!-- Document: RegisterWork, Created-on: 15/01/2020, Updated-on: 15/01/2020, Author: Fabio Dippold, rev: 1.0.0 -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <%@include file="../includes/MetaTagsHtmlInclude.jsp" %>
        <%@include file="../includes/CssCoreLibrariesInclude.jsp" %>
    </head>
    <body>
        <%@include file="../includes/MenuInclude.jsp" %>
        <!-- MAIN CONTAINER -->   
        <div id="main" class="container-fluid">
            <div class="row">
                <div class="col-md-6" ><h2 style="text-shadow: 0.1em 0.1em 0.2em black;">${viewName}</h2></div>
            </div>
            <!-- FORM MAIN -->
            <form id="frmMain" name="frmMain" method="POST" action="${url}">
                <!-- MVC -->
                <input type="hidden" id="url" name="url" value="${url}">
                <input type="hidden" id="cmd" name="cmd" value="${cmd}">
                <input type="hidden" id="task" name="task" value="${task}">
                <input type="hidden" id="id" name="id" value="${id}">
                <input type="hidden" id="pid" name="pid" value="${pid}">
                <input type="hidden" id="ppid" name="ppid" value="${ppid}">
                <input type="hidden" id="msg" name="msg" value="${msg}">
                <!-- /MVC -->

                <!-- LINHA-1 -->
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="comboProject">Projeto:</label>
                        <SELECT id="comboProject" name="comboProject" size="1"  required="required" class="form-control" style="box-shadow: 1px 1px 1px #999;">
                            <c:forEach var="o" items="${projects}">
                                <c:choose>
                                    <c:when test="${entity == null}"><!-- if condition -->
                                        <option value="${o.id}">${o.name}</option>
                                    </c:when> 
                                    <c:otherwise><!-- else condition -->
                                        <option value="${o.id}" ${entity.projectId == o.id ? 'selected' : ''}>${o.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>                                  
                        </SELECT>                     
                    </div>
                    <div class="form-group col-md-4">
                        <label for="comboActivity">Atividade:</label>
                        <SELECT id="comboActivity" name="comboActivity" size="1"  required="required" class="form-control" style="box-shadow: 1px 1px 1px #999;">
                            <c:forEach var="o" items="${activities}">
                                <c:choose>
                                    <c:when test="${entity == null}"><!-- if condition -->
                                        <option value="${o.id}">${o.name}</option>
                                    </c:when> 
                                    <c:otherwise><!-- else condition -->
                                        <option value="${o.id}" ${entity.acticityId == o.id ? 'selected' : ''}>${o.name}</option>
                                    </c:otherwise>
                                </c:choose>                                
                            </c:forEach>                                  
                        </SELECT>                     
                    </div>                    
                </div><!-- /LINHA-1 -->                
                <!-- LINHA-2 (8 UNIDADES DE TELA) -->
                <div class="row">
                    <div class="form-group col-md-2">
                        <label for="dateInput">Data:</label>
                        <div class="input-group">
                            <input type="date" class="form-control" id="dateInput" name="dateInput" required="required" value="${entity.workedHoursDate}">
                        </div>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="comboWorkHours">Qt. horas:</label>
                        <SELECT id="comboWorkHours" name="comboWorkHours" size="1"  required="required" class="form-control" style="box-shadow: 1px 1px 1px #999;">
                            <c:forEach var="o" items="${workhoursday}">
                                <c:choose>
                                    <c:when test="${entity == null}"><!-- if condition -->
                                        <option value="${o.id}">${o.name}</option>
                                    </c:when> 
                                    <c:otherwise><!-- else condition -->
                                        <option value="${o.id}" ${entity.workedHours == o.id ? 'selected' : ''}>${o.name}</option>
                                    </c:otherwise>
                                </c:choose>                                
                            </c:forEach>                                  
                        </SELECT>                        
                    </div>     
                    <div class="form-group col-md-2">
                        <label for="comboCompleteness">% Pronto</label>
                        <SELECT id="comboCompleteness" name="comboCompleteness" size="1"  required="required" class="form-control" style="box-shadow: 1px 1px 1px #999;">
                            <c:forEach var="o" items="${completeness}">
                                <c:choose>
                                    <c:when test="${entity == null}"><!-- if condition -->
                                        <option value="${o.id}">${o.name}</option>
                                    </c:when> 
                                    <c:otherwise><!-- else condition -->
                                        <option value="${o.id}" ${entity.completenessPercentage == o.id ? 'selected' : ''}>${o.name}</option>
                                    </c:otherwise>
                                </c:choose>                                
                            </c:forEach>                                  
                        </SELECT>                        
                    </div>                   
                </div><!-- /LINHA-2 -->  
                <!-- LINHA-3 -->
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="descriptionInput">Observações:</label>
                        <textarea class="form-control"  style="box-shadow: 1px 1px 1px #999;" id="descriptionInput" name="descriptionInput" placeholder="Colque suas observações de progresso ou impedimentos" maxlength="255" rows="3"></textarea>                       
                        <span id="counterDescriptionInput" class="label label-warning" style="color: #0099ff;font-size: 11px; text-shadow: 0.1em 0.1em 0.2em black">255 Restantes!</span>
                    </div>                                       
                </div><!-- /LINHA-3 -->                                
                <!-- LINHA-4 : BUTTONS SAVE AND CANCEL -->
                <div class="row">
                    <div class="col-md-8">
                        <button id="btnSubmit" class="btn btn-primary" style="text-shadow: 0.1em 0.1em 0.2em black; box-shadow: 1px 1px 1px #999" type="submit" >${btnSubmitLabel}</button>
                        <a id="btnCancel" href="${urlToCancel}" class="btn btn-primary" style="text-shadow: 0.1em 0.1em 0.2em black; box-shadow: 1px 1px 1px #999">Cancelar</a>
                    </div>
                </div><!-- /LINHA-4 -->

                <br><br>
            </form><!-- /FORM MAIN -->
            <jsp:include page="../includes/MessageBarInclude.jsp" />
        </div> <!--/MAIN CONTAINER --> 
        <%@include file="../includes/JavaScriptCoreLibrariesInclude.jsp" %>       
        <script type="text/javascript">
            $(document).ready(function () {

                $("#frmMain").on("submit", function () {
                    $("#btnSubmit").text("Processando . . .");
                });

                $("#btnCancel").on("click", function () {
                    $("#btnCancel").text("Processando . . .");
                });

                $("#descriptionInput").keyup(
                        function () {
                            var limite = 255;
                            var caracteresDigitados = $(this).val().length;
                            var caracteresRestantes = limite - caracteresDigitados;
                            $("#counterDescriptionInput").text(caracteresRestantes + " Restantes!");
                        }
                );

            });
        </script>
    </body>
</html>
