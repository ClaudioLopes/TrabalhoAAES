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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Funcionario;
import state.Pedido;

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
    
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    
    public void save(Funcionario funcionario, int id_empresa) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement st = null;
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into funcionario (id_empresa, nome, email, funcao, senha) values (" + id_empresa + ", '" + funcionario.getNome() + "', '" + funcionario.getEmail() + "', '" + funcionario.getFuncao() + "', '" + funcionario.getSenha() + "')");
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
            rs = st.executeQuery("select * from funcionario where id_funcionario = " + id + "");
            while(rs.next()){
                funcionario = Factory.createFuncionario(rs.getString("funcao"));
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
    
    public List<Funcionario> listFuncionariosEmpresa(int id_empresa) {
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from funcionario where id_empresa = " + id_empresa + "");
            while(rs.next()) {
                Funcionario f = Factory.createFuncionario(rs.getString("funcao"));
                f
                        .setId(rs.getInt("id_funcionario"))
                        .setEmail(rs.getString("email"))
                        .setFuncao(rs.getString("funcao"))
                        .setNome(rs.getString("nome"));
                funcionarios.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st, rs);
        }
        return funcionarios;
    }
    
    public Funcionario getFuncionarioSuperior(int id_funcionario) {
        Funcionario funcionario = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from funcionario as f join superior as s on s.id_funcionario = " + id_funcionario + " where s.id_superior = f.id_funcionario");
            while(rs.next()) {
                funcionario = Factory.createFuncionario(rs.getString("funcao"));
                funcionario
                        .setEmail(rs.getString("email"))
                        .setId(rs.getInt("id_funcionario"))
                        .setNome(rs.getString("nome"))
                        .setSenha(rs.getString("senha"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st, rs);
        }
        return funcionario;
    }
    
    public int login(String email, String senha) throws SQLException, ClassNotFoundException {
        Integer id_funcionario = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select id_funcionario from funcionario where email = '" + email + "' and senha = '" + senha + "'");
            while (rs.next()) {
                id_funcionario = rs.getInt("id_funcionario");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st, rs);
            return id_funcionario;
        }

    }
    
    public int getAdministrador(int id_empresa) {
        Integer id_funcionario = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select id_funcionario from funcionario where id_empresa = " + id_empresa + " and funcao = 'Administrador'");
            while (rs.next()) {
                id_funcionario = rs.getInt("id_funcionario");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st, rs);
            return id_funcionario;
        }
    }
}
