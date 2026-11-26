package vallegrande.edu.pe.gestionveterinaria.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import vallegrande.edu.pe.gestionveterinaria.Model.Cita;
import vallegrande.edu.pe.gestionveterinaria.Model.Mascota;

import java.sql.Timestamp;
import java.util.List;

public class MainView extends BorderPane {

    private static final String BG_APP = "#f1f5f9";
    private static final String BG_CARD = "#ffffff";
    private static final String BG_SIDEBAR = "#0f172a";
    private static final String BORDER_COLOR = "#e2e8f0";
    private static final String TEXT_PRIMARY = "#0f172a";
    private static final String TEXT_MUTED = "#64748b";
    private static final String ACCENT_HOVER = "#0f766e";

    private static final String BTN_NAV_NORMAL =
            "-fx-background-color: transparent; -fx-text-fill: #cbd5e1; -fx-alignment: CENTER-LEFT; " +
                    "-fx-font-size: 14px; -fx-font-weight: 600; -fx-padding: 11 14; -fx-background-radius: 8; -fx-cursor: hand;";
    private static final String BTN_NAV_ACTIVE =
            "-fx-background-color: #0d9488; -fx-text-fill: #ffffff; -fx-alignment: CENTER-LEFT; " +
                    "-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 11 14; -fx-background-radius: 8; -fx-cursor: hand;";

    private static final String INPUT_STYLE =
            "-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-radius: 6; " +
                    "-fx-background-radius: 6; -fx-padding: 8 10; -fx-font-size: 13px; -fx-text-fill: #0f172a;";

    private static final String BTN_REGISTRAR_STYLE =
            "-fx-background-color: #0d9488; -fx-text-fill: white; -fx-font-weight: bold; " +
                    "-fx-padding: 9 18; -fx-background-radius: 6; -fx-font-size: 13px; -fx-cursor: hand;";
    private static final String BTN_ACTUALIZAR_STYLE =
            "-fx-background-color: #0284c7; -fx-text-fill: white; -fx-font-weight: bold; " +
                    "-fx-padding: 9 18; -fx-background-radius: 6; -fx-font-size: 13px; -fx-cursor: hand;";
    private static final String BTN_ELIMINAR_STYLE =
            "-fx-background-color: #e11d48; -fx-text-fill: white; -fx-font-weight: bold; " +
                    "-fx-padding: 9 18; -fx-background-radius: 6; -fx-font-size: 13px; -fx-cursor: hand;";

    private final Button btnInicio = new Button("Inicio");
    private final Button btnServicios = new Button("Servicios");
    private final Button btnMascotas = new Button("Mascotas");
    private final Button btnCitas = new Button("Citas");
    private final Button btnLogout = new Button("Cerrar Sesión");

    private final Label lblSeccionActual = new Label("Panel Principal");

    private final StackPane contenidoCentral = new StackPane();
    private final VBox panelInicio = new VBox();
    private final VBox panelServicios = new VBox();
    private final VBox panelMascotas = new VBox();
    private final VBox panelCitas = new VBox();

    private final TextField txtCitaIdMascota = new TextField();
    private final TextField txtCitaIdVeterinario = new TextField();
    private final ComboBox<String> cmbCitaEstado = new ComboBox<>();

    private final Button btnCitaRegistrar = new Button("+ Registrar");
    private final Button btnCitaActualizar = new Button("Actualizar");
    private final Button btnCitaEliminar = new Button("Eliminar");
    private final TextField txtBuscarCitas = new TextField();

    private final TableView<Cita> tablaCitas = new TableView<>();
    private final ObservableList<Cita> listaCitas = FXCollections.observableArrayList();

    private final TextField txtMascotaNombre = new TextField();
    private final TextField txtMascotaEspecie = new TextField();
    private final TextField txtMascotaRaza = new TextField();
    private final TextField txtMascotaEdad = new TextField();
    private final TextField txtMascotaDueno = new TextField();
    private final TextField txtMascotaTelefono = new TextField();

    private final Button btnMascotaRegistrar = new Button("+ Registrar");
    private final Button btnMascotaActualizar = new Button("Actualizar");
    private final Button btnMascotaEliminar = new Button("Eliminar");
    private final TextField txtBuscarMascotas = new TextField();

    private final TableView<Mascota> tablaMascotas = new TableView<>();
    private final ObservableList<Mascota> listaMascotas = FXCollections.observableArrayList();

    public MainView() {
        initUI();
    }

    private void initUI() {
        this.setStyle("-fx-background-color: " + BG_APP + ";");

        VBox sidebar = new VBox(10);
        sidebar.setPadding(new Insets(22, 16, 22, 16));
        sidebar.setStyle("-fx-background-color: " + BG_SIDEBAR + ";");
        sidebar.setPrefWidth(240);

        Label lblMarca = new Label("VETCARE CLINIC");
        lblMarca.setStyle("-fx-text-fill: #2dd4bf; -fx-font-weight: bold; -fx-font-size: 18px;");

        Label lblSubmarca = new Label("Gestión Veterinaria");
        lblSubmarca.setStyle("-fx-text-fill: #94a3b8; -fx-font-size: 12px;");

        VBox headerSidebar = new VBox(2, lblMarca, lblSubmarca);
        headerSidebar.setPadding(new Insets(0, 6, 12, 6));

        btnLogout.setStyle(
                "-fx-background-color: #1e293b; -fx-text-fill: #fda4af; -fx-border-color: #be123c; " +
                        "-fx-border-radius: 8; -fx-background-radius: 8; -fx-font-weight: bold; " +
                        "-fx-padding: 10 14; -fx-cursor: hand;"
        );
        btnLogout.setMaxWidth(Double.MAX_VALUE);

        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        sidebar.getChildren().addAll(
                headerSidebar,
                btnInicio,
                btnMascotas,
                btnCitas,
                btnServicios,
                spacer,
                btnLogout
        );
        this.setLeft(sidebar);

        HBox topbar = new HBox();
        topbar.setAlignment(Pos.CENTER_LEFT);
        topbar.setPadding(new Insets(14, 24, 14, 24));
        topbar.setStyle("-fx-background-color: " + BG_CARD + "; -fx-border-color: transparent transparent " + BORDER_COLOR + " transparent; -fx-border-width: 1;");

        lblSeccionActual.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: " + TEXT_PRIMARY + ";");

        Region topSpacer = new Region();
        HBox.setHgrow(topSpacer, Priority.ALWAYS);

        Label lblBadge = new Label("MySQL • Activo");
        lblBadge.setStyle(
                "-fx-background-color: #ccfbf1; -fx-text-fill: #0f766e; -fx-font-weight: bold; " +
                        "-fx-font-size: 12px; -fx-padding: 5 12; -fx-background-radius: 20;"
        );

        topbar.getChildren().addAll(lblSeccionActual, topSpacer, lblBadge);
        this.setTop(topbar);

        construirPanelInicio();
        construirPanelServicios();
        construirPanelMascotas();
        construirPanelCitas();

        contenidoCentral.setPadding(new Insets(22));
        contenidoCentral.getChildren().addAll(panelInicio, panelServicios, panelMascotas, panelCitas);
        this.setCenter(contenidoCentral);

        mostrarInicio();
    }

    private void marcarBotonActivo(Button activo) {
        Button[] navs = {btnInicio, btnMascotas, btnCitas, btnServicios};
        for (Button b : navs) {
            b.setStyle(b == activo ? BTN_NAV_ACTIVE : BTN_NAV_NORMAL);
            b.setMaxWidth(Double.MAX_VALUE);
        }
    }

    private VBox crearTarjeta(String... estilosExtra) {
        VBox card = new VBox(14);
        card.setPadding(new Insets(18));
        String extra = estilosExtra.length > 0 ? estilosExtra[0] : "";
        card.setStyle(
                "-fx-background-color: " + BG_CARD + "; -fx-background-radius: 10; " +
                        "-fx-border-color: " + BORDER_COLOR + "; -fx-border-radius: 10; " +
                        "-fx-effect: dropshadow(gaussian, rgba(15,23,42,0.05), 10, 0, 0, 3); " + extra
        );
        return card;
    }

    private Label crearEtiquetaCampo(String texto) {
        Label lbl = new Label(texto);
        lbl.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: " + TEXT_MUTED + ";");
        return lbl;
    }

    private void estilizarInput(TextField tf, String prompt) {
        tf.setPromptText(prompt);
        tf.setStyle(INPUT_STYLE);
        tf.setMaxWidth(Double.MAX_VALUE);
    }

    private void estilizarTabla(TableView<?> tabla) {
        tabla.setStyle(
                "-fx-background-color: " + BG_CARD + "; -fx-border-color: " + BORDER_COLOR + "; " +
                        "-fx-border-radius: 8; -fx-background-radius: 8; -fx-font-size: 13px;"
        );
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
        VBox.setVgrow(tabla, Priority.ALWAYS);
    }

    private void construirPanelInicio() {
        panelInicio.setSpacing(20);
        panelInicio.setAlignment(Pos.TOP_LEFT);

        VBox hero = crearTarjeta("-fx-background-color: linear-gradient(to right, #0f172a, #134e4a); -fx-border-width: 0;");
        hero.setPadding(new Insets(28));

        Label titulo = new Label("Bienvenido al Sistema de Gestión de Veterinaria");
        titulo.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: white;");

        Label subtitulo = new Label("Administra pacientes, propietarios y citas médicas desde un panel unificado conectado a MySQL.");
        subtitulo.setStyle("-fx-font-size: 14px; -fx-text-fill: #cbd5e1;");

        hero.getChildren().addAll(titulo, subtitulo);

        HBox cardsRow = new HBox(18);
        cardsRow.getChildren().addAll(
                crearTarjetaInfo("Mascotas", "Registro, edición, búsqueda y control de pacientes."),
                crearTarjetaInfo("Citas Médicas", "Programación, seguimiento y estados de atención."),
                crearTarjetaInfo("Arquitectura MVC", "JavaFX + JDBC + MySQL estructurado por capas.")
        );
        for (var node : cardsRow.getChildren()) {
            HBox.setHgrow(node, Priority.ALWAYS);
        }

        panelInicio.getChildren().addAll(hero, cardsRow);
    }

    private VBox crearTarjetaInfo(String titulo, String descripcion) {
        VBox box = crearTarjeta();
        Label lblT = new Label(titulo);
        lblT.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: " + ACCENT_HOVER + ";");
        Label lblD = new Label(descripcion);
        lblD.setWrapText(true);
        lblD.setStyle("-fx-font-size: 13px; -fx-text-fill: " + TEXT_MUTED + ";");
        box.getChildren().addAll(lblT, lblD);
        return box;
    }

    private void construirPanelServicios() {
        panelServicios.setSpacing(16);
        panelServicios.setAlignment(Pos.TOP_LEFT);

        VBox card = crearTarjeta();
        Label lblTitulo = new Label("Servicios Veterinarios Disponibles");
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: " + TEXT_PRIMARY + ";");

        Label s1 = new Label("• Consulta general y diagnóstico clínico preventivo");
        Label s2 = new Label("• Vacunación y desparasitación interna/externa");
        Label s3 = new Label("• Control de citas, seguimiento y atención programada");
        for (Label l : new Label[]{s1, s2, s3}) {
            l.setStyle("-fx-font-size: 14px; -fx-text-fill: " + TEXT_PRIMARY + ";");
        }

        card.getChildren().addAll(lblTitulo, s1, s2, s3);
        panelServicios.getChildren().add(card);
    }

    @SuppressWarnings("unchecked")
    private void construirPanelMascotas() {
        panelMascotas.setSpacing(16);

        VBox formCard = crearTarjeta();
        Label lblTitulo = new Label("Gestión de Mascotas");
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: " + TEXT_PRIMARY + ";");

        GridPane gridForm = new GridPane();
        gridForm.setHgap(14);
        gridForm.setVgap(10);

        ColumnConstraints col0 = new ColumnConstraints();
        col0.setPercentWidth(12);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(38);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(12);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(38);
        gridForm.getColumnConstraints().addAll(col0, col1, col2, col3);

        estilizarInput(txtMascotaNombre, "Ej. Rocky");
        estilizarInput(txtMascotaEspecie, "Ej. Perro, Gato");
        estilizarInput(txtMascotaRaza, "Ej. Pastor Alemán");
        estilizarInput(txtMascotaEdad, "Ej. 3");
        estilizarInput(txtMascotaDueno, "Nombre completo del dueño");
        estilizarInput(txtMascotaTelefono, "Ej. 987654321");

        gridForm.add(crearEtiquetaCampo("Nombre *"), 0, 0);
        gridForm.add(txtMascotaNombre, 1, 0);
        gridForm.add(crearEtiquetaCampo("Especie *"), 2, 0);
        gridForm.add(txtMascotaEspecie, 3, 0);

        gridForm.add(crearEtiquetaCampo("Raza"), 0, 1);
        gridForm.add(txtMascotaRaza, 1, 1);
        gridForm.add(crearEtiquetaCampo("Edad *"), 2, 1);
        gridForm.add(txtMascotaEdad, 3, 1);

        gridForm.add(crearEtiquetaCampo("Dueño *"), 0, 2);
        gridForm.add(txtMascotaDueno, 1, 2);
        gridForm.add(crearEtiquetaCampo("Teléfono"), 2, 2);
        gridForm.add(txtMascotaTelefono, 3, 2);

        btnMascotaRegistrar.setStyle(BTN_REGISTRAR_STYLE);
        btnMascotaActualizar.setStyle(BTN_ACTUALIZAR_STYLE);
        btnMascotaEliminar.setStyle(BTN_ELIMINAR_STYLE);

        HBox boxBotones = new HBox(12, btnMascotaRegistrar, btnMascotaActualizar, btnMascotaEliminar);
        boxBotones.setPadding(new Insets(6, 0, 0, 0));

        formCard.getChildren().addAll(lblTitulo, gridForm, boxBotones);

        VBox tableCard = crearTarjeta();
        estilizarInput(txtBuscarMascotas, "Buscar por nombre, especie, raza o dueño...");
        txtBuscarMascotas.setPrefWidth(340);
        txtBuscarMascotas.setMaxWidth(450);

        HBox boxBuscador = new HBox(10, crearEtiquetaCampo("BUSCAR:"), txtBuscarMascotas);
        boxBuscador.setAlignment(Pos.CENTER_LEFT);

        TableColumn<Mascota, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("idMascota"));
        colId.setMaxWidth(70);

        TableColumn<Mascota, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Mascota, String> colEspecie = new TableColumn<>("Especie");
        colEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));

        TableColumn<Mascota, String> colRaza = new TableColumn<>("Raza");
        colRaza.setCellValueFactory(new PropertyValueFactory<>("raza"));

        TableColumn<Mascota, Integer> colEdad = new TableColumn<>("Edad");
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        colEdad.setMaxWidth(80);

        TableColumn<Mascota, String> colDueno = new TableColumn<>("Dueño");
        colDueno.setCellValueFactory(new PropertyValueFactory<>("dueno"));

        TableColumn<Mascota, String> colTelefono = new TableColumn<>("Teléfono");
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        tablaMascotas.getColumns().addAll(colId, colNombre, colEspecie, colRaza, colEdad, colDueno, colTelefono);
        tablaMascotas.setItems(listaMascotas);
        estilizarTabla(tablaMascotas);

        tableCard.getChildren().addAll(boxBuscador, tablaMascotas);
        VBox.setVgrow(tableCard, Priority.ALWAYS);

        panelMascotas.getChildren().addAll(formCard, tableCard);
    }

    @SuppressWarnings("unchecked")
    private void construirPanelCitas() {
        panelCitas.setSpacing(16);

        VBox formCard = crearTarjeta();
        Label lblTitulo = new Label("Gestión de Citas");
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: " + TEXT_PRIMARY + ";");

        GridPane gridForm = new GridPane();
        gridForm.setHgap(14);
        gridForm.setVgap(10);

        ColumnConstraints col0 = new ColumnConstraints();
        col0.setPercentWidth(14);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(36);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(14);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(36);
        gridForm.getColumnConstraints().addAll(col0, col1, col2, col3);

        estilizarInput(txtCitaIdMascota, "ID de la mascota");
        estilizarInput(txtCitaIdVeterinario, "ID del veterinario");

        cmbCitaEstado.getItems().addAll("PENDIENTE", "ATENDIDA", "CANCELADA");
        cmbCitaEstado.setValue("PENDIENTE");
        cmbCitaEstado.setStyle(INPUT_STYLE);
        cmbCitaEstado.setMaxWidth(Double.MAX_VALUE);

        gridForm.add(crearEtiquetaCampo("ID Mascota *"), 0, 0);
        gridForm.add(txtCitaIdMascota, 1, 0);
        gridForm.add(crearEtiquetaCampo("ID Veterinario *"), 2, 0);
        gridForm.add(txtCitaIdVeterinario, 3, 0);

        gridForm.add(crearEtiquetaCampo("Estado"), 0, 1);
        gridForm.add(cmbCitaEstado, 1, 1);

        btnCitaRegistrar.setStyle(BTN_REGISTRAR_STYLE);
        btnCitaActualizar.setStyle(BTN_ACTUALIZAR_STYLE);
        btnCitaEliminar.setStyle(BTN_ELIMINAR_STYLE);

        HBox boxBotones = new HBox(12, btnCitaRegistrar, btnCitaActualizar, btnCitaEliminar);
        boxBotones.setPadding(new Insets(6, 0, 0, 0));

        formCard.getChildren().addAll(lblTitulo, gridForm, boxBotones);

        VBox tableCard = crearTarjeta();
        estilizarInput(txtBuscarCitas, "Buscar por ID o estado...");
        txtBuscarCitas.setPrefWidth(340);
        txtBuscarCitas.setMaxWidth(450);

        HBox boxBuscador = new HBox(10, crearEtiquetaCampo("BUSCAR:"), txtBuscarCitas);
        boxBuscador.setAlignment(Pos.CENTER_LEFT);

        TableColumn<Cita, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("idCita"));
        colId.setMaxWidth(70);

        TableColumn<Cita, Integer> colMascota = new TableColumn<>("ID Mascota");
        colMascota.setCellValueFactory(new PropertyValueFactory<>("idMascota"));

        TableColumn<Cita, Integer> colVeterinario = new TableColumn<>("ID Veterinario");
        colVeterinario.setCellValueFactory(new PropertyValueFactory<>("idVeterinario"));

        TableColumn<Cita, Timestamp> colFecha = new TableColumn<>("Fecha Cita");
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaCita"));

        TableColumn<Cita, String> colEstado = new TableColumn<>("Estado");
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        tablaCitas.getColumns().addAll(colId, colMascota, colVeterinario, colFecha, colEstado);
        tablaCitas.setItems(listaCitas);
        estilizarTabla(tablaCitas);

        tableCard.getChildren().addAll(boxBuscador, tablaCitas);
        VBox.setVgrow(tableCard, Priority.ALWAYS);

        panelCitas.getChildren().addAll(formCard, tableCard);
    }

    public void mostrarInicio() {
        lblSeccionActual.setText("Panel Principal");
        marcarBotonActivo(btnInicio);
        panelInicio.setVisible(true);
        panelServicios.setVisible(false);
        panelMascotas.setVisible(false);
        panelCitas.setVisible(false);
    }

    public void mostrarServicios() {
        lblSeccionActual.setText("Servicios Veterinarios");
        marcarBotonActivo(btnServicios);
        panelInicio.setVisible(false);
        panelServicios.setVisible(true);
        panelMascotas.setVisible(false);
        panelCitas.setVisible(false);
    }

    public void mostrarMascotas() {
        lblSeccionActual.setText("Gestión de Mascotas");
        marcarBotonActivo(btnMascotas);
        panelInicio.setVisible(false);
        panelServicios.setVisible(false);
        panelMascotas.setVisible(true);
        panelCitas.setVisible(false);
    }

    public void mostrarCitas() {
        lblSeccionActual.setText("Gestión de Citas");
        marcarBotonActivo(btnCitas);
        panelInicio.setVisible(false);
        panelServicios.setVisible(false);
        panelMascotas.setVisible(false);
        panelCitas.setVisible(true);
    }

    public void mostrarDatosMascotas(List<Mascota> lista) {
        listaMascotas.setAll(lista);
    }

    public Mascota getMascotaSeleccionada() {
        return tablaMascotas.getSelectionModel().getSelectedItem();
    }

    public void cargarMascotaEnFormulario(Mascota m) {
        txtMascotaNombre.setText(m.getNombre());
        txtMascotaEspecie.setText(m.getEspecie());
        txtMascotaRaza.setText(m.getRaza());
        txtMascotaEdad.setText(String.valueOf(m.getEdad()));
        txtMascotaDueno.setText(m.getDueno());
        txtMascotaTelefono.setText(m.getTelefono());
    }

    public void limpiarFormularioMascotas() {
        txtMascotaNombre.clear();
        txtMascotaEspecie.clear();
        txtMascotaRaza.clear();
        txtMascotaEdad.clear();
        txtMascotaDueno.clear();
        txtMascotaTelefono.clear();
        tablaMascotas.getSelectionModel().clearSelection();
    }

    public void mostrarDatosCitas(List<Cita> lista) {
        listaCitas.setAll(lista);
    }

    public Cita getCitaSeleccionada() {
        return tablaCitas.getSelectionModel().getSelectedItem();
    }

    public void cargarCitaEnFormulario(Cita c) {
        txtCitaIdMascota.setText(String.valueOf(c.getIdMascota()));
        txtCitaIdVeterinario.setText(String.valueOf(c.getIdVeterinario()));
        cmbCitaEstado.setValue(c.getEstado());
    }

    public void limpiarFormularioCitas() {
        txtCitaIdMascota.clear();
        txtCitaIdVeterinario.clear();
        cmbCitaEstado.setValue("PENDIENTE");
        tablaCitas.getSelectionModel().clearSelection();
    }

    public Button getBtnInicio() { return btnInicio; }
    public Button getBtnServicios() { return btnServicios; }
    public Button getBtnMascotas() { return btnMascotas; }
    public Button getBtnCitas() { return btnCitas; }
    public Button getBtnLogout() { return btnLogout; }

    public TextField getTxtMascotaNombre() { return txtMascotaNombre; }
    public TextField getTxtMascotaEspecie() { return txtMascotaEspecie; }
    public TextField getTxtMascotaRaza() { return txtMascotaRaza; }
    public TextField getTxtMascotaEdad() { return txtMascotaEdad; }
    public TextField getTxtMascotaDueno() { return txtMascotaDueno; }
    public TextField getTxtMascotaTelefono() { return txtMascotaTelefono; }
    public Button getBtnMascotaRegistrar() { return btnMascotaRegistrar; }
    public Button getBtnMascotaActualizar() { return btnMascotaActualizar; }
    public Button getBtnMascotaEliminar() { return btnMascotaEliminar; }
    public TextField getTxtBuscarMascotas() { return txtBuscarMascotas; }
    public TableView<Mascota> getTablaMascotas() { return tablaMascotas; }

    public String getCitaIdMascota() { return txtCitaIdMascota.getText(); }
    public String getCitaIdVeterinario() { return txtCitaIdVeterinario.getText(); }
    public String getCitaEstado() { return cmbCitaEstado.getValue(); }
    public Button getBtnCitaRegistrar() { return btnCitaRegistrar; }
    public Button getBtnCitaActualizar() { return btnCitaActualizar; }
    public Button getBtnCitaEliminar() { return btnCitaEliminar; }
    public TextField getTxtBuscarCitas() { return txtBuscarCitas; }
    public TableView<Cita> getTablaCitas() { return tablaCitas; }
}