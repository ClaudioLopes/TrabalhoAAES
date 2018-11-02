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
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        if(email.equals("") || senha.equals("")) {
           response.sendRedirect("LoginEmpresa.jsp");
        } else {
            try{
                Empresa empresa = EmpresaDAO.getInstance().login(email, senha);
                if(empresa.getNome() != null) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("EmpresaIndex.jsp");
                    request.setAttribute("id_empresa", empresa.getId());
                    dispatcher.forward(request, response);
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
