interface IPago {
    void procesarPago();
}

class Pago implements IPago {
    private double monto;
    private String metodo;

    public Pago(double monto, String metodo) {
        this.monto = monto;
        this.metodo = metodo;
    }

    @Override
    public void procesarPago() {
        System.out.println("Procesando el pago de $" + monto + " mediante " + metodo);
    }
}
