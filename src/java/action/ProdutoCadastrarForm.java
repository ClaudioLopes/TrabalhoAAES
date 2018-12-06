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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import strategy.Item;
import strategy.Produto;

/**
 *
 * @author claudio
 */
public class ProdutoCadastrarForm implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException,
     ServletException {
        request.setAttribute("id_empresa", Integer.parseInt(request.getParameter("id_empresa"));
        request.getRequestDispatcher("ProdutoCadastrar.jsp").forward(request, response);
    }
}
