/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author claudio
 */
public class DatabaseLocator {
    //Padrão Singleton
    private static DatabaseLocator instance = new DatabaseLocator();
    private DatabaseLocator(){}
    public static DatabaseLocator getInstance(){
        return instance;
    }
    
    Connection getConnection() throws SQLException, ClassNotFoundException{
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ifood", "root", "root");// Falta criar o banco de dados
        return conn;
    }
}
