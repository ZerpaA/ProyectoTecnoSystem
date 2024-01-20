
package Modelos;

public class Productos {  //Declaramos el inicio de la definición de la clase Productos, que tiene el modificador public, lo que significa que se puede acceder desde cualquier otra clase
    
    private int id;
    private String codigo;
    private String nombre;
    private int proveedor;  //Declaramos las variables privadas
    private String proveedorPro;
    private int stock;
    private double precio;
    
    public Productos(){  //Creamos un constructor vacío para crear un objeto de tipo Productos sin asignarle ningún valor a sus atributos
        
    }

    public Productos(int id, String codigo, String nombre, int proveedor, String proveedorPro, int stock, double precio) {  //Creamos un constructor con parámetros
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.proveedor = proveedor;  // Asignación de valores a los atributos del objeto
        this.proveedorPro = proveedorPro;
        this.stock = stock;
        this.precio = precio;
    }

    public int getId() {  // Método para obtener el valor del atributo Id del objeto.
        return id;
    }

    public void setId(int id) {  // Método para modificar el valor del atributo id del objeto.
        this.id = id;
    }

    public String getCodigo() {  // Método para obtener el valor del atributo codigo del objeto.
        return codigo;
    }

    public void setCodigo(String codigo) {  // Método para modificar el valor del atributo codigo del objeto.
        this.codigo = codigo;
    }

    public String getNombre() {  // Método para obtener el valor del atributo nombre del objeto.
        return nombre;
    }

    public void setNombre(String nombre) {  // Método para modificar el valor del atributo nombre del objeto.
        this.nombre = nombre;
    }

    public int getProveedor() {  // Método para obtener el valor del atributo id del proveedor.
        return proveedor;
    }

    public void setProveedor(int proveedor) {  // Método para modificar el valor del atributo id del proveedor.
        this.proveedor = proveedor;
    }

    public String getProveedorPro() {  //Método para obtener el nombre del proveedor
        return proveedorPro;
    }

    public void setProveedorPro(String proveedorPro) {  //Método para modificar el nombre del proveedor
        this.proveedorPro = proveedorPro;
    }

    public int getStock() {  // Método para obtener el valor del atributo stock del objeto.
        return stock;
    }

    public void setStock(int stock) {  // Método para modificar el valor del atributo stock del objeto.
        this.stock = stock;
    }

    public double getPrecio() {  // Método para obtener el valor del atributo precio del objeto.
        return precio;
    }

    public void setPrecio(double precio) {  // Método para modificar el valor del atributo precio del objeto.
        this.precio = precio;
    }                    
}