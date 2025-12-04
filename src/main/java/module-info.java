module com.group18.oopprojectgroup18realestate {

    requires javafx.controls;
    requires javafx.fxml;

    opens com.group18.oopprojectgroup18realestate to javafx.fxml;
    opens com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator to javafx.fxml;
    opens com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer to javafx.fxml;

    // ADD THESE FOR R A M I S A
    opens com.group18.oopprojectgroup18realestate.Ramisa to javafx.fxml;

    exports com.group18.oopprojectgroup18realestate;
    exports com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;
    exports com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;

    // OPTIONAL but safe
    exports com.group18.oopprojectgroup18realestate.Ramisa;
}
