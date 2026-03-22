package examenProgramacionOtro;

import java.util.ArrayList;

public class ListaVehiculos {

	ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
	String mensajeError= "ERROR. No se ha encontrado el vehiculo";
	
	//LISTAR-----------------------------------------------------------------------

	public void listarTodos() {
		for (Vehiculo vehiculoEnLista : listaVehiculos) {
			System.out.println(vehiculoEnLista.toString());;
		}
	}
	
	public void listarVehiculosPremiun() {
		for (Vehiculo vehiculoEnLista : listaVehiculos) {
			if(vehiculoEnLista.porcentajeSuperiorADoce()) {
				vehiculoEnLista.toString();
			}
		}
	}
	
	//BUSCAR-----------------------------------------------------------------------

	public Vehiculo buscarPorMatricula(String matricula) {
		Vehiculo vehiculoEncontrado=null;
		for (Vehiculo vehiculoEnLista : listaVehiculos) {
			if(vehiculoEnLista.getMatricula().equals(matricula)) {
				vehiculoEncontrado= vehiculoEnLista;
			}
		}
		return vehiculoEncontrado;
	}
	
	//AÑADIR-----------------------------------------------------------------------

	public boolean añadirVehiculo(Vehiculo vehiculoParaAñadir) {
		boolean puedeAñadir=false;
		if (buscarPorMatricula(vehiculoParaAñadir.getMatricula())==null) {
			listaVehiculos.add(vehiculoParaAñadir);
			System.out.println("Vehiculo añadido correctamente.");
		}else {
			System.out.println("Este vehiculo ya existe");
		}
		return puedeAñadir;
	}
	
	//ELIMINAR-----------------------------------------------------------------------

	public boolean eliminarPorMatricula(String matricula) {
		Vehiculo vehiculoEliminado=buscarPorMatricula(matricula);
		boolean eliminado=false;
		if(vehiculoEliminado!=null) {
			listaVehiculos.remove(vehiculoEliminado);
			System.out.println("Vehiculo eliminado correctamente");
			eliminado=true;
		} else {
			System.out.println(mensajeError);
		}
		return eliminado;
	}
	
	//MODIFICAR-----------------------------------------------------------------------Ç
	
	public boolean modificarDiasAlquilados(String matricula, int dias) {
		Vehiculo vehiculoParaModificar = buscarPorMatricula(matricula);
		boolean modificado=false;
		if(vehiculoParaModificar!=null) {
			vehiculoParaModificar.setDiasAlquilados(dias);
			System.out.println("Días de alquiler modificados correctamente");
			modificado=true;
		} else {
			System.out.println(mensajeError);
		}
		return modificado;
	}
	
	public boolean modificarRecargoPremiun(String matricula, double porcentaje) {
		Vehiculo vehiculoParaModificar= buscarPorMatricula(matricula);
		boolean modificado=false;
		if(vehiculoParaModificar!=null) {
			vehiculoParaModificar.setRecargoPremiun(porcentaje);
			System.out.println("Recargo modificado correctamente");
			modificado=true;
		} else {
			System.out.println(mensajeError);
		}
		return modificado;
	}
	
	//CALCULAR-----------------------------------------------------------------------

	public double calcularIngresoTotalRecargos() {
		double sumaTotal=0;
		for(Vehiculo vehiculoEnLista:listaVehiculos) {
		sumaTotal += vehiculoEnLista.calcularImporteRecargoPremiun();
		}
		return sumaTotal;
	}
	
	public void mostrarEstadisticas() {
		System.out.println("===ESTADISTICAS===");
		System.out.println("Ingreso total de recargos premiun" + calcularIngresoTotalRecargos());
		System.out.println("Listado de vehículos premiun"); listarVehiculosPremiun();
	}
	
	
}