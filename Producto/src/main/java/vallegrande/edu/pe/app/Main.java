package vallegrande.edu.pe.app;

import vallegrande.edu.pe.model.Producto;

public class Main {

    public static void main(String[] args) {

        Producto producto1 = new Producto(
                "Laptop Lenovo",
                "P001",
                2500.00,
                10,
                "Tecnología"
        );

        producto1.mostrarDatos();
    }
}