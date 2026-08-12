package vallegrande.edu.pe.app;

import vallegrande.edu.pe.controller.AgendaController;
import vallegrande.edu.pe.model.Contacto;
import vallegrande.edu.pe.view.AgendaView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //Crear los componentes
        AgendaController controller = new AgendaController();
        AgendaView view = new AgendaView();

        //Mostrar Informacion
        view.mostrarTitulo();

        //Crear contactos
        Contacto contacto1 = new Contacto(
                1,
                "Ana",
                "Torres",
                "Cañete",
                "983745656",
                "ana@gmail.com"
        );

        Contacto contacto2 = new Contacto(
                2,
                "Carlos",
                "Perez",
                "Imperial",
                "951264456",
                "carlos@gmail.com"
        );

        Contacto contacto3 = new Contacto(
                3,
                "Valery",
                "Chumpitaz",
                "Imperial",
                "951264456",
                "valery@gmail.com"
        );

        Contacto contacto4 = new Contacto(
                4,
                "Luis",
                "Garcia",
                "San Vicente",
                "987654321",
                "luis@gmail.com"
        );

        Contacto contacto5 = new Contacto(
                5,
                "Maria",
                "Lopez",
                "Lunahuana",
                "912345678",
                "maria@gmail.com"
        );
        //Agregar contactos
        controller.agregarContacto(contacto1);
        controller.agregarContacto(contacto2);
        controller.agregarContacto(contacto3);
        controller.agregarContacto(contacto4);
        controller.agregarContacto(contacto5);

        // MENU

        int opcion;

        do {

            view.mostrarMenu();

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.println("\n===== REGISTRAR CONTACTO =====");

                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nombres: ");
                    String nombres = scanner.nextLine();

                    System.out.print("Apellidos: ");
                    String apellidos = scanner.nextLine();

                    System.out.print("Direccion: ");
                    String direccion = scanner.nextLine();

                    System.out.print("Telefono: ");
                    String telefono = scanner.nextLine();

                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();

                    Contacto nuevoContacto = new Contacto(
                            id,
                            nombres,
                            apellidos,
                            direccion,
                            telefono,
                            correo
                    );

                    controller.agregarContacto(nuevoContacto);

                    break;

                case 2:

                    controller.listarContactos();

                    break;

                case 3:

                    System.out.println("\n===== BUSCAR CONTACTO =====");

                    System.out.print("Ingrese nombre o apellido: ");
                    String busqueda = scanner.nextLine();

                    controller.buscarContacto(busqueda);

                    break;

                case 4:

                    System.out.println("\n===== ELIMINAR CONTACTO =====");

                    System.out.print("Ingrese el ID del contacto: ");
                    int idEliminar = scanner.nextInt();
                    scanner.nextLine();

                    controller.eliminarContacto(idEliminar);

                    break;

                case 5:

                    System.out.println("\nGracias por utilizar la Agenda de Contactos.");

                    break;

                default:

                    System.out.println("\nOpcion no valida. Seleccione del 1 al 5.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}