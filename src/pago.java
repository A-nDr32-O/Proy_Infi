class Pago {
    private double monto;
    private String metodoPago;

    public Pago(double monto, String metodoPago) {
        this.monto = monto;
        this.metodoPago = metodoPago;
    }

    public void procesarPago() {
        System.out.println("Procesando pago de $" + monto + " mediante " + metodoPago + "...");
        System.out.println("Pago exitoso.");
    }

    public double getMonto() {
        return monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }
}
