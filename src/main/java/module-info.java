module com.example.userjfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javax.mail.api;
    requires java.desktop;
    requires javafx.swing;
    // requires mail;
   // requires java.mail;


    opens com.example.userjfx to javafx.fxml;
    exports com.example.userjfx;
}