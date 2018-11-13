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
import controller.Factory;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import model.Empresa;
import pagamento.Cartao;
import pagamento.Dinheiro;
import pagamento.FormaPagamento;
import persistence.EmpresaDAO;
import persistence.PedidoDAO;
import persistence.ProdutoDAO;
import state.Pedido;
import state.PedidoEstadoConfirmado;
import state.PedidoEstadoEmProdução;
import strategy.Item;
import strategy.Produto;

/**
 *
 * @author claudio
 */
public class ClientePedidoConcluido implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException {
        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        int id_empresa = Integer.parseInt(request.getParameter("id_empresa"));
        String[] items = request.getParameterValues("item");
        double total = Float.parseFloat(request.getParameter("total"));
        String pagamento = request.getParameter("pagamento");
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClientePedidoStatus.jsp");
        request.setAttribute("id_cliente", id_cliente);
        request.setAttribute("id_empresa", id_empresa);
        Integer notificacao = ClienteDAO.getInstance().getNotificacao(id_cliente);
        request.setAttribute("ntf", notificacao);
        try {
            List<Produto> itens = new ArrayList<Produto>();
            for (String item : items) {
                int id_produto = Integer.parseInt(item);
                Produto p = ProdutoDAO.getInstance().find(id_produto);
                itens.add(p);
            }
            FormaPagamento pg = Factory.createFormaPagamento(pagamento);
            Pedido pedido = new Pedido();
            pedido
                    .setProduto(itens)
                    .setNomeEstado(new PedidoEstadoConfirmado().getEstado())
                    .setValor(total)
                    .setFormaPagamento(pg);
            PedidoDAO.getInstance().save(id_empresa, id_cliente, pedido);
            pedido = PedidoDAO.getInstance().findLast(id_empresa, id_cliente);
            pedido.setPedidoEstado(new PedidoEstadoConfirmado());
            request.setAttribute("itens", itens);
            List<Produto> produtos = EmpresaDAO.getInstance().listProdutos(id_empresa);
            request.setAttribute("produtos", produtos);
            request.setAttribute("pedido", pedido);
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ClientePedidoConcluido.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
