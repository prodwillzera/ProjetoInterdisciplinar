/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/
package connection;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 
@author nmare*/
public class connection {
    private static final String URL
            = "jdbc:mysql://localhost:3306/projetoInter";

    private static final String USER = "root";

    private static final String PASSWORD = "SUA_SENHA_AQUI";

    public static Connection conectar() {

        try {

            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }
}