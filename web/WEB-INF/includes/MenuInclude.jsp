<!-- Document: MenuInclude: Created-on: 13/01/2020, Updated-on:15/01/2020, Author: Fabio Dippold, rev: 1.0.1 -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" style="text-shadow: 0.1em 0.1em 0.2em black" href="#">${appName}</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" style="text-shadow: 0.1em 0.1em 0.2em black" href="${urlToHome}">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Apontar Trabalho</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Gerenciar
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Apontamentos</a>
                            <a class="dropdown-item" href="#">Projetos</a>
                            <!-- <div class="dropdown-divider"></div> -->
                            <a class="dropdown-item" href="#">Atividades</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="color: blue; text-shadow: 0.1em 0.1em 0.2em black" href="#">${userName}</a>
                    </li>
                </ul>
                <form id="frmLogout" method="post" action="${urlToLogout}">
                    <button id="btnLogout" class="btn btn-primary my-2 my-sm-0" style="text-shadow: 0.1em 0.1em 0.2em black" type="submit">Sair</button>
                </form>  
                <!--  
                <form class="form-inline my-2 my-lg-0">
                  <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                  <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
                -->
            </div>
        </nav><!-- /MenuInclude -->