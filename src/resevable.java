import java.util.ArrayList;
import java.util.List;

class Habitacion {
    private int numero;
    private String tipo;
    private List<String[]> reservas;

    public Habitacion(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.reservas = new ArrayList<>();
    }

    public boolean reservar(String fechaInicio, String fechaFin) {
        if (verificarDisponibilidad(fechaInicio, fechaFin)) {
            reservas.add(new String[]{fechaInicio, fechaFin});
            System.out.println("Habitación " + numero + " reservada del " + fechaInicio + " al " + fechaFin + ".");
            return true;
        }
        System.out.println("Habitación no disponible.");
        return false;
    }

    public void cancelar(String fechaInicio, String fechaFin) {
        reservas.removeIf(r -> r[0].equals(fechaInicio) && r[1].equals(fechaFin));
        System.out.println("Reserva cancelada del " + fechaInicio + " al " + fechaFin + ".");
    }

    public boolean verificarDisponibilidad(String fechaInicio, String fechaFin) {
        for (String[] rango : reservas) {
            if (rango[0].equals(fechaInicio) && rango[1].equals(fechaFin)) {
                return false;
            }
        }
        return true;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }
}
