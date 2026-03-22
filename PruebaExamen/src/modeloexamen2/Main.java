package modeloexamen2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		// -------------------1----------------------
		String mensajes[] = { "LA NIEBLA CUBRE EL PUENTE", "NO MIRES DETRÁS DE LA PUERTA",
				"EL RELOJ SUENA A MEDIANOCHE", "LAS SOMBRAS SABEN TU NOMBRE", "TODO MENSAJE DEJA UNA HUELLA",
				"EL ECO REPITE LA VERDAD", "ALGUIEN ESCONDE ALGO AQUÍ", "NUNCA APAGUES LA RADIO" };
		
		boolean salirMenu = false;
		while(!salirMenu) {
			
			System.out.println("ARCHIVOS DE LOS ECOS \n"
					+ "1. Mostrar mensajes\n"
					+ "2. Contar letra en un mensaje\n"
					+ "3. Extraer mensaje oculto\n"
					+ "4. Buscar palabra en todos los mensajes\n"
					+ "5. Marcar mensaje como alterado\n"
					+ "6. Mostrar palabra más larga de un mensaje\n"
					+ "7. Mostrar estadísticas generales\n"
					+ "8. Salir\n"
					+ ""); 
			
		System.out.println("Introduce una opcion, INDICANDO EL NUMERO: ");
		
		int opcionUsuario=0;

		try { //IMPORTANTE TRY Y CATCH EN TODO LO Q PUEDAS
			 opcionUsuario= sc.nextInt();
		} catch(Exception e) {
			System.out.println("Debes introducir un número del menu de opciones");
		}
		sc.nextLine(); //IMPORTANTE PONER LA SEGUNDA COMO NEXT SINO NEXT INT SE LO COMEEEE
		
		if(opcionUsuario>0 && opcionUsuario<9) {
			switch(opcionUsuario) {				
			
		case 1: {
			 mostrarMensajes(mensajes);
	         break;
			}
	     case 2: {
	         System.out.println("Introduce el mensaje: ");
	         String mensaje = sc.nextLine();
	         
	         System.out.println("Introduce la letra a contar: ");
	         char letra = sc.nextLine().charAt(0); 
	         
	         int cantidad = contarLetra(mensaje, letra);
	         System.out.println("La letra " + letra + " aparece " + cantidad + " veces");
	         break;
	     }
	     case 3: {
	         System.out.println("Introduce el mensaje para extraer el oculto: ");
	         String mensaje = sc.nextLine();
	         String oculto = extraerMensajeOculto(mensaje);
	         System.out.println("Mensaje oculto: " + oculto);
	         break;
	     }
	     case 4: {
	         System.out.println("Introduce la palabra a buscar: ");
	         String palabra = sc.nextLine();
	         int cantidad = buscarMensajesConPalabra(mensajes, palabra);
	         System.out.println("La palabra '" + palabra + "' aparece en " + cantidad + " mensajes");
	         break;
	     }
	     case 5: {
	         System.out.println("Introduce el índice del mensaje a marcar (0-" + (mensajes.length-1) + "): ");
	         int indice = sc.nextInt();
	         sc.nextLine(); // Consumir el salto de línea
	         
	         boolean resultado = marcarAlterado(mensajes, indice);
	         if(resultado) {
	             System.out.println("Mensaje marcado como alterado correctamente");
	         } else {
	             System.out.println("No se pudo marcar el mensaje (índice inválido o ya estaba marcado)");
	         }
	         break;
	     }
	     case 6: {
	         System.out.println("Introduce un mensaje para encontrar la palabra más larga: ");
	         String mensaje = sc.nextLine();
	         String palabraLarga = palabraMasLarga(mensaje);
	         System.out.println("La palabra más larga es: '" + palabraLarga + "' con " + palabraLarga.length() + " letras");
	         break;
	     }
	     case 7: {
	    	 mostrarEstadisticas(mensajes);
	    	    break;
	     }
	     case 8: {
	         System.out.println("Saliendo del programa...");
	         salirMenu = true;
	         break;
	     }
	 } }else

	{
		System.out.println("ERROR, INTRODUCE UNA OPCION VALIDA DEL 1-8");
	}
		}
	}// fin MAIN

	// -------------------2-------------------
	static void mostrarMensajes(String[] mensajes) {
		int posicionMensajes = 0;
		for (posicionMensajes = 0; posicionMensajes < mensajes.length; posicionMensajes++) {
			System.out.println(posicionMensajes + ". " + mensajes[posicionMensajes]);
		} // fin For
	}// fin mostrarMensaje

	// -------------------3-------------------
	static boolean esIndiceValido(String[] mensajes, int indice) {
		boolean existe = true;
		if (indice > mensajes.length || indice < mensajes.length) {
			existe = false;
		}
		return existe;
	}// fin esIndiceValido

	// -------------------4-------------------

	static int contarLetra(String mensaje, char letra) {

		letra= Character.toUpperCase(letra); //PARA CAMBIAR CHAR A MAYUS
		mensaje = mensaje.toUpperCase(); 
		
		char[] mensajeEnArray = mensaje.toCharArray();
		int letrasEnTexto = 0;

		for (int posicionTexto = 0; posicionTexto < mensajeEnArray.length; posicionTexto++) {

			if (letra == mensajeEnArray[posicionTexto]) {
				letrasEnTexto++;
			}
		}
		return letrasEnTexto;

	}

	// -------------------5-------------------
	static String quitarEspacios(String mensaje) {
		String mensajeSinEspacios = mensaje.trim();

		return mensajeSinEspacios;
	}

	// -------------------6-------------------

	static String extraerMensajeOculto(String mensaje) { // holaquetalfulano 10
		mensaje = quitarEspacios(mensaje); // h l q e a f l n

		char[] mensajeArray = mensaje.toCharArray();
		char[] mensajeOculto = new char[mensajeArray.length]; // IMPORTANTE ARRAY VACIO
		int contadorMensajeOculto = 0;

		for (int posicionMensaje = 0; posicionMensaje < mensajeArray.length; posicionMensaje++) {
			if (posicionMensaje % 2 == 0) {
				mensajeOculto[contadorMensajeOculto] = mensajeArray[posicionMensaje];
				contadorMensajeOculto++;
			} // acaba if
		} // acaba for

		String mensajeOcultoFinal = new String(mensajeOculto).toUpperCase(); // IMPORTANTE PARA PASAR DE ARRAY A STRING
		quitarEspacios(mensajeOcultoFinal);

		return mensajeOcultoFinal;
	} // fin extraerMensajeOculto

//-------------------7-------------------
	static int buscarMensajesConPalabra(String[] mensajes, String palabra) {
		palabra = palabra.toUpperCase();

		int numeroDeMensajesContienenPalabra = 0;
		for (int contadorMensajes = 0; contadorMensajes < mensajes.length; contadorMensajes++) {
			if (mensajes[contadorMensajes].contains(palabra)) {
				numeroDeMensajesContienenPalabra++;
			}
		}
		return numeroDeMensajesContienenPalabra;
	}

//-------------------8-------------------

	static boolean marcarAlterado(String[] mensajes, int indice) {
		boolean marcadoAlterado = false;

		if (indice < mensajes.length) { // validar q el indice es menor al tamaño max del array. VALIDO
			if (mensajes[indice].contains("[ALTERADO]")) {
				marcadoAlterado = false;
			} else {
				mensajes[indice] = "[ALTERADO]" + mensajes[indice];
				marcadoAlterado = true;
			}
		}
		return marcadoAlterado;

	}

//-------------------9-------------------

	static String palabraMasLarga(String mensaje) {
		String palabraLarga = "";

		String[] mensajeArray = mensaje.split(" ");
		for (int indice = 0; indice < mensajeArray.length; indice++) {
			if (palabraLarga.length() < mensajeArray[indice].length()) {
				palabraLarga = mensajeArray[indice];

			}
		}
		return palabraLarga;
	}

	//-----------------10--------------------
	static void mostrarEstadisticas(String[] mensajes) {
	    System.out.println("=== ESTADÍSTICAS GENERALES ===");
	    
	    System.out.println("Total de mensajes: " + mensajes.length);
	    
	    // 2. Cuántos están marcados como alterados
	    int alterados = 0;
	    for(int i = 0; i < mensajes.length; i++) {
	        if(mensajes[i].contains("[ALTERADO]")) {
	            alterados++;
	        }
	    }
	    System.out.println("Mensajes marcados como alterados: " + alterados);
	    
	    // 3. Cuál es el mensaje con mayor longitud
	    String mensajeMasLargo = "";
	    int longitudMaxima = 0;
	    
	    for(int i = 0; i < mensajes.length; i++) {
	            if(mensajes[i].length() > mensajeMasLargo.length()) {
	                mensajeMasLargo = mensajes[i];
	            }
	        }
	    System.out.println("Mensaje con mayor longitud: " + mensajeMasLargo);
	    
	    // 4. Cuántas veces aparece en total la letra 'A' en todos los mensajes
	    int totalLetrasA = 0;
	    for(int i = 0; i < mensajes.length; i++) {
	            totalLetrasA += contarLetra(mensajes[i], 'A');
	    }
	    System.out.println("Total de letras A en todos los mensajes: " + totalLetrasA);
	}
	//-----------------10--------------------

	public static void invertirArray(String[] args) {
		int numeros[]= {1,2,3,4,5};
		int aux[]= new int[numeros.length];
		
		for(int i=numeros.length-1, j=0; i>=0 ;i--,j++) {
			aux[j]=numeros[i];
			System.out.println(aux[j]);
		}
		
	}
	
	
	
	
	

}// fin clase NO TOCAR