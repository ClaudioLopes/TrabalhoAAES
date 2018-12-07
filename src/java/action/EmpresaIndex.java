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
public class EmpresaIndex implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException,
    ServletException {
        request.setAttribute("id_empresa", Integer.parseInt(request.getParameter("id_empresa")));
        request.getRequestDispatcher("EmpresaIndex.jsp").forward(request, response);
    }
}
