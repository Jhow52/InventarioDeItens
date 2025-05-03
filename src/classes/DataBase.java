/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author Etec-User
 */
public class DataBase {

    final String URL = "jdbc:mysql://localhost:3306/cafeteria";
    final String USER = "root";
    final String PASSWD = "root";
    Connection connection = null;

    public Connection getConnection() {
        if (this.connection == null) {
            try {
                this.connection = DriverManager.getConnection(URL, USER, PASSWD);
            } catch (SQLException e) {
                System.out.println("Erro com a conexão com o banco. Eceção: " + e);
            }
        }
        return this.connection;
    }
}
