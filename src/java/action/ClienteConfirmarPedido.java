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
import persistence.EmpresaDAO;
import persistence.ProdutoDAO;
import strategy.Item;
import strategy.Produto;

/**
 *
 * @author claudio
 */
public class ClienteConfirmarPedido implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException {
        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        int id_empresa = Integer.parseInt(request.getParameter("id_empresa"));
        String[] produtos = request.getParameterValues("item");
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClienteConfirmarPedido.jsp");
        List<Produto> itens = new ArrayList<Produto>();
        int total = 0;
        for (String produto : produtos) {
            int id_produto = Integer.parseInt(produto);
            try {
                Produto p = ProdutoDAO.getInstance().find(id_produto);
                total = total + p.getValor();
                itens.add(p);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteConfirmarPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        request.setAttribute("total", total);
        request.setAttribute("itens", itens);
        request.setAttribute("id_cliente", id_cliente);
        request.setAttribute("id_empresa", id_empresa);
        dispatcher.forward(request, response);

    }
}
