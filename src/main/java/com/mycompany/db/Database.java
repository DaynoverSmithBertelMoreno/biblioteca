package com.mycompany.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database {
    
    protected Connection conexion;
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/db_library";

    private final String USER = "root";
    private final String PASS = "root";


    public void Conectar() throws ClassNotFoundException {
        try {
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);
            Class.forName(JDBC_DRIVER);
            System.out.println("BD conectado");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Cerrar() throws SQLException{
        if (conexion != null) {
            if (!conexion.isClosed()){
                conexion.close();
            }
        }
    }
    
    /**
     * Verifica las credenciales de usuario en la base de datos
     * @param username Nombre de usuario
     * @param password Contraseña
     * @return true si las credenciales son válidas, false en caso contrario
     */
    public boolean checkCredentials(String username, String password) {
        String query = "SELECT * FROM user_admin WHERE username = ? AND password = ?";
        
        try {
            Conectar();
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            
            boolean hasResults = resultSet.next();
            
            // Close resources
            resultSet.close();
            statement.close();
            Cerrar();
            
            return hasResults;
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
}