/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Empresa;
import persistence.EmpresaDAO;

/**
 *
 * @author claudio
 */
public class CadastrarEmpresa implements Usuario{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("textNome");
        String modalidade = request.getParameter("textModalidade");
        
        if(nome.equals("") || modalidade.equals("")) {
           response.sendRedirect("index.jsp");
        } else {
            Empresa empresa = new Empresa(nome, modalidade);
            try{
                EmpresaDAO.getInstance().save(empresa);
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
