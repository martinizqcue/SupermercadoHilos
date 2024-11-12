import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Lista de clientes
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("CLIENTE 1", List.of("Pan", "Leche", "Huevos", "Fruta", "Carne")));
        clientes.add(new Cliente("CLIENTE 2", List.of("Cereal", "Jugo", "Pasta", "Papel", "Pescado")));
        clientes.add(new Cliente("CLIENTE 3", List.of("Galletas", "Queso", "Verduras", "Arroz", "Pollo")));
        clientes.add(new Cliente("CLIENTE 4", List.of("Yogur", "Aceite", "Harina", "Té", "Sal")));
        clientes.add(new Cliente("CLIENTE 5", List.of("Chocolate", "Vino", "Azúcar", "Café", "Tortillas")));

        long initialTime = System.currentTimeMillis();

        //Creamos un objeto para controlar el acceso a la lista de clientes
        Object lock = new Object();

        //Creamos las cajas(hilos) y les pasamos la lista de clientes y el lock
        Caja caja1 = new Caja("Caja 1", clientes, lock, initialTime);
        Caja caja2 = new Caja("Caja 2", clientes, lock, initialTime);

        //Crear los hilos directamente
        Thread hiloCaja1 = new Thread(caja1);
        Thread hiloCaja2 = new Thread(caja2);

        //Iniciar las cajas(hilos)
        hiloCaja1.start();
        hiloCaja2.start();

        //Esperar a que ambos hilos terminen
        try {
            hiloCaja1.join();
            hiloCaja2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("SUPERMERCADO FINALIZADO");
    }
}


