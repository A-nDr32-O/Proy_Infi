class Cliente {
    private String nombre;
    private String doc;

    public Cliente() {
    }

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.doc = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDoc() {
        return doc;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public boolean registrar(String nombre, String dni) {
        if (this.nombre.equals(nombre) && this.doc.equals(dni)) {
            System.out.println("Cliente ya registrado.");
            return false;
        }
        this.nombre = nombre;
        this.doc = doc;
        System.out.println("Cliente " + nombre + " registrado con éxito.");
        return true;
    }

    public void verReservas() {

        System.out.println(nombre + " está viendo sus reservas.");

    }


}