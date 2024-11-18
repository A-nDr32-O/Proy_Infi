class Cliente {
    private String nombre;
    private String doc;

    public Cliente() {
    }

    public Cliente(String nombre, String doc) {
        this.nombre = nombre;
        this.doc = doc;
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

    public boolean registrar(String nombre, String doc) {
        if (this.nombre.equals(nombre) && this.doc.equals(doc)) {
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
