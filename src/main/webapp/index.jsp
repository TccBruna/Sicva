<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Sicva</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.flatly.min.css" rel="stylesheet">
        <link href="css/estilo.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body  data-spy="scroll" data-target=".menu-navegacao" data-offset="80">
        <!--Menu da Aplica��o  -->
        <nav  class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#menu-navegacao">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Logomarca</a>
                </div>
                <div class="collapse navbar-collapse menu-navegacao" id="menu-navegacao">
                    <ul class="nav navbar-nav navbar-right ">
                        <li><a class="scrollSuave" href="#inicio">In�cio</a></li>
                        <li><a class="scrollSuave" href="#servicos">Servi�os</a></li>
                        <li><a class="scrollSuave" href="#portifolio">Portif�lio</a></li>
                        <li><a class="scrollSuave" href="#quem-somos">Quem Somos</a></li>
                        <li><a class="scrollSuave" href="#localizacao">Localiza��o</a></li>
                        <li><a class="scrollSuave" href="#contato">Contato</a></li>                    
                        <li  class="dropdown" id="menuLogin">
                            <a class="dropdown-toggle" href="#" data-toggle="dropdown" id="navLogin">Login</a>
                            <div style="min-width: 250px; padding-top: 15px" class="dropdown-menu">
                                <div class="col-xs-12">
                                <form class="form" id="formLogin" action="/j_spring_security_check" method="POST"> 
                                    <input name="j_username" class="form-control" id="username" placeholder="Nome de Usu�rio" type="text"> 
                                    <input name="j_password" class="form-control" id="password" placeholder="Senha" type="password"><br>
                                    <button type="button"   id="btnLogin" class="btn btn-default btn-block">Login</button>
                                </form>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!--// Menu da Aplica��o  -->
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="jumbotron">
                        <h1>Bem Vindo!</h1>
                        <p>Texto explicativo...</p>
                        <p><a class="btn btn-primary btn-lg" href="#" role="button">Leia mais</a></p>
                    </div>
                </div>
            </div>

        </div>


        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-sm-10">Informa��es gerais sobre a empresa, endere�o e-mail e etc:</div>
                    <div class="col-sm-2 text-right">
                        <small>Dessenvolvido por:</small><br/>
                        <strong>Mary , Bruna e Rodrigo </strong>
                    </div>
                </div> 
            </div>     
        </footer>

        <script src="js/jquery.min.js"></script>   
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>   
    </body>
</html>