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
public class EmpresaDAO {// Classe do Padrão DAO
    //Padrão Singleton

    private static EmpresaDAO instance = new EmpresaDAO();

    private EmpresaDAO() {
    }

    public static EmpresaDAO getInstance() {
        return instance;
    }

    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;

    public void save(Empresa empresa) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into empresa (nome, senha, email) values ( '" + empresa.getNome() + "', '" + empresa.getSenha() + "', '" + empresa.getEmail() + "')");
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

    public Empresa find(String nome) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Empresa empresa = new Empresa();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select nome, email from cliente where nome = '" + nome + "'");
            while (rs.next()) {
                empresa.setId(Integer.valueOf(rs.getString("id")));
                empresa.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL");
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return empresa;
    }

    public void update(String nome, String modalidade) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("update empresa set modalidade = '" + modalidade + "' where nome = '" + nome + "'");
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

    public List<Empresa> listAll() {
        List<Empresa> empresas = new ArrayList<Empresa>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select id_empresa, nome from empresa");
            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa
                        .setId(rs.getInt("id_empresa"))
                        .setNome(rs.getString("nome"));
                empresas.add(empresa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st, rs);
            return empresas;
        }
    }

    public Empresa login(String email, String senha) throws SQLException, ClassNotFoundException {
        Empresa empresa = new Empresa();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from empresa where email = '" + email + "' and senha = '" + senha + "'");
            while (rs.next()) {
                empresa
                        .setId(rs.getInt("id_empresa"))
                        .setNome(rs.getString("nome"))
                        .setEmail(rs.getString("email"))
                        .setSenha(rs.getString("senha"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st, rs);
            return empresa;
        }

    }

    public List<Produto> listProdutos() {
        List<Produto> produtos = new ArrayList<Produto>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select e.id_empresa, p.* from produtos as p join empresa as e join produto_empresa as pe on pe.id_empresa = e.id_empresa and pe.id_produto = p.id_produto");
            while(rs.next()) {
                Produto produto = new Item();
                produto
                        .setNome(rs.getString("nome"))
                        .setValor(rs.getInt("valor"))
                        .setId(rs.getInt("id_produto"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }
}
