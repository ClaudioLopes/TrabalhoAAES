package persistence;

import controller.Factory;
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
import strategy.Combo;
import strategy.Item;
import strategy.Produto;

/**
 *
 * @author claudio
 */
public class ComboDAO {// Classe do Padrão DAO
    //Padrão Singleton

    private static ComboDAO instance = new ComboDAO();

    private ComboDAO() {
    }

    public static ComboDAO getInstance() {
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

    public void save(int id_empresa, Combo combo) {
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into combo (id_empresa, nome, total) values (" + id_empresa + ", '" + combo.getNome() + "', " + combo.getValor() + ")");
            rs = st.executeQuery("select max(id_combo) as id_combo from combo");
            Integer id_combo = null;
            while (rs.next()) {
                id_combo = rs.getInt("id_combo");
            }
            for (Produto produto : combo.getProdutos()) {
                st.execute("insert into produto_combo (id_produto, id_combo) values (" + produto.getId() + ", " + id_combo + ")");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Combo> listCombos(int id_empresa) {
        List<Combo> combos = new ArrayList<>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from combo where id_empresa = " + id_empresa + "");
            while(rs.next()) {
                Combo c = new Combo();
                List<Produto> p = listProdutosCombo(rs.getInt("id_combo"));
                c
                        .setNome(rs.getString("nome"))
                        .setValor(rs.getDouble("total"))
                        .setId_combo(rs.getInt("id_combo"))
                        .setProdutos(p);
                combos.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return combos;
    }

    public List<Produto> listProdutosCombo(int id_combo) {
        List<Produto> produtos = new ArrayList<Produto>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select p.* from produto as p join produto_combo pc pe on pc.id_produto = p.id_produto where pc.id_combo = " + id_combo  + "");
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
