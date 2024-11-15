import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<usuario> lstusuario = new ArrayList<>();
        int menu = 0;

        System.out.println("¡Bienvenido! Para continuar, por favor registre los siguientes datos: ");
        System.out.print("Numero de documento: ");
        int numerodocumento = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Nombre Completo: ");
        String nombreusu = teclado.nextLine();

        usuario Usuario = new usuario();
        Usuario.registro(numerodocumento, nombreusu);

        lstusuario.add(Usuario);

        System.out.println("Usuario registrado exitosamente.");

        do {
            habitacion habitacion = new habitacion();
            System.out.println("Seleccione la habitacion para su reserva: ");
            System.out.println("1 Reservar habitación");
            System.out.println("2 Salir");

            System.out.print("Elija la opción deseada: ");
            menu = teclado.nextInt();

            switch (menu) {
                case 1:
                    habitacion habitacion1 = new habitacion();
                    System.out.println("Seleccione el tipo de habitación:");
                    System.out.println("1 - Habitacion individual");
                    System.out.println("2 - Habitacion doble");
                    System.out.println("3 - Habitacion familiar");
                    System.out.println("4 - Habitacion presidencial");
                    int tipoSeleccionado = teclado.nextInt();
                    habitacion.setTipo(tipoSeleccionado);

                    int precio = habitacion.tipo();
                    System.out.println("El precio de la habitación seleccionada es: " + precio);

                    int menu2 = 0;
                    do {
                        System.out.println("Desea continuar?");
                        System.out.println("1 Si");

                        System.out.println("2 No");
                        menu2 = teclado.nextInt();

                        if (menu2 == 1) {
                            System.out.println("Habitacion confirmada :)");
                            break;
                        } else if (menu2 == 2) {
                            System.out.println("Devolviendo al menu...");
                        }
                    } while (menu2 != 2);

                    break;

            }

        } while (menu != 2);

        System.out.println("Usuario registrado:");
        for (usuario es : lstusuario) {
            System.out.println(es);
        }
    }
}