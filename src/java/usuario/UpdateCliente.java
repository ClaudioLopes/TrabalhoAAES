/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import controler.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import persistence.ClienteDAO;

/**
 *
 * @author claudio
 */
public class UpdateCliente implements Usuario{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("textNome");
        String telefone = request.getParameter("textTelefone");
        
        if(nome.equals("") || telefone.equals("")) {
           response.sendRedirect("index.jsp");
        } else {
            try{
                ClienteDAO.getInstance().update(nome, telefone);
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
