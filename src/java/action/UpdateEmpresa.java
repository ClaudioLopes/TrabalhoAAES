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
import persistence.EmpresaDAO;
import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

/**
 *
 * @author claudio
 */
public class UpdateEmpresa implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nome = request.getParameter("textNome");
        String email = request.getParameter("textEmail");
        String senha = request.getParameter("textSenha");
        int id = Integer.parseInt(request.getParameter("id_empresa"));

        RequestDispatcher dispatcher = request.getRequestDispatcher("EmpresaIndex.jsp");
        request.setAttribute("id_empresa", id);

        if (nome.equals("") || email.equals("")) {
            dispatcher.forward(request, response);
        } else {
            try {
                if (senha.equals("")) {
                    EmpresaDAO.getInstance().update(id, nome, email);
                } else {
                    EmpresaDAO.getInstance().update(id, nome, email, senha);
                }
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
