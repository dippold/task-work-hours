<!-- Document: SignIn.jsp, Created-on: 17/05/2018, Updated-on:14/01/2020, Author: Fabio Dippold, rev: 1.0.1 -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="pt-br">
    <!-- head -->
    <head>
        <meta http-equiv="Content-Language" content="pt-br">
        <meta name="description" content="WorkHours App">
        <meta name="author" content="Fábio Tavares Dippold">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>WorkHoursApp</title>
        <link rel="shortcut icon" href="assets/core/images/ftd-logo.jpg">
        <%@include file="WEB-INF/includes/CssCoreLibrariesInclude.jsp" %>
        <title>Work Hours</title>
        <link rel="shortcut icon" href="assets/core/images/ftd-logo.jpg">
        <!-- Custom styles for this template -->
        <link href="assets/custom/css/signin.css" rel="stylesheet">
    </head><!-- /head -->
    <body class="text-center">       
        <form id="frmLogin" class="form-signin" method="POST" action="signin">
            <h2 id="appName">Work Hours App</h2>
            <h4 id="title">Autenticação</h4>
            <br>
            <input type="email" id="inputEmail" name="email" class="form-control" style="box-shadow: 1px 1px 1px #999" placeholder="Email address" value="dippold.br@gmail.com" required>
            <input type="password" id="inputPassword" name="passwd" class="form-control" style="box-shadow: 1px 1px 1px #999" placeholder="Password" value="galateo2013" required>
            <br>
            <button id="btnSubmit" class="btn btn-lg btn-primary btn-block" style="text-shadow: 0.1em 0.1em 0.2em black; box-shadow: 1px 1px 1px #999" type="submit">Autenticar</button>
            <br>Copyright 2020 <i class="fas fa-award"></i> <i class="fab fa-java"></i>
            <br>By Software WorkForce
            <!-- DIV MENSAGEM -->
            <c:if test="${!msg.equals('')}"><br><span id="spanMsg">${msg}</span></c:if><!-- /DIV MENSAGEM -->
        </form>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>     
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/4.4.0/bootbox.min.js"></script>       
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
        <script type="text/javascript" defer src="https://use.fontawesome.com/releases/v5.1.0/js/all.js" integrity="sha384-3LK/3kTpDE/Pkp8gTNp2gR/2gOiwQ6QaO7Td0zV76UFJVhqLl4Vl3KL1We6q6wR9" crossorigin="anonymous"></script>    
        <!-- script -->
        <script type="text/javascript">
            $(document).ready(function () {

                $("#frmLogin").on("submit", function () {
                    $("#btnSubmit").text("Processando . . .");
                });

            });
        </script><!-- /script -->
    </body>
</html>