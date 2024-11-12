import java.util.List;

public class Caja {
    private String nombreCaja;
    private List<Cliente> clientes;
    private long initialTime;

    public Caja(String nombreCaja, List<Cliente> clientes, long initialTime) {
        this.nombreCaja = nombreCaja;
        this.clientes = clientes;
        this.initialTime = initialTime;
    }


    public void run() {
        for (Cliente cliente : clientes) {
            procesarCliente(cliente);
        }
    }

    private void procesarCliente(Cliente cliente) {
        System.out.println(nombreCaja + " empieza a procesar al cliente " + cliente.getNombre());

        for (String producto : cliente.getCarrito()) {
            procesarProducto(cliente, producto);
        }

        long tiempoTotal = System.currentTimeMillis() - initialTime;
        System.out.println(nombreCaja + " terminó de procesar a " + cliente.getNombre() +
                " en " + (tiempoTotal / 1000) + " segundos.");
    }

    private void procesarProducto(Cliente cliente, String producto) {
        System.out.println(nombreCaja + " está procesando el producto " + producto +
                " del cliente " + cliente.getNombre());

        try {
            Thread.sleep(1000); // Simulamos tiempo de procesamiento
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
