import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;
    private ArrayList<Libro> libros_pendientes;


    public void agregarUsuarios(Libro libro){
        libros_pendientes.add(libro);
    }

    public void pedirLibro(Libro libro){
        libros_pendientes.add(libro);
    }

    public void devolverLibro(Libro libro){
        libros_pendientes.remove(libro);
    }

    //CONSTRUCTOR
    public Usuario(String nombre, String apellidos, String telefono, String email){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.libros_pendientes = new ArrayList<>();
    }

    //GETTER Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Libro> getLibros_pendientes() {
        return libros_pendientes;
    }

    public void setLibros_pendientes(ArrayList<Libro> libros_pendientes) {
        this.libros_pendientes = libros_pendientes;
    }


}
