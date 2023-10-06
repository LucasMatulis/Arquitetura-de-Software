package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Departamento;
import model.EmpresaDao;

@WebServlet(name = "ControleDepartamento", urlPatterns = {"/ControleDepartamento"})
public class ControleDepartamento extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String flag, mensagem;
        flag = request.getParameter("flag");
        if(flag.equals("cad_Dep")){//Aqui vamos fazer o cadastro
            /*recebe os dados digitados no formulário e
              encapsula os dados recebidos em um obj
              da classe Departamento*/
            Departamento dep = new Departamento(request.getParameter("idDep"),
                                                request.getParameter("nomeDep"),
                                                request.getParameter("telefoneDep"));
            /*  Tenta cadastrar um departamento no banco de
                dados e verifica qual foi o nivel de erro dele*/
            switch(new EmpresaDao().cadastrar(dep)){                
                case 1:
                    mensagem = "Departamento cadastrado com sucesso";
                    break;
                case 2:
                    mensagem = "O departamento "+dep.getIdDep()+" já está cadastrado";
                    break;
                default:
                    mensagem = "Erro ao tentar salvar o departamento";
                    break;
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("mensagens.jsp").forward(request, response);
        } else if(flag.equals("list_dep")){
            List<Departamento> departamentos = new EmpresaDao().listar("Departamento.findAll", Departamento.class);
            if(departamentos == null){
                request.setAttribute("mensagem", "Nenhum departamento cadastrado no momento");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
            } else {                
                request.setAttribute("departamentos", departamentos);
                request.getRequestDispatcher("/Departamentos/mostrar_departamentos.jsp").forward(request, response);
            }     
        }
        else if(flag.equals("exc_dep")){
                    String id= request.getParameter("id");
                    int retorno= new EmpresaDao().excluir(id,Departamento.class);
            switch (retorno) {
                case 1:
                    mensagem= "Departametno "+id+" excluido com sucesso";
                    break;
                case 2:
                    mensagem= "Departametno "+id+" não cadastrado";
                    break;
                default:
                    mensagem= "Erro encontrado.Entre em contato com o suporte";
                    break;
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("mensagens.jsp").forward(request, response);   
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}