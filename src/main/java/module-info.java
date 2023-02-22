module com.example.userjfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires javax.mail.api;


    opens com.example.userjfx to javafx.fxml;
    exports com.example.userjfx;
}