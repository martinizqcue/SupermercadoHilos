import java.util.List;

public class Caja implements Runnable {
    private String nombreCaja;
    private List<Cliente> clientes; //Lista compartida de clientes
    private Object lock; //Objeto para sincronización
    private long initialTime;

    public Caja(String nombreCaja, List<Cliente> clientes, Object lock, long initialTime) {
        this.nombreCaja = nombreCaja;
        this.clientes = clientes;
        this.lock = lock;
        this.initialTime = initialTime;
    }

    @Override
    public void run() {
        while (true) {
            Cliente cliente = null;

            synchronized (lock) {
                if (!clientes.isEmpty()) {
                    cliente = clientes.remove(0);
                }
            }

            if (cliente == null) {

                break;
            }

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
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}



