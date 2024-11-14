class Cliente {
    private String nombre;
    private String dni;

    public Cliente() {
    }

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean registrar(String nombre, String dni) {
        if (this.nombre.equals(nombre) && this.dni.equals(dni)) {
            System.out.println("Cliente ya registrado.");
            return false;
        }
        this.nombre = nombre;
        this.dni = dni;
        System.out.println("Cliente " + nombre + " registrado con éxito.");
        return true;
    }

    public void verReservas() {

        System.out.println(nombre + " está viendo sus reservas.");

    }


}

