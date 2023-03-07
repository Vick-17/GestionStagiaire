module com.gestion.gestionstagiare {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gestion.gestionstagiare to javafx.fxml;
    exports com.gestion.gestionstagiare;
}