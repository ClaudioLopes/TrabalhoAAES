package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.jstl.sql.Result;
import model.Cliente;

/**
 *
 * @author claudio
 */
public class ClienteDAO extends DAO { // Classe do Padrão DAO
    //Padrão Singleton

    private static ClienteDAO instance = new ClienteDAO();

    private ClienteDAO() {
    }

    public static ClienteDAO getInstance() {
        return instance;
    }

    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;

    public void closeResources(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL");
        }
    }

    public void closeResources(Connection conn, Statement st, ResultSet rs) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL");
        }
    }

    public void save(Cliente cliente) throws SQLException, ClassNotFoundException {
        conn = null;
        st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into cliente (nome, email, telefone, senha) values ( '" + cliente.getNome() +
             "', '" + cliente.getEmail() + "', '" + cliente.getTelefone() + "', '" + cliente.getSenha() + "')");
        } catch (SQLException e) {
            System.out.println("Erro no SQL");
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public String getSQLDelete(){
      return ("delete from cliente where nome = '");
    }

    public Cliente find(int id) throws SQLException, ClassNotFoundException {
        conn = null;
        st = null;
        rs = null;
        Cliente cliente = new Cliente();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from cliente where id_cliente = " + id + "");
            while (rs.next()) {
                cliente
                        .setEmail(rs.getString("email"))
                        .setNome(rs.getString("nome"))
                        .setSenha(rs.getString("senha"))
                        .setTelefone(rs.getString("telefone"))
                        .setId(id);

            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL");
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return cliente;
    }

    public Cliente find(String nome) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Cliente cliente = new Cliente();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select nome, email from cliente where nome = '" + nome + "'");
            while (rs.next()) {
                cliente.setEmail(rs.getString("emial"));
                cliente.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL");
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return cliente;
    }

    public void update(String nome, String telefone, String email, String senha) throws SQLException,
     ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("update cliente set telefone = '" + telefone + "' where nome = '" + nome + "'");
        } catch (SQLException e) {
            System.out.println("Erro no SQL");
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public Cliente login(String email, String senha) throws SQLException, ClassNotFoundException {
        Cliente cliente = new Cliente();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from cliente where email = '" + email + "' and senha = '" + senha + "'");
            while (rs.next()) {
                cliente
                        .setId(rs.getInt("id_cliente"))
                        .setNome(rs.getString("nome"))
                        .setEmail(rs.getString("email"))
                        .setSenha(rs.getString("senha"));
            }
        } catch (SQLException ex){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st, rs);
            return cliente;
        }
    }
}
