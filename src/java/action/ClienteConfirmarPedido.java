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
public class ClienteConfirmarPedido implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException,
     ClassNotFoundException {
        String[] items = request.getParameterValues("item");
        request.setAttribute("id_cliente", Integer.parseInt(request.getParameter("id_cliente")));
        request.setAttribute("id_empresa", Integer.parseInt(request.getParameter("id_empresa")));
        try {
            Class classe = Class.forName("pagamento." + request.getParameter("pagamento"));
            Object objeto = classe.newInstance();
            FormaPagamento fp = (FormaPagamento) objeto;
            List<Produto> itens = new ArrayList<Produto>();
            float total = 0;
            if (items != null) {
                for (String item : items) {
                    Produto p = ProdutoDAO.getInstance().find(Integer.parseInt(item));
                    total = total + p.getValor();
                    itens.add(p);
                }
                total = total - (total * fp.getDesconto() / 100);
                request.setAttribute("pagamento", fp);
                request.setAttribute("total", total);
                request.setAttribute("itens", itens);
                request.getRequestDispatcher("ClienteConfirmarPedido.jsp").forward(request, response);
            } else {
                List<Produto> produtos = EmpresaDAO.getInstance().listProdutos(Integer.parseInt(request.getParameter("id_empresa")));
                FormaPagamento dinheiro = new Dinheiro();
                FormaPagamento cartao = new Cartao();
                request.setAttribute("dinheiro", dinheiro);
                request.setAttribute("cartao", cartao);
                request.setAttribute("produtos", produtos);
                request.getRequestDispatcher("ClienteProdutosEmpresa.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteConfirmarPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ClienteConfirmarPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ClienteConfirmarPedido.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
