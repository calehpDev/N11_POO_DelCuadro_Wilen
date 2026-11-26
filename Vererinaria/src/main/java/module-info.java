module vallegrande.edu.pe.gestionveterinaria {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens vallegrande.edu.pe.gestionveterinaria to javafx.fxml;
    opens vallegrande.edu.pe.gestionveterinaria.Model to javafx.base;

    exports vallegrande.edu.pe.gestionveterinaria;
    exports vallegrande.edu.pe.gestionveterinaria.Controller;
    exports vallegrande.edu.pe.gestionveterinaria.Model;
    exports vallegrande.edu.pe.gestionveterinaria.View;
}