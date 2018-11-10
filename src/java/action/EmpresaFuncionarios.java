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
import controller.Action;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import model.Empresa;
import model.Funcionario;
import persistence.ComboDAO;
import persistence.EmpresaDAO;
import persistence.FuncionarioDAO;
import strategy.Combo;
import strategy.Produto;

/**
 *
 * @author claudio
 */
public class EmpresaFuncionarios implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("EmpresaFuncionarios.jsp");
        int id = Integer.parseInt(request.getParameter("id_empresa"));
        List<Funcionario> funcionarios = FuncionarioDAO.getInstance().listFuncionariosEmpresa(id);
        request.setAttribute("funcionarios", funcionarios);
        request.setAttribute("id_empresa", id);
        dispatcher.forward(request, response);
    }
}
