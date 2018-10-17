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
import persistence.EmpresaDAO;

/**
 *
 * @author claudio
 */
public class DeletarEmpresa implements Usuario{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("textNome");
        
        if(nome.equals("")) {
           response.sendRedirect("index.jsp");
        } else {
            try{
                EmpresaDAO.getInstance().delete(nome);
                response.sendRedirect("apagarSucesso.jsp");
            }catch(SQLException ex){
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            }catch(ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }
    }
}
