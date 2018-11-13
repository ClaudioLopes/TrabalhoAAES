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
public class LoginCliente implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        if (email.equals("") || senha.equals("")) {
            response.sendRedirect("LoginCliente.jsp");
        } else {
            try {
                Cliente cliente = ClienteDAO.getInstance().login(email, senha);
                if (cliente.getNome() != null) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("ClienteIndex.jsp");
                    request.setAttribute("id_cliente", cliente.getId());
                    Integer notificacao = ClienteDAO.getInstance().getNotificacao(cliente.getId());
                    request.setAttribute("ntf", notificacao);
                    dispatcher.forward(request, response);
                } else {
                    response.sendRedirect("LoginCliente.jsp");
                }
            } catch (SQLException ex) {
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}
