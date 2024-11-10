public class servicioAdicional implements reservable{

    private int idServicio;
    private String descricion;
    private int precio;

    public servicioAdicional() {
    }

    public servicioAdicional(int idServicio, String descricion, int precio) {
        this.idServicio = idServicio;
        this.descricion = descricion;
        this.precio = precio;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "servicioAdicional{" +
                "idServicio=" + idServicio +
                ", descricion='" + descricion + '\'' +
                ", precio=" + precio +
                '}';
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
