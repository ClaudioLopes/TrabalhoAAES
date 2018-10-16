package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Cliente;
import model.Empresa;

/**
 *
 * @author claudio
 */
public class EmpresaDAO {// Classe do Padrão DAO
    //Padrão Singleton
    private static EmpresaDAO instance = new EmpresaDAO();
    private EmpresaDAO(){}
    public static EmpresaDAO getInstance(){
        return instance;
    }
    
    public void save(Empresa empresa) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement st = null;
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into empresa () values ( '" + empresa.getNome() + "', '" + empresa.getId()+ "')");
        }catch(SQLException e){
            System.out.println("Erro no SQL");
            throw e;
        }finally{
            closeResources(conn, st);
        }
    }
    
    public void delete(String nome) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement st = null;
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("delete from empresa where nome = '" + nome + "'");
        }catch(SQLException e){
            System.out.println("Erro no SQL");
            throw e;
        }finally{
            closeResources(conn, st);
        }
    }
    
    public Empresa find (String nome) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Empresa empresa = new Empresa();
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select nome, email from cliente where nome = '" + nome + "'");
            while(rs.next()){
                empresa.setId(Integer.valueOf(rs.getString("id")));
                empresa.setNome(rs.getString("nome"));
            }
        }catch(SQLException e){
            System.out.println("Erro no SQL");
            throw e;
        }finally{
            closeResources(conn, st);
        }
        return empresa;
    }
    
    public void update (Empresa empresa) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement st = null;
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("update empresa set nome = '" + empresa.getNome() + "' where id = '" + empresa.getId() + "'");
        }catch(SQLException e){
            System.out.println("Erro no SQL");
            throw e;
        }finally{
            closeResources(conn, st);
        }
    }
    
    public void closeResources(Connection conn, Statement st){
        try{
            if(st != null){
                st.close();
            }
            if(conn != null){
                conn.close();
            }
        }catch(SQLException e){
            System.out.println("Erro no SQL");
        }
    }
    
}
