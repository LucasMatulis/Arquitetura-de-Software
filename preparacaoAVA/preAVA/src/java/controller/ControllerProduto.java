package controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BancoDAO;
import model.Produto;


@WebServlet(name = "ControllerProduto", urlPatterns = {"/ControllerProduto"})
public class ControllerProduto extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String flag, mensagem;
        flag = request.getParameter("flag");
        
        if(flag.equals("cad_Pro")){
            Produto pro = new Produto(Integer.parseInt(request.getParameter("id")),
                                                        request.getParameter("nome"),
                                                        request.getParameter("marca"),
                                                            Double.parseDouble(request.getParameter("pre")));
         
            
            switch(new BancoDAO().cadastrar(pro)){                
                case 1:
                    mensagem = "produto cadastrado com sucesso";
                    break;
                case 2:
                    mensagem = "O produto "+pro.getId()+" já está cadastrado";
                    break;
                default:
                    mensagem = "Erro ao tentar salvar o produto";
                    break;
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("mensagens.jsp").forward(request, response);
        }else if(flag.equals("list_pro")){
            List<Produto> produtos = new BancoDAO().listar("Produto.findAll", Produto.class);
            if(produtos == null){
                request.setAttribute("mensagem", "Nenhum produto cadastrado no momento");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
            } else {                
                request.setAttribute("produtos", produtos);
                request.getRequestDispatcher("mostrar_produtos.jsp").forward(request, response);
            }     
        }      
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
