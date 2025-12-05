module com.group18.oopprojectgroup18realestate {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires java.logging;
    requires com.group18.oopprojectgroup18realestate;


    opens com.group18.oopprojectgroup18realestate to javafx.fxml;
    opens com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator to javafx.fxml;
    exports com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;
    opens com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer to javafx.fxml;
    exports com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;

    exports com.group18.oopprojectgroup18realestate;
    opens com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport to javafx.fxml;
    exports com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;
    opens com.group18.oopprojectgroup18realestate.Sonda.MarketingOfficer to javafx.fxml;
    exports com.group18.oopprojectgroup18realestate.Sonda.MarketingOfficer;
}