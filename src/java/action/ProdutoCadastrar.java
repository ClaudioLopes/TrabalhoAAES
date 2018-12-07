/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.EmpresaDAO;
import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import persistence.ProdutoDAO;
import persistence.ProdutoEmpresaDAO;
import strategy.Item;
import strategy.Produto;

/**
 *
 * @author claudio
 */
public class ProdutoCadastrar implements Action{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException,
     ServletException {
        request.setAttribute("id_empresa", Integer.parseInt(request.getParameter("id_empresa")));

        if(request.getParameter("nome").equals("") || request.getParameter("valor").equals("")) {
           request.getRequestDispatcher("ProdutoCadastrar.jsp").forward(request, response);
        } else {
            Produto produto = new Item();
            produto
                    .setNome(request.getParameter("nome"))
                    .setValor(Integer.parseInt(request.getParameter("valor")));
            try{
                ProdutoDAO.getInstance().save(Integer.parseInt(request.getParameter("id_empresa")), produto);
                request.getRequestDispatcher("ProdutoCadastrar.jsp").forward(request, response);
            }catch(SQLException ex){
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            }catch(ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }
    }
}
