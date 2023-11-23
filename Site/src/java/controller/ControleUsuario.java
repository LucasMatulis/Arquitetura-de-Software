package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EmpresaDao;
import model.Usuario;

@WebServlet(name = "ControleUsuario", urlPatterns = {"/ControleUsuario"})
public class ControleUsuario extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String flag, arquivo;
        flag = request.getParameter("flag");
        if(flag.equals("login")){
            //aqui vem a parte de verificação de login
            Usuario usuario = new EmpresaDao().validarLogin(request.getParameter("usuario"), request.getParameter("senha"));
            if(usuario == null){// não achou o usuario no BD
                request.setAttribute("mensagem", "Usuário e/ou senha inválidos");
                RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");
                disp.forward(request, response);
            } else { //achou o usuario no BD
                if(usuario.getFuncionario().getCargoFun().equalsIgnoreCase("gerente")){
                    arquivo = "acesso_admin.jsp";
                }else{
                    arquivo = "acesso_outros.jsp";
                }
                request.setAttribute("nome", usuario.getFuncionario().getNomeFun());
                RequestDispatcher disp = request.getRequestDispatcher(arquivo);
                disp.forward(request, response);
            }
        }else if(flag.equals("cadastroUsuario")){
            //aqui vem a parte de cadastro do usuario
        
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}