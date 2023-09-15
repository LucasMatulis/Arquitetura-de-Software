/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EmpresaDao;
import model.Usuario;

/**
 *
Esta servelt gerenciara tudo referente a usuarios */
public class ControleUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String flag,u,s, mensagem;
        flag= request.getParameter("flag");
        if(flag.equals("login")){
            u=request.getParameter("usuario");
            s= request.getParameter("senha");
            EmpresaDao dao= new EmpresaDao();
            Usuario usuario= dao.validarLogin(u, s);
            if(usuario==null){//não achou o Usuario no BD
                mensagem= "usuario e/ou senha invalidos";
                request.setAttribute("mensagem", mensagem);
                RequestDispatcher disp= request.getRequestDispatcher("mensagens.jsp");
                disp.forward(request, response);
            }
            else{//achou o usuario no BD
                
            }
        }
        else if(flag.equals("cadastroUsuario")){
            
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
