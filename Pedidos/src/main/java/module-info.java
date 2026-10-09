module vallegrande.edu.pe.pedidos {
    // Módulos requeridos
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql; // Necesario para la clase Conexion y JDBC

    // Paquete principal (donde está la clase Main)
    exports vallegrande.edu.pe.pedidos;
    opens vallegrande.edu.pe.pedidos to javafx.fxml;

    // Paquete controlador (donde está MainController)
    exports vallegrande.edu.pe.pedidos.controller;
    opens vallegrande.edu.pe.pedidos.controller to javafx.fxml;

    // Paquete modelo (donde están Conexion, Pedido y PedidoDAO)
    exports vallegrande.edu.pe.pedidos.model;
    opens vallegrande.edu.pe.pedidos.model to javafx.fxml;

    // Paquete vista (donde está MainView)
    exports vallegrande.edu.pe.pedidos.view;
    opens vallegrande.edu.pe.pedidos.view to javafx.fxml;
}