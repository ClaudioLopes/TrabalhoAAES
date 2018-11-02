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
import model.Cliente;
import persistence.ClienteDAO;
import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

/**
 *
 * @author claudio
 */
public class UpdateClienteForm implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id_cliente"));
        try {
            Cliente cliente = ClienteDAO.getInstance().find(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateCliente.jsp");
            request.setAttribute("cliente", cliente);
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}
