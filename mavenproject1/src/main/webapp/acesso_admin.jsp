<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Home</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="index.css">
    </head>
    <body>
        <header>
            <h1>SENAC</h1>
            <p>Bem-vindo ${nome}</p>
        </header>
        <nav>
            <div class="menu">
                <button class="botao">Departamentos</button>
                <div class="submenu">
                    <a href="caddep.html" target="centro">Cadastro</a>
                    <a href="condep.html" target="centro">Consulta</a>
                    <a href="altdep.html" target="centro">Alteração</a>
                    <a href="excdep.html" target="centro">Exclusão</a>
                    <a href="lisdep.html" target="centro">Listagem</a>                    
                </div>
            </div>
            <div class="menu">
                <button class="botao">Funcionários</button>
                <div class="submenu">
                    <a href="cadfun.html"  target="centro">Cadastro</a>
                    <a href="confun.html" target="centro">Consulta</a>
                    <a href="altfun.html" target="centro">Alteração</a>
                    <a href="excfun.html" target="centro">Exclusão</a>
                    <a href="lisfun.html" target="centro">Listagem</a>                    
                </div>
            </div>
            <div class="menu">
                <button class="botao">Usuários</button>
                <div class="submenu">
                    <a href="cadusu.html" target="centro">Cadastro</a>
                    <a href="conusu.html" target="centro">Consulta</a>
                    <a href="altusu.html" target="centro">Alteração</a>
                    <a href="excusu.html" target="centro">Exclusão</a>
                    <a href="lisusu.html" target="centro">Listagem</a>                    
                </div>
            </div>            
        </nav>
        <main>
            <iframe src="inicial.html" name="centro"></iframe>
        </main>
        <footer>
            <p>
                <a href="http://jigsaw.w3.org/css-validator/check/referer">
                    <img style="border:0;width:88px;height:31px"
                         src="http://jigsaw.w3.org/css-validator/images/vcss"
                         alt="CSS válido!" />
                </a>
            </p>
        </footer>
    </body>
</html>

