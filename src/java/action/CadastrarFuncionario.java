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
public class CadastrarFuncionario implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("EmpresaIndex.jsp");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String funcao = request.getParameter("funcao");
        String senha = request.getParameter("senha");
        int id_empresa = Integer.parseInt(request.getParameter("id_empresa"));
        request.setAttribute("id_empresa", id_empresa);
        if (nome.equals("") || email.equals("") || senha.equals("")) {
            dispatcher = request.getRequestDispatcher("CadastrarFuncionario.jsp");
            dispatcher.forward(request, response);
        } else {
            try {
                Funcionario funcionario = Factory.createFuncionario(funcao);
                Integer id_func_superior = FuncionarioDAO.getInstance().findSuperiorId(funcionario.getFuncionarioSuperior().getFuncao(), id_empresa);
                funcionario
                        .setEmail(email)
                        .setNome(nome)
                        .setSenha(senha);
                FuncionarioDAO.getInstance().save(funcionario, id_empresa, id_func_superior);
                dispatcher.forward(request, response);
            } catch (SQLException ex) {
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}
