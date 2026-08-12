package vallegrande.edu.pe.view;

public class AgendaView {

    public void mostrarTitulo() {

        System.out.println("==============================");
        System.out.println("      AGENDA DE CONTACTOS");
        System.out.println("==============================");
    }

    public void mostrarMenu() {

        System.out.println("\n===== AGENDA DE CONTACTOS =====");
        System.out.println("1. Registrar contacto");
        System.out.println("2. Listar contactos");
        System.out.println("3. Buscar contacto");
        System.out.println("4. Eliminar contacto");
        System.out.println("5. Salir");
        System.out.println("==============================");
        System.out.print("Seleccione una opcion: ");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}