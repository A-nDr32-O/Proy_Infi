import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaDeReservas sistema = new SistemaDeReservas();
        ArrayList<Habitacion> habitaciones = new ArrayList<>();

        // Agregamos algunas habitaciones de ejemplo
        habitaciones.add(new Habitacion(101, "Simple"));
        habitaciones.add(new Habitacion(102, "Doble"));
        habitaciones.add(new Habitacion(103, "Suite"));

        // Usuario de ejemplo para iniciar sesión sin registrarse
        sistema.registrarCliente("usuarioEjemplo", "1234", "00000000");

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Sistema de Reservas ---");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Cerrar Sesión");
            System.out.println("4. Reservar Habitación");
            System.out.println("5. Cancelar Reserva");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String contrasena = scanner.nextLine();
                    System.out.print("DNI: ");
                    String dni = scanner.nextLine();
                    sistema.registrarCliente(nombre, contrasena, dni);
                    break;
                case 2:
                    System.out.print("Nombre de usuario: ");
                    nombre = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    contrasena = scanner.nextLine();
                    sistema.iniciarSesion(nombre, contrasena);
                    break;
                case 3:
                    sistema.cerrarSesion();
                    break;
                case 4:
                    if (sistema.getClienteActual() != null) {
                        System.out.print("Número de habitación: ");
                        int numeroHabitacion = scanner.nextInt();
                        scanner.nextLine();

                        Habitacion habitacion = habitaciones.stream()
                                .filter(h -> h.getNumero() == numeroHabitacion)
                                .findFirst()
                                .orElse(null);

                        if (habitacion != null) {
                            System.out.print("Fecha de inicio (YYYY-MM-DD): ");
                            String fechaInicio = scanner.nextLine();
                            System.out.print("Fecha de fin (YYYY-MM-DD): ");
                            String fechaFin = scanner.nextLine();

                            if (habitacion.reservar(fechaInicio, fechaFin)) {
                                System.out.print("Ingrese el monto de pago: ");
                                double montoPago = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.print("Método de pago (efectivo/tarjeta): ");
                                String metodoPago = scanner.nextLine();

                                Pago pago = new Pago(montoPago, metodoPago);
                                pago.procesarPago();
                            }
                        } else {
                            System.out.println("Número de habitación no encontrado.");
                        }
                    } else {
                        System.out.println("Debe iniciar sesión para realizar una reserva.");
                    }
                    break;
                case 5:
                    if (sistema.getClienteActual() != null) {
                        System.out.print("Número de habitación a cancelar: ");
                        int numeroHabitacion = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Fecha de inicio de la reserva a cancelar (YYYY-MM-DD): ");
                        String fechaInicio = scanner.nextLine();
                        System.out.print("Fecha de fin de la reserva a cancelar (YYYY-MM-DD): ");
                        String fechaFin = scanner.nextLine();

                        Habitacion habitacion = habitaciones.stream()
                                .filter(h -> h.getNumero() == numeroHabitacion)
                                .findFirst()
                                .orElse(null);

                        if (habitacion != null) {
                            habitacion.cancelar(fechaInicio, fechaFin);
                        } else {
                            System.out.println("Número de habitación no encontrado.");
                        }
                    } else {
                        System.out.println("Debe iniciar sesión para cancelar una reserva.");
                    }
                    break;
                case 0:
                    exit = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
}
