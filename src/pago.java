public class pago {

    private Double monto;

    public pago() {
    }

    public pago(Double monto) {
        this.monto = monto;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "pago{" +
                "monto=" + monto +
                '}';
    }

    //Metodo de clase

    public void procesarPago(){

    }
}
