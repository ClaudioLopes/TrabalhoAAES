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

/**
 *
 * @author claudio
 */
public class UpdateCliente implements Action{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if(request.getParameter("textNome").equals("") || request.getParameter("textTelefone").equals("")) {
           response.sendRedirect("index.jsp");
        } else {
            try{
                ClienteDAO.getInstance().update(request.getParameter("textNome"), request.getParameter("textTelefone"), request.getParameter("textEmail"),request.getParameter("textSenha"));
                response.sendRedirect("contatoSucesso.jsp");
            }catch(SQLException ex){
                response.sendRedirect("contatoErro.jsp");
                ex.printStackTrace();
            }catch(ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }
    }
}
