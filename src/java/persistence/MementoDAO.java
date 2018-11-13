package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Empresa;
import state.Pedido;
import strategy.Item;
import strategy.Produto;

/**
 *
 * @author claudio
 */
public class MementoDAO {// Classe do Padrão DAO
    //Padrão Singleton

    private static MementoDAO instance = new MementoDAO();

    private MementoDAO() {
    }

    public static MementoDAO getInstance() {
        return instance;
    }

    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;

    public void save(Pedido pedido) throws SQLException, ClassNotFoundException {
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into memento (id_pedido, id_funcionario, nome_estado) values ( " + pedido.getId() + ", " + pedido.getId_funcionario() + ", '" + pedido.getNomeEstado() + "')");
        } catch (SQLException e) {
            System.out.println("Erro no SQL");
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public Empresa find(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Empresa empresa = new Empresa();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from empresa where id_empresa = " + id + "");
            while (rs.next()) {
                empresa
                        .setId(rs.getInt("id_empresa"))
                        .setNome(rs.getString("nome"))
                        .setEmail(rs.getString("email"))
                        .setSenha(rs.getString("senha"));
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL");
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return empresa;
    }

    public void update(int id, String nome, String email) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("update empresa set email = '" + email + "', nome = '" + nome + "' where id_empresa = " + id + "");
        } catch (SQLException e) {
            System.out.println("Erro no SQL");
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void update(int id, String nome, String email, String senha) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("update empresa set email = '" + email + "', nome = '" + nome + "', senha = '" + senha + "' where id_empresa = " + id + "");
        } catch (SQLException e) {
            System.out.println("Erro no SQL");
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

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
}
