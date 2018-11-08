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
import strategy.Combo;
import strategy.Item;
import strategy.Produto;

/**
 *
 * @author claudio
 */
public class EmpresaConfirmarCombo implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("EmpresaConfirmarCombo.jsp");
        int id_empresa = Integer.parseInt(request.getParameter("id_empresa"));
        String[] items = request.getParameterValues("item");
        String nome = request.getParameter("nome");
        try {
            List<Produto> itens = new ArrayList<Produto>();
            if (items != null) {
                for (String item : items) {
                    int id_produto = Integer.parseInt(item);
                    Produto p = ProdutoDAO.getInstance().find(id_produto);
                    itens.add(p);
                }
                Combo combo = new Combo(itens, nome);
                request.setAttribute("itens", itens);
                request.setAttribute("id_empresa", id_empresa);
                request.setAttribute("combo", combo);
                dispatcher.forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaConfirmarCombo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
