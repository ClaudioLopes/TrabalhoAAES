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
import model.Empresa;
import persistence.EmpresaDAO;
import controller.Action;

/**
 *
 * @author claudio
 */
public class CadastrarEmpresa implements Action{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if(nome.equals("") || senha.equals("")) {
           response.sendRedirect("index.jsp");
        } else {
            Empresa empresa = new Empresa();
            empresa
                    .setNome(request.getParameter("textNome"))
                    .setSenha(request.getParameter("textSenha"))
                    .setEmail(request.getParameter("textEmail"));
            try{
                EmpresaDAO.getInstance().save(empresa);
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
