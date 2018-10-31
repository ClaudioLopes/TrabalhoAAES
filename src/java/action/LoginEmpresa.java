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
import persistence.EmpresaDAO;

/**
 *
 * @author claudio
 */
public class LoginEmpresa implements Usuario{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("textNome");
        String senha = request.getParameter("textSenha");
        
        if(nome.equals("")) {
           response.sendRedirect("index.jsp");
        } else {
            try{
                String empresa = null;
                request.setAttribute(empresa, EmpresaDAO.getInstance().find(nome));
                /*if(cliente.getSenha() == senha){
                    RequestDispatcher view = request.getRequestDispatcher("/ExibirContato.jsp");
                    view.forward(request, response);
                }*/ // Cria um jeito de autenticar o usuario
            }catch(SQLException ex){
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            }catch(ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }
    }
}
