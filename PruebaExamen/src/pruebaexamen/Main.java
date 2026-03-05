// MAIN
package pruebaexamen;

public class Main {
    public static void main(String[] args) {

        // Leer y validar los strings
    	boolean textosValidos = funciones.leerComprobar();

    	if (!textosValidos) {
            System.out.println("Alguno de los strings no es válido.");
            return;
        }

        // Contar subsecuencias
        int vecesQueAparece = funciones.buscarMensaje(funciones.textoMin, funciones.mensajeMin);

        System.out.println("Tu mensaje:" + funciones.mensajeInicial + " aparece " + vecesQueAparece + " vez/veces en " + funciones.textoInicial);
    }
}