class ServicioAdicional {
    private String nombre;
    private double precio;

    public ServicioAdicional(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public void aplicarServicio() {
        System.out.println("Servicio " + nombre + " aplicado con un costo de " + precio);
    }
}

