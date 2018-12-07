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
import model.Empresa;

/**
 *
 * @author claudio
 */
public class LoginEmpresa implements Action{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException,
     ServletException {

        if(request.getParameter("email").equals("") || request.getParameter("senha").equals("")) {
           response.sendRedirect("LoginEmpresa.jsp");
        } else {
            try{
                Empresa empresa = EmpresaDAO.getInstance().login(request.getParameter("email"), request.getParameter("senha"));
                if(empresa.getNome() != null) {
                    request.setAttribute("id_empresa", empresa.getId());
                    request.getRequestDispatcher("EmpresaIndex.jsp").forward(request, response);
                } else {
                    response.sendRedirect("LoginEmpresa.jsp");
                }
            }catch(SQLException ex){
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            }catch(ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }
    }
}
