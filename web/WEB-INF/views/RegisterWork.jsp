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
                <div class="col-md-6"><h2>${viewName}</h2></div>
            </div>

            <!-- FORM MAIN -->
            <form id="frmMain" name="frmMain" method="POST" action="${url}">
                <!-- MVC -->
                <input type="hidden" id="url" name="url" value="${url}">
                <input type="hidden" id="cmd" name="cmd" value="${cmd}">
                <input type="hidden" id="task" name="task" value="${task}">
                <input type="hidden" id="id" name="id" value="${id}">
                <input type="hidden" id="pid" name="id" value="${pid}">
                <input type="hidden" id="ppid" name="id" value="${ppid}">
                <input type="hidden" id="msg" name="id" value="${msg}"><!-- /MVC -->

                <!-- LINHA-1 -->
                <div class="row">
                    
                    <div class="form-group col-md-4">
                        <label for="comboProject">Projeto:</label>
                        <SELECT id="comboProject" name="comboProject" size="1"  required="required" class="form-control">
                            <c:forEach var="o" items="${projects}">
                                <option value="${o.id}" ${entity.projectId == o.projectId ? 'selected' : ''}>${o.name}</option>
                            </c:forEach>                                  
                        </SELECT>                     
                    </div>
                    
                    <div class="form-group col-md-4">
                        <label for="comboActivity">Atividade:</label>
                        <SELECT id="comboActivity" name="comboActivity" size="1"  required="required" class="form-control">
                            <c:forEach var="o" items="${activities}">
                                <option value="${o.id}" ${entity.acticityId == o.activityid ? 'selected' : ''}>${o.name}</option>
                            </c:forEach>                                  
                        </SELECT>                     
                    </div>                    
                    
                </div><!-- /LINHA-1 -->                

                <!-- LINHA-2 (8 UNIDADES DE TELA) -->
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="emailInput">E-mail:</label>
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">@</span>
                            <input type="email" class="form-control" id="emailInput" name="emailInput" required="required" placeholder="Digite um e-mail"  aria-describedby="basic-addon1"
                                   value="${entity.email}">
                        </div>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="passwdInput">Senha:</label>
                        <input type="password" class="form-control" id="passwdInput" name="passwdInput" required="required" placeholder="Digite uma senha"
                               value="${entity.passwd}">
                    </div>                   
                </div><!-- /LINHA-2 -->           

                <!-- LINHA-3 (8 UNIDADES DE TELA) -->
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="profileIdsInput">Perfis IDs:</label>
                        <input type="text" class="form-control" id="profileIdsInput" name="profileIdsInput" required="required" max="50" placeholder="Classe Model"
                               value="${entity.profileIds}">
                        <span id="contadorProfileIdsInput" class="label label-warning">50 Restantes!</span>
                        <img src="assets/images/loading/loading19.gif" id="loading-indicator" style="display:none" alt=""/> 
                        <span id="profileNamesSpan" class="label label-info"></span>
                    </div>

                    <div class="form-group col-md-2">
                        <label for="comboSystem">Sistema?:</label>                        
                        <!-- COMBOBOX SYSTEM -->
                        <SELECT id="comboSystem" name="comboSystem" size="1" class="form-control">
                            <c:if test="${entity.system == true}">
                                <option value="true" selected>Sim</option> 
                                <option value="false">Não</option>
                            </c:if> 
                            <c:if test="${entity.system == false}">
                                <option value="true">Sim</option> 
                                <option value="false" selected>Não</option>
                            </c:if> 
                        </SELECT><!-- /COMBOBOX SYSTEM -->   
                    </div>                    
                    <div class="form-group col-md-2">
                        <label for="comboBlocked">Bloqueado?:</label>
                        <!-- COMBOBOX BLOCKED -->
                        <SELECT id="comboBlocked" name="comboBlocked" size="1" class="form-control">
                            <c:if test="${entity.blocked == true}">
                                <option value="true" selected>Sim</option> 
                                <option value="false">Não</option>
                            </c:if> 
                            <c:if test="${entity.blocked == false}">
                                <option value="true">Sim</option> 
                                <option value="false" selected>Não</option>
                            </c:if> 
                        </SELECT><!-- /COMBOBOX BLOCKED -->   
                    </div>                                        
                </div><!-- /LINHA-3 -->                                

                <!-- LINHA-7 : BUTTONS SAVE AND CANCEL  (6 UNIDADES DE TELA)-->
                <div class="row">
                    <div class="col-md-8">
                        <button id="btnSubmit" style="text-shadow: 0.1em 0.1em 0.2em black" type="submit" class="btn btn-primary">${btnSubmitLabel}</button>
                        <a id="btnCancel" href="${urlToCancel}" class="btn btn-primary">Cancelar</a>
                    </div>
                </div><!-- /LINHA-7 -->

                <br><br>

            </form><!-- /FORM MAIN -->

            <!-- MESSAGE BAR -->
            <jsp:include page="../includes/MessageBarInclude.jsp" /> 
            <!-- /MESSAGE BAR -->

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
                
            });
        </script>
    </body>
</html>
