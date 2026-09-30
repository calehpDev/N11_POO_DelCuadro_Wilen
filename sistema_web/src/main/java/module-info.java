module vallegrande.edu.pe.sistema_web {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens vallegrande.edu.pe.sistema_web to javafx.fxml;
    opens vallegrande.edu.pe.sistema_web.Controller to javafx.fxml;
    opens vallegrande.edu.pe.sistema_web.Model to javafx.base;

    exports vallegrande.edu.pe.sistema_web;
    exports vallegrande.edu.pe.sistema_web.Controller;
    exports vallegrande.edu.pe.sistema_web.Model;
}