package vallegrande.edu.pe.miperfil.controller;

import vallegrande.edu.pe.miperfil.model.Perfil;
import vallegrande.edu.pe.miperfil.view.PerfilView;

public class PerfilController {
    private PerfilView view;

    public PerfilController(PerfilView view) {
        this.view = view;
        this.view.getBtnMostrar().setOnAction(e -> mostrarPerfil());
        this.view.getBtnLimpiar().setOnAction(e -> limpiarCampos());
    }

    private void mostrarPerfil() {
        String nombre = view.getTxtNombre().getText().trim();
        String carrera = view.getTxtCarrera().getText().trim();
        String semestre = view.getCboSemestre().getValue();
        String hobby = view.getCboHobby().getValue();

        if (nombre.isEmpty()) {
            view.getLblResultado().setText("⚠️ El campo Nombre no puede estar vacío.");
            view.getLblResultado().setStyle("-fx-text-fill: #e11d48; -fx-font-weight: bold;");
            return;
        }

        Perfil perfil = new Perfil(
                nombre,
                carrera.isEmpty() ? "No especificado" : carrera,
                semestre != null ? semestre : "No seleccionado",
                hobby != null ? hobby : "No seleccionado"
        );

        view.getLblResultado().setStyle("-fx-text-fill: #16a34a; -fx-font-weight: bold;");
        view.getLblResultado().setText(perfil.obtenerPresentacion());
    }

    private void limpiarCampos() {
        view.getTxtNombre().clear();
        view.getTxtCarrera().clear();
        view.getCboSemestre().getSelectionModel().clearSelection();
        view.getCboHobby().getSelectionModel().clearSelection();
        view.getLblResultado().setText("");
    }
}