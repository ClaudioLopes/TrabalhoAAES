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
import persistence.FuncionarioDAO;
import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
/**
 *
 * @author claudio
 */
public class LoginFuncionario implements Action{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        RequestDispatcher dispatcher = request.getRequestDispatcher("FuncionarioIndex.jsp");
        if(email.equals("") || senha.equals("")) {
           response.sendRedirect("LoginFuncionario.jsp");
        } else {
            try{
                int id_funcionario = FuncionarioDAO.getInstance().login(email, senha);
                request.setAttribute("id_funcionario", id_funcionario);
                dispatcher.forward(request, response);
            }catch(SQLException ex){
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            }catch(ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }
    }
}
