module com.group18.oopprojectgroup18realestate {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.group18.oopprojectgroup18realestate to javafx.fxml;
    exports com.group18.oopprojectgroup18realestate;
}