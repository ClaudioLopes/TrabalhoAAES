package usuario;

import controler.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ClienteDAO;

/**
 *
 * @author claudio
 */
public class DeletarCliente implements Usuario{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("textNome");
        
        if(nome.equals("")) {
           response.sendRedirect("index.jsp");
        } else {
            try{
                ClienteDAO.getInstance().delete(nome);
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
