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
public class CadastrarCliente implements Action{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if(request.getParameter("textNome").equals("") || request.getParameter("textEmail").equals("")) {
           response.sendRedirect("index.jsp");
        } else {
            Cliente cliente = new Cliente();
            cliente.setNome(request.getParameter("textNome"))
                   .setEmail(request.getParameter("textEmail"))
                   .setTelefone(request.getParameter("textTelefone"))
                   .setSenha(request.getParameter("textSenha"));
            try{
                ClienteDAO.getInstance().save(cliente);
                response.sendRedirect("CadastrarSucesso.jsp");
            }catch(SQLException ex){
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            }catch(ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }
    }
}
