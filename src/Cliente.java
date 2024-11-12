import java.util.List;

public class Cliente {
    private String nombre;
    private List<String> carrito;

    public Cliente(String nombre, List<String> carrito) {
        this.nombre = nombre;
        this.carrito = carrito;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getCarrito() {
        return carrito;
    }
}
