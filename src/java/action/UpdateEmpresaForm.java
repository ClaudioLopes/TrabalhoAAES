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
import model.Empresa;
import persistence.EmpresaDAO;

/**
 *
 * @author claudio
 */
public class UpdateEmpresaForm implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            request.setAttribute("id_empresa", Integer.parseInt(request.getParameter("id_empresa")));
            request.setAttribute("empresa", EmpresaDAO.getInstance().find(Integer.parseInt(request.getParameter("id_empresa"))));
            request.getRequestDispatcher("UpdateEmpresa.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}
