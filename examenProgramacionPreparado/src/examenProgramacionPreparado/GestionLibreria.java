package examenProgramacionPreparado;

import java.time.LocalDate;
import java.util.ArrayList;

public class GestionLibreria {

    private ArrayList<Libro> listaLibros = new ArrayList<>();
    private ArrayList<Socio> listaSocios = new ArrayList<>();
	private ArrayList<Prestamo> listaPrestamos = new ArrayList<>();
	
	
	public Socio buscarSocioPorCodigo(int codigoSocio) {
		Socio socioEncontrado = null;
		
		for(Socio socioEnLista : listaSocios) {
			if(socioEnLista.getCodigoSocio()==(codigoSocio)) {
				socioEncontrado=socioEnLista;
			}
		}
		return socioEncontrado;	
	}

	public Libro buscarLibroPorIsbn(String isbn) {
		Libro libroEncontrado=null;
		
		for(Libro libroEnLista : listaLibros) {
			if(libroEnLista.getISBN().equals(isbn)) {
				libroEncontrado=libroEnLista;
			}		
		}
		return libroEncontrado;
	}
	
	public void modificarSocio(int codigoSocio, String nombre, int telefono, int prestamos) {
		Socio socioEnLista = buscarSocioPorCodigo(codigoSocio);
		if(socioEnLista==null) {
			System.out.println("Socio no encontrado");
		}else {
			socioEnLista.setNombre(nombre);
			socioEnLista.setCodigoSocio(telefono);
			System.out.println("Socio Modificado");
		}
	}
	
	public void modificarLibro(String isbn, String titulo, String autor, int ejemplares) {
		Libro libroAModificar = buscarLibroPorIsbn(isbn);
		if(libroAModificar == null) {
			System.out.println("Este libro no existe");
		} else {
			libroAModificar.setTitulo(titulo);
			libroAModificar.setAutor(autor);
			libroAModificar.setEjemplares(ejemplares);
			System.out.println("Libro Modificado");
		}
	}
	
	public void darAltaSocio(int codigoSocio, String nombre, int telefono, int prestamos) {
		 if (buscarSocioPorCodigo(codigoSocio) != null) {
		        System.out.println("Ya existe un socio con ese código.");
		    }else {
		    	 listaSocios.add(new Socio(codigoSocio, nombre, telefono, 0));
				 System.out.println("Socio creado");
		    }
		   
	}
	
	public void darAltaLibro(String isbn, String titulo, String autor, String genero, int ejemplares) {
	Libro libroAModificar = buscarLibroPorIsbn(isbn);
		if(libroAModificar == null) {
			listaLibros.add(new Libro(isbn, titulo, autor, ejemplares));
			System.out.println("Libro creado correctamente.");
		}else {
			System.out.println("Este libro ya existe");
		}
	}
	
	public void eliminarSocio(int codigoSocio) {
	    Socio socioEnLista = buscarSocioPorCodigo(codigoSocio);
	    if (socioEnLista == null) {
	    	System.out.println("Socio no encontrado."); 
	    } else {
	    	listaSocios.remove(socioEnLista);
		    System.out.println("Socio eliminado.");
	    }
	    
	}
	
	public void eliminarLibro(String isbn) {
	    Libro libroEnLista = buscarLibroPorIsbn(isbn);
	    if (libroEnLista == null) {
	    	System.out.println("Libro no encontrado.");
	    }
	    listaLibros.remove(libroEnLista);
	    System.out.println("Libro eliminado.");
	}
	
	//genera id para los prestamos
	public String contadorPrestamos() {
		String idPrestamo = null;
		
		 for (int indice=0; indice<(listaPrestamos.size() + 1); indice++) {
			 idPrestamo= "P" + indice;
		 }
		 return idPrestamo;
	 }
	
	
	public void registrarPrestamo(int codigoSocio, String isbn) {
		 Socio socio = buscarSocioPorCodigo(codigoSocio);
		   Libro libro = buscarLibroPorIsbn(isbn);

		    if (socio == null || libro == null) {
		    	System.out.println("Socio o libro no encontrado.");
		    }
		    if (!Prestamo.prestamoPosible(socio, libro)) {
		        System.out.println("Préstamo no posible");
		    }else { 
		    	listaPrestamos.add(new Prestamo(contadorPrestamos(), socio, libro,LocalDate.now() , null, true ));
		    	libro.prestarLibro();
		    	socio.incrementarPrestamos();
		    	System.out.println("Prestamo completado con ID: " + contadorPrestamos());
		    }
				
		}
	public void registrarDevolucion(String codigoPrestamo) {
		for (Prestamo prestamoEnLista : listaPrestamos) {
            if (prestamoEnLista.getCodigoPrestamo().equals(codigoPrestamo) && prestamoEnLista.isPrestamoActivo()) {
                prestamoEnLista.setFechaDevolucion(LocalDate.now());
                
                prestamoEnLista.setPrestamoActivo(false);
                prestamoEnLista.getLibroPrestado().devolverLibro(); //en libro
                prestamoEnLista.getSocioPrestamo().decrementarPrestamos(); //en prestamo y socio
            } else {
                System.out.println("Préstamo no encontrado o ya devuelto.");
            }
        }
    }
	
	
	// Listar socios
	public void listarSocios() {
	    if (listaSocios.isEmpty()) {
	    	System.out.println("No hay socios registrados."); return; 
	    }
	    listaSocios.forEach(System.out::println);
	}

	// Listar libros
	public void listarLibros() {
	    if (listaLibros.isEmpty()) {
	    	System.out.println("No hay libros registrados."); return; 
	    }
	    listaLibros.forEach(System.out::println);
	}

	// Listar libros disponibles
	public void listarLibrosDisponibles() {
	    boolean hay = false;
	    for (Libro l : listaLibros) {
	        if (l.ejemplaresDisponibles()) {
	        	System.out.println(l); hay = true; 
	        }
	    }
	    if (!hay) {
	    	System.out.println("No hay libros disponibles.");
	    } 
	}
	
	// Listar préstamos
	public void listarPrestamos() {
	    if (listaPrestamos.isEmpty()) {
	    	System.out.println("No hay préstamos registrados."); return; 
	    }
	    listaPrestamos.forEach(System.out::println);
	}	
}
	

