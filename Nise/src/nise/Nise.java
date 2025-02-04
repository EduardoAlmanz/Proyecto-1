package nise;
/**
 *
 * @author Almanza
 */
public class Nise {

    public static void main(String[] args) {
        Persona p = new Persona();
        p.setNombre("Almanza");
        System.out.println(p.getNombre());
        System.out.println(p);
    }
    
}
//todas las clases se inician con letra mayuscula 

class Persona {
    
    private String nombre;

    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Mi nomre es: " + nombre;
    }
    
    
    
}
