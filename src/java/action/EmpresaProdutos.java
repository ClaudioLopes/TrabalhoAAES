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
import controller.Action;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import model.Empresa;
import persistence.EmpresaDAO;
import strategy.Produto;

/**
 *
 * @author claudio
 */
public class EmpresaProdutos implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id_empresa"));
        List<Produto> produtos = EmpresaDAO.getInstance().listProdutos();
        RequestDispatcher dispatcher = request.getRequestDispatcher("EmpresaProdutos.jsp");
        request.setAttribute("produtos", produtos);
        request.setAttribute("id_empresa", id);
        dispatcher.forward(request, response);

    }
}
