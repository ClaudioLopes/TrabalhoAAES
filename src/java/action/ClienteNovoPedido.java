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

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id_cliente"));
        List<Empresa> empresas = EmpresaDAO.getInstance().listAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClienteNovoPedido.jsp");
        request.setAttribute("empresas", empresas);
        request.setAttribute("id_cliente", id);
        Integer notificacao = ClienteDAO.getInstance().getNotificacao(id);
        request.setAttribute("ntf", notificacao);
        dispatcher.forward(request, response);

    }
}
