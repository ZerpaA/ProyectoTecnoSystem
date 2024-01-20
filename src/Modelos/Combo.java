
package Modelos;

public class Combo {  // Declaramos la clase Combo que representa un elemento de un ComboBox
    private int id;
    private String nombre;  //Declaramos dos atributos que guardan el identificador y el nombre del elemento del ComboBox.

    public Combo(int id, String nombre) {  //Constructor que recibe dos parámetros
        this.id = id;
        this.nombre = nombre;  //El constructor asigna los valores de los parámetros a los atributos de la clase.
    }
    public int getId() {  // Método para obtener el valor del atributo Id de la clase
        return id;
    }

    public void setId(int id) {  // Método para modificar el valor del atributo Id de la clase
        this.id = id;
    }

    public String getNombre() {  // Método para obtener el valor del atributo nombre de la clase
        return nombre;
    }

    public void setNombre(String nombre) {  // Método para modificar el valor del atributo nombre de la clase
        this.nombre = nombre;
    }
    
    @Override  // Este método sobrescribe el método toString de la clase Object, que es la clase padre de todas las clases en Java
    public String toString(){
        return this.getNombre();
    }
}
