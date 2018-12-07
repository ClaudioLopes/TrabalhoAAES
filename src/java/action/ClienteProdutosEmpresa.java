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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import model.Empresa;
import pagamento.Cartao;
import pagamento.Dinheiro;
import pagamento.FormaPagamento;
import persistence.EmpresaDAO;
import persistence.PedidoDAO;
import persistence.ProdutoDAO;
import state.Pedido;
import strategy.Produto;

/**
 *
 * @author claudio
 */
public class ClienteProdutosEmpresa implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException,
     ServletException {
        FormaPagamento dinheiro = new Dinheiro();
        FormaPagamento cartao = new Cartao();
        request.setAttribute("dinheiro", dinheiro);
        request.setAttribute("cartao", cartao);
        request.setAttribute("produtos", EmpresaDAO.getInstance().listProdutos(id_empresa));
        request.setAttribute("id_cliente", Integer.parseInt(request.getParameter("id_cliente")));
        request.setAttribute("id_empresa", Integer.parseInt(request.getParameter("id_empresa")));
        request.getRequestDispatcher("ClienteProdutosEmpresa.jsp").forward(request, response);
        Pedido pedido = new Pedido();
        try{
            pedido.setProduto(produtos);
            PedidoDAO.getInstance().save(id_empresa, id_cliente,produtos);
            response.sendRedirect("CadastrarSucesso.jsp");
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteProdutosEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
