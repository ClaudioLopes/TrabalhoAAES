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
import strategy.Item;
import strategy.Produto;

/**
 *
 * @author claudio
 */
public class ProdutoEmpresaDAO extends DAO{// Classe do Padrão DAO
    //Padrão Singleton

    private static ProdutoEmpresaDAO instance = new ProdutoEmpresaDAO();

    private ProdutoEmpresaDAO() {
    }

    public static ProdutoEmpresaDAO getInstance() {
        return instance;
    }

    public void save(int id_produto, int id_empresa) throws SQLException, ClassNotFoundException {
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into produto_empresa (id_produto, id_empresa) values ( " + id_produto +
             ", " + id_empresa + ")");
        } catch (SQLException e) {
            System.out.println("Erro no SQL");
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public String getSQLDeleteByName(String nome){
      return ("delete from empresa where nome = '" + nome + "'");
    }

    public Produto find(int id) throws SQLException, ClassNotFoundException {
        Produto produto = new Item();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from produto where id_produto = " + id + "");
            while (rs.next()) {
                produto
                        .setId(rs.getInt("id_empresa"))
                        .setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL");
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return produto;
    }

    public void update(int id, String nome, String email) throws SQLException, ClassNotFoundException {
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
            Logger.getLogger(ProdutoEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st, rs);
            return produtos;
        }
    }
}
