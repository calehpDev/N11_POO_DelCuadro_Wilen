package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Contacto;
import java.util.ArrayList;

public class AgendaController {

    private ArrayList<Contacto> contactos;

    public AgendaController() {
        contactos = new ArrayList<>();
    }

    // Agregar contacto
    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
        System.out.println("Contacto agregado correctamente.");
    }

    // Listar contactos
    public void listarContactos() {

        System.out.println("\n===== LISTA DE CONTACTOS =====");

        if (contactos.isEmpty()) {
            System.out.println("No hay contactos registrados.");
            return;
        }

        for (Contacto contacto : contactos) {
            contacto.mostrarContacto();
        }
    }

    // Buscar contacto por nombre o apellido
    public void buscarContacto(String texto) {

        boolean encontrado = false;

        System.out.println("\n===== RESULTADO DE BUSQUEDA =====");

        for (Contacto contacto : contactos) {

            if (contacto.getNombres().toLowerCase().contains(texto.toLowerCase())
                    || contacto.getApellidos().toLowerCase().contains(texto.toLowerCase())) {

                contacto.mostrarContacto();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún contacto.");
        }
    }

    // Eliminar contacto por ID
    public void eliminarContacto(int id) {

        boolean eliminado = false;

        for (Contacto contacto : contactos) {

            if (contacto.getId() == id) {
                contactos.remove(contacto);
                eliminado = true;
                System.out.println("Contacto eliminado correctamente.");
                break;
            }
        }

        if (!eliminado) {
            System.out.println("No se encontró un contacto con ese ID.");
        }
    }
}