<!-- Document: Home.jsp, Created-on: 11/01/2020, Updated-on: 11/01/2020, Author: Fabio Dippold, rev: 1.0.1 -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="pt-br">
    <head>
        <%@include file="../includes/MetaTagsHtmlInclude.jsp" %>
        <%@include file="../includes/CssCoreLibrariesInclude.jsp" %>
    </head>
    <body>
        <%@include file="../includes/MenuInclude.jsp" %>
        <div class="container">
            <h3>Seja Bem-Vindo!</h3>
            <p>Esse é um aplicativo simples e tem o objetivo de apontamento de horas para equipes que executam tarefas em projetos.</p>


            <!--
            <c:forEach var="o" items="${userProjects}">
                <div class="row">
                    <div class="form-group col-md-6">
                        <div class="input-group">
                            <a id="btnProjeto${o.id}" href="${urlToCancel}" class="btn btn-primary" style="width: 400px; text-shadow: 0.1em 0.1em 0.2em black; box-shadow: 1px 1px 1px #999">${o.name}</a>
                        </div>                
                    </div>
                </div>
            </c:forEach> 
            -->
            <div class="list-group" style="box-shadow: 1px 1px 1px #999">
                <c:forEach var="o" items="${userProjects}">
                    <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                        <div class="d-flex w-100 justify-content-between">
                            <h5 class="mb-1">${o.name}</h5>
                            <small>3 dias atrás</small>
                        </div>
                        <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
                        <small>Donec id elit non mi porta.</small>
                    </a>
                </c:forEach> 

                <c:forEach var="o" items="${userProjects}">
                    <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                        <div class="d-flex w-100 justify-content-between">
                            <h5 class="mb-1">${o.name}</h5>
                            <small>3 dias atrás</small>
                        </div>
                        <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
                        <small>Donec id elit non mi porta.</small>
                    </a>
                </c:forEach> 
            </div>

            <BR>
        </div>
        <%@include file="../includes/JavaScriptCoreLibrariesInclude.jsp" %>       
        <script type="text/javascript">
            $(document).ready(function () {
            });
        </script>
    </body>
</html>