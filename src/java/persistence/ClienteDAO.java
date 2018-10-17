package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.jsp.jstl.sql.Result;
import model.Cliente;

/**
 *
 * @author claudio
 */
public class ClienteDAO { // Classe do Padrão DAO
    //Padrão Singleton
    private static ClienteDAO instance = new ClienteDAO();
    private ClienteDAO(){}
    public static ClienteDAO getInstance(){
        return instance;
    }
    
    public void save(Cliente cliente) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement st = null;
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into cliente () values ( '" + cliente.getNome() + "', '" + cliente.getEmail() + "')");
        }catch(SQLException e){
            System.out.println("Erro no SQL");
            throw e;
        }finally{
            closeResources(conn, st);
        }
    }
    
    public void delete(String nome) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement st = null;
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("delete from cliente where nome = '" + nome + "'");
        }catch(SQLException e){
            System.out.println("Erro no SQL");
        }finally{
            closeResources(conn, st);
        }
    }
    
    public Cliente find (String nome) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Cliente cliente = new Cliente();
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select nome, email from cliente where nome = '" + nome + "'");
            while(rs.next()){
                cliente.setEmail(rs.getString("emial"));
                cliente.setNome(rs.getString("nome"));
            }
        }catch(SQLException e){
            System.out.println("Erro no SQL");
            throw e;
        }finally{
            closeResources(conn, st);
        }
        return cliente;
    }
    
    public void update (String nome, String telefone) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement st = null;
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("update cliente set telefone = '" + telefone + "' where nome = '" + nome + "'");
        }catch(SQLException e){
            System.out.println("Erro no SQL");
            throw e;
        }finally{
            closeResources(conn, st);
        }
    }
    
    public void closeResources(Connection conn, Statement st){
        try{
            if(st != null){
                st.close();
            }
            if(conn != null){
                conn.close();
            }
        }catch(SQLException e){
            System.out.println("Erro no SQL");
        }
    }
}
