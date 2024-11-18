import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaDeReservas sistema = new SistemaDeReservas();
        ArrayList<ServicioAdicional> servicios = new ArrayList<>();
        ArrayList<Habitacion> habitaciones = new ArrayList<>();

        // Ejemplos de habitaciones
        habitaciones.add(new Habitacion(101, "Simple", 150000));
        habitaciones.add(new Habitacion(102, "Doble", 250000));
        habitaciones.add(new Habitacion(103, "Suite", 500000));

        //Ejemplos de servicios adicionales
        servicios.add(new ServicioAdicional("Piscina", 15000));
        servicios.add(new ServicioAdicional("Restaurante", 30000));
        servicios.add(new ServicioAdicional("Spa", 30000));
        servicios.add(new ServicioAdicional("Gimnasio", 20000));

        // Usuarios para iniciar sesión sin registrarse
        sistema.registrarCliente("Brayan", "1003660985");
        sistema.registrarCliente("Andres", "1072642260");
        sistema.registrarCliente("Pachito", "1076136352");

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Hotel infidelidades ---");
            System.out.println("\n1. Registrar Cliente");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Cerrar Sesión");
            System.out.println("4. Reservar Habitación");
            System.out.println("5. Cancelar Reserva");
            System.out.println("6. Listar Usuarios Registrados");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Doc: ");
                    String doc = scanner.nextLine();
                    sistema.registrarCliente(nombre, doc);
                    break;
                case 2:
                    System.out.print("Nombre de usuario: ");
                    nombre = scanner.nextLine();
                    System.out.print("Doc: ");
                    doc = scanner.nextLine();
                    sistema.iniciarSesion(nombre, doc);
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
                                double montoTotal = habitacion.getPrecio();

                                System.out.println("¿Desea agregar servicios adicionales? (si/no): ");
                                String respuesta = scanner.nextLine();

                                if (respuesta.equalsIgnoreCase("si")) {
                                    System.out.println("Servicios adicionales disponibles:");
                                    for (int i = 0; i < servicios.size(); i++) {
                                        System.out.print((i + 1) + ". ");
                                        servicios.get(i).mostrarDetalle();
                                    }

                                    System.out.print("\nSeleccione los números de los servicios a agregar (separados por comas): ");
                                    String[] seleccionServicios = scanner.nextLine().split(",");

                                    for (String seleccion : seleccionServicios) {
                                        int servicioSeleccionado = Integer.parseInt(seleccion.trim());
                                        if (servicioSeleccionado > 0 && servicioSeleccionado <= servicios.size()) {
                                            ServicioAdicional servicio = servicios.get(servicioSeleccionado - 1);
                                            montoTotal += servicio.getCosto();
                                            System.out.println("Servicio de " + servicio.getNombre() + " agregado.");
                                        } else {
                                            System.out.println("Selección de servicio inválida: " + servicioSeleccionado);
                                        }
                                    }
                                }

                                System.out.println("Monto total a pagar por la reserva y servicios: $" + montoTotal);
                                System.out.print("Método de pago (efectivo/tarjeta): ");
                                String metodoPago = scanner.nextLine();

                                Pago pago = new Pago(montoTotal, metodoPago);
                                pago.procesarPago();
                                System.out.println("Reserva y servicios adicionales confirmados.");
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
                case 6:
                    sistema.listarClientes();
                    break;
                case 7:
                    if (sistema.getClienteActual() != null) {
                        System.out.print("Número de habitación a renovar: ");
                        int numeroHabitacion = scanner.nextInt();
                        scanner.nextLine();

                        Habitacion habitacion = habitaciones.stream()
                                .filter(h -> h.getNumero() == numeroHabitacion)
                                .findFirst()
                                .orElse(null);

                        if (habitacion != null) {
                            if (habitacion.isReservada()) {
                                System.out.print("Nueva fecha de fin de la reserva (YYYY-MM-DD): ");
                                String nuevaFechaFin = scanner.nextLine();

                                // Renovar la reserva
                                if (habitacion.renovarReserva(nuevaFechaFin)) {
                                    double montoAdicional = habitacion.getPrecio();
                                    System.out.println("Monto adicional por la renovación: $" + montoAdicional);
                                    System.out.print("Método de pago para la renovación (efectivo/tarjeta): ");
                                    String metodoPago = scanner.nextLine();

                                    Pago pago = new Pago(montoAdicional, metodoPago);
                                    pago.procesarPago();
                                    System.out.println("Renovación de reserva confirmada.");
                                }
                            } else {
                                System.out.println("No hay reserva activa para esta habitación.");
                            }
                        } else {
                            System.out.println("Número de habitación no encontrado.");
                        }
                    } else {
                        System.out.println("Debe iniciar sesión para renovar una reserva.");
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
