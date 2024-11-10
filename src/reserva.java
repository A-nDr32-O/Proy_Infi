import java.util.Date;

public class reserva extends usuario implements reservable {

    private int idReserva;
    private Date fechaInicio;
    private Date fechaFin;

    public reserva() {
    }

    public reserva(int idReserva, Date fechaInicio, Date fechaFin) {
        this.idReserva = idReserva;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "reserva{" +
                "idReserva=" + idReserva +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }

    //Metodo de clase

    public void calcularCosto(){

    }

    public void renovarReserva(Date nuevaFechaFin){

    }

    //Metodos de Interfaz

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
