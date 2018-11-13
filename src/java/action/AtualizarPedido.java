/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import controller.Factory;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Funcionario;
import persistence.FuncionarioDAO;
import persistence.PedidoDAO;
import state.Pedido;

/**
 *
 * @author claudio
 */
public class AtualizarPedido implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id_funcionario"));
        int id_pedido = Integer.parseInt(request.getParameter("id_pedido"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("FuncionarioPedidos.jsp");
        try {
            Funcionario funcionario = Factory.createFuncionario(FuncionarioDAO.getInstance().find(id));
            Pedido pedido = PedidoDAO.getInstance().find(id_pedido);
            funcionario.atualizarPedido(pedido);
            Cliente c = new Cliente(pedido);
            pedido.setPedidoEstado(pedido.getPedidoEstado());
            if (FuncionarioDAO.getInstance().getFuncionarioSuperior(id) != null) {
                int id_novo_responsavel = FuncionarioDAO.getInstance().getFuncionarioSuperior(id).getId();
                PedidoDAO.getInstance().atualizaStatus(id_pedido, id_novo_responsavel, pedido.getNomeEstado());
            } else 
                PedidoDAO.getInstance().atualizaStatus(id_pedido, null, pedido.getNomeEstado());
            request.setAttribute("id_funcionario", id);
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            response.sendRedirect("contatoErro.jsp");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
