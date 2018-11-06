/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import controller.Factory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Funcionario;

/**
 *
 * @author claudio
 */
public class FuncionarioDAO {// Classe do Padrão DAO
    //Padrão Singleton
    private static FuncionarioDAO instance = new FuncionarioDAO();
    private FuncionarioDAO(){}
    public static FuncionarioDAO getInstance(){
        return instance;
    }
    
    public void save(Funcionario funcionario) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement st = null;
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into funcionario (nome, email, funcao, senha) values ( '" + funcionario.getNome() + "', '" + funcionario.getEmail() + "', '" + funcionario.getFuncao() + "', '" + funcionario.getSenha() + "')");
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
            st.execute("delete from funcionario where nome = '" + nome + "'");
        }catch(SQLException e){
            System.out.println("Erro no SQL");
        }finally{
            closeResources(conn, st);
        }
    }
    
    public Funcionario find (String nome) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Funcionario funcionario = null;
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select nome, email from funcionario where nome = '" + nome + "'");
            while(rs.next()){
                funcionario = Factory.createFuncionario(rs.getString("funcao"));
                funcionario.setEmail(rs.getString("emial"));
                funcionario.setNome(rs.getString("nome"));
            }
        }catch(SQLException e){
            System.out.println("Erro no SQL");
            throw e;
        }finally{
            closeResources(conn, st);
        }
        return funcionario;
    }
    
    public String find (int id) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Funcionario funcionario = null;
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select nome, email from funcionario where id = '" + id + "'");
            while(rs.next()){
                funcionario = Factory.createFuncionario(rs.getString("funcao"));
                funcionario.setEmail(rs.getString("emial"));
                funcionario.setNome(rs.getString("nome"));
            }
        }catch(SQLException e){
            System.out.println("Erro no SQL");
            throw e;
        }finally{
            closeResources(conn, st);
        }
        return funcionario.getFuncao();
    }
    
    public void update (String nome, String telefone) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement st = null;
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("update funcionario set telefone = '" + telefone + "' where nome = '" + nome + "'");
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
