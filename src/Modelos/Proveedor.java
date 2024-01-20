
package Modelos;

public class Proveedor { //Declaramos el inicio de la definición de la clase Proveedor, que tiene el modificador public, lo que significa que se puede acceder desde cualquier otra clase
    
    private int id;
    private String rif;
    private String nombre;  //Declaramos las variables privadas
    private String telefono;
    private String direccion;
    
    public Proveedor (){  //Creamos un constructor vacío para crear un objeto de tipo Proveedor sin asignarle ningún valor a sus atributos.
        
    }

    public Proveedor(int id, String rif, String nombre, String telefono, String direccion) {  //Creamos un constructor con parámetros
        this.id = id;
        this.rif = rif;
        this.nombre = nombre;   // Asignación de valores a los atributos del objeto
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getId() {  // Método para obtener el valor del atributo id del objeto.
        return id;
    }

    public void setId(int id) {  // Método para modificar el valor del atributo id del objeto.
        this.id = id;
    }

    public String getRif() {  // Método para obtener el valor del atributo RIF del objeto.
        return rif;
    }

    public void setRif(String rif) {  // Método para modificar el valor del atributo RIF del objeto.
        this.rif = rif;
    }

    public String getNombre() {  // Método para obtener el valor del atributo nombre del objeto.
        return nombre;
    }

    public void setNombre(String nombre) {  // Método para modificar el valor del atributo nombre del objeto.
        this.nombre = nombre;
    }

    public String getTelefono() {  // Método para obtener el valor del atributo telefono del objeto.
        return telefono;
    }

    public void setTelefono(String telefono) {  // Método para modificar el valor del atributo telefono del objeto.
        this.telefono = telefono;
    }

    public String getDireccion() {  // Método para obtener el valor del atributo direccion del objeto.
        return direccion;
    }

    public void setDireccion(String direccion) {  // Método para modificar el valor del atributo direccion del objeto.
        this.direccion = direccion;
    }        
    
} // Final de la clase
