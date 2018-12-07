/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Factory;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;
import persistence.FuncionarioDAO;
import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

/**
 *
 * @author claudio
 */
public class CadastrarFuncionario implements Action{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("id_empresa", Integer.parseInt(request.getParameter("id_empresa")));
        if(request.getParameter("nome").equals("") || request.getParameter("email").equals("") || request.getParameter("senha").equals("")) {
           request.getRequestDispatcher("CadastrarFuncionario.jsp").forward(request, response);
        } else {
            Funcionario funcionario = Factory.createFuncionario(request.getParameter("funcao"));
            funcionario
                    .setEmail(request.getParameter("email"))
                    .setNome(request.getParameter("nome"))
                    .setSenha(request.getParameter("senha"));
            try{
                FuncionarioDAO.getInstance().save(funcionario);
                request.getRequestDispatcher("EmpresaIndex.jsp").forward(request, response);
            }catch(SQLException ex){
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            }catch(ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }
    }
}
