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
            <p>Esse é um aplicativo simple e objetivo de apontamento de horas para equipes que executam tarefas em projetos.</p>
        </div>
        <%@include file="../includes/JavaScriptCoreLibrariesInclude.jsp" %>       
        <script type="text/javascript">
            $(document).ready(function () {
            });
        </script>
    </body>
</html>