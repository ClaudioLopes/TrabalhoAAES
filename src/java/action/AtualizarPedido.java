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
import model.Funcionario;
import persistence.FuncionarioDAO;
import persistence.PedidoDAO;
import state.Pedido;

/**
 *
 * @author claudio
 */
public class AtualizarPedido implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException,
    ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("FuncionarioPedidoStatus.jsp");
        dispatcher.forward(request, response);
        try{
            Funcionario funcionario = Factory.createFuncionario(FuncionarioDAO.getInstance().find(Integer.parseInt
            (request.getParameter("id_funcionario"))));
            Pedido pedido = PedidoDAO.getInstance().find(Integer.parseInt(request.getParameter("id_pedido")));
            funcionario.atualizarPedido(PedidoDAO.getInstance().find(Integer.parseInt(request.getParameter
            ("id_pedido"))));
            response.sendRedirect("contatoSucesso.jsp");
        }catch(SQLException ex){
                response.sendRedirect("contatoErro.jsp");
                ex.printStackTrace();
            }catch(ClassNotFoundException ex){
                ex.printStackTrace();
            }
    }
}
