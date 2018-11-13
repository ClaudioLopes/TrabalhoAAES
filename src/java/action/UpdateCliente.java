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
import model.Cliente;
import persistence.ClienteDAO;
import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

/**
 *
 * @author claudio
 */
public class UpdateCliente implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClienteIndex.jsp");
        String nome = request.getParameter("textNome");
        String telefone = request.getParameter("textTelefone");
        String email = request.getParameter("textEmail");
        String senha = request.getParameter("textSenha");
        int id = Integer.parseInt(request.getParameter("id_cliente"));
        request.setAttribute("id_cliente", id);
        if (nome.equals("") || telefone.equals("") || telefone.equals("")) {
            dispatcher = request.getRequestDispatcher("UpdateCliente.jsp");
            dispatcher.forward(request, response);
        } else {
            try {
                if (senha.equals("")) {
                    ClienteDAO.getInstance().update(id, nome, telefone, email);
                } else {
                    ClienteDAO.getInstance().update(id, nome, telefone, email, senha);
                }
                Integer notificacao = ClienteDAO.getInstance().getNotificacao(id);
                request.setAttribute("ntf", notificacao);
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
