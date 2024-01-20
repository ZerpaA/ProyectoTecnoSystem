
package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;  //Importamos todas las librerías a utilizar en esta clase
import java.util.ArrayList;
import java.util.List;

public class ProductosDAO {
    Connection con;
    Conexion cn = new Conexion();  // Realizamos la conexión con la BD
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarProductos(Productos pro){  // Creación del método para registrar productos   
        String sql = "INSERT INTO productos (codigo, nombre, proveedor, stock, precio) VALUES (?,?,?,?,?)";  // Sentencia SQL para insertar datos en la BD
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setInt(3, pro.getProveedor());   //Asignamos los valores a los atributos del objeto
            ps.setInt(4, pro.getStock());
            ps.setDouble(5, pro.getPrecio());
                ps.execute();  // Ejecutamos la sentencia SQL
            return true;
        } catch (SQLException e) {  // Inicio del bloque catch, donde está el código a ejecutar si se produce una excepción de tipo SQLException.
            System.out.println(e.toString());
            return false;
        }                
    }  // Final del método RegistrarProductos        
    
    public List ListarProductos(){  // Declaramos método para listar los datos de los productos de la tabla productos de la BD.
       List<Productos> Listapro = new ArrayList();
       String sql = "SELECT pr.id AS id_proveedor, pr.nombre AS nombre_proveedor, p.* FROM proveedor pr INNER JOIN productos p ON pr.id = p.proveedor ORDER BY p.id DESC";  //Sentencia SQL para seleccionar datos uniendo las tablas productos y proveedor
       try {
           con = cn.getConnection(); // Obtenemos la conexion con la BD
           ps = con.prepareStatement(sql);  
           rs = ps.executeQuery();  // Ejecución de la sentencia SQL
           while (rs.next()) {   // Ciclo while que se ejecuta mientras haya datos en el objeto ResultSet.             
               Productos pro = new Productos();
               pro.setId(rs.getInt("id"));
               pro.setCodigo(rs.getString("codigo"));
               pro.setNombre(rs.getString("nombre"));  // Asignamos valores a los atributos del objeto.
               pro.setProveedor(rs.getInt("id_proveedor"));
               pro.setProveedorPro(rs.getString("nombre_proveedor"));
               pro.setStock(rs.getInt("stock"));
               pro.setPrecio(rs.getDouble("precio"));
               Listapro.add(pro);  // Añadimos el objeto pro a la lista.
           }
       } catch (SQLException e) {  // Inicio del bloque catch, donde está el código a ejecutar si se produce una excepción de tipo SQLException.
           System.out.println(e.toString());
       }
       return Listapro;
   } //Final del método ListarProductos
    
    public boolean EliminarProductos(int id){  // Declaramos método para eliminar productos
        
        String sql = "DELETE FROM productos WHERE id = ?"; // Sentencia SQL para eliminar el producto con el id indicado
       try {  // Usamos un bloque try-catch-finally para manejar posibles excepciones de tipo SQLException
           ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           ps.execute();
           return true;
       } catch (SQLException e) {  // Inicio del bloque catch, donde está el código a ejecutar si se produce una excepción de tipo SQLException.
           System.out.println(e.toString());
           return false;
       }finally{
           try {
               con.close();  // Cerramos la conexión a la BD usando el método close de la variable con
           } catch (SQLException ex) {
               System.out.println(ex.toString());
           }
       }
    }  //Final del método EliminarProductos
    
    public boolean ModificarProductos(Productos pro){  //Declaramos el método para modificar productos de la BD
       String sql = "UPDATE productos SET codigo=?, nombre=?, proveedor=?, stock=?, precio=? WHERE id=?";  // Sentencia SQL para modificar los campos del producto en la BD
       try {  // Usamos un bloque try-catch-finally para manejar posibles excepciones de tipo SQLException
           ps = con.prepareStatement(sql);
           ps.setString(1, pro.getCodigo());
           ps.setString(2, pro.getNombre());  
           ps.setInt(3, pro.getProveedor()); // Asignamos valores a los atributos del parámetro pro a los signos de interrogación de la sentencia SQL usando los métodos setString, setInt, y setDouble del objeto p
           ps.setInt(4, pro.getStock());  
           ps.setDouble(5, pro.getPrecio());
           ps.setInt(6, pro.getId());
           ps.execute();  // Ejecutamos la sentencia SQL usando el método execute
           return true;
       } catch (SQLException e) {  // Inicio del bloque catch, donde está el código a ejecutar si se produce una excepción de tipo SQLException.
           System.out.println(e.toString());
           return false;
       }finally{
           try {  // Usamos otro bloque try-catch para manejar otra posible excepción de tipo SQLException
               con.close();
           } catch (SQLException e) {
               System.out.println(e.toString());
           }
       }
    }  //Final del método ModificarProductos
    
   public Productos BuscarPro(String cod){
        Productos producto = new Productos();
        String sql = "SELECT * FROM productos WHERE codigo = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return producto;
    }
    
    public Productos BuscarId(int id){
        Productos pro = new Productos();
        String sql = "SELECT pr.id AS id_proveedor, pr.nombre AS nombre_proveedor, p.* FROM proveedor pr INNER JOIN productos p ON p.proveedor = pr.id WHERE p.id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                pro.setId(rs.getInt("id"));
                pro.setCodigo(rs.getString("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setProveedor(rs.getInt("proveedor"));
                pro.setProveedorPro(rs.getString("nombre_proveedor"));
                pro.setStock(rs.getInt("stock"));
                pro.setPrecio(rs.getDouble("precio"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return pro;
    }
    public Proveedor BuscarProveedor(String nombre){
        Proveedor pr = new Proveedor();
        String sql = "SELECT * FROM proveedor WHERE nombre = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                pr.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return pr;
    }
   
}
