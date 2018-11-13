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
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import pagamento.Cartao;
import pagamento.Dinheiro;
import pagamento.FormaPagamento;
import persistence.ClienteDAO;
import persistence.PedidoDAO;
import state.Pedido;
import strategy.Produto;

/**
 *
 * @author claudio
 */
public class ClientePedidoStatus implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClientePedidoStatus.jsp");
        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        int id_pedido = Integer.parseInt(request.getParameter("id_pedido"));
        try {
            Pedido pedido = PedidoDAO.getInstance().find(id_pedido);
            List<Produto> itens = PedidoDAO.getInstance().listProdutosPedido(id_pedido);
            request.setAttribute("itens", itens);
            request.setAttribute("pedido", pedido);
            request.setAttribute("id_cliente", id_cliente);
            Integer notificacao = ClienteDAO.getInstance().getNotificacao(id_cliente);
            request.setAttribute("ntf", notificacao);
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ClientePedidoStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
