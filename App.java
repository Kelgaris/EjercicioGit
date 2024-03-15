import java.util.ArrayList;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        Libro libro1 = new Libro("El senhor de los anillos: La comunidad del anillo", "J.R.R.R Tolkien", "123456789A",
                true);
        Libro libro2 = new Libro("El senhor de los anillos: Las Dos Torres", "J.R.R.R Tolkien", "123456789A", true);
        Libro libro3 = new Libro("El senhor de los anillos: El retorno del Rey", "J.R.R.R Tolkien", "123456789A", true);

        Usuario usuario1 = new Usuario("davidpp", "abc123.", "david", "Priego Puga", "630650786", "davidpp@aulaestudio.es");
        Usuario usuario2 = new Usuario("agusap", "abc123.", "agustin", "Alonso Perez", "123456789", "agustinap@aulaestudio.es");

        Biblioteca biblioteca = new Biblioteca("Biblioteca Municipal");

        biblioteca.agregarLibros(libro1);
        biblioteca.agregarLibros(libro2);
        biblioteca.agregarLibros(libro3);

        biblioteca.agregarUsuarios(usuario1);
        biblioteca.agregarUsuarios(usuario2);

        boolean salir = false; // Variable para controlar si salir del programa
        while (!salir) {
            String menu = "";
            String nombre_usuario = "";
            String password_usuario = "";
            boolean usuarioValido = false;
            boolean passwordValida = false;

            String[] opciones = { "Iniciar Sesion", "Registrarse", "Salir" };
            int eleccion = JOptionPane.showOptionDialog(null, "Bienvenido al sistema", "Menu de inicio",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            switch (eleccion) {
                case 0:

                    while (!menu.equals("6")) {

                        nombre_usuario = JOptionPane.showInputDialog("Por favor inserte el nombre de usuario");
                        password_usuario = JOptionPane.showInputDialog("Por favor, Inserte la contrasenha");
                        usuarioValido = false;
                        passwordValida = false;

                        for (Usuario usuario : biblioteca.getUsuarios()) {
                            if (nombre_usuario.equalsIgnoreCase(usuario.getUser())
                                    && password_usuario.equalsIgnoreCase(usuario.getPassword())) {
                                usuarioValido = true;
                                passwordValida = true;
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Usuario o Contraseña no validos");
                                usuarioValido = false;
                                passwordValida = false;
                                break;
                            }
                        }
                        if (usuarioValido == true) {
                            while (!menu.equals("6")) {
                                menu = JOptionPane
                                        .showInputDialog("1. Ver libros  \n" + "2. Ver libros Pendientes \n"
                                                + "3. Pedir un libro \n" + "4. Devolver un libro \n"
                                                + "5. Libros Reservados \n" + "6. Salir \n");

                                switch (menu) {
                                    case "1":
                                        StringBuilder mensaje_libros = new StringBuilder();
                                        for (Libro libro : biblioteca.getLibros()) {
                                            mensaje_libros.append(libro.getTitulo() + " \n");
                                        }
                                        JOptionPane.showMessageDialog(null,
                                                "Nuestros libros: \n" + mensaje_libros + " \n");
                                        break;

                                    case "2":
                                        for (Usuario usuario : biblioteca.getUsuarios()) {
                                            if (usuario.getUser().equalsIgnoreCase(nombre_usuario)) {
                                                ArrayList<Libro> libros_pendientes = usuario.getLibros_pendientes();
                                                if (!libros_pendientes.isEmpty()) {
                                                    StringBuilder mensaje_libros_pendientes = new StringBuilder();
                                                    for (Libro libro : libros_pendientes) {
                                                        mensaje_libros_pendientes.append(libro.getTitulo() + " \n");
                                                    }
                                                    JOptionPane.showMessageDialog(null,
                                                            "Lista de libros pendientes: \n"
                                                                    + mensaje_libros_pendientes + " \n");
                                                } else {
                                                    JOptionPane.showMessageDialog(null,
                                                            "El usuario no tiene libros pendientes");
                                                }
                                            }
                                        }
                                        break;

                                    case "3":
                                        boolean libro_encontrado = false;
                                        boolean libro_reservado = false;
                                        for (Usuario usuario : biblioteca.getUsuarios()) {
                                            if (usuario.getUser().equalsIgnoreCase(nombre_usuario)) {
                                                String libro_requerido = JOptionPane.showInputDialog(
                                                        "¿Que libro desea? (Inserte el titulo del libro)");
                                                for (Libro libro : biblioteca.getLibros()) {
                                                    if (libro.getTitulo().equalsIgnoreCase(libro_requerido)
                                                            && libro.isDisponibilidad() == true) {
                                                        usuario.pedirLibro(libro);
                                                        JOptionPane.showMessageDialog(null,
                                                                "Aqui tiene su libro, tiene un plazo de 15 dias para devolverlo");
                                                        libro.setDisponibilidad(false);
                                                        libro_encontrado = true;
                                                        break;
                                                    } else {
                                                        String[] opcion = { "Si", "No" };
                                                        int respuesta = JOptionPane.showOptionDialog(null,
                                                                "El libro no esta disponible, ¿Quieres reservarlo?",
                                                                "Reservas:",
                                                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                                                                opcion, opcion[0]);
                                                        if (respuesta == JOptionPane.YES_OPTION) {
                                                            usuario.reservarLibro(libro);
                                                            libro_reservado = true;
                                                            JOptionPane.showMessageDialog(null, "Libro Reservado");
                                                            break;
                                                        } else {
                                                            JOptionPane.showMessageDialog(null,
                                                                    "De acuerdo que tenga un buen dia");
                                                        }
                                                    }
                                                }
                                                break;
                                            }

                                        }
                                        break;

                                    case "4":
                                        boolean libro_devuelto = false;
                                        for (Usuario usuario : biblioteca.getUsuarios()) {
                                            if (usuario.getUser().equalsIgnoreCase(nombre_usuario)) {
                                                String devolverLibro = JOptionPane.showInputDialog(
                                                        "¿Que libro desea devolver? (Inserte el titulo del libro)");
                                                for (Libro libro : biblioteca.getLibros()) {
                                                    if (libro.getTitulo().equalsIgnoreCase(devolverLibro)
                                                            && libro.isDisponibilidad() == false) {
                                                        usuario.devolverLibro(libro);
                                                        JOptionPane.showMessageDialog(null,
                                                                "Muchas gracias por devolver el libro a tiempo");
                                                        libro.setDisponibilidad(true);
                                                        libro_devuelto = true;
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        if (libro_devuelto == false) {
                                            JOptionPane.showMessageDialog(null,
                                                    "No dispone de ningun libro que devolver por favor pida un libro");
                                            break;
                                        }
                                        break;

                                    case "5":
                                        StringBuilder mensaje_libros_reservados = new StringBuilder();
                                        for (Usuario usuario : biblioteca.getUsuarios()) {
                                            if (usuario.getUser().equalsIgnoreCase(nombre_usuario)) {
                                                for (Libro libro : usuario.getLibros_reservados()) {
                                                    mensaje_libros_reservados.append(libro.getTitulo() + " \n");
                                                }
                                                JOptionPane.showMessageDialog(null,
                                                        "Tus Reservas: \n" + mensaje_libros_reservados + " \n");
                                            } else {
                                                JOptionPane.showMessageDialog(null,
                                                        "El usuario no tiene libros reservados");
                                            }
                                        }

                                        break;

                                    default:
                                        break;
                                }
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "El usuario no es Valido, por favor inserte otro");
                        }
                    }

                    break;

                case 1:
                    boolean registroExitoso = false;
                    while (!registroExitoso) {
                        String nuevo_user = "";
                        String nueva_password = "";
                        String nuevo_nombre = "";
                        String nuevo_apellidos = "";
                        String nuevo_telefono = "";
                        String nuevo_correo = "";

                        nuevo_user = JOptionPane.showInputDialog("Por favor Inserte el nombre de usuario");
                        nueva_password = JOptionPane.showInputDialog("Por favor, Inserte la contraseña");
                        nuevo_nombre = JOptionPane.showInputDialog("Cual es su nombre");
                        nuevo_apellidos = JOptionPane.showInputDialog("Inserte sus 2 apellidos");
                        nuevo_telefono = JOptionPane.showInputDialog("Inserte su numero de telefono");
                        nuevo_correo = JOptionPane.showInputDialog("Inserte el correo a validar");

                        Usuario nuevo_usuario = new Usuario(nuevo_user, nueva_password, nuevo_nombre, nuevo_apellidos,nuevo_telefono, nuevo_correo);
                        biblioteca.agregarUsuarios(nuevo_usuario);

                        String[] opcionesRegistro = { "Sí", "No" };
                        int continuarRegistro = JOptionPane.showOptionDialog(null, "¿Desea registrar otro usuario?",
                                "Registro de Usuarios", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.PLAIN_MESSAGE, null, opcionesRegistro, opcionesRegistro[0]);
                        if (continuarRegistro == JOptionPane.NO_OPTION) {
                            registroExitoso = true; 
                            
                        }
                    }
                    break;

                case 2:
                    salir = true;
                    break;

                default:
                    break;
            }

        }
    }
}