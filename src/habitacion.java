public class habitacion implements reservable {

    private int numHabitacion;
    private int tipo;
    private boolean disponible;

    public habitacion() {
    }

    public habitacion(int numHabitacion, int tipo, boolean disponible) {
        this.numHabitacion = numHabitacion;
        this.tipo = tipo;
        this.disponible = disponible;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    //Metodo de clase

    public void obtenerInfo(){

    }

    //Metodos de interfaz

    @Override
    public void reservar() {

    }

    @Override
    public void cancelar() {

    }

    @Override
    public void verificarDiponibilidad() {

    }
}
