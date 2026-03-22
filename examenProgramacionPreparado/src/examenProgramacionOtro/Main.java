package examenProgramacionOtro;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ListaVehiculos funcionesMenu = new ListaVehiculos();
        int opcion;

        do {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Añadir Vehículo");
            System.out.println("2. Listar Vehículos");
            System.out.println("3. Buscar vehículo por matrícula");
            System.out.println("4. Modificar días alquilados");
            System.out.println("5. Modificar recargo premium");
            System.out.println("6. Modificar precio seguro diario");
            System.out.println("7. Eliminar vehículo");
            System.out.println("8. Ver Estadísticas");
            System.out.println("9. Salir");
            System.out.print("\nElige una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1 -> funcionesMenu.añadirVehiculo(asignarPropiedadesVehiculo());

                    case 2 -> funcionesMenu.listarTodos();

                    case 3 -> {
                        Vehiculo encontrado = funcionesMenu.buscarPorMatricula(pedirMatricula());
                        if (encontrado != null) System.out.println(encontrado);
                        else System.out.println("ERROR. No se ha encontrado el vehículo.");
                    }

                    case 4 -> {
                        String matricula = pedirMatricula(); //
                        System.out.print("Introduce los días para modificar: ");
                        int dias = Integer.parseInt(sc.nextLine());
                        funcionesMenu.modificarDiasAlquilados(matricula, dias);
                    }

                    case 5 -> {
                        String matricula = pedirMatricula(); // ← primero matrícula
                        System.out.print("Introduce el porcentaje para modificar: ");
                        double porcentaje = Double.parseDouble(sc.nextLine());
                        funcionesMenu.modificarRecargoPremiun(matricula, porcentaje);
                    }

                    case 6 -> {
                        System.out.print("Introduce el nuevo precio del seguro diario: ");
                        Vehiculo.PRECIO_SEGURO_DIARIO = Integer.parseInt(sc.nextLine());
                    }

                    case 7 -> funcionesMenu.eliminarPorMatricula(pedirMatricula());

                    case 8 -> funcionesMenu.mostrarEstadisticas();

                    case 9 -> System.out.println("Gracias por usar el sistema. Hasta pronto!");

                    default -> System.out.println("Opción no válida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("ERROR: Debes introducir un número entero.");
                opcion = -1;
            }

        } while (opcion != 9);
    }

    static Vehiculo asignarPropiedadesVehiculo() {
        System.out.print("Introduce la matrícula: ");
        String matricula = sc.nextLine();

        System.out.print("Introduce el modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Introduce el precio base/día: ");
        int precioBasePorDia = Integer.parseInt(sc.nextLine());

        System.out.print("Introduce el porcentaje de recargo premium: ");
        double recargoPremiun = Double.parseDouble(sc.nextLine());

        System.out.print("Introduce los días alquilados: ");
        int diasAlquilados = Integer.parseInt(sc.nextLine());

        return new Vehiculo(matricula, modelo, precioBasePorDia, recargoPremiun, diasAlquilados);
    }

    static String pedirMatricula() {
        System.out.print("Introduce la matrícula: ");
        return sc.nextLine(); 
    } 
}