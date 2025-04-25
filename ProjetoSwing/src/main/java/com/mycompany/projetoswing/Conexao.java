/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoswing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Cricca
 */
public class Conexao {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/estoque";
        String user = "root";
        String password = "123456";

        return DriverManager.getConnection(url, user, password);
    }
}
