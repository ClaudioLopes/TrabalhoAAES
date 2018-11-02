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

/**
 *
 * @author claudio
 */
public class CadastrarFuncionario implements Action{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("textNome");
        String email = request.getParameter("textEmail");
        String funcao = request.getParameter("textFuncao");
        String senha = request.getParameter("textSenha");
        String superior = request.getParameter("textSuperior");
        
        if(nome.equals("") || email.equals("")) {
           response.sendRedirect("index.jsp");
        } else {
            Funcionario funcionario = Factory.createFuncionario(superior);
            funcionario
                    .setFuncao(funcao)
                    .setEmail(email)
                    .setNome(nome);
            try{
                FuncionarioDAO.getInstance().save(funcionario);
                response.sendRedirect("CadastroSucesso.jsp");
            }catch(SQLException ex){
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            }catch(ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }
    }
}
