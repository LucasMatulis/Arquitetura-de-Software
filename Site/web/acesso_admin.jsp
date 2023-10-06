<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <title>Site B)</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="index.css">
    </head>
    <body>
        <header>   
            <h1>SENAC</h1>
            <p>Bem vindo ${nome}</p>
        </header>
        <nav>
            <div class="menu">
                <button class="botao">Departamentos</button>
                <div class="submenu">
                    <a href="Departamentos/caddep.html" target="centro">Cadastro</a>
                    <a href="Departamentos/condep.html" target="centro">Consulta</a>
                    <a href="Departamentos/altdep.html" target="centro">Alteração</a>
                    <a href="Departamentos/excdep.html" target="centro">Exclusão</a>
                    <a href="ControleDepartamento?flag=list_dep" target="centro">Listagem</a>
                </div>
            </div>
            <div class="menu">
                <button class="botao">Funcionários</button>
                <div class="submenu">
                    <a href="Funcionarios/cadfun.html" target="centro">Cadastro</a>
                    <a href="Funcionarios/confun.html" target="centro">Consulta</a>
                    <a href="Funcionarios/altfun.html" target="centro">Alteração</a>
                    <a href="Funcionarios/excfun.html" target="centro">Exclusão</a>
                    <a href="Funcionarios/lisfun.html" target="centro">Listagem</a>
                </div>
            </div>
            <div class="menu">
                <button class="botao">Usuários</button>
                <div class="submenu">
                    <a href="Usuarios/cadusu.html" target="centro">Cadastro</a>
                    <a href="Usuarios/conusu.html" target="centro">Consulta</a>
                    <a href="Usuarios/altusu.html" target="centro">Alteração</a>
                    <a href="Usuarios/excusu.html" target="centro">Exclusão</a>
                    <a href="Usuarios/lisusu.html" target="centro">Listagem</a>
                </div>
            </div>
        </nav>
        <main>
            <iframe src="inicial.html" name="centro"></iframe>
        </main>
        <footer>
            teste
        </footer>
    </body>
</html>