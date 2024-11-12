import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Creamos los clientes con sus carritos
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Cliente1", List.of("Pan", "Leche", "Huevos", "Fruta", "Carne")));
        clientes.add(new Cliente("Cliente2", List.of("Cereal", "Jugo", "Pasta", "Papel", "Pescado")));
        clientes.add(new Cliente("Cliente3", List.of("Galletas", "Queso", "Verduras", "Arroz", "Pollo")));
        clientes.add(new Cliente("Cliente4", List.of("Yogur", "Aceite", "Harina", "Té", "Sal")));
        clientes.add(new Cliente("Cliente5", List.of("Chocolate", "Vino", "Azúcar", "Café", "Tortillas")));

        long initialTime = System.currentTimeMillis();

        //Dividimos a los clientes entre las dos cajas
        List<Cliente> clientesCaja1 = clientes.subList(0, 3); // 3 primeros clientes para la caja 1
        List<Cliente> clientesCaja2 = clientes.subList(3, 5); // 2 últimos clientes para la caja 2

        //Creamos las cajas(hilos) y pasamos la instancia de Caja directamente
        Caja caja1 = new Caja("Caja 1", clientesCaja1, initialTime);
        Caja caja2 = new Caja("Caja 2", clientesCaja2, initialTime);

        // Creamos los hilos pasándoles las instancias de Caja
        Thread hiloCaja1 = new Thread(caja1);
        Thread hiloCaja2 = new Thread(caja2);


        hiloCaja1.start();
        hiloCaja2.start();

        try {

            hiloCaja1.join();
            hiloCaja2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Supermercado finalizado");
    }
}


