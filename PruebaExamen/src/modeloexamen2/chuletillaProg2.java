package modeloexamen2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class chuletillaProg2 {

	public static void main(String[] args) { //PARA INVERTIR ARRAYS

		int numeros[]= {1,2,3,4,5};
		int numerosInvertidos[]= new int[numeros.length];
		int contador=0; 
		
		for(int indiceNumeros=numeros.length-1; indiceNumeros>=0 ; indiceNumeros--) {
			numerosInvertidos[contador] = numeros[indiceNumeros];
			contador++;
		}
		System.out.println("Array invertido: " + Arrays.toString(numerosInvertidos)); //PARA IMPRIMIR ARRAYS
	
	
	//PARA COPIAR ARRAYS
	int numeritos[] = {1,2,3,4,5};
	int numeritosCopia[]= new int[numeritos.length];
	int indiceCopia=0;
	
	for (int indiceNumeritos=0; indiceNumeritos<numeritos.length;indiceNumeritos++) {
		numeritosCopia[indiceCopia] = numeritos[indiceNumeritos];
		indiceCopia++;
	}
	System.out.println("Array invertido: " + Arrays.toString(numeritosCopia) + Arrays.toString(numeritos)); //PARA IMPRIMIR ARRAYS

	
	//COPIAR ARRAYS OTRA MANERA CON COPY OF
	int[] original = {1, 2, 3, 4, 5};

	// Copiar completo
	int[] copia1 = Arrays.copyOf(original, original.length);  // {1, 2, 3, 4, 5}

	// Copiar solo primeros 3
	int[] copia2 = Arrays.copyOf(original, 3);  // {1, 2, 3}

	// Copiar con tamaño mayor (rellena con 0)
	int[] copia3 = Arrays.copyOf(original, 7);  // {1, 2, 3, 4, 5, 0, 0}

	// Copiar con tamaño 0 (array vacio)
	int[] copia4 = Arrays.copyOf(original, 0);  // {}

	// Con Strings
	String[] palabras = {"hola", "mundo", "java"};
	String[] copia5 = Arrays.copyOf(palabras, 2);  // {"hola", "mundo"}

	// Con char
	char[] letras = {'a', 'b', 'c', 'd'};
	char[] copia6 = Arrays.copyOf(letras, 5);  // {'a', 'b', 'c', 'd', '\u0000'}
	
	
//	## Funciones de `java.lang.String`:
//
//		length() devuelve la longitud del string
//		charAt(int index) devuelve el caracter en la posicion indicada
//		toCharArray() convierte el string a un array de caracteres
//
//		equals(Object obj) compara si dos strings son iguales
//		equalsIgnoreCase(String str) compara ignorando mayusculas/minusculas
//		compareTo(String str) compara lexicograficamente
//		compareToIgnoreCase(String str) compara lexicograficamente ignorando mayusculas/minusculas
//
//		toLowerCase() convierte todo a minusculas
//		toUpperCase() convierte todo a mayusculas
//		trim() elimina espacios en blanco al inicio y final
//		strip() elimina espacios Unicode al inicio y final (Java 11+)
//		stripLeading() elimina espacios Unicode al inicio (Java 11+)
//		stripTrailing() elimina espacios Unicode al final (Java 11+)
//
//		substring(int beginIndex) extrae desde beginIndex hasta el final
//		substring(int beginIndex, int endIndex) extrae desde beginIndex hasta endIndex-1
//		subSequence(int beginIndex, int endIndex) similar a substring pero devuelve CharSequence
//
//		replace(char oldChar, char newChar) reemplaza todas las ocurrencias de un caracter
//		replace(CharSequence target, CharSequence replacement) reemplaza todas las ocurrencias de una secuencia
//		replaceAll(String regex, String replacement) reemplaza usando expresion regular
//		replaceFirst(String regex, String replacement) reemplaza la primera ocurrencia usando regex
//
//		split(String regex) divide el string en array usando regex
//		split(String regex, int limit) divide con limite de resultados
//		join(CharSequence delimiter, CharSequence... elements) une elementos con delimitador (metodo estatico)
//
//		contains(CharSequence s) verifica si contiene una secuencia
//		startsWith(String prefix) verifica si empieza con prefijo
//		startsWith(String prefix, int offset) verifica si empieza con prefijo desde posicion
//		endsWith(String suffix) verifica si termina con sufijo
//
//		indexOf(int ch) busca primera aparicion de un caracter
//		indexOf(int ch, int fromIndex) busca desde posicion
//		indexOf(String str) busca primera aparicion de un string
//		indexOf(String str, int fromIndex) busca desde posicion
//		lastIndexOf(int ch) busca ultima aparicion de un caracter
//		lastIndexOf(int ch, int fromIndex) busca hacia atras desde posicion
//		lastIndexOf(String str) busca ultima aparicion de un string
//		lastIndexOf(String str, int fromIndex) busca hacia atras desde posicion
//
//		isEmpty() verifica si longitud es 0
//		isBlank() verifica si solo tiene espacios en blanco (Java 11+)
//
//		concat(String str) concatena otro string al final
//		repeat(int count) repite el string count veces (Java 11+)
//
//		matches(String regex) verifica si coincide con expresion regular
//		format(String format, Object... args) formatea string con especificadores (metodo estatico)
//
//		valueOf(X x) convierte diferentes tipos a string (metodo estatico)
//		intern() devuelve representacion canonica del string
//
//		getBytes() convierte a array de bytes con encoding por defecto
//		getBytes(String charsetName) convierte a array de bytes con encoding especifico
//		toCharArray() convierte a array de caracteres
//
//		indent(int n) agrega o quita espacios al inicio (Java 12+)
//		transform(Function<String, R> f) aplica una funcion al string (Java 12+)
//		stripIndent() elimina espacios indentados (Java 15+)
//		translateEscapes() traduce secuencias de escape (Java 15+)
//		formatted(Object... args) similar a format pero como metodo de instancia (Java 15+)
	
	
	
}
//	toString(array) convierte array a string legible
//	deepToString(array) convierte array multidimensional a string
//	asList(T... a) convierte array a Lista
//	sort(array) ordena el array completo
//	sort(array, fromIndex, toIndex) ordena parte del array
//	parallelSort(array) ordena en paralelo para grandes arrays
//	binarySearch(array, key) busca un elemento (array ordenado)
//	binarySearch(array, fromIndex, toIndex, key) busca en un rango
//	equals(array1, array2) compara si dos arrays son iguales
//	deepEquals(array1, array2) compara arrays multidimensionales
//	fill(array, value) llena todo el array con un valor
//	fill(array, fromIndex, toIndex, value) llena un rango del array
//	copyOf(original, newLength) copia array con nueva longitud
//	copyOfRange(original, from, to) copia un rango del array
//	compare(array1, array2) compara lexicográficamente (Java 9+)
//	mismatch(array1, array2) encuentra primer índice de diferencia (Java 9+)
//	stream(array) crea un Stream del array
//	stream(array, fromIndex, toIndex) Stream de un rango
//	hashCode(array) genera hash code del array
//	deepHashCode(array) hash code para arrays multidimensionales
//	setAll(array, generator) asigna valores usando función generadora
//	parallelSetAll(array, generator) versión paralela de setAll
//	
	
//	java.util.Random random = new java.util.Random();
//
//	random.nextInt() genera un int aleatorio en todo el rango de int
//	random.nextInt(int bound) genera un int aleatorio entre 0 y bound-1
//	random.nextLong() genera un long aleatorio en todo el rango de long
//	random.nextDouble() genera un double aleatorio entre 0.0 y 1.0
//	random.nextFloat() genera un float aleatorio entre 0.0 y 1.0
//	random.nextBoolean() genera un boolean aleatorio true o false
//	random.nextBytes(byte[] bytes) llena el array con bytes aleatorios
//	random.nextGaussian() genera double con distribucion gaussiana media 0.0 desviacion 1.0
//	random.setSeed(long seed) establece la semilla para reproducir secuencias
//	random.doubles() genera un stream infinito de doubles entre 0.0 y 1.0
//	random.doubles(long streamSize) genera stream de doubles con tamaño especifico entre 0.0 y 1.0
//	random.doubles(double randomNumberOrigin, double randomNumberBound) genera stream infinito de doubles en el rango especificado
//	random.doubles(long streamSize, double randomNumberOrigin, double randomNumberBound) genera stream de doubles con tamaño y rango especifico
//	random.ints() genera un stream infinito de ints en todo el rango
//	random.ints(long streamSize) genera stream de ints con tamaño especifico en todo el rango
//	random.ints(int randomNumberOrigin, int randomNumberBound) genera stream infinito de ints en el rango especificado
//	random.ints(long streamSize, int randomNumberOrigin, int randomNumberBound) genera stream de ints con tamaño y rango especifico
//	random.longs() genera un stream infinito de longs en todo el rango
//	random.longs(long streamSize) genera stream de longs con tamaño especifico en todo el rango
//	random.longs(long randomNumberOrigin, long randomNumberBound) genera stream infinito de longs en el rango especificado
//	random.longs(long streamSize, long randomNumberOrigin, long randomNumberBound) genera stream de longs con tamaño y rango especifico
//	
	
	
	
	
}
