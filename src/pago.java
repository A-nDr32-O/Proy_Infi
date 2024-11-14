interface IPago {
    void procesarPago();
}

class Pago implements IPago {
    private double monto;
    private String metodo;

    public Pago() {
    }

    public Pago(double monto, String metodo) {
        this.monto = monto;
        this.metodo = metodo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    @Override
    public void procesarPago() {
        System.out.println("Procesando el pago de $" + monto + " mediante " + metodo);
    }
}
