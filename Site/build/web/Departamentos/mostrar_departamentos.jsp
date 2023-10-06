<%@page import="java.util.List"%>
<%@page import="model.Departamento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='pt-BR'>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<Departamento> departamentos = (List<Departamento>)request.getAttribute("departamentos");
        %>
        <table border='1'>
            <tr>
                <th>Sigla</th>
                <th>Nome</th>
                <th>Telefone</th>
                <th>Exclusão</th>
            </tr>
        <%
            for(Departamento dep: departamentos){
        %>
            <tr>
                <td><%= dep.getIdDep()%> </td>
                <td><%= dep.getNomeDep()%> </td>
                <td><%= dep.getTelefoneDep()%> </td>
                <td><a href="#">Excluir</a></td>
            </tr>
        <%
            }
        %>
        </table>
    </body>
</html>