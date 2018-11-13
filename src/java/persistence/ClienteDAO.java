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
public class ClienteDAO { // Classe do Padrão DAO
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
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into cliente (nome, email, telefone, senha) values ( '" + cliente.getNome() + "', '" + cliente.getEmail() + "', '" + cliente.getTelefone() + "', '" + cliente.getSenha() + "')");
        } catch (SQLException e) {
            System.out.println("Erro no SQL");
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void delete(String nome) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("delete from cliente where nome = '" + nome + "'");
        } catch (SQLException e) {
            System.out.println("Erro no SQL");
        } finally {
            closeResources(conn, st);
        }
    }

    public Cliente find(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
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

    public void update(int id_cliente, String nome, String telefone, String email, String senha) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.executeUpdate("update cliente set telefone = '" + telefone + "', nome = '" + nome + "', email = '" + email + "', senha = '" + senha + "' where id_cliente = '" + id_cliente + "'");
        } catch (SQLException e) {
            System.out.println("Erro no SQL");
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void update(int id_cliente, String nome, String telefone, String email) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.executeUpdate("update cliente set telefone = '" + telefone + "', nome = '" + nome + "', email = '" + email + "' where id_cliente = " + id_cliente + "");
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
    
    public Integer getNotificacao(int id_usuario) {
        Integer contador = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select notify from cliente where id_cliente = " + id_usuario + "");
            while(rs.next()) {
                contador = rs.getInt("notify");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st, rs);
        }
        return contador;
    }
    
    public void notifica(int id_cliente) {
        try {
            Integer contador = getNotificacao(id_cliente);
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            contador++;
            st.executeUpdate("update cliente set notify = " + contador + " where id_cliente = " + id_cliente + "");
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st);
        }
    }
    
    public void zerarNotify(int id_cliente) {
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.executeUpdate("update cliente set notify = 0 where id_cliente = " + id_cliente + "");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st);
        }
    }
}
