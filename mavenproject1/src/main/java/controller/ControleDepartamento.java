package controller;

import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Departamento;
import model.SenacDao;


@WebServlet(name = "ControleDepartamento", urlPatterns = {"/ControleDepartamento"})
public class ControleDepartamento extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        // aqui fica a programação da servlet
        String flag, nome, telefone, mensagem;
        RequestDispatcher dispatcher;
        flag = request.getParameter("flag");
        if (flag.equals("Cdep")){
            nome = request.getParameter("nome");
            telefone = request.getParameter("telefone");
            
            Departamento departamento = new Departamento();
            departamento.setNomedepartamento(nome);
            departamento.setTelefonedepartamento(telefone);
            
            SenacDao dao = new SenacDao();
            int resultado =  dao.salvarDepartamento(departamento);
            
            if(resultado==1){
                mensagem = "Departamento salvo com sucesso :)";
            }
            else{
                mensagem = "Erro ao tentar salvar o departamento :(";
            }
            request.setAttribute("mensagem", mensagem);
            dispatcher = request.getRequestDispatcher("mensagem.jsp");
            dispatcher.forward(request, response);
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
