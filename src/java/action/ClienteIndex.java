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

/**
 *
 * @author claudio
 */
public class ClienteIndex implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException,
     ServletException {
        request.setAttribute("id_cliente", Integer.parseInt(request.getParameter("id_cliente")));
        request.getRequestDispatcher("ClienteIndex.jsp").forward(request, response);

    }
}
