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
                case SUCESSO:
                    mensagem = "Departamento cadastrado com sucesso";
                    break;
                case CHAVEDUPLICADA:
                    mensagem = "O departamento "+dep.getIdDep()+" já está cadastrado";
                    break;
                default:
                    mensagem = "Erro ao tentar salvar o departamento";
                    break;
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("mensagens.jsp").forward(request, response);
        } else if(flag.equals("list_dep")){
            List<Departamento> departamentos;
            departamentos = new EmpresaDao().listar("Departamento.findAll", Departamento.class);
            if(departamentos == null){
                request.setAttribute("mensagem", "Nenhum departamento cadastrado no momento");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
            } else {                
                request.setAttribute("departamentos", departamentos);
                request.getRequestDispatcher("/Departamentos/mostrar_departamentos.jsp").forward(request, response);
            }
            
        }   else if(flag.equals("exc")){
            String id = request.getParameter("id");
            switch(new EmpresaDao().excluir(id, Departamento.class)){
                case SUCESSO:
                    mensagem = "Produto "+id+" excluí com sucesso";
                    break;
                case NAOCADASTRADO:
                    mensagem = "Produto "+id+" não cadastrado";
                    break;
                default:
                    mensagem = "Erro encontrado. Entre em contato com o suporte";
                    break;
                    
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("mensagens.jsp").forward(request, response);
        } else if(flag.equals("buscar_alt_dep")){
            Departamento dep = new EmpresaDao().buscar(Departamento.class,request.getParameter("id"));
            if(dep == null){
                request.setAttribute("mensagem", "Departamento não encontrado");
                request.getRequestDispatcher("mensagens.jsp").forward(request, response);
            }else{
                request.setAttribute("dep", dep);
                request.getRequestDispatcher("/Departamentos/alterar_dep.jsp").forward(request, response);                
            }
        } else if(flag.equals("alt")){
            String i, n, t;
            i= request.getParameter("idDep");
            n= request.getParameter("nomeDep");
            t= request.getParameter("telefoneDep");
            int resultado = new EmpresaDao().alterar(i, n, t);
            switch(resultado){
                case 1:
                    mensagem = "Alteração no departamento "+ i + " realizada com sucesso";
                    break;
                default:
                    mensagem = "Erro ao tentar alterar os dados. Entre em contato com o suporte";
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("mensagens.jsp").forward(request, response);
        } else if(flag.equals("buscar_departamentos")){
            List<Departamento> listaDepartamentos = new EmpresaDao().listar("Departamento.findAll", Departamento.class);
            request.setAttribute("listaDepartamentos", listaDepartamentos);
            request.getRequestDispatcher("/Funcionario/cadfun.jsp").forward(request, response);
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