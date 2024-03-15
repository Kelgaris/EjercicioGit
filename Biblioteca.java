import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Libro> libros;

    public Biblioteca(String nombre){
        this.nombre = nombre;
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    //Agregar Usuarios y Agregar Libros

    public void agregarUsuarios(Usuario usuario){
        usuarios.add(usuario);
    }

    public void agregarLibros(Libro libro){
        libros.add(libro);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    
}
