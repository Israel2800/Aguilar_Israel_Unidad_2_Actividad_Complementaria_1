// Clase principal Producto
class Producto {
    protected String nombre;
    protected double precio;
    protected int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public void mostrarInfo() {
        System.out.println("Producto: " + nombre + ", Precio: " + precio + ", Cantidad disponible: " + cantidad);
    }

    public double calcularPrecioTotal(int cantidad) {
        return precio * cantidad;
    }
}

// Subclase ProductoExpirado
class ProductoExpirado extends Producto {
    private String fechaCaducidad;

    public ProductoExpirado(String nombre, double precio, int cantidad, String fechaCaducidad) {
        super(nombre, precio, cantidad);
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Fecha de caducidad: " + fechaCaducidad);
    }

    // Sobrecarga del método calcularPrecioTotal
    public double calcularPrecioTotal(int cantidad, boolean descuento) {
        double total = super.calcularPrecioTotal(cantidad);
        if (descuento) {
            total *= 0.9;  // 10% de descuento
        }
        return total;
    }
}

// Subclase ProductoNoExpirado
class ProductoNoExpirado extends Producto {
    private String tipo;

    public ProductoNoExpirado(String nombre, double precio, int cantidad, String tipo) {
        super(nombre, precio, cantidad);
        this.tipo = tipo;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Tipo: " + tipo);
    }
}

public class Autoservicio {
    public static void main(String[] args) {
        ProductoExpirado leche = new ProductoExpirado("Leche", 1.50, 100, "2024-12-01");
        ProductoNoExpirado jabon = new ProductoNoExpirado("Jabón", 0.99, 200, "Limpieza");

        // Mostrar información de los productos
        leche.mostrarInfo();
        System.out.println("Precio total sin descuento: " + leche.calcularPrecioTotal(5));
        System.out.println("Precio total con descuento: " + leche.calcularPrecioTotal(5, true));

        jabon.mostrarInfo();
        System.out.println("Precio total: " + jabon.calcularPrecioTotal(10));
    }
}