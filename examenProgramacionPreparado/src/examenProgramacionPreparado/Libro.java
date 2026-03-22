package examenProgramacionPreparado;

import java.util.Objects;

public class Libro {

	private String isbn; //es unico
	private String titulo; //
	private String autor;
	private int ejemplares;
	
	public Libro(String isbn, String titulo, String autor, int ejemplares) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.ejemplares = ejemplares;
	}

	public String getISBN() {
		return isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public int getEjemplares() {
		return ejemplares;
	}

	public void setISBN(String iSBN) {
		isbn = iSBN;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setEjemplares(int ejemplares) {
		this.ejemplares = ejemplares;
	}

	@Override
	public String toString() {
		return "Libro [ISBN=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", ejemplares=" + ejemplares + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return isbn == other.isbn && Objects.equals(autor, other.autor) && ejemplares == other.ejemplares
				&& Objects.equals(titulo, other.titulo);
	}
	
	public boolean ejemplaresDisponibles() {
		boolean hayDisponibles=false;
		if (ejemplares>0) {
			hayDisponibles=true;
		}
		return hayDisponibles;

	}
	
	public void prestarLibro() {
		if (ejemplaresDisponibles()) {
			ejemplares--;
		} else {
			System.out.println("No quedan ejemplares de este libro");
		}
	}
	
	public void devolverLibro() {
		ejemplares++;
	}
	
	
	
	

	
}
