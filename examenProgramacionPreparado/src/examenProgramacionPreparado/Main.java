package examenProgramacionPreparado;

import java.util.Scanner;

public class Main {

    static GestionLibreria gestion = new GestionLibreria();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerInt();
            switch (opcion) {
                case 1 -> menuLibros();
                case 2 -> menuSocios();
                case 3 -> menuPrestamos();
                case 4 -> menuConsultas();
                case 0 -> System.out.println("Hasta pronto.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    static void mostrarMenu() {
        System.out.println("\n===== GESTIÓN DE BIBLIOTECA =====");
        System.out.println("1. Gestión de libros");
        System.out.println("2. Gestión de socios");
        System.out.println("3. Gestión de préstamos");
        System.out.println("4. Consultas");
        System.out.println("0. Salir");
        System.out.print("Elige opción: ");
    }

    // LIBROS 

    static void menuLibros() {
        System.out.println("\n-- LIBROS --");
        System.out.println("1. Alta libro");
        System.out.println("2. Listar libros");
        System.out.println("3. Modificar libro");
        System.out.println("4. Eliminar libro");
        System.out.print("Elige opción: ");
        switch (leerInt()) {
            case 1 -> altaLibro();
            case 2 -> gestion.listarLibros();
            case 3 -> modificarLibro();
            case 4 -> eliminarLibro();
        }
    }

    static void altaLibro() {
        System.out.print("ISBN: ");          String isbn = sc.next();
        System.out.print("Título: ");        String titulo = sc.next();
        System.out.print("Autor: ");         String autor = sc.next();
        System.out.print("Género: ");        String genero = sc.next();
        System.out.print("Nº ejemplares: "); int ejemplares = leerInt();
        gestion.darAltaLibro(isbn, titulo, autor, genero, ejemplares);
    }

    static void modificarLibro() {
        System.out.print("ISBN a modificar: "); String isbn = sc.next();
        System.out.print("Nuevo título: ");     String titulo = sc.next();
        System.out.print("Nuevo autor: ");      String autor = sc.next();
        System.out.print("Nº ejemplares: ");    int ejemplares = leerInt();
        gestion.modificarLibro(isbn, titulo, autor, ejemplares);
    }

    static void eliminarLibro() {
        System.out.print("ISBN a eliminar: ");
        gestion.eliminarLibro(sc.next());
    }

    // SOCIOS 

    static void menuSocios() {
        System.out.println("\n-- SOCIOS --");
        System.out.println("1. Alta socio");
        System.out.println("2. Listar socios");
        System.out.println("3. Modificar socio");
        System.out.println("4. Eliminar socio");
        System.out.print("Elige opción: ");
        switch (leerInt()) {
            case 1 -> altaSocio();
            case 2 -> gestion.listarSocios();
            case 3 -> modificarSocio();
            case 4 -> eliminarSocio();
        }
    }

    static void altaSocio() {
        System.out.print("Código socio: "); int codigo = leerInt();
        System.out.print("Nombre: ");       String nombre = sc.next();
        System.out.print("Teléfono: ");     int telefono = leerInt();
        gestion.darAltaSocio(codigo, nombre, telefono, 0);
    }

    static void modificarSocio() {
        System.out.print("Código socio a modificar: "); int codigo = leerInt();
        System.out.print("Nuevo nombre: ");              String nombre = sc.next();
        System.out.print("Nuevo teléfono: ");            int telefono = leerInt();
        gestion.modificarSocio(codigo, nombre, telefono, 0);
    }

    static void eliminarSocio() {
        System.out.print("Código socio a eliminar: ");
        gestion.eliminarSocio(leerInt());
    }

    // PRÉSTAMOS 

    static void menuPrestamos() {
        System.out.println("\n-- PRÉSTAMOS --");
        System.out.println("1. Registrar préstamo");
        System.out.println("2. Registrar devolución");
        System.out.println("3. Ver todos los préstamos");
        System.out.print("Elige opción: ");
        switch (leerInt()) {
            case 1 -> {
                System.out.print("Código socio: "); int cod = leerInt();
                System.out.print("ISBN libro: ");   String isbn = sc.next();
                gestion.registrarPrestamo(cod, isbn);
            }
            case 2 -> {
                System.out.print("ID préstamo: ");
                gestion.registrarDevolucion(sc.next());
            }
            case 3 -> gestion.listarPrestamos();
        }
    }

    // CONSULTAS 

    static void menuConsultas() {
        System.out.println("\n-- CONSULTAS --");
        System.out.println("1. Libros disponibles");
        System.out.println("2. Info de un libro");
        System.out.println("3. Info de un socio");
        System.out.print("Elige opción: ");
        switch (leerInt()) {
            case 1 -> gestion.listarLibrosDisponibles();
            case 2 -> {
                System.out.print("ISBN: ");
                Libro l = gestion.buscarLibroPorIsbn(sc.next());
                System.out.println(l != null ? l : "Libro no encontrado.");
            }
            case 3 -> {
                System.out.print("Código socio: ");
                Socio s = gestion.buscarSocioPorCodigo(leerInt());
                System.out.println(s != null ? s : "Socio no encontrado.");
            }
        }
    }

    static int leerInt() {
        while (!sc.hasNextInt()) { System.out.print("Introduce un número: "); sc.next(); }
        return sc.nextInt();
    }
}