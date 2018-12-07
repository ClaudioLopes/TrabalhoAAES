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
/**
 *
 * @author claudio
 */
public class LoginFuncionario implements Action{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if(nome.equals("")) {
           response.sendRedirect("index.jsp");
        } else {
            try{
                String fundionario = null;
                request.setAttribute(fundionario, FuncionarioDAO.getInstance().find(request.getParameter("textNome")));
            }catch(SQLException ex){
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            }catch(ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }
    }
}
