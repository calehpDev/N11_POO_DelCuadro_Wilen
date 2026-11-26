package vallegrande.edu.pe.gestionveterinaria.Controller;

import java.util.List;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import vallegrande.edu.pe.gestionveterinaria.Model.Cita;
import vallegrande.edu.pe.gestionveterinaria.Model.CitaDAO;
import vallegrande.edu.pe.gestionveterinaria.Model.Mascota;
import vallegrande.edu.pe.gestionveterinaria.Model.MascotaDAO;
import vallegrande.edu.pe.gestionveterinaria.View.MainView;

public class MainController {

    private final MainView view;
    private final Stage stage;
    private String usuarioLogueado;

    private final CitaDAO citaDAO;
    private final MascotaDAO mascotaDAO;

    public MainController(MainView view, Stage stage, String usuarioLogueado) {
        this.view = view;
        this.stage = stage;
        this.usuarioLogueado = usuarioLogueado;

        this.citaDAO = new CitaDAO();
        this.mascotaDAO = new MascotaDAO();

        configurarEventos();
    }

    private void configurarEventos() {

        if (view.getBtnInicio() != null) {
            view.getBtnInicio().setOnAction(e -> view.mostrarInicio());
        }

        if (view.getBtnServicios() != null) {
            view.getBtnServicios().setOnAction(e -> view.mostrarServicios());
        }

        if (view.getBtnLogout() != null) {
            view.getBtnLogout().setOnAction(e -> cerrarSesion());
        }

        // --- MÓDULO MASCOTAS ---
        if (view.getBtnMascotas() != null) {
            view.getBtnMascotas().setOnAction(e -> {
                view.mostrarMascotas();
                cargarMascotas();
            });
        }

        if (view.getTxtBuscarMascotas() != null) {
            view.getTxtBuscarMascotas().setOnKeyReleased(e -> buscarMascotas());
        }

        if (view.getBtnMascotaRegistrar() != null) {
            view.getBtnMascotaRegistrar().setOnAction(e -> registrarMascota());
        }

        if (view.getBtnMascotaActualizar() != null) {
            view.getBtnMascotaActualizar().setOnAction(e -> actualizarMascota());
        }

        if (view.getBtnMascotaEliminar() != null) {
            view.getBtnMascotaEliminar().setOnAction(e -> eliminarMascota());
        }

        if (view.getTablaMascotas() != null) {
            view.getTablaMascotas().setOnMouseClicked(e -> {
                Mascota seleccion = view.getMascotaSeleccionada();
                if (seleccion != null) {
                    view.cargarMascotaEnFormulario(seleccion);
                }
            });
        }

        // --- MÓDULO CITAS ---
        if (view.getBtnCitas() != null) {
            view.getBtnCitas().setOnAction(e -> {
                view.mostrarCitas();
                cargarCitas();
            });
        }

        if (view.getTxtBuscarCitas() != null) {
            view.getTxtBuscarCitas().setOnKeyReleased(e -> buscarCitas());
        }

        if (view.getBtnCitaRegistrar() != null) {
            view.getBtnCitaRegistrar().setOnAction(e -> registrarCita());
        }

        if (view.getBtnCitaActualizar() != null) {
            view.getBtnCitaActualizar().setOnAction(e -> actualizarCita());
        }

        if (view.getBtnCitaEliminar() != null) {
            view.getBtnCitaEliminar().setOnAction(e -> eliminarCita());
        }

        if (view.getTablaCitas() != null) {
            view.getTablaCitas().setOnMouseClicked(e -> {
                Cita seleccion = view.getCitaSeleccionada();
                if (seleccion != null) {
                    view.cargarCitaEnFormulario(seleccion);
                }
            });
        }
    }

    // --- MÉTODOS MASCOTAS ---
    private void cargarMascotas() {
        try {
            List<Mascota> lista = mascotaDAO.listarTodos();
            view.mostrarDatosMascotas(lista);
        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error al cargar mascotas: " + e.getMessage());
        }
    }

    private void buscarMascotas() {
        try {
            String texto = view.getTxtBuscarMascotas().getText().trim();
            List<Mascota> lista = mascotaDAO.listarPorEspecieODueno(texto);
            view.mostrarDatosMascotas(lista);
        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error al buscar mascotas: " + e.getMessage());
        }
    }

    private void registrarMascota() {
        try {
            String nombre = view.getTxtMascotaNombre().getText().trim();
            String especie = view.getTxtMascotaEspecie().getText().trim();
            String raza = view.getTxtMascotaRaza().getText().trim();
            String edadTexto = view.getTxtMascotaEdad().getText().trim();
            String dueno = view.getTxtMascotaDueno().getText().trim();
            String telefono = view.getTxtMascotaTelefono().getText().trim();

            if (nombre.isEmpty() || especie.isEmpty() || edadTexto.isEmpty() || dueno.isEmpty()) {
                mostrarAlerta(Alert.AlertType.WARNING, "Validación", "Complete los campos obligatorios (Nombre, Especie, Edad, Dueño).");
                return;
            }

            if (!edadTexto.matches("\\d+")) {
                mostrarAlerta(Alert.AlertType.WARNING, "Validación", "La edad solo debe contener números.");
                return;
            }

            int edad = Integer.parseInt(edadTexto);
            Mascota m = new Mascota(nombre, especie, raza, edad, dueno, telefono);

            if (mascotaDAO.insertar(m)) {
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Mascota registrada correctamente.");
                view.limpiarFormularioMascotas();
                cargarMascotas();
            } else {
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo registrar la mascota en la base de datos.");
            }

        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error al registrar mascota: " + e.getMessage());
        }
    }

    private void actualizarMascota() {
        try {
            Mascota seleccion = view.getMascotaSeleccionada();
            if (seleccion == null) {
                mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "Seleccione una mascota de la tabla para actualizar.");
                return;
            }

            String nombre = view.getTxtMascotaNombre().getText().trim();
            String especie = view.getTxtMascotaEspecie().getText().trim();
            String raza = view.getTxtMascotaRaza().getText().trim();
            String edadTexto = view.getTxtMascotaEdad().getText().trim();
            String dueno = view.getTxtMascotaDueno().getText().trim();

            if (nombre.isEmpty() || especie.isEmpty() || edadTexto.isEmpty() || dueno.isEmpty()) {
                mostrarAlerta(Alert.AlertType.WARNING, "Validación", "Los campos principales no pueden estar vacíos.");
                return;
            }

            if (!edadTexto.matches("\\d+")) {
                mostrarAlerta(Alert.AlertType.WARNING, "Validación", "La edad solo debe contener números.");
                return;
            }

            seleccion.setNombre(nombre);
            seleccion.setEspecie(especie);
            seleccion.setRaza(raza);
            seleccion.setEdad(Integer.parseInt(edadTexto));
            seleccion.setDueno(dueno);
            seleccion.setTelefono(view.getTxtMascotaTelefono().getText().trim());

            if (mascotaDAO.actualizar(seleccion)) {
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Mascota actualizada correctamente.");
                view.limpiarFormularioMascotas();
                cargarMascotas();
            } else {
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo actualizar la mascota.");
            }

        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error al actualizar mascota: " + e.getMessage());
        }
    }

    private void eliminarMascota() {
        try {
            Mascota seleccion = view.getMascotaSeleccionada();
            if (seleccion == null) {
                mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "Seleccione una mascota para eliminar.");
                return;
            }

            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Confirmación de Borrado");
            confirmacion.setHeaderText(null);
            confirmacion.setContentText("¿Está seguro de eliminar a " + seleccion.getNombre() + " (Dueño: " + seleccion.getDueno() + ")?");

            Optional<ButtonType> resultado = confirmacion.showAndWait();
            if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                if (mascotaDAO.eliminar(seleccion.getIdMascota())) {
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Mascota eliminada correctamente.");
                    view.limpiarFormularioMascotas();
                    cargarMascotas();
                } else {
                    mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo eliminar la mascota.");
                }
            }

        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error al eliminar mascota: " + e.getMessage());
        }
    }

    // --- MÉTODOS CITAS ---
    private void cargarCitas() {
        try {
            List<Cita> lista = citaDAO.listar();
            view.mostrarDatosCitas(lista);
        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error al cargar citas: " + e.getMessage());
        }
    }

    private void buscarCitas() {
        try {
            String texto = view.getTxtBuscarCitas().getText().trim();
            List<Cita> lista = citaDAO.buscar(texto);
            view.mostrarDatosCitas(lista);
        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error al buscar citas: " + e.getMessage());
        }
    }

    private void registrarCita() {
        try {
            if (view.getCitaIdMascota().trim().isEmpty() || view.getCitaIdVeterinario().trim().isEmpty()) {
                mostrarAlerta(Alert.AlertType.WARNING, "Validación", "Ingresa el ID de la Mascota y el ID del Veterinario.");
                return;
            }

            Cita cita = new Cita();
            cita.setIdMascota(Integer.parseInt(view.getCitaIdMascota().trim()));
            cita.setIdVeterinario(Integer.parseInt(view.getCitaIdVeterinario().trim()));

            String estado = view.getCitaEstado();
            cita.setEstado((estado != null && !estado.isEmpty()) ? estado : "PENDIENTE");

            citaDAO.insertar(cita);
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Cita registrada correctamente.");

            view.limpiarFormularioCitas();
            cargarCitas();

        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.WARNING, "Validación", "Los IDs deben ser números enteros.");
        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error al registrar la cita: " + e.getMessage());
        }
    }

    private void actualizarCita() {
        try {
            Cita seleccion = view.getCitaSeleccionada();
            if (seleccion == null) {
                mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "Selecciona una cita de la tabla para actualizar.");
                return;
            }

            if (view.getCitaIdMascota().trim().isEmpty() || view.getCitaIdVeterinario().trim().isEmpty()) {
                mostrarAlerta(Alert.AlertType.WARNING, "Validación", "Los campos ID Mascota e ID Veterinario no pueden estar vacíos.");
                return;
            }

            seleccion.setIdMascota(Integer.parseInt(view.getCitaIdMascota().trim()));
            seleccion.setIdVeterinario(Integer.parseInt(view.getCitaIdVeterinario().trim()));
            seleccion.setEstado(view.getCitaEstado());

            citaDAO.actualizar(seleccion);
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Cita actualizada correctamente.");

            view.limpiarFormularioCitas();
            cargarCitas();

        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.WARNING, "Validación", "Verifica que los IDs ingresados sean valores numéricos.");
        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error al actualizar la cita: " + e.getMessage());
        }
    }

    private void eliminarCita() {
        try {
            Cita seleccion = view.getCitaSeleccionada();
            if (seleccion == null) {
                mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "Selecciona una cita para eliminar.");
                return;
            }

            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Confirmación de Borrado");
            confirmacion.setHeaderText(null);
            confirmacion.setContentText("¿Está seguro de eliminar la cita ID #" + seleccion.getIdCita() + "?");

            Optional<ButtonType> resultado = confirmacion.showAndWait();
            if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                citaDAO.eliminar(seleccion.getIdCita());
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Cita eliminada correctamente.");

                view.limpiarFormularioCitas();
                cargarCitas();
            }

        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error al eliminar la cita: " + e.getMessage());
        }
    }

    private void cerrarSesion() {
        stage.close();
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}