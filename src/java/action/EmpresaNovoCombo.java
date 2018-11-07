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
public class EmpresaNovoCombo implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException {
        int id_empresa = Integer.parseInt(request.getParameter("id_empresa"));
        List<Produto> produtos = EmpresaDAO.getInstance().listProdutos(id_empresa);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EmpresaNovoCombo.jsp");
        request.setAttribute("produtos", produtos);
        request.setAttribute("id_empresa", id_empresa);
        dispatcher.forward(request, response);
    }

}
