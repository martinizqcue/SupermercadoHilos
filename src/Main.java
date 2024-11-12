import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Creamos los clientes con sus carritos
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Cliente1", List.of("Pan", "Leche", "Huevos", "Fruta", "Carne")));
        clientes.add(new Cliente("Cliente2", List.of("Cereal", "Jugo", "Pasta", "Papel", "Pescado")));
        clientes.add(new Cliente("Cliente3", List.of("Galletas", "Queso", "Verduras", "Arroz", "Pollo")));
        clientes.add(new Cliente("Cliente4", List.of("Yogur", "Aceite", "Harina", "Té", "Sal")));
        clientes.add(new Cliente("Cliente5", List.of("Chocolate", "Vino", "Azúcar", "Café", "Tortillas")));

        long initialTime = System.currentTimeMillis();

        // Dividimos a los clientes entre las dos cajas
        List<Cliente> clientesCaja1 = clientes.subList(0, 3); // 3 primeros clientes para la caja 1
        List<Cliente> clientesCaja2 = clientes.subList(3, 5); // 2 últimos clientes para la caja 2

        // Creamos las cajas (hilos)
        Thread caja1 = new Thread(String.valueOf(new Caja("Caja 1", clientesCaja1, initialTime)));
        Thread caja2 = new Thread(String.valueOf(new Caja("Caja 2", clientesCaja2, initialTime)));

        // Iniciamos los hilos
        caja1.start();
        caja2.start();

        try {
            // Esperamos a que ambos hilos terminen
            caja1.join();
            caja2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Simulación del supermercado finalizada.");

    }
}