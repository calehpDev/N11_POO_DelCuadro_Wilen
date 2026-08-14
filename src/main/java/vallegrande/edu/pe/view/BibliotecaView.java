package vallegrande.edu.pe.view;

import javax.management.PersistentMBean;

public class BibliotecaView {

    public void mostrarTitulo(){
        System.out.println("=====================");
        System.out.println("ISTEMA DE BIBLIOTECA VG");
        System.out.println("=====================");
    }

    //MENU
    public void mostrarMenu(){
        System.out.println("1. Resgistar Libro");
        System.out.println("2. Listas Libro");
        System.out.println("3. Buscar Libro");
        System.out.println("4. Salir");
        System.out.println("Selecione una Opcion:");
    }
    //MENSAJE
    public void mostrarMensaje( String mensaje){
        System.out.println(mensaje);
    }
}
