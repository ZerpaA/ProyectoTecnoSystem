
package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;  //Importamos todas las librerías a utilizar en esta clase
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    
    Connection con;
    Conexion cn = new Conexion(); // Realizamos la conexión con la BD
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarProveedor(Proveedor pr){ // Declaramos método para insertar los datos del proveedor en la tabla proveedor de la BD.
        
        String sql = "INSERT INTO proveedor(rif, nombre, telefono, direccion) VALUES (?,?,?,?)"; // Sentencia SQL para insertar los datos del proveedor en en sus respectivos campos.
        try {
           con = cn.getConnection();  // Obtenemos la conexión con la BD
           ps = con.prepareStatement(sql);
           ps.setString(1, pr.getRif());
           ps.setString(2, pr.getNombre());  // Asignamos el valor de cada atributo del objeto pr según su marcador de posición de la sentencia SQL.
           ps.setString(3, pr.getTelefono());  
           ps.setString(4, pr.getDireccion());
           ps.execute();  // Ejecutamos la sentencia SQL usando el método execute que devuelve un valor booleano que indica si la ejecución fue exitosa o no.
           return true;
        } catch (SQLException e) {  // Inicio del bloque catch, donde está el código a ejecutar si se produce una excepción de tipo SQLException.
            System.out.println(e.toString());
            return false;  // Devuelve el valor false como resultado del método, si la ejecución no fue exitosa.
        }finally{  // Código que se ejecuta siempre, independientemente de si se produjo una excepción o no.
            try {
                con.close();
            } catch (SQLException e) {  
                System.out.println(e.toString());
            }
        }
    } // Final del método RegistrarProveedor
        
    public List ListarProveedor(){  // Declaramos método para listar los datos del proveedor de la tabla proveedor de la BD
        List<Proveedor> Listapr = new ArrayList();  // Creación de lista para almacenar los datos del proveedor
        String sql = "SELECT * FROM proveedor";  // Sentencia SQL para seleccionar los datos
        try {
            con = cn.getConnection();  // Obtenemos la conexion con la BD
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();  // Ejecución de la sentencia SQL
            while (rs.next()) {  // Ciclo while que se ejecuta mientras haya datos en el objeto ResultSet               
                Proveedor pr = new Proveedor();  // Creamos un objeto para para almacenar los datos de cada proveedor que se obtienen de la BD
                pr.setId(rs.getInt("id"));
                pr.setRif(rs.getString("rif"));
                pr.setNombre(rs.getString("nombre"));  // Asignamos valores a los atributos del objeto
                pr.setTelefono(rs.getString("telefono"));
                pr.setDireccion(rs.getString("direccion"));
                Listapr.add(pr);
            }            
        } catch (SQLException e) {  // Inicio del bloque catch, donde está el código a ejecutar si se produce una excepción de tipo SQLException.
            System.out.println(e.toString());
        }
        return Listapr;  // Se devuelve la lista Listapr como resultado del método
    } // Final del método ListarProveedor
    
    
    public boolean EliminarProveedor(int id){  // Declaramos método para borrar el proveedor que tiene el id especificado de la tabla proveedor de la BD.
        
        String sql = "DELETE FROM proveedor WHERE id = ? ";  // Sentencia SQL para eliminar el proveedor que tiene el id indicado. 
        try {
            con = cn.getConnection();   // Obtenemos la conexion con la BD
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);  // Asignamos el valor del argumento id al primer marcador de posición de la sentencia SQL
            ps.execute();
            return true;  // Esta línea devuelve el valor true como resultado del método, si la ejecución fue exitosa.
        } catch (SQLException e) {  // Inicio del bloque catch, donde está el código a ejecutar si se produce una excepción de tipo SQLException.
            System.out.println(e.toString());
            return false;
        }finally{  // Código que se ejecuta siempre, independientemente de si se produjo una excepción o no.
            try {
                con.close();
            } catch (SQLException e) {  //  Código que se ejecuta si se produce otra excepción al intentar cerrar el objeto Connection.
                System.out.println(e.toString());
            }
        }
    }  // Final del método Eliminar Proveedor
    
    public boolean ModificarProveedor(Proveedor pr){  // Declaramos método para modificar los datos de algún proveedor de la tabla
        
        String sql = "UPDATE proveedor SET rif=?, nombre=?, telefono=?, direccion=? WHERE id=?"; // Sentencia SQL para modificar el proveedor que tiene el id indicado       
        try {
            con = cn.getConnection();  // Obtenemos la conexion con la BD
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getRif());
            ps.setString(2, pr.getNombre());  // Asignamos valores a los atributos del objeto.
            ps.setString(3, pr.getTelefono());
            ps.setString(4, pr.getDireccion());
            ps.setInt(5, pr.getId());
            ps.execute();  // Ejecución de la sentencia SQL
            return true;
        } catch (SQLException e) {  // Inicio del bloque catch, donde está el código a ejecutar si se produce una excepción de tipo SQLException.
            System.out.println(e.toString());
            return false;
        }finally{  // Código que se ejecuta siempre, independientemente de si se produjo una excepción o no.
            try {
                con.close();
            } catch (SQLException e) {  //  Código que se ejecuta si se produce otra excepción al intentar cerrar el objeto Connection.
                System.out.println(e.toString());
            }
        }
        
    }  // Final del método ModificarProveedor

} // Final de la clase