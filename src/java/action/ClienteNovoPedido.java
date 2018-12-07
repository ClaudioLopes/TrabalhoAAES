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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import model.Empresa;
import persistence.EmpresaDAO;

/**
 *
 * @author claudio
 */
public class ClienteNovoPedido implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException,
     ServletException {
        request.setAttribute("empresas", EmpresaDAO.getInstance().listAll());
        request.setAttribute("id_cliente", Integer.parseInt(request.getParameter("id_cliente")));
        request.getRequestDispatcher("ClienteNovoPedido.jsp").forward(request, response);

    }
}
