module com.group18.oopprojectgroup18realestate {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens com.group18.oopprojectgroup18realestate to javafx.fxml;
    exports com.group18.oopprojectgroup18realestate;
    opens com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport to javafx.fxml;
    exports com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;
    opens com.group18.oopprojectgroup18realestate.Sonda.MarketingOfficer to javafx.fxml;
    exports com.group18.oopprojectgroup18realestate.Sonda.MarketingOfficer;
}