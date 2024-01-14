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
import javax.swing.JOptionPane;
/**
 *
 * @author Zerpa
 */
public class ClienteDAO {
    Conexion cn = new Conexion();//CONEXION
    Connection con;
    PreparedStatement ps;//Variables para las consultas
    ResultSet rs;//variable para los resultados
    
    public boolean RegistrarCliente(Cliente cl){
        String sql = "INSERT INTO clientes (cedula, nombre, telefono, direccion) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getCedula());//guarda los datos en su respectiva columna
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getTelefono());
            ps.setString(4, cl.getDireccion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try {
                con.close();//cierra la conexion
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
}
