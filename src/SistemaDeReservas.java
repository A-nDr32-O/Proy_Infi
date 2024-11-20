import java.util.ArrayList;

class SistemaDeReservas {
    private ArrayList<Cliente> clientes;
    private Cliente clienteActual;

    public SistemaDeReservas() {
        this.clientes = new ArrayList<>();
        this.clienteActual = null;
    }

    public Cliente getClienteActual() {
        return clienteActual;
    }

    public void setClienteActual(Cliente clienteActual) {
        this.clienteActual = clienteActual;
    }

    public void registrarCliente(String nombre, String doc) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre)) {
                System.out.println("Error: El nombre de cliente ya está en uso.");
                return;
            }
        }

        Cliente nuevoCliente = new Cliente(nombre, doc);
        clientes.add(nuevoCliente);
        System.out.println("Cliente " + nombre + " registrado exitosamente.");
    }

    public Cliente iniciarSesion(String nombre, String doc) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre) && cliente.getDoc().equals(doc)) {
                clienteActual = cliente;
                System.out.println("\nBienvenido, " + cliente.getNombre() + ".");
                return cliente;
            }
        }
        System.out.println("Nombre de cliente o contraseña incorrectos.");
        return null;
    }

    public void cerrarSesion() {
        if (clienteActual != null) {
            System.out.println("\n" + clienteActual.getNombre() + " ha cerrado sesión.");
            clienteActual = null;
        } else {
            System.out.println("No hay ninguna sesión activa.");
        }
    }

    public void listarClientes() {
        System.out.println("\n--- Lista de Usuarios Registrados ---\n");
        if (clientes.isEmpty()) {
            System.out.println("\nNo hay usuarios registrados.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println("Nombre: " + cliente.getNombre() + ", Doc: " + cliente.getDoc());
            }
        }
    }
}
