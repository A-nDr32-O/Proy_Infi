class Cliente {
    private String nombre;
    private String contrasena;
    private String docCliente;

    public Cliente(String nombre, String contrasena, String docCliente) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.docCliente = docCliente;
    }

    public boolean registrar(String nombre, String contrasena) {
        if (this.nombre.equals(nombre) && this.contrasena.equals(contrasena)) {
            System.out.println("Cliente ya registrado.");
            return false;
        }
        this.nombre = nombre;
        this.contrasena = contrasena;
        System.out.println("Cliente " + nombre + " registrado con éxito.");
        return true;
    }

    public void verReservas() {
        System.out.println(nombre + " está viendo sus reservas.");
    }

    public void renovarReserva(String nuevaFechaFin) {
        System.out.println("Reserva renovada hasta " + nuevaFechaFin);
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }
}

