public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponibilidad;

    public Libro(String titulo, String autor, String isbn, boolean disponibilidad){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponibilidad = disponibilidad;
    }

    //GETTERS Y SETTERS
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    
    
}
