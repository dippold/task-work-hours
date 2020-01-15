<!-- Document: Home.jsp, Created-on: 11/01/2020, Updated-on: 11/01/2020, Author: Fabio Dippold, rev: 1.0.1 -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Language" content="pt-br">
        <meta name="description" content="WorkHours App">
        <meta name="author" content="Fábio Tavares Dippold">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>WorkHoursApp</title>
        <link rel="shortcut icon" href="assets/core/images/ftd-logo.jpg">        
        <%@include file="../includes/CssCoreLibrariesInclude.jsp" %>
    </head>

    <body>
        <%@include file="../includes/MenuInclude.jsp" %>

        <div class="container">
            <h3>Basic Navbar Example</h3>
            <p>A navigation bar is a navigation header that is placed at the top of the page.</p>
        </div>

        <%@include file="../includes/JavaScriptCoreLibrariesInclude.jsp" %>       

        <script type="text/javascript">
            $(document).ready(function () {

            });
        </script>

    </body>
</html>