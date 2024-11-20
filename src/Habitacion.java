class Habitacion {
    private int numero;
    private String tipo;
    private double precio;
    private boolean reservada;
    private String fechaFinReserva;

    public Habitacion() {
    }

    public Habitacion(int numero, String tipo, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.reservada = false;
        this.fechaFinReserva = null;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isReservada() {
        return reservada;
    }

    public void setReservada(boolean reservada) {
        this.reservada = reservada;
    }

    public String getFechaFinReserva() {
        return fechaFinReserva;
    }

    public void setFechaFinReserva(String fechaFinReserva) {
        this.fechaFinReserva = fechaFinReserva;
    }

    public boolean reservar(String fechaInicio, String fechaFin) {
        if (!reservada) {
            reservada = true;
            this.fechaFinReserva = fechaFin;
            System.out.println("\nHabitación " + numero + " reservada del " + fechaInicio + " al " + fechaFin);
            return true;
        } else {
            System.out.println("\nLa habitación " + numero + " ya está reservada.");
            return false;
        }
    }

    public void cancelar(String fechaInicio, String fechaFin) {
        if (reservada) {
            reservada = false;
            this.fechaFinReserva = null;
            System.out.println("\nReserva de la habitación " + numero + " cancelada del " + fechaInicio + " al " + fechaFin);
        } else {
            System.out.println("\nLa habitación " + numero + " no está reservada.");
        }
    }

    public boolean renovarReserva(String nuevaFechaFin) {
        if (reservada) {
            System.out.println("\nReserva de la habitación " + numero + " renovada hasta " + nuevaFechaFin);
            this.fechaFinReserva = nuevaFechaFin;
            return true;
        } else {
            System.out.println("\nNo hay una reserva activa para esta habitación.");
            return false;
        }
    }
}
    /*public boolean verificarDisponibilidad(String fechaInicio, String fechaFin) {
        for (String[] rango : reservas) {
            if (rango[0].equals(fechaInicio) && rango[1].equals(fechaFin)) {
                return false;
            }
        }
        return true;
    }*/

