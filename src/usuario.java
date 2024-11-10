public class usuario {

    private int docUsuario;
    private int nombre;

    public usuario() {
    }

    public usuario(int docUsuario, int nombre) {
        this.docUsuario = docUsuario;
        this.nombre = nombre;
    }

    public int getDocUsuario() {
        return docUsuario;
    }

    public void setDocUsuario(int docUsuario) {
        this.docUsuario = docUsuario;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "usuario{" +
                "docUsuario=" + docUsuario +
                ", nombre=" + nombre +
                '}';
    }

    public void registro(){

    }

}
