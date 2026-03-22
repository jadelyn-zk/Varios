package funcionesTipicas;

public class excepciones {
	import java.util.*;
	import java.io.*;

	/**
	 * ARCHIVO DE REFERENCIA - EXCEPCIONES EN JAVA
	 * Para el examen: copia el bloque try-catch que necesites.
	 */
	    static void metodoRecursivo() {
	        metodoRecursivo();
	    }

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        // =====================================================================
	        // 1. NullPointerException
	        //    Se lanza al intentar usar un objeto que es null
	        // =====================================================================
	        try {
	            String s = null;
	            s.length();
	        } catch (NullPointerException e) {
	            System.out.println("ERROR: El objeto es null, no puedes operar con él.");
	        }

	        // =====================================================================
	        // 2. ArrayIndexOutOfBoundsException
	        //    Se lanza al acceder a un índice que no existe en un array
	        // =====================================================================
	        try {
	            int[] array = new int[3];
	            System.out.print("Introduce un índice para el array (tamaño 3): ");
	            int indice = sc.nextInt();
	            int x = array[indice];
	        } catch (ArrayIndexOutOfBoundsException e) {
	            System.out.println("ERROR: El índice introducido está fuera del rango del array.");
	        }

	        // =====================================================================
	        // 3. StringIndexOutOfBoundsException
	        //    Se lanza al acceder a un índice inválido de un String
	        // =====================================================================
	        try {
	            String s = "Hola";
	            System.out.print("Introduce una posición del String \"Hola\": ");
	            int pos = sc.nextInt();
	            char c = s.charAt(pos);
	        } catch (StringIndexOutOfBoundsException e) {
	            System.out.println("ERROR: La posición introducida no existe en el String.");
	        }

	        // =====================================================================
	        // 4. ClassCastException
	        //    Se lanza al hacer un cast inválido entre tipos incompatibles
	        // =====================================================================
	        try {
	            Object obj = "Soy un String";
	            Integer num = (Integer) obj;
	        } catch (ClassCastException e) {
	            System.out.println("ERROR: No se puede convertir el objeto al tipo indicado.");
	        }

	        // =====================================================================
	        // 5. NumberFormatException
	        //    Se lanza al convertir un String que no es número a tipo numérico
	        // =====================================================================
	        try {
	            System.out.print("Introduce un número entero: ");
	            String entrada = sc.next();
	            int num = Integer.parseInt(entrada);
	        } catch (NumberFormatException e) {
	            System.out.println("ERROR: El valor introducido no es un número entero válido.");
	        }

	        // =====================================================================
	        // 6. ArithmeticException
	        //    Se lanza en operaciones aritméticas ilegales (ej: división entre 0)
	        // =====================================================================
	        try {
	            System.out.print("Introduce el divisor (prueba con 0): ");
	            int divisor = sc.nextInt();
	            int resultado = 10 / divisor;
	        } catch (ArithmeticException e) {
	            System.out.println("ERROR: No se puede dividir entre cero.");
	        }

	        // =====================================================================
	        // 7. StackOverflowError
	        //    Se lanza cuando la pila de llamadas se desborda (recursión infinita)
	        // =====================================================================
	        try {
	            metodoRecursivo();
	        } catch (StackOverflowError e) {
	            System.out.println("ERROR: Recursión infinita, se ha desbordado la pila de llamadas.");
	        }

	        // =====================================================================
	        // 8. OutOfMemoryError
	        //    Se lanza cuando la JVM se queda sin memoria heap
	        // =====================================================================
	        try {
	            int[] gigante = new int[Integer.MAX_VALUE];
	        } catch (OutOfMemoryError e) {
	            System.out.println("ERROR: No hay suficiente memoria para completar la operación.");
	        }

	        // =====================================================================
	        // 9. IllegalArgumentException
	        //    Se lanza al pasar un argumento ilegal o inapropiado a un método
	        // =====================================================================
	        try {
	            System.out.print("Introduce la prioridad del hilo (rango válido 1-10): ");
	            int prioridad = sc.nextInt();
	            Thread t = new Thread();
	            t.setPriority(prioridad);
	        } catch (IllegalArgumentException e) {
	            System.out.println("ERROR: El argumento introducido no es válido para este método.");
	        }

	        // =====================================================================
	        // 10. IllegalStateException
	        //     Se lanza cuando un método se invoca en un estado incorrecto
	        // =====================================================================
	        try {
	            Iterator<String> it = new ArrayList<String>().iterator();
	            it.remove(); // remove() sin haber llamado next() antes
	        } catch (IllegalStateException e) {
	            System.out.println("ERROR: El objeto no se encuentra en un estado válido para esta operación.");
	        }

	        // =====================================================================
	        // 11. UnsupportedOperationException
	        //     Se lanza cuando una operación no está soportada por el objeto
	        // =====================================================================
	        try {
	            List<String> lista = List.of("a", "b", "c"); // lista inmutable
	            lista.add("d");
	        } catch (UnsupportedOperationException e) {
	            System.out.println("ERROR: Esta operación no está permitida en este objeto (lista inmutable).");
	        }

	        // =====================================================================
	        // 12. ConcurrentModificationException
	        //     Se lanza al modificar una colección mientras se itera sobre ella
	        // =====================================================================
	        try {
	            List<String> lista = new ArrayList<>(Arrays.asList("a", "b", "c"));
	            for (String s : lista) {
	                lista.remove(s);
	            }
	        } catch (ConcurrentModificationException e) {
	            System.out.println("ERROR: No puedes modificar la lista mientras la estás recorriendo.");
	        }

	        // =====================================================================
	        // 13. NoSuchElementException
	        //     Se lanza al pedir el siguiente elemento cuando no existe más
	        // =====================================================================
	        try {
	            Iterator<String> it = new ArrayList<String>().iterator();
	            it.next();
	        } catch (NoSuchElementException e) {
	            System.out.println("ERROR: No existe el elemento solicitado, el iterador está vacío.");
	        }

	        // =====================================================================
	        // 14. NegativeArraySizeException
	        //     Se lanza al crear un array con tamaño negativo
	        // =====================================================================
	        try {
	            System.out.print("Introduce el tamaño del array: ");
	            int tam = sc.nextInt();
	            int[] arr = new int[tam];
	        } catch (NegativeArraySizeException e) {
	            System.out.println("ERROR: El tamaño del array no puede ser negativo.");
	        }

	        // =====================================================================
	        // 15. ArrayStoreException
	        //     Se lanza al guardar un tipo incompatible en un array de objetos
	        // =====================================================================
	        try {
	            Object[] arr = new String[3];
	            arr[0] = 42; // un Integer en un array declarado como String[]
	        } catch (ArrayStoreException e) {
	            System.out.println("ERROR: El tipo del objeto no es compatible con el tipo del array.");
	        }

	        // =====================================================================
	        // 16. IOException  (checked)
	        //     Se lanza en operaciones de entrada/salida fallidas
	        // =====================================================================
	        try {
	            System.out.print("Introduce el nombre del fichero a abrir: ");
	            String nombreFichero = sc.next();
	            FileReader fr = new FileReader(nombreFichero);
	        } catch (IOException e) {
	            System.out.println("ERROR: Fallo en la operación de entrada/salida: " + e.getMessage());
	        }

	        // =====================================================================
	        // 17. FileNotFoundException  (checked, subclase de IOException)
	        //     Se lanza cuando no se encuentra el archivo indicado
	        // =====================================================================
	        try {
	            System.out.print("Introduce la ruta del fichero: ");
	            String ruta = sc.next();
	            FileInputStream fis = new FileInputStream(ruta);
	        } catch (FileNotFoundException e) {
	            System.out.println("ERROR: El fichero indicado no existe o no se puede abrir.");
	        }

	        // =====================================================================
	        // 18. EOFException  (checked, subclase de IOException)
	        //     Se lanza al alcanzar el fin de fichero inesperadamente
	        // =====================================================================
	        try {
	            DataInputStream dis = new DataInputStream(
	                new ByteArrayInputStream(new byte[0])
	            );
	            dis.readInt();
	        } catch (EOFException e) {
	            System.out.println("ERROR: Se alcanzó el fin del fichero antes de leer todos los datos esperados.");
	        } catch (IOException e) {
	            System.out.println("ERROR: Fallo leyendo el fichero.");
	        }

	        // =====================================================================
	        // 19. ClassNotFoundException  (checked)
	        //     Se lanza al intentar cargar una clase que no existe en el classpath
	        // =====================================================================
	        try {
	            System.out.print("Introduce el nombre de la clase a cargar: ");
	            String nombreClase = sc.next();
	            Class.forName(nombreClase);
	        } catch (ClassNotFoundException e) {
	            System.out.println("ERROR: La clase \"" + e.getMessage() + "\" no se encontró en el classpath.");
	        }

	        // =====================================================================
	        // 20. InterruptedException  (checked)
	        //     Se lanza cuando un hilo es interrumpido mientras duerme o espera
	        // =====================================================================
	        try {
	            System.out.print("Introduce los milisegundos que dormirá el hilo: ");
	            int ms = sc.nextInt();
	            Thread.sleep(ms);
	        } catch (InterruptedException e) {
	            System.out.println("ERROR: El hilo fue interrumpido mientras estaba en espera.");
	        }

	        // =====================================================================
	        // 21. InputMismatchException
	        //     Se lanza con Scanner cuando el tipo leído no coincide con el esperado
	        // =====================================================================
	        try {
	            Scanner scLocal = new Scanner(System.in);
	            System.out.print("Introduce un número entero: ");
	            int num = scLocal.nextInt(); // si introduces texto lanza la excepción
	        } catch (InputMismatchException e) {
	            System.out.println("ERROR: El valor introducido no coincide con el tipo esperado (se esperaba un entero).");
	        }

	        // =====================================================================
	        // 22. ParseException  (checked)
	        //     Se lanza al fallar el parseo de una fecha u otro formato concreto
	        // =====================================================================
	        try {
	            System.out.print("Introduce una fecha (formato dd/MM/yyyy): ");
	            String fechaStr = sc.next();
	            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
	            sdf.setLenient(false);
	            java.util.Date fecha = sdf.parse(fechaStr);
	        } catch (java.text.ParseException e) {
	            System.out.println("ERROR: La fecha introducida no tiene el formato correcto (dd/MM/yyyy).");
	        }

	        // =====================================================================
	        // 23. SQLException  (checked)
	        //     Se lanza en operaciones de base de datos fallidas
	        // =====================================================================
	        try {
	            java.sql.DriverManager.getConnection("jdbc:mysql://localhost/dbInexistente", "user", "pass");
	        } catch (java.sql.SQLException e) {
	            System.out.println("ERROR: Fallo en la base de datos - " + e.getMessage());
	        }

	        sc.close();
	    }
	}
}
