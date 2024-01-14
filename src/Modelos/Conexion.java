/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Zerpa
 */
public class Conexion {
    Connection con;
    public Connection getConnection() {
        try {
            String myBD = "jdbc:mysql://localhost:3306/sis_java?serverTimezone=UTC";//direccion de la BD
            con = DriverManager.getConnection(myBD, "root", "");// Datos de la BD
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString());//Mensaje en caso de errores
        }
        return null;
    }
}
