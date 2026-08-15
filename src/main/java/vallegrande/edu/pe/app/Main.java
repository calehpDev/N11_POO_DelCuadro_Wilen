package vallegrande.edu.pe.app;

import vallegrande.edu.pe.controller.AutorController;
import vallegrande.edu.pe.controller.BibliotecaController;
import vallegrande.edu.pe.model.Autor;
import vallegrande.edu.pe.model.Libro;
import vallegrande.edu.pe.view.BibliotecaView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BibliotecaController libroController = new BibliotecaController();
        AutorController autorController = new AutorController();
        BibliotecaView view = new BibliotecaView();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        view.mostrarTitulo();

        do {
            view.mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Título:");
                    String titulo = scanner.nextLine();
                    System.out.println("Autor:");
                    String autor = scanner.nextLine();
                    System.out.println("Año:");
                    int anio = scanner.nextInt();
                    scanner.nextLine();

                    if (titulo.trim().isEmpty() || autor.trim().isEmpty() || anio <= 0) {
                        System.out.println("Datos no válidos");
                    } else {
                        Libro libro = new Libro(id, titulo, autor, anio);
                        libroController.agregarLibro(libro);
                    }
                    break;

                case 2:
                    libroController.listarLibros();
                    break;

                case 3:
                    System.out.println("Ingrese Título o Autor:");
                    String criterio = scanner.nextLine();
                    libroController.buscarLibro(criterio);
                    break;

                case 4:
                    System.out.println("ID:");
                    int idAutor = scanner.nextInt();
                    scanner.nextLine();

                    String nombreAutor;
                    do {
                        System.out.println("Nombre del Autor:");
                        nombreAutor = scanner.nextLine().trim();
                        if (nombreAutor.isEmpty()) {
                            System.out.println(" No puede estar vacío.");
                        }
                    } while (nombreAutor.isEmpty());

                    System.out.println("Nacionalidad:");
                    String nacionalidad = scanner.nextLine();

                    Autor nuevoAutor = new Autor(idAutor, nombreAutor, nacionalidad);
                    autorController.agregarAutor(nuevoAutor);
                    break;

                case 5:
                    autorController.listarAutores();
                    break;

                case 6:
                    System.out.println("Hasta luego.");
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 6);

        scanner.close();
    }
}