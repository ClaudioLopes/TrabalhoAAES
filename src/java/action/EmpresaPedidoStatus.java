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
import persistence.PedidoDAO;
import state.Pedido;
import strategy.Produto;

/**
 *
 * @author claudio
 */
public class EmpresaPedidoStatus implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("EmpresaPedidoStatus.jsp");
        int id_empresa = Integer.parseInt(request.getParameter("id_empresa"));
        int id_pedido = Integer.parseInt(request.getParameter("id_pedido"));
        try {
            Pedido pedido = PedidoDAO.getInstance().find(id_pedido);
            List<Produto> itens = PedidoDAO.getInstance().listProdutosPedido(id_pedido);
            request.setAttribute("itens", itens);
            request.setAttribute("pedido", pedido);
            request.setAttribute("id_empresa", id_empresa);
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaPedidoStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}