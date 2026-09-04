module vallegrande.edu.pe.preguntaspreguntonas {
    requires javafx.controls;
    requires javafx.fxml;

    opens vallegrande.edu.pe.preguntaspreguntonas to javafx.fxml;
    opens vallegrande.edu.pe.preguntaspreguntonas.controller to javafx.fxml;
    opens vallegrande.edu.pe.preguntaspreguntonas.view to javafx.fxml;

    exports vallegrande.edu.pe.preguntaspreguntonas;
    exports vallegrande.edu.pe.preguntaspreguntonas.controller;
    exports vallegrande.edu.pe.preguntaspreguntonas.view;
}
