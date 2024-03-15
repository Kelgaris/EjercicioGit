import java.util.ArrayList;

public class Usuario {
    private String user;
    private String password;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;
    private ArrayList<Libro> libros_pendientes;
    private ArrayList<Libro> libros_reservados;


    

    public void pedirLibro(Libro libro){
        libros_pendientes.add(libro);
    }

    public void devolverLibro(Libro libro){
        libros_pendientes.remove(libro);
    }

    public void reservarLibro(Libro libro){
        libros_reservados.add(libro);
    }

    //CONSTRUCTOR
    public Usuario(String user, String password,String nombre, String apellidos, String telefono, String email){
        this.user = user;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.libros_pendientes = new ArrayList<>();
        this.libros_reservados = new ArrayList<>();
    }

    //GETTER Y SETTERS

    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public ArrayList<Libro> getLibros_reservados() {
        return libros_reservados;
    }

    public void setLibros_reservados(ArrayList<Libro> libros_reservados) {
        this.libros_reservados = libros_reservados;
    }

    

}
