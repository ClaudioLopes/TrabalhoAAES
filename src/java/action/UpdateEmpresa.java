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
import persistence.EmpresaDAO;
import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

/**
 *
 * @author claudio
 */
public class UpdateEmpresa implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException,
     ServletException {
        request.setAttribute("id_empresa", Integer.parseInt(request.getParameter("id_empresa")));

        if (request.getParameter("textNome").equals("") || request.getParameter("textEmail").equals("")) {
            request.getRequestDispatcher("EmpresaIndex.jsp").forward(request, response);
        } else {
            try {
                if (request.getParameter("textSenha").equals("")) {
                    EmpresaDAO.getInstance().update(Integer.parseInt(request.getParameter("id_empresa")),
                     request.getParameter("textNome"), request.getParameter("textEmail"));
                } else {
                    EmpresaDAO.getInstance().update(Integer.parseInt(request.getParameter("id_empresa")),
                     request.getParameter("textNome"), request.getParameter("textEmail"),
                    request.getParameter("textSenha"));
                }
                request.getRequestDispatcher("EmpresaIndex.jsp").forward(request, response);
            } catch (SQLException ex) {
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}
