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
import persistence.ProdutoDAO;
import strategy.Item;
import strategy.Produto;

/**
 *
 * @author claudio
 */
public class ClientePedidoStatus implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException {
        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        int id_empresa = Integer.parseInt(request.getParameter("id_empresa"));
        String[] produtos = request.getParameterValues("item");
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClienteFormaPagamento.jsp");
        FormaPagamento dinheiro = new Dinheiro();
        FormaPagamento cartao = new Cartao();
        request.setAttribute("dinheiro", dinheiro);
        request.setAttribute("cartao", cartao);
        request.setAttribute("produtos", produtos);
        request.setAttribute("id_cliente", id_cliente);
        request.setAttribute("id_empresa", id_empresa);
        dispatcher.forward(request, response);

    }
}
