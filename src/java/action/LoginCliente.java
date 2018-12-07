/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import persistence.ClienteDAO;
import controller.Action;

/**
 *
 * @author claudio
 */
public class LoginCliente implements Action{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException,
     ServletException {

        if(request.getParameter("email").equals("") || request.getParameter("senha").equals("")) {
           response.sendRedirect("LoginCliente.jsp");
        } else {
            try{
                Cliente cliente = ClienteDAO.getInstance().login(request.getParameter("email"), request.getParameter("senha"));
                if(cliente.getNome() != null) {
                    request.setAttribute("id_cliente", cliente.getId());
                    request.getRequestDispatcher("ClienteIndex.jsp").forward(request, response);
                } else {
                    response.sendRedirect("LoginCliente.jsp");
                }
            }catch(SQLException ex){
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            }catch(ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }
    }
}
