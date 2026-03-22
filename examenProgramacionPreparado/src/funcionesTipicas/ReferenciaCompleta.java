package funcionesTipicas;
import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================
 *  ARCHIVO DE REFERENCIA COMPLETO - POO JAVA
 *  Basado en ejercicios CRUD, Colecciones y modelos de examen
 *  Copia el bloque que necesites directamente en tu examen.
 * ============================================================
 *
 *  ÍNDICE DE BLOQUES:
 *  [A] CLASE MODELO (con constructor, getters/setters, toString, equals)
 *  [B] CLASE GESTORA (CRUD: alta, baja, modificar, buscar, listar)
 *  [C] COLECCIONES - ArrayList
 *  [D] COLECCIONES - LinkedHashSet (sin duplicados, orden inserción)
 *  [E] COLECCIONES - TreeSet (sin duplicados, orden alfabético/natural)
 *  [F] COLECCIONES - HashMap (clave-valor, sin orden)
 *  [G] COLECCIONES - TreeMap (clave-valor, orden alfabético)
 *  [H] MENÚ INTERACTIVO (bucle do-while + switch)
 *  [I] ENTRADA POR TECLADO (Scanner - int, double, String)
 *  [J] NÚMEROS ALEATORIOS
 *  [K] RECORRER COLECCIONES (for-each, iterator, índices)
 *  [L] OPERACIONES MATEMÁTICAS sobre lista (suma, media, max, min)
 *  [M] BUSCAR EN UNA LISTA (by campo)
 *  [N] ORDENAR UNA LISTA (Comparator)
 *  [O] ENUM
 *  [P] HERENCIA (superclase + subclase)
 *  [Q] INTERFAZ
 *  [R] CLASE ABSTRACTA
 *  [S] PATRONES DE EXAMEN: préstamos, stock, login, euromillón
 */
public class ReferenciaCompleta {

    // =========================================================================
    // [O] ENUM - Tipos predefinidos (ej: género musical, nivel, categoría)
    // =========================================================================
    enum Genero { ROCK, POP, JAZZ, BLUES }
    enum Nivel  { BASICO, INTERMEDIO, AVANZADO }


    // =========================================================================
    // [A] CLASE MODELO - Plantilla base para cualquier clase de examen
    //     Sustituye "Alumno" por tu clase (Libro, Disco, Pizza, Articulo...)
    // =========================================================================
    static class Alumno {

        // --- Atributos ---
        private String nombre;
        private int    edad;
        private double nota;

        // --- Constructor completo ---
        public Alumno(String nombre, int edad, double nota) {
            this.nombre = nombre;
            this.edad   = edad;
            this.nota   = nota;
        }

        // --- Constructor vacío (por si lo necesitas) ---
        public Alumno() {}

        // --- Getters ---
        public String getNombre() { return nombre; }
        public int    getEdad()   { return edad;   }
        public double getNota()   { return nota;   }

        // --- Setters ---
        public void setNombre(String nombre) { this.nombre = nombre; }
        public void setEdad(int edad)        { this.edad   = edad;   }
        public void setNota(double nota)     { this.nota   = nota;   }

        // --- toString: cómo se imprime el objeto ---
        @Override
        public String toString() {
            return "Alumno{nombre='" + nombre + "', edad=" + edad + ", nota=" + nota + "}";
        }

        // --- equals: comparar dos objetos (aquí por nombre) ---
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Alumno)) return false;
            Alumno a = (Alumno) o;
            return this.nombre.equalsIgnoreCase(a.nombre);
        }

        // --- hashCode: necesario si usas equals en colecciones ---
        @Override
        public int hashCode() {
            return nombre.toLowerCase().hashCode();
        }
    }


    // =========================================================================
    // [B] CLASE GESTORA - CRUD completo sobre una lista de objetos
    //     Toda la lógica de la lista va AQUÍ, separada del modelo y del main
    // =========================================================================
    static class GestionAlumnos {

        private ArrayList<Alumno> lista = new ArrayList<>();

        // --- ALTA: añadir un alumno a la lista ---
        public void alta(Alumno a) {
            if (!existe(a.getNombre())) {     // evitar duplicados
                lista.add(a);
                System.out.println("Alumno añadido correctamente.");
            } else {
                System.out.println("ERROR: Ya existe un alumno con ese nombre.");
            }
        }

        // --- BAJA: borrar un alumno por nombre ---
        public void baja(String nombre) {
            Alumno a = buscarPorNombre(nombre);
            if (a != null) {
                lista.remove(a);
                System.out.println("Alumno eliminado correctamente.");
            } else {
                System.out.println("ERROR: No se encontró el alumno '" + nombre + "'.");
            }
        }

        // --- MODIFICAR: cambiar la nota de un alumno buscado por nombre ---
        public void modificarNota(String nombre, double nuevaNota) {
            Alumno a = buscarPorNombre(nombre);
            if (a != null) {
                a.setNota(nuevaNota);
                System.out.println("Nota modificada correctamente.");
            } else {
                System.out.println("ERROR: No se encontró el alumno '" + nombre + "'.");
            }
        }

        // --- BUSCAR por nombre (devuelve el objeto o null) ---
        public Alumno buscarPorNombre(String nombre) {
        	Alumno alumnoEncontrado = null;
            for (Alumno a : lista) {
                if (a.getNombre().equalsIgnoreCase(nombre)) {
                	alumnoEncontrado=a;
                }
            }
            return alumnoEncontrado; // no encontrado
        }

        // --- EXISTE: comprueba si ya hay un alumno con ese nombre ---
        public boolean existe(String nombre) {
            return buscarPorNombre(nombre) != null;
        }

        // --- LISTAR: imprimir todos los objetos ---
        public void listar() {
            if (lista.isEmpty()) {
                System.out.println("La lista está vacía.");
            } else {
                System.out.println("=== LISTADO DE ALUMNOS ===");
                for (Alumno a : lista) {
                    System.out.println(a); // llama a toString()
                }
            }
        }

        // --- LISTAR con índices (para mostrar posición) ---
        public void listarConIndices() {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println("[" + i + "] " + lista.get(i));
            }
        }

        // --- TAMAÑO de la lista ---
        public int tamanio() {
            return lista.size();
        }

        // --- OBTENER lista completa (para recorrerla fuera) ---
        public ArrayList<Alumno> getLista() {
            return lista;
        }
    }


    // =========================================================================
    // [C] COLECCIONES - ArrayList
    //     Orden de inserción, permite duplicados, acceso por índice
    // =========================================================================
    static void ejemploArrayList() {
        ArrayList<String> lista = new ArrayList<>();

        lista.add("Ana");           // añadir al final
        lista.add(0, "Luis");       // añadir en posición 0
        lista.remove("Ana");        // borrar por valor
        lista.remove(0);            // borrar por índice
        lista.set(0, "Marta");      // modificar posición 0
        String elem = lista.get(0); // obtener por índice
        int tam = lista.size();     // tamaño
        boolean vacia = lista.isEmpty();
        boolean tiene = lista.contains("Marta");
        lista.clear();              // vaciar lista

        // Recorrer
        for (String s : lista) System.out.println(s);
    }


    // =========================================================================
    // [D] COLECCIONES - LinkedHashSet
    //     SIN duplicados, conserva el ORDEN DE INSERCIÓN
    // =========================================================================
    static void ejemploLinkedHashSet() {
        LinkedHashSet<String> set = new LinkedHashSet<>();

        set.add("Carlos");
        set.add("Ana");
        set.add("Carlos"); // ignorado: ya existe

        set.remove("Ana");
        boolean tiene = set.contains("Carlos");
        int tam = set.size();

        // Recorrer
        for (String s : set) System.out.println(s);
    }


    // =========================================================================
    // [E] COLECCIONES - TreeSet
    //     SIN duplicados, ORDER ALFABÉTICO / NATURAL automático
    // =========================================================================
    static void ejemploTreeSet() {
        TreeSet<String> set = new TreeSet<>();

        set.add("Marta");
        set.add("Ana");
        set.add("Pedro");
        set.add("Ana"); // ignorado

        System.out.println("Primero: " + set.first());
        System.out.println("Último:  " + set.last());

        // Recorrer (ya sale ordenado)
        for (String s : set) System.out.println(s);
    }

    // TreeSet de enteros con 30 aleatorios (Ejercicio 3 colecciones)
    static void treintaAleatoriosOrdenados() {
        TreeSet<Integer> set = new TreeSet<>();
        Random rand = new Random();
        for (int i = 0; i < 30; i++) {
            set.add(rand.nextInt(10) + 1); // entre 1 y 10
        }
        System.out.println("Colección ordenada: " + set);
    }


    // =========================================================================
    // [F] COLECCIONES - HashMap
    //     CLAVE → VALOR, sin orden, sin claves duplicadas
    // =========================================================================
    static void ejemploHashMap() {
        HashMap<String, String> mapa = new HashMap<>();

        mapa.put("usuario1", "pass123");      // añadir / sobrescribir
        mapa.remove("usuario1");              // borrar por clave
        String val = mapa.get("usuario1");    // obtener valor (null si no existe)
        boolean existe = mapa.containsKey("usuario1");
        boolean tieneVal = mapa.containsValue("pass123");
        int tam = mapa.size();

        // Recorrer clave-valor
        for (Map.Entry<String, String> entry : mapa.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        // Solo claves
        for (String clave : mapa.keySet()) System.out.println(clave);

        // Solo valores
        for (String v : mapa.values()) System.out.println(v);

        // Incrementar un contador (euromillón)
        HashMap<Integer, Integer> conteo = new HashMap<>();
        int numero = 7;
        if (conteo.containsKey(numero)) {
            conteo.put(numero, conteo.get(numero) + 1); // incrementar
        } else {
            conteo.put(numero, 1); // primera vez
        }
    }


    // =========================================================================
    // [G] COLECCIONES - TreeMap
    //     CLAVE → VALOR, ordenado ALFABÉTICAMENTE por clave
    // =========================================================================
    static void ejemploTreeMap() {
        TreeMap<String, String> diccionario = new TreeMap<>();

        diccionario.put("gato",  "cat");
        diccionario.put("perro", "dog");
        diccionario.put("casa",  "house");

        // Buscar traducción
        String traduccion = diccionario.get("gato");
        if (traduccion != null) {
            System.out.println("Traducción: " + traduccion);
        } else {
            System.out.println("Palabra no encontrada.");
        }

        // Recorrer ordenado por clave
        for (Map.Entry<String, String> e : diccionario.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }
    }


    // =========================================================================
    // [H] MENÚ INTERACTIVO - Bucle do-while + switch
    //     Plantilla estándar para cualquier menú de examen
    // =========================================================================
    static void menuInteractivo() {
        Scanner sc = new Scanner(System.in);
        GestionAlumnos gestion = new GestionAlumnos();
        int opcion;

        do {
            System.out.println("\nALUMNOS/AS");
            System.out.println("===================");
            System.out.println("1. Listado");
            System.out.println("2. Nuevo Alumno");
            System.out.println("3. Modificar");
            System.out.println("4. Borrar");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer tras nextInt()

            switch (opcion) {
                case 1:
                    gestion.listar();
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    System.out.print("Nota: ");
                    double nota = sc.nextDouble();
                    sc.nextLine(); // limpiar buffer
                    gestion.alta(new Alumno(nombre, edad, nota));
                    break;
                case 3:
                    System.out.print("Nombre del alumno a modificar: ");
                    String nomMod = sc.nextLine();
                    System.out.print("Nueva nota: ");
                    double nuevaNota = sc.nextDouble();
                    sc.nextLine();
                    gestion.modificarNota(nomMod, nuevaNota);
                    break;
                case 4:
                    System.out.print("Nombre del alumno a borrar: ");
                    String nomBorrar = sc.nextLine();
                    gestion.baja(nomBorrar);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        sc.close();
    }


    // =========================================================================
    // [I] ENTRADA POR TECLADO - Scanner
    //     Todos los tipos + truco del nextLine() tras nextInt/nextDouble
    // =========================================================================
    static void ejemploScanner() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un entero: ");
        int    entero = sc.nextInt();
        sc.nextLine(); // ← SIEMPRE después de nextInt/nextDouble para limpiar el buffer

        System.out.print("Introduce un decimal: ");
        double decimal = sc.nextDouble();
        sc.nextLine();

        System.out.print("Introduce un String: ");
        String texto = sc.nextLine(); // nextLine lee línea completa con espacios

        System.out.print("Introduce un carácter: ");
        char caracter = sc.nextLine().charAt(0);

        // Leer hasta que se introduzca "fin"
        ArrayList<String> nombres = new ArrayList<>();
        String entrada = "";
        while (!entrada.equalsIgnoreCase("fin")) {
            System.out.print("Nombre (o 'fin' para acabar): ");
            entrada = sc.nextLine();
            if (!entrada.equalsIgnoreCase("fin")) {
                nombres.add(entrada);
            }
        }

        // Leer hasta número negativo
        ArrayList<Integer> numeros = new ArrayList<>();
        int num;
        do {
            System.out.print("Número (negativo para salir): ");
            num = sc.nextInt();
            if (num >= 0) numeros.add(num);
        } while (num >= 0);
    }


    // =========================================================================
    // [J] NÚMEROS ALEATORIOS
    // =========================================================================
    static void ejemploAleatorios() {
        Random rand = new Random();

        int entre0y100  = rand.nextInt(101);      // 0 a 100
        int entre1y10   = rand.nextInt(10) + 1;   // 1 a 10
        int entre5y10   = rand.nextInt(6)  + 5;   // 5 a 10
        int entreMinyMax(int min, int max) { return rand.nextInt(max - min + 1) + min; } // genérico

        // ArrayList con tamaño aleatorio entre 5 y 10
        int tam = rand.nextInt(6) + 5; // 5..10
        ArrayList<Double> lista = new ArrayList<>();
        for (int i = 0; i < tam; i++) {
            lista.add((double) rand.nextInt(101)); // 0..100
        }

        // 20 enteros DISTINTOS menores que 100
        TreeSet<Integer> sinRep = new TreeSet<>();
        while (sinRep.size() < 20) {
            sinRep.add(rand.nextInt(100)); // 0..99, TreeSet ignora duplicados
        }
    }


    // =========================================================================
    // [K] RECORRER COLECCIONES
    // =========================================================================
    static void recorrerColecciones() {
        ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(10, 20, 30, 40));

        // 1. For-each (el más habitual)
        for (int n : lista) System.out.println(n);

        // 2. For clásico con índice
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Índice " + i + ": " + lista.get(i));
        }

        // 3. Iterator (útil para borrar durante el recorrido sin ConcurrentModificationException)
        Iterator<Integer> it = lista.iterator();
        while (it.hasNext()) {
            int val = it.next();
            if (val == 20) it.remove(); // forma segura de borrar durante iteración
        }

        // 4. Mostrar índices de elementos pares (Ejercicio 1 colecciones)
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) % 2 == 0) {
                System.out.println("Índice con valor par: " + i);
            }
        }
    }


    // =========================================================================
    // [L] OPERACIONES MATEMÁTICAS sobre ArrayList
    //     Suma, media, máximo, mínimo
    // =========================================================================
    static void operacionesMatematicas(ArrayList<Double> lista) {
        if (lista.isEmpty()) {
            System.out.println("Lista vacía.");
            return;
        }

        double suma = 0;
        double max  = lista.get(0);
        double min  = lista.get(0);

        for (double n : lista) {
            suma += n;
            if (n > max) max = n;
            if (n < min) min = n;
        }

        double media = suma / lista.size();

        System.out.println("Suma:  " + suma);
        System.out.println("Media: " + media);
        System.out.println("Máx:   " + max);
        System.out.println("Mín:   " + min);

        // Alternativa con Collections
        System.out.println("Max (Collections): " + Collections.max(lista));
        System.out.println("Min (Collections): " + Collections.min(lista));
    }


    // =========================================================================
    // [M] BUSCAR EN UNA LISTA por campo
    // =========================================================================
    static void busquedas() {
        ArrayList<Alumno> lista = new ArrayList<>();

        // Buscar por nombre → devuelve objeto
        String buscar = "Ana";
        Alumno encontrado = null;
        for (Alumno a : lista) {
            if (a.getNombre().equalsIgnoreCase(buscar)) {
                encontrado = a;
                break;
            }
        }
        if (encontrado != null) System.out.println("Encontrado: " + encontrado);
        else System.out.println("No encontrado.");

        // Buscar por nota mínima → devuelve lista filtrada
        double notaMin = 5.0;
        ArrayList<Alumno> aprobados = new ArrayList<>();
        for (Alumno a : lista) {
            if (a.getNota() >= notaMin) aprobados.add(a);
        }

        // Verificar si existe (booleano)
        boolean existe = false;
        for (Alumno a : lista) {
            if (a.getNombre().equalsIgnoreCase("Ana")) { existe = true; break; }
        }
    }


    // =========================================================================
    // [N] ORDENAR UNA LISTA con Comparator
    // =========================================================================
    static void ordenarLista() {
        ArrayList<Alumno> lista = new ArrayList<>();

        // Ordenar por nota ascendente
        lista.sort(Comparator.comparingDouble(Alumno::getNota));

        // Ordenar por nombre alfabético
        lista.sort(Comparator.comparing(Alumno::getNombre));

        // Ordenar por nombre descendente
        lista.sort(Comparator.comparing(Alumno::getNombre).reversed());

        // Ordenar por nota descendente (mayor primero)
        lista.sort(Comparator.comparingDouble(Alumno::getNota).reversed());

        // Ordenar enteros en ArrayList
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(5, 2, 8, 1));
        Collections.sort(nums);                         // ascendente
        Collections.sort(nums, Collections.reverseOrder()); // descendente
    }


    // =========================================================================
    // [P] HERENCIA - Superclase + Subclase
    //     Ejemplo: Persona → Alumno / Profesor
    // =========================================================================
    static class Persona {
        protected String nombre;
        protected String dni;

        public Persona(String nombre, String dni) {
            this.nombre = nombre;
            this.dni    = dni;
        }

        public String getNombre() { return nombre; }
        public String getDni()    { return dni;    }

        public void mostrarInfo() {
            System.out.println("Nombre: " + nombre + ", DNI: " + dni);
        }

        @Override
        public String toString() {
            return "Persona{nombre='" + nombre + "', dni='" + dni + "'}";
        }
    }

    static class Estudiante extends Persona {
        private double nota;

        public Estudiante(String nombre, String dni, double nota) {
            super(nombre, dni); // llamada al constructor del padre
            this.nota = nota;
        }

        public double getNota() { return nota; }

        @Override
        public void mostrarInfo() {   // sobreescribir método del padre
            super.mostrarInfo();      // llamar al padre
            System.out.println("Nota: " + nota);
        }

        @Override
        public String toString() {
            return "Estudiante{" + super.toString() + ", nota=" + nota + "}";
        }
    }


    // =========================================================================
    // [Q] INTERFAZ
    // =========================================================================
    interface Gestionable {
        void alta(Object obj);
        void baja(String id);
        void listar();
    }

    // Clase que implementa la interfaz
    static class GestorBasico implements Gestionable {
        private ArrayList<Object> items = new ArrayList<>();

        @Override
        public void alta(Object obj) { items.add(obj); }

        @Override
        public void baja(String id) { /* lógica de borrado */ }

        @Override
        public void listar() {
            for (Object o : items) System.out.println(o);
        }
    }


    // =========================================================================
    // [R] CLASE ABSTRACTA
    //     No se puede instanciar directamente; obliga a implementar métodos
    // =========================================================================
    static abstract class Contenido {
        protected String titulo;
        protected int    duracion;
        protected Nivel  nivel;

        public Contenido(String titulo, int duracion, Nivel nivel) {
            this.titulo   = titulo;
            this.duracion = duracion;
            this.nivel    = nivel;
        }

        // Método abstracto: OBLIGATORIO en cada subclase
        public abstract double calcularPrecio();

        // Método concreto: heredado tal cual
        public void mostrar() {
            System.out.println(titulo + " | " + duracion + "min | " + nivel);
        }
    }

    static class Curso extends Contenido {
        private int numLecciones;

        public Curso(String titulo, int duracion, Nivel nivel, int numLecciones) {
            super(titulo, duracion, nivel);
            this.numLecciones = numLecciones;
        }

        @Override
        public double calcularPrecio() {
            return numLecciones * 2.5;
        }
    }


    // =========================================================================
    // [S] PATRONES DE EXAMEN ESPECÍFICOS
    // =========================================================================

    // --- PATRÓN: Control de stock (GESTISIMAL) ---
    static class Articulo {
        private String codigo, nombre;
        private double precio;
        private int    stock;

        public Articulo(String codigo, String nombre, double precio, int stock) {
            this.codigo  = codigo;
            this.nombre  = nombre;
            this.precio  = precio;
            this.stock   = stock;
        }

        // Entrada de mercancía (incrementar stock)
        public void entradaMercancia(int cantidad) {
            this.stock += cantidad;
            System.out.println("Stock actualizado: " + this.stock);
        }

        // Salida de mercancía (decrementar stock con control)
        public void salidaMercancia(int cantidad) {
            if (cantidad > this.stock) {
                System.out.println("ERROR: No hay suficiente stock. Stock actual: " + this.stock);
            } else {
                this.stock -= cantidad;
                System.out.println("Salida registrada. Stock actual: " + this.stock);
            }
        }

        public String getCodigo() { return codigo; }
        public int    getStock()  { return stock;  }

        @Override
        public String toString() {
            return "Articulo{codigo='" + codigo + "', nombre='" + nombre +
                   "', precio=" + precio + ", stock=" + stock + "}";
        }
    }

    // --- PATRÓN: Préstamo con límite (Biblioteca) ---
    static class Socio {
        private String id, nombre;
        private ArrayList<String> prestamosActivos = new ArrayList<>();
        private static final int LIMITE_PRESTAMOS = 3;

        public Socio(String id, String nombre) {
            this.id     = id;
            this.nombre = nombre;
        }

        public boolean puedePrestar() {
            return prestamosActivos.size() < LIMITE_PRESTAMOS;
        }

        public void agregarPrestamo(String isbn) {
            if (puedePrestar()) {
                prestamosActivos.add(isbn);
                System.out.println("Préstamo registrado.");
            } else {
                System.out.println("ERROR: El socio ha alcanzado el límite de " + LIMITE_PRESTAMOS + " préstamos.");
            }
        }

        public void devolverPrestamo(String isbn) {
            if (prestamosActivos.remove(isbn)) {
                System.out.println("Devolución registrada.");
            } else {
                System.out.println("ERROR: No se encontró ese préstamo activo.");
            }
        }

        public String getId()  { return id; }
        public String getNombre() { return nombre; }
        public ArrayList<String> getPrestamosActivos() { return prestamosActivos; }

        @Override
        public String toString() {
            return "Socio{id='" + id + "', nombre='" + nombre +
                   "', préstamos activos=" + prestamosActivos.size() + "/" + LIMITE_PRESTAMOS + "}";
        }
    }

    // --- PATRÓN: Libro con disponibilidad ---
    static class Libro {
        private String isbn, titulo, autor;
        private int    ejemplaresTotal;
        private int    ejemplaresDisponibles;

        public Libro(String isbn, String titulo, String autor, int ejemplares) {
            this.isbn                 = isbn;
            this.titulo               = titulo;
            this.autor                = autor;
            this.ejemplaresTotal      = ejemplares;
            this.ejemplaresDisponibles = ejemplares;
        }

        public boolean estaDisponible() {
            return ejemplaresDisponibles > 0;
        }

        public void prestar() {
            if (estaDisponible()) {
                ejemplaresDisponibles--;
            } else {
                System.out.println("ERROR: No hay ejemplares disponibles.");
            }
        }

        public void devolver() {
            if (ejemplaresDisponibles < ejemplaresTotal) {
                ejemplaresDisponibles++;
            }
        }

        public String getIsbn() { return isbn; }

        @Override
        public String toString() {
            return "Libro{isbn='" + isbn + "', titulo='" + titulo +
                   "', disponibles=" + ejemplaresDisponibles + "/" + ejemplaresTotal + "}";
        }
    }

    // --- PATRÓN: Login con intentos (HashMap + contador) ---
    static void sistemaLogin() {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> usuarios = new HashMap<>();
        usuarios.put("admin", "1234");
        usuarios.put("pepe",  "abcd");

        int opcion;
        do {
            System.out.println("1. Registro  2. Login  0. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                System.out.print("Usuario: ");  String user = sc.nextLine();
                System.out.print("Contraseña: "); String pass = sc.nextLine();
                if (usuarios.containsKey(user)) {
                    System.out.println("ERROR: El usuario ya existe.");
                } else {
                    usuarios.put(user, pass);
                    System.out.println("Registro exitoso.");
                }

            } else if (opcion == 2) {
                int intentos = 0;
                boolean acceso = false;
                while (intentos < 3 && !acceso) {
                    System.out.print("Usuario: ");  String user = sc.nextLine();
                    System.out.print("Contraseña: "); String pass = sc.nextLine();
                    if (usuarios.containsKey(user) && usuarios.get(user).equals(pass)) {
                        System.out.println("Ha accedido al área restringida.");
                        acceso = true;
                    } else {
                        intentos++;
                        System.out.println("Credenciales incorrectas. Intentos: " + intentos + "/3");
                    }
                }
                if (!acceso) System.out.println("Lo siento, no tiene acceso al área restringida.");
            }

        } while (opcion != 0);
    }

    // --- PATRÓN: Euromillón (HashMap con conteo de apariciones) ---
    static void euromillon() {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> numeros  = new TreeMap<>(); // TreeMap → ordenado
        HashMap<Integer, Integer> estrellas = new TreeMap<>();

        System.out.println("Introduce los 5 números del sorteo:");
        for (int i = 0; i < 5; i++) {
            int n = sc.nextInt();
            numeros.put(n, numeros.getOrDefault(n, 0) + 1); // getOrDefault evita el if
        }

        System.out.println("Introduce las 2 estrellas:");
        for (int i = 0; i < 2; i++) {
            int e = sc.nextInt();
            estrellas.put(e, estrellas.getOrDefault(e, 0) + 1);
        }

        System.out.println("Números: "  + numeros);
        System.out.println("Estrellas: " + estrellas);
    }

    // --- PATRÓN: Estadísticas - Elemento más repetido en lista ---
    static void elementoMasRepetido(ArrayList<String> lista) {
        HashMap<String, Integer> conteo = new HashMap<>();
        for (String s : lista) {
            conteo.put(s, conteo.getOrDefault(s, 0) + 1);
        }
        String masRepetido = null;
        int maxVeces = 0;
        for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
            if (entry.getValue() > maxVeces) {
                maxVeces     = entry.getValue();
                masRepetido  = entry.getKey();
            }
        }
        System.out.println("Más repetido: " + masRepetido + " (" + maxVeces + " veces)");
    }

    // =========================================================================
    // MAIN - punto de entrada
    // =========================================================================
    public static void main(String[] args) {
        // Descomenta lo que quieras probar:
        // menuInteractivo();
        // sistemaLogin();
        // euromillon();
        System.out.println("Archivo de referencia cargado correctamente.");
    }
}