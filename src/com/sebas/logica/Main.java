package com.sebas.logica;

import com.sebas.entidades.Libro;
import com.sebas.entidades.Usuario;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistroLibros registroLibros = new RegistroLibros();
        RegistroUsuario registroUsuarios = new RegistroUsuario();

        boolean continuar = true;
        while (continuar) {
            mostrarMenuPrincipal();
            int op = scanner.nextInt();
            scanner.nextLine();

            if (op == 1) {
                agregarLibro(scanner, registroLibros);
            } else if (op == 2) {
                eliminarLibro(scanner, registroLibros);
            } else if (op == 3) {
                buscarLibro(scanner, registroLibros);
            } else if (op == 4) {
                agregarUsuario(scanner, registroUsuarios);
            } else if (op == 5) {
                eliminarUsuario(scanner, registroUsuarios);
            } else if (op == 6) {
                buscarUsuario(scanner, registroUsuarios);
            } else if (op == 7) {
                continuar = false;
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opción no válida. Seleccione una opción válida.");
            }
        }

        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Agregar libro");
        System.out.println("2. Eliminar libro");
        System.out.println("3. Buscar libro por título");
        System.out.println("4. Agregar usuario");
        System.out.println("5. Eliminar usuario");
        System.out.println("6. Buscar usuario por nombre");
        System.out.println("7. Salir");
    }

    private static void agregarLibro(Scanner scanner, RegistroLibros registroLibros) {
        System.out.println("Ingrese el título del libro:");
        String tituloLibro = scanner.nextLine();
        System.out.println("Ingrese el autor del libro:");
        String autorLibro = scanner.nextLine();
        System.out.println("Ingrese el género del libro:");
        String generoLibro = scanner.nextLine();

        int anoPublicacion = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.println("Ingrese el año de publicación del libro:");
                anoPublicacion = Integer.parseInt(scanner.nextLine());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un año válido.");
            }
        }

        Libro nuevoLibro = new Libro(tituloLibro, autorLibro, generoLibro, anoPublicacion);
        registroLibros.agregarLibro(nuevoLibro);
        System.out.println("Libro agregado exitosamente.");
    }

    private static void eliminarLibro(Scanner scanner, RegistroLibros registroLibros) {
        System.out.println("Ingrese el título del libro que desea eliminar:");
        String tituloEliminar = scanner.nextLine();
        if (registroLibros.eliminarLibro(tituloEliminar)) {
            System.out.println("Libro eliminado exitosamente.");
        } else {
            System.out.println("El libro no existe en el registro.");
        }
    }

    private static void buscarLibro(Scanner scanner, RegistroLibros registroLibros) {
        System.out.println("Ingrese el título del libro a buscar:");
        String tituloBuscar = scanner.nextLine();
        List<Libro> librosEncontrados = registroLibros.buscarPorTitulo(tituloBuscar);
        if (librosEncontrados.isEmpty()) {
            System.out.println("No se encontraron libros con ese título.");
        } else {
            System.out.println("Libros encontrados:");
            for (Libro libro : librosEncontrados) {
                System.out.println(libro + " - " + libro.getAutor());
            }
        }
    }

    private static void agregarUsuario(Scanner scanner, RegistroUsuario registroUsuarios) {
        System.out.println("Ingrese el nombre del usuario:");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Ingrese la dirección del usuario:");
        String direccionUsuario = scanner.nextLine();
        System.out.println("Ingrese el teléfono del usuario:");
        String telefonoUsuario = scanner.nextLine();
        Usuario nuevoUsuario = new Usuario(nombreUsuario, direccionUsuario, telefonoUsuario);
        registroUsuarios.agregarUsuario(nuevoUsuario);
        System.out.println("Usuario agregado exitosamente.");
    }

    private static void eliminarUsuario(Scanner scanner, RegistroUsuario registroUsuarios) {
        System.out.println("Ingrese el nombre del usuario que desea eliminar:");
        String nombreEliminar = scanner.nextLine();
        if (registroUsuarios.eliminarUsuario(nombreEliminar)) {
            System.out.println("Usuario eliminado exitosamente.");
        } else {
            System.out.println("El usuario no existe en el registro.");
        }
    }

    private static void buscarUsuario(Scanner scanner, RegistroUsuario registroUsuarios) {
        System.out.println("Ingrese el nombre del usuario a buscar:");
        String nombreBuscar = scanner.nextLine();
        List<Usuario> usuariosEncontrados = registroUsuarios.buscarPorNombre(nombreBuscar);
        if (usuariosEncontrados.isEmpty()) {
            System.out.println("No se encontraron usuarios con ese nombre.");
        } else {
            System.out.println("Usuarios encontrados:");
            for (Usuario usuario : usuariosEncontrados) {
                System.out.println(usuario.getNombre() + " - " + usuario.getDireccion());
            }
        }
    }
}
