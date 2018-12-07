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
public class ProdutoDAO extends DAO{// Classe do Padrão DAO
    //Padrão Singleton

    private static ProdutoDAO instance = new ProdutoDAO();

    private ProdutoDAO() {
    }

    public static ProdutoDAO getInstance() {
        return instance;
    }

    public void save(int id_empresa, Produto produto) throws SQLException, ClassNotFoundException {
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into produto (nome, valor) values ( '" + produto.getNome() +
            "', " + produto.getValor() + ")");
            Produto p = find(produto.getNome());
            ProdutoEmpresaDAO.getInstance().save(p.getId(), id_empresa);
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
        return produto;
    }

    public Produto find(String nome) throws SQLException, ClassNotFoundException {
        Produto produto = new Item();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from produto where nome = '" + nome + "'");
            while (rs.next()) {
                produto
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
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st, rs);
            return produtos;
        }
    }
}
