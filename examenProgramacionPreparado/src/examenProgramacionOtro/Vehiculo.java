package examenProgramacionOtro;

import java.util.Objects;

public class Vehiculo {
		
	private String matricula;
	private String modelo;
	private int precioBasePorDia;
	private double recargoPremiun;
	public static int PRECIO_SEGURO_DIARIO= 5;
	private int diasAlquilados;
	
	public Vehiculo(String matricula, String modelo, int precioBasePorDia, double recargoPremiun , int diasAlquilados) {
		super();
		this.matricula = matricula;
		this.modelo = modelo;
		this.precioBasePorDia = precioBasePorDia;
		this.recargoPremiun = recargoPremiun;
		this.diasAlquilados = diasAlquilados;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public int getPrecioBasePorDia() {
		return precioBasePorDia;
	}

	public double getRecargoPremiun() {
		return recargoPremiun;
	}

	public int getDiasAlquilados() {
		return diasAlquilados;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setPrecioBasePorDia(int precioBasePorDia) {
		this.precioBasePorDia = precioBasePorDia;
	}

	public void setRecargoPremiun(double recargoPremiun) {
		this.recargoPremiun = recargoPremiun; 
	}

	public void setDiasAlquilados(int diasAlquilados) {
		this.diasAlquilados = diasAlquilados;
	}
	
	

	/**
	 * Funcion que calcula el importe del recargo premiun
	 * @return devuelve el importe calculado
	 */
	public double calcularImporteRecargoPremiun() {
		return precioBasePorDia * recargoPremiun / 100 ;
	}
	
	public int calcularImporteSeguro() {
		return diasAlquilados * PRECIO_SEGURO_DIARIO;
	}
	
	public double ingresoTotal() {
		return precioBasePorDia + calcularImporteRecargoPremiun() + calcularImporteSeguro();
	}

	@Override
	public String toString() {
		return matricula + " - " + modelo + "\n Precio Base/Dia: " + precioBasePorDia
				+ " | RECARGO PREMIUN: " + recargoPremiun + " \n DíasAlquilados:" + diasAlquilados + " | Total generado:" + ingresoTotal();
	}
	
	public boolean porcentajeSuperiorADoce() {
		return (recargoPremiun>12);
	}
	
	
	
}
