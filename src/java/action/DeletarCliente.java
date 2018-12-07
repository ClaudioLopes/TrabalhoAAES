package action;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ClienteDAO;
import controller.Action;

/**
 *
 * @author claudio
 */
public class DeletarCliente implements Action{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if(request.getParameter("textNome").equals("")) {
           response.sendRedirect("index.jsp");
        } else {
            try{
                ClienteDAO.getInstance().delete(request.getParameter("textNome"));
                response.sendRedirect("apagarSucesso.jsp");
            }catch(SQLException ex){
                response.sendRedirect("Erro.jsp");
                ex.printStackTrace();
            }catch(ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }
    }
}
