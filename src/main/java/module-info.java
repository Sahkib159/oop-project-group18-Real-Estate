module com.group18.oopprojectgroup18realestate {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;

    opens com.group18.oopprojectgroup18realestate to javafx.fxml;
    opens com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator to javafx.fxml;
    opens com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer to javafx.fxml;
    opens com.group18.oopprojectgroup18realestate.Ramisa to javafx.fxml;

    opens com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport to javafx.fxml;
    opens com.group18.oopprojectgroup18realestate.Sonda.MarketingOfficer to javafx.fxml;
    opens com.group18.oopprojectgroup18realestate.Adiba.PropertyBuyer to javafx.fxml;
    opens com.group18.oopprojectgroup18realestate.Adiba.SalesAgent to javafx.fxml;

    exports com.group18.oopprojectgroup18realestate;
    exports com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;
    exports com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;
    exports com.group18.oopprojectgroup18realestate.Ramisa;

    exports com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;
    exports com.group18.oopprojectgroup18realestate.Sonda.MarketingOfficer;
    exports com.group18.oopprojectgroup18realestate.Adiba.PropertyBuyer;
    exports com.group18.oopprojectgroup18realestate.Adiba.SalesAgent;
}
