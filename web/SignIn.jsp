<%--
    Document   : SignIn.jsp
    Created on : 17/05/2018, 10:01:43
    Updated on : 14/01/2020, 13:06:00
    Author     : Fabio Tavares Dippold
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="pt-br">
    <!-- head -->
    <head>
        <!-- Required meta tags -->
        <meta http-equiv="Content-Language" content="pt-br">
        <meta name="description" content="WorkHoursApp">
        <meta name="author" content="Fábio Tavares Dippold">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">      
        <title>Work Hours</title>
        <link rel="shortcut icon" href="assets/core/images/ftd-logo.jpg">
        <!-- Custom styles for this template -->
        <link href="assets/custom/css/signin.css" rel="stylesheet">
    </head><!-- /head -->

    <body class="text-center">       
        <form id="frmLogin" class="form-signin" method="POST" action="signin">
            <h1 id="appName">Work Hours App</h1>
            <h2 id="title">Autenticação</h1>
            <label for="inputEmail" class="sr-only">E-mail</label>
            <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" value="dippold.br@gmail.com" required>
            <label for="inputPassword" class="sr-only">Senha</label>
            <input type="password" id="inputPassword" name="passwd" class="form-control" placeholder="Password" value="galateo2013" required>
            <button id="btnSubmit" class="btn btn-lg btn-primary btn-block" type="submit">Autenticar</button>
            <br>WorkHours App | Copyright 2020 <i class="fas fa-award"></i> <i class="fab fa-java"></i>
            <br>By Software WorkForce
            <!-- DIV MENSAGEM -->
            <c:if test="${!msg.equals('')}">
                <br><span id="spanMsg">${msg}</span>
            </c:if><!-- /DIV MENSAGEM -->
        </form>

        <!-- JavaScript libraries -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>     
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/4.4.0/bootbox.min.js"></script>       
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
        <script type="text/javascript" defer src="https://use.fontawesome.com/releases/v5.1.0/js/all.js" integrity="sha384-3LK/3kTpDE/Pkp8gTNp2gR/2gOiwQ6QaO7Td0zV76UFJVhqLl4Vl3KL1We6q6wR9" crossorigin="anonymous"></script>
        <!-- /JavaScript libraries -->
        
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