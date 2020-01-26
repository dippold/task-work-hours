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
            <BR>
            <h6>
                Seja bem-vindo, <span style="color: blue; text-shadow: 0.1em 0.1em 0.2em black" href="#">${userName}</span> !
                &nbsp;Selecione um projeto abaixo p/ registrar horas trabalhadas.
            </h6>
            <div class="list-group" style="box-shadow: 1px 1px 1px #999">
                <c:forEach var="o" items="${userProjects}">
                    <a href="mvc?cmd=WorkHourCmd&task=addModel&projectid=${o.id}" class="list-group-item list-group-item-action flex-column align-items-start">
                        <div class="d-flex w-100 justify-content-between">
                            <h5 class="mb-1" style="text-shadow: 0.1em 0.1em 0.2em black">${o.name}</h5>
                            <small>${o.info2} tarefa(s)</small>
                        </div>
                        <p class="mb-1">${o.description}</p>
                        <small>Empresa: ${o.info1}</small>
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