module com.group18.oopprojectgroup18realestate {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.group18.oopprojectgroup18realestate to javafx.fxml;
    exports com.group18.oopprojectgroup18realestate;
    opens com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport to javafx.fxml;
    exports com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;
    opens com.group18.oopprojectgroup18realestate.Sonda.MarketingOfficer to javafx.fxml;
    exports com.group18.oopprojectgroup18realestate.Sonda.MarketingOfficer;
    opens com.group18.oopprojectgroup18realestate.Ramisa to javafx.fxml;
    exports com.group18.oopprojectgroup18realestate.Ramisa;
}