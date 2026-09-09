package vallegrande.edu.pe.misistema.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainView extends BorderPane {
    private Button btnInicio;
    private Button btnUsuarios;
    private Button btnProductos;
    private Button btnReportes;
    private Button btnConfiguracion;
    private Button btnCitas;

    public MainView() {
        // Fondo general gris ultra claro
        setStyle("-fx-background-color: #F8FAFC;");
        crearMenu();
        mostrarInicio();
    }

    private void crearMenu() {
        VBox menu = new VBox(6);
        menu.setPadding(new Insets(24, 14, 24, 14));
        menu.setPrefWidth(220);
        menu.setStyle("-fx-background-color: #0F172A;"); // Slate oscuro

        Label titulo = new Label("MI SISTEMA");
        titulo.setStyle(
                "-fx-font-size: 13px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #94A3B8;" +
                        "-fx-padding: 0 0 12 10;"
        );

        btnInicio = crearBoton("🏠  Inicio");
        btnUsuarios = crearBoton("👥  Usuarios");
        btnProductos = crearBoton("📦  Productos");
        btnReportes = crearBoton("📊  Reportes");
        btnConfiguracion = crearBoton("⚙️  Configuración");
        btnCitas = crearBoton("📅  Citas");

        menu.getChildren().addAll(
                titulo,
                btnInicio,
                btnUsuarios,
                btnProductos,
                btnReportes,
                btnConfiguracion,
                btnCitas
        );
        setLeft(menu);
    }

    private Button crearBoton(String texto) {
        Button boton = new Button(texto);
        boton.setPrefWidth(192);
        boton.setPrefHeight(38);
        boton.setAlignment(Pos.CENTER_LEFT);
        boton.setPadding(new Insets(0, 0, 0, 12));

        // Estilo Base Transparente
        String estiloBase =
                "-fx-background-color: transparent;" +
                        "-fx-text-fill: #94A3B8;" +
                        "-fx-font-size: 13px;" +
                        "-fx-font-weight: 500;" +
                        "-fx-background-radius: 6;" +
                        "-fx-cursor: hand;";

        // Estilo al pasar el cursor (Hover)
        String estiloHover =
                "-fx-background-color: #1E293B;" +
                        "-fx-text-fill: #F8FAFC;" +
                        "-fx-font-size: 13px;" +
                        "-fx-font-weight: 500;" +
                        "-fx-background-radius: 6;" +
                        "-fx-cursor: hand;";

        boton.setStyle(estiloBase);

        // Eventos dinámicos de Hover
        boton.setOnMouseEntered(e -> boton.setStyle(estiloHover));
        boton.setOnMouseExited(e -> boton.setStyle(estiloBase));

        return boton;
    }

    public void mostrarInicio() {
        VBox contenido = new VBox(8);
        contenido.setAlignment(Pos.CENTER);

        Label titulo = new Label("Bienvenido de nuevo");
        titulo.setStyle("-fx-font-size: 24px; -fx-font-weight: 600; -fx-text-fill: #0F172A;");

        Label texto = new Label("Resumen general del panel de administración.");
        texto.setStyle("-fx-font-size: 14px; -fx-text-fill: #64748B;");

        contenido.getChildren().addAll(titulo, texto);
        setCenter(contenido);
    }

    public void mostrarUsuarios() {
        VBox contenido = crearContenedorSeccion("Gestión de Usuarios", "Administra los accesos y roles de la plataforma.");
        HBox tarjetas = new HBox(16);
        tarjetas.getChildren().addAll(
                crearTarjeta("Carlos Pérez", "Administrador", "Activo"),
                crearTarjeta("María López", "Vendedora", "Activo"),
                crearTarjeta("Piero Ramos", "Supervisor", "Inactivo")
        );
        contenido.getChildren().add(tarjetas);
        setCenter(contenido);
    }

    public void mostrarProductos() {
        VBox contenido = crearContenedorSeccion("Catálogo de Productos", "Inventario disponible en el almacén.");
        HBox tarjetas = new HBox(16);
        tarjetas.getChildren().addAll(
                crearTarjeta("Laptop Lenovo", "S/ 2,500.00", "Stock: 12 unids."),
                crearTarjeta("Mouse Logitech", "S/ 80.00", "Stock: 45 unids."),
                crearTarjeta("Teclado Mecánico", "S/ 180.00", "Stock: 8 unids.")
        );
        contenido.getChildren().add(tarjetas);
        setCenter(contenido);
    }

    public void mostrarReportes() {
        VBox contenido = crearContenedorSeccion("Reportes y Analíticas", "Métricas de rendimiento comercial del periodo.");
        HBox tarjetas = new HBox(16);
        tarjetas.getChildren().addAll(
                crearTarjeta("Ventas Mensuales", "S/ 12,450.00", "+12% vs mes anterior"),
                crearTarjeta("Productos Reg.", "1,240 Unidades", "8 categorías activas"),
                crearTarjeta("Usuarios Activos", "45 En línea", "Pico diario: 11:00 AM")
        );
        contenido.getChildren().add(tarjetas);
        setCenter(contenido);
    }

    public void mostrarConfiguracion() {
        VBox contenido = crearContenedorSeccion("Configuración", "Preferencias del sistema y ajustes de cuenta.");
        HBox tarjetas = new HBox(16);
        tarjetas.getChildren().addAll(
                crearTarjeta("Perfil de Usuario", "admin@vallegrande.edu.pe", "Editar datos"),
                crearTarjeta("Apariencia", "Modo Minimalista", "Tema activo"),
                crearTarjeta("Seguridad", "Autenticación 2FA", "Habilitada")
        );
        contenido.getChildren().add(tarjetas);
        setCenter(contenido);
    }

    public void mostrarCitas() {
        VBox contenido = crearContenedorSeccion("Citas Agendadas", "Cronograma de atenciones programadas.");
        HBox tarjetas = new HBox(16);
        tarjetas.getChildren().addAll(
                crearTarjeta("Juan Pérez", "10:00 AM - Hoy", "Atención Presencial"),
                crearTarjeta("María Gómez", "11:30 AM - Hoy", "Soporte Técnico"),
                crearTarjeta("Pedro Ruiz", "03:00 PM - Mañana", "Consulta General")
        );
        contenido.getChildren().add(tarjetas);
        setCenter(contenido);
    }

    // Estructura limpia para títulos de sección
    private VBox crearContenedorSeccion(String tituloTexto, String subtituloTexto) {
        VBox contenedor = new VBox(20);
        contenedor.setPadding(new Insets(36));

        VBox encabezado = new VBox(4);
        Label titulo = new Label(tituloTexto);
        titulo.setStyle("-fx-font-size: 22px; -fx-font-weight: 600; -fx-text-fill: #0F172A;");
        Label subtitulo = new Label(subtituloTexto);
        subtitulo.setStyle("-fx-font-size: 13px; -fx-text-fill: #64748B;");

        encabezado.getChildren().addAll(titulo, subtitulo);
        contenedor.getChildren().add(encabezado);
        return contenedor;
    }

    // Tarjetas minimalistas: Fondo blanco puro, borde gris fino, tipografía limpia
    private VBox crearTarjeta(String titulo, String valor, String detalle) {
        VBox tarjeta = new VBox(6);
        tarjeta.setPadding(new Insets(18));
        tarjeta.setPrefWidth(200);
        tarjeta.setStyle(
                "-fx-background-color: #FFFFFF;" +
                        "-fx-border-color: #E2E8F0;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 8px;" +
                        "-fx-background-radius: 8px;"
        );

        Label lblTitulo = new Label(titulo);
        lblTitulo.setStyle("-fx-font-size: 14px; -fx-font-weight: 600; -fx-text-fill: #0F172A;");

        Label lblValor = new Label(valor);
        lblValor.setStyle("-fx-font-size: 14px; -fx-font-weight: 500; -fx-text-fill: #334155;");

        Label lblDetalle = new Label(detalle);
        lblDetalle.setStyle("-fx-font-size: 12px; -fx-text-fill: #94A3B8;");

        tarjeta.getChildren().addAll(lblTitulo, lblValor, lblDetalle);
        return tarjeta;
    }

    // Getters
    public Button getBtnInicio() { return btnInicio; }
    public Button getBtnUsuarios() { return btnUsuarios; }
    public Button getBtnProductos() { return btnProductos; }
    public Button getBtnReportes() { return btnReportes; }
    public Button getBtnConfiguracion() { return btnConfiguracion; }
    public Button getBtnCitas() { return btnCitas; }
}