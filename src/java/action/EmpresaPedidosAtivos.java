/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Action;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import persistence.PedidoDAO;
import state.Pedido;

/**
 *
 * @author claudio
 */
public class EmpresaPedidosAtivos implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("EmpresaPedidos.jsp");
        int id = Integer.parseInt(request.getParameter("id_empresa"));
        List<Pedido> pedidos = PedidoDAO.getInstance().listPedidosCliente(id);
        request.setAttribute("pedidos", pedidos);
        request.setAttribute("id_empresa", id);
        dispatcher.forward(request, response);
    }
}