package vallegrande.edu.pe.view;

public class BibliotecaView {

    public void mostrarTitulo() {
        System.out.println("=====================");
        System.out.println("SISTEMA DE BIBLIOTECA VG");
        System.out.println("=====================");
    }

    public void mostrarMenu() {
        System.out.println("\n===== BIBLIOTECA =====");
        System.out.println("1. Registrar libro");
        System.out.println("2. Listar libros");
        System.out.println("3. Buscar libro");
        System.out.println("4. Registrar autor [Nuevo]");
        System.out.println("5. Listar autores [Nuevo]");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}