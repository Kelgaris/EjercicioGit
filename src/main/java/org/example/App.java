import java.util.ArrayList;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        Libro libro1 = new Libro("El senhor de los anillos: La comunidad del anillo", "J.R.R.R Tolkien", "123456789A", true);
        Libro libro2= new Libro("El senhor de los anillos: Las Dos Torres", "J.R.R.R Tolkien", "123456789A", true);
        Libro libro3 = new Libro("El senhor de los anillos: El retorno del Rey", "J.R.R.R Tolkien", "123456789A", true);

        Usuario usuario1 =  new Usuario("david", "Priego Puga", "630650786", "davidpp@aulaestudio.es");
        Usuario usuario2 =  new Usuario("agustin", "Alonso Perez", "123456789", "agustinap@aulaestudio.es");

        Biblioteca biblioteca = new Biblioteca("Biblioteca Municipal");

        biblioteca.agregarLibros(libro1);
        biblioteca.agregarLibros(libro2);
        biblioteca.agregarLibros(libro3);

        biblioteca.agregarUsuarios(usuario1);
        biblioteca.agregarUsuarios(usuario2);


        String menu = "";
        String nombre_usuario = "";
        boolean usuarioValido = false;

        while(!menu.equals("1")){
           nombre_usuario = JOptionPane.showInputDialog("Por favor inserte el nombre de usuario");
           usuarioValido = false;
           
           for(Usuario usuario : biblioteca.getUsuarios()){
                if(nombre_usuario.equalsIgnoreCase(usuario.getNombre())){
                    usuarioValido = true;
                    break;    
                }
           }
           if(usuarioValido == true){
                while (!menu.equals("5")) {
                    menu = JOptionPane.showInputDialog("1. Ver libros Disponibles \n"+"2. Ver libros Pendientes \n"+"3. Pedir un libro \n"+"4. Devolver un libro \n"+"5. Salir \n");

                    switch (menu) {
                        case "1":
                    
                            for(Libro libro : biblioteca.getLibros()){
                                if(libro.isDisponibilidad() == true){
                                    JOptionPane.showMessageDialog(null, libro.getTitulo());
                                }
                            }
                            break;
                    
                        case "2":
                            for(Usuario usuario : biblioteca.getUsuarios()){
                                if(usuario.getNombre().equalsIgnoreCase(nombre_usuario)){
                                    ArrayList<Libro> libros_pendientes = usuario.getLibros_pendientes();
                                    if(!libros_pendientes.isEmpty()){
                                        StringBuilder mensaje_libros_pendientes = new StringBuilder();
                                        for(Libro libro : libros_pendientes){
                                            mensaje_libros_pendientes.append(libro.getTitulo()+" \n");
                                        }
                                        JOptionPane.showMessageDialog(null, "Lista de libros pendientes: \n"+mensaje_libros_pendientes + " \n");
                                    }else{
                                        JOptionPane.showMessageDialog(null, "El usuario no tiene libros pendientes");
                                    }
                                }
                            }
                            break;

                        case "3":
                            boolean libro_encontrado = false;
                            for(Usuario usuario : biblioteca.getUsuarios()){
                                if(usuario.getNombre().equalsIgnoreCase(nombre_usuario)){
                                    String libro_requerido = JOptionPane.showInputDialog("¿Que libro desea? (Inserte el titulo del libro)");
                                    for(Libro libro : biblioteca.getLibros()){
                                        if(libro.getTitulo().equalsIgnoreCase(libro_requerido) && libro.isDisponibilidad() == true){
                                            usuario.pedirLibro(libro);
                                            JOptionPane.showMessageDialog(null, "Aqui tiene su libro, tiene un plazo de 15 dias para devolverlo");
                                            libro.setDisponibilidad(false);
                                            libro_encontrado = true;
                                            break;
                                        }
                                    }
                                    break;
                                }
                                
                            }
                            if(libro_encontrado == false){
                                JOptionPane.showMessageDialog(null, "El libro no se encuentra disponibles, lo sentimos vuelva otro dia");
                                break;
                            }
                            break;

                        case "4":
                            boolean libro_devuelto = false;
                            for(Usuario usuario : biblioteca.getUsuarios()){
                                if(usuario.getNombre().equalsIgnoreCase(nombre_usuario)){
                                    String devolverLibro = JOptionPane.showInputDialog("¿Que libro desea devolver? (Inserte el titulo del libro)");
                                    for(Libro libro : biblioteca.getLibros()){
                                        if(libro.getTitulo().equalsIgnoreCase(devolverLibro) && libro.isDisponibilidad() == false){
                                            usuario.devolverLibro(libro);
                                            JOptionPane.showMessageDialog(null, "Muchas gracias por devolver el libro a tiempo");
                                            libro.setDisponibilidad(true);
                                            libro_devuelto = true;
                                            break;
                                        }
                                    }
                                }
                            }
                            if(libro_devuelto == false){
                                JOptionPane.showMessageDialog(null, "No dispone de ningun libro que devolver por favor pida un libro");
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                }

           }else{
                JOptionPane.showMessageDialog(null, "El usuario no es Valido, por favor inserte otro");
            }
        }
    }
}
