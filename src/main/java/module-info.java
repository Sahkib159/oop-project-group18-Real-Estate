module com.group18.oopprojectgroup18realestate {

    requires javafx.controls;
    requires javafx.fxml;

    opens com.group18.oopprojectgroup18realestate to javafx.fxml;
    opens com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator to javafx.fxml;
    opens com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer to javafx.fxml;


    opens com.group18.oopprojectgroup18realestate.Ramisa to javafx.fxml;

    exports com.group18.oopprojectgroup18realestate;
    exports com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;
    exports com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;


    exports com.group18.oopprojectgroup18realestate.Ramisa;
}
