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
public class EmpresaDAO extends DAO{// Classe do Padrão DAO
    //Padrão Singleton

    private static EmpresaDAO instance = new EmpresaDAO();

    private EmpresaDAO() {
    }

    public static EmpresaDAO getInstance() {
        return instance;
    }

    public void save(Empresa empresa) throws SQLException, ClassNotFoundException {
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into empresa (nome, senha, email) values ( '" + empresa.getNome() +
            "', '" + empresa.getSenha() + "', '" + empresa.getEmail() + "')");
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

    public Empresa find(int id) throws SQLException, ClassNotFoundException {
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
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("update empresa set email = '" + email + "', nome = '" + nome +
            "' where id_empresa = " + id + "");
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
            st.execute("update empresa set email = '" + email + "', nome = '" + nome + "', senha = '" + senha + "' where id_empresa = " + id + "");
        } catch (SQLException e) {
            System.out.println("Erro no SQL");
            throw e;
        } finally {
            closeResources(conn, st);
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

    public List<Produto> listProdutos(int id_empresa) {
        List<Produto> produtos = new ArrayList<Produto>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select p.* from produto as p join produto_empresa as pe on pe.id_produto = p.id_produto where pe.id_empresa = " + id_empresa + "");
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
