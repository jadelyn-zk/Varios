package examenProgramacionPreparado;

import java.time.LocalDate;

public class Prestamo {

	private String codigoPrestamo;
	private Socio socioPrestamo;
	private Libro libroPrestado;
	
	private LocalDate fechaPrestamo= LocalDate.now();
	private LocalDate fechaDevolucion=null;
	private boolean prestamoActivo;
	
	public Prestamo(String codigoPrestamo, Socio socioPrestamo, Libro libroPrestado, LocalDate fechaPrestamo,
		LocalDate fechaDevolucion, boolean prestamoActivo) {
		
		this.codigoPrestamo = codigoPrestamo;
		this.socioPrestamo = socioPrestamo;
		this.libroPrestado = libroPrestado;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
		this.prestamoActivo = prestamoActivo;	
	}

	public String getCodigoPrestamo() {
		return codigoPrestamo;
	}

	public Socio getSocioPrestamo() {
		return socioPrestamo;
	}

	public Libro getLibroPrestado() {
		return libroPrestado;
	}

	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public boolean isPrestamoActivo() {
		return prestamoActivo;
	}

	public void setCodigoPrestamo(String codigoPrestamo) {
		this.codigoPrestamo = codigoPrestamo;
	}

	public void setSocioPrestamo(Socio socioPrestamo) {
		socioPrestamo = socioPrestamo;
	}

	public void setLibroPrestado(Libro libroPrestado) {
		libroPrestado = libroPrestado;
	}

	public void setFechaPrestamo(LocalDate fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public void setPrestamoActivo(boolean prestamoActivo) {
		this.prestamoActivo = prestamoActivo;
	}
	
	@Override
	public String toString() {
		return "Prestamo [codigoPrestamo=" + codigoPrestamo + ", socioPrestamo=" + socioPrestamo + ", libroPrestado="
				+ libroPrestado + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion
				+ ", prestamoActivo=" + prestamoActivo + "]";
	}		
	
	 public static boolean prestamoPosible(Socio socio, Libro libro) {
	        return libro.ejemplaresDisponibles() && socio.puedePrestar();
	    }
	 
	 
	
}