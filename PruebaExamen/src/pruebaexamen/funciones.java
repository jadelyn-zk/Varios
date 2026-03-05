package pruebaexamen;

import java.util.Scanner;

public class funciones {

    // Ahora NO recibe parámetros, los lee dentro y los devuelve
	   	
	public static String textoMin;
	public static String mensajeMin;
    public static String textoInicial;
    public static String mensajeInicial;

	    public static boolean leerComprobar() {

	        Scanner sc = new Scanner(System.in);

	        System.out.println("Introduce tu texto: ");
	        textoInicial = sc.nextLine();

	        System.out.println("Introduce tu mensaje: ");
	        mensajeInicial = sc.nextLine();

	        textoMin   = textoInicial.toLowerCase();
	        mensajeMin = mensajeInicial.toLowerCase();

	        if (textoMin.isEmpty() || textoMin.isBlank() ||
	            mensajeMin.isEmpty() || mensajeMin.isBlank()) {
	            return false;
	        }

	        return true;
	    }


    public static int buscarMensaje(String texto, String mensaje) {
        int vecesEncontradas = 0;

        char[] letrasTexto   = texto.toCharArray();
        char[] letrasMensaje = mensaje.toCharArray();

        int posMensaje = 0;

        for (int posTexto = 0; posTexto < letrasTexto.length; posTexto++) {

            // Si la letra del texto coincide con la que toca del mensaje, avanzamos en el mensaje
            if (letrasTexto[posTexto] == letrasMensaje[posMensaje]) {
                posMensaje++;
            }

            // Si hemos completado el mensaje entero, contamos 1 y reiniciamos
            if (posMensaje == letrasMensaje.length) {
                vecesEncontradas++;
                posMensaje = 0;
            }
        }

        return vecesEncontradas;

    }
} 
	 