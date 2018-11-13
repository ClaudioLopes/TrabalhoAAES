/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import controller.Factory;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Funcionario;
import persistence.FuncionarioDAO;
import persistence.MementoDAO;
import persistence.PedidoDAO;
import state.Pedido;

/**
 *
 * @author claudio
 */
public class MementoVoltarEstado implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id_pedido = Integer.parseInt(request.getParameter("id_pedido"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("EmpresaPedidoStatus.jsp");
            dispatcher.forward(request, response);
    }
}
