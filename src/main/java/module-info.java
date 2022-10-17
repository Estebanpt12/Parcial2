module co.edu.uniquindio {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.desktop;
    requires java.logging;

    exports co.edu.uniquindio.application;
    opens co.edu.uniquindio.application to javafx.fxml;
    exports co.edu.uniquindio.controllers;
    opens co.edu.uniquindio.controllers to javafx.fxml;
    exports co.edu.uniquindio.model;
    opens co.edu.uniquindio.model to javafx.fxml;
    exports co.edu.uniquindio.exceptions;

}
