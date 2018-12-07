package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.jstl.sql.Result;
import model.Cliente;

public abstract class DAO {

    protected Connection conn = null;
    protected Statement st = null;
    protected ResultSet rs = null;
    
    public abstract String getSQLDeleteByName(String nome);

    public DAO() {

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

    public void delete(String nome) throws SQLException, ClassNotFoundException {
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute(getSQLDeleteByName(nome));
        } catch (SQLException e) {
            System.out.println("Erro no SQL");
        } finally {
            closeResources(conn, st);
        }
    }
}
