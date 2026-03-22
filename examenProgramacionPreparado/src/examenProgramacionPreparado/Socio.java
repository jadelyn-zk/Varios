package examenProgramacionPreparado;

import java.util.Objects;

public class Socio {

	private int codigoSocio;
	private String nombre;
	private int telefono;
	private int prestamos;
	static final int LIMITE_PRESTAMOS = 3;
		
	public Socio(int codigoSocio, String nombre, int telefono, int prestamos) {
		super();
		this.codigoSocio = codigoSocio;
		this.nombre = nombre;
		this.telefono = telefono;
		this.prestamos = prestamos;
	}

	public int getCodigoSocio() {
		return codigoSocio;
	}

	public String getNombre() {
		return nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public int getPrestamos() {
		return prestamos;
	}

	public void setCodigoSocio(int codigoSocio) {
		this.codigoSocio = codigoSocio;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public void setPrestamos(int prestamos) {
		this.prestamos = prestamos;
	}

	@Override
	public String toString() {
		return "Socio [codigoSocio=" + codigoSocio + ", nombre=" + nombre + ", telefono=" + telefono + ", prestamos="
				+ prestamos + ", limitePrestamosSimultáneos=" + LIMITE_PRESTAMOS + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Socio other = (Socio) obj;
		return codigoSocio == other.codigoSocio && LIMITE_PRESTAMOS == other.LIMITE_PRESTAMOS
				&& Objects.equals(nombre, other.nombre) && prestamos == other.prestamos && telefono == other.telefono;
	}
	
	public boolean puedePrestar() {
		return (prestamos < LIMITE_PRESTAMOS); 
	}
	
	public void incrementarPrestamos() {
		prestamos++;
	}
	
	public void decrementarPrestamos() {
		if(prestamos>0) {
			prestamos--;
		}
	}
	
}
