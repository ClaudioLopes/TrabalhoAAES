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
public class PedidoDAO {// Classe do Padrão DAO
    //Padrão Singleton

    private static PedidoDAO instance = new PedidoDAO();

    private PedidoDAO() {
    }

    public static PedidoDAO getInstance() {
        return instance;
    }

    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;

    public void save(int id_empresa, int id_cliente, List<Produto> produto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            for(int i = 0; i < produto.size(); i++){
                st.execute("insert into pedido (nome, valor) values ( '" + produto.get(i).getNome() + "', " + produto.get(i).getValor() + ")");
                Pedido p = find(produto.get(i).getNome());
                ProdutoEmpresaDAO.getInstance().save(p.getId(), id_empresa);
            }
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
            st.execute("delete from empresa where nome = '" + nome + "'");
        } catch (SQLException e) {
            System.out.println("Erro no SQL");
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public Pedido find(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Pedido pedido = new Pedido();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from pedido where id_pedido = " + id + "");
            while (rs.next()) {
                pedido
                        .setId(rs.getInt("id_produto"))
                        .setNome(rs.getString("nome"))
                        .setValor(rs.getInt("valor"));
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL");
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return pedido;
    }
    
    public Pedido find(String nome) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Pedido pedido = new Pedido();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from pedido where nome = '" + nome + "'");
            while (rs.next()) {
                pedido
                        .setId(rs.getInt("id_pedido"))
                        .setNome(rs.getString("nome"))
                        .setValor(rs.getInt("valor"));
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL");
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return pedido;
    }

    public void update(int id, String nome, String email) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("update produto set email = '" + email + "', nome = '" + nome + "' where id_produto = " + id + "");
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
            st.execute("update produto set email = '" + email + "', nome = '" + nome + "', senha = '" + senha + "' where id_produto = " + id + "");
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

    public List<Produto> listAll() {
        List<Produto> produtos = new ArrayList<Produto>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select id_empresa, nome from empresa");
            while (rs.next()) {
                Produto produto = new Item();
                produto
                        .setId(rs.getInt("id_produto"))
                        .setNome(rs.getString("nome"))
                        .setValor(rs.getInt("valor"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st, rs);
            return produtos;
        }
    }
}
