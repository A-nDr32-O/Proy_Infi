import java.util.ArrayList;

class SistemaDeReservas {
    private ArrayList<Cliente> clientes;
    private Cliente clienteActual;

    public SistemaDeReservas() {
        this.clientes = new ArrayList<>();
        this.clienteActual = null;
    }

    public void registrarCliente(String nombre, String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre)) {
                System.out.println("Error: El nombre de cliente ya está en uso.");
                return;
            }
        }

        Cliente nuevoCliente = new Cliente(nombre, dni);
        clientes.add(nuevoCliente);
        System.out.println("Cliente " + nombre + " registrado exitosamente.");
    }

    public Cliente iniciarSesion(String nombre, String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre) && cliente.getDni().equals(dni)) {
                clienteActual = cliente;
                System.out.println("Inicio de sesión exitoso. Bienvenido, " + cliente.getNombre() + ".");
                return cliente;
            }
        }
        System.out.println("Nombre de cliente o contraseña incorrectos.");
        return null;
    }

    public void cerrarSesion() {
        if (clienteActual != null) {
            System.out.println(clienteActual.getNombre() + " ha cerrado sesión.");
            clienteActual = null;
        } else {
            System.out.println("No hay ninguna sesión activa.");
        }
    }

    public Cliente getClienteActual() {
        return clienteActual;
    }

    public void listarClientes() {
        System.out.println("\n--- Lista de Usuarios Registrados ---");
        if (clientes.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println("Nombre: " + cliente.getNombre() + ", DNI: " + cliente.getDni());
            }
        }
    }
}
