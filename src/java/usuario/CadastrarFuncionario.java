/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import controler.Factory;
import controler.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;
import persistence.FuncionarioDAO;

/**
 *
 * @author claudio
 */
public class CadastrarFuncionario implements Usuario{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("textNome");
        String email = request.getParameter("textEmail");
        String funcao = request.getParameter("textFuncao");
        String superior = request.getParameter("textSuperior");
        
        if(nome.equals("") || email.equals("")) {
           response.sendRedirect("index.jsp");
        } else {
            Funcionario funcionario = Factory.createFuncionario(superior);
            funcionario.setFuncao(funcao);
            funcionario.setEmail(email);
            funcionario.setNome(nome);
            try{
                FuncionarioDAO.getInstance().save(funcionario);
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
