/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Zerpa
 */
public class LoginDAO {
    Connection con;
    PreparedStatement ps;//Variable para guardar el codigo SQL
    ResultSet rs;//Variable para guardar el resulatdo de la consulta SQL
    Conexion cn = new Conexion();
    
    public Login log(String correo, String pass){
        Login l = new Login();//crea un objeto de tipo login para guardar los datos
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND pass = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);//pasa los parametros ingresados por el usuario a la consulta
            ps.setString(2, pass);
            rs= ps.executeQuery();//ejecuta la consulta
            if (rs.next()) {//si hay datos entra en el if
                l.setId(rs.getInt("id"));//asigna los datos del usuario
                l.setNombre(rs.getString("nombre"));
                l.setCorreo(rs.getString("correo"));
                l.setPass(rs.getString("pass"));
                l.setRol(rs.getString("rol"));
                
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return l;
    }
}
