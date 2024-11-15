import java.util.ArrayList;
import java.util.List;

public class usuario {
    private int docUsuario;
    private String nombre;

    public usuario() {

    }

    public usuario(int docUsuario, String nombre) {
        this.docUsuario = docUsuario;
        this.nombre = nombre;
    }

    public int getDocUsuario() {
        return docUsuario;
    }

    public void setDocUsuario(int docUsuario) {
        this.docUsuario = docUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "usuario{" +
                "docUsuario=" + docUsuario +
                ", nombre='" + nombre + '\'' +
                '}';
    }


    public void registro(int docUsuario, String nombreusu) {
        if (docUsuario > 1) {
            this.docUsuario = docUsuario;
        }
        if (nombreusu != null && !nombreusu.isEmpty()) {
            this.nombre = nombreusu;
        } else {
            System.out.println("Nombre no válido");
        }
    }
}
