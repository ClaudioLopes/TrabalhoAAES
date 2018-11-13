/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import persistence.ClienteDAO;

/**
 *
 * @author claudio
 */
public class ClienteIndex implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id_cliente"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClienteIndex.jsp");
        request.setAttribute("id_cliente", id);
        Integer notificacao = ClienteDAO.getInstance().getNotificacao(id);
        request.setAttribute("ntf", notificacao);
        dispatcher.forward(request, response);
    }
}
