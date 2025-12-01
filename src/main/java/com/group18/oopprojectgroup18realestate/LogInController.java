package com.group18.oopprojectgroup18realestate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LogInController {

    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    @FXML private Label errorLabel;
    @FXML private ComboBox<String> roleComboBox;

    @FXML
    public void initialize() {
        roleComboBox.getItems().addAll(
                "System Administrator",
                "Finance Officer",
                "Marketing Officer",
                "Customer Support Executive",
                "Property Renter",
                "Property Manager",
                "Property buyer",
                "Sales Agent"
        );
    }

    @FXML
    public void logInOnClick(ActionEvent event) throws Exception {

        String role = roleComboBox.getSelectionModel().getSelectedItem();

        if (role == null) {
            errorLabel.setText("Please select a role!");
            return;
        }

        switch (role) {

            case "System Administrator":
                SceneSwitcher.switchTo(
                        "Sahkib/SystemAdministrator/SystemAdministratorDashboard",
                        (Node) event.getSource()
                );
                break;

            case "Finance Officer":
                SceneSwitcher.switchTo(
                        "Sahkib/FinanceOfficer/FinanceOfficerDashboard",
                        (Node) event.getSource()
                );
                break;

            case "Marketing Officer":
                SceneSwitcher.switchTo(
                        "Sahkib/MarketingOfficer/MarketingOfficerDashboard",
                        (Node) event.getSource()
                );
                break;

            case "Customer Support Executive":
                SceneSwitcher.switchTo(
                        "Sahkib/CustomerSupport/CustomerSupportDashboard",
                        (Node) event.getSource()
                );
                break;

            case "Property Renter":
                SceneSwitcher.switchTo(
                        "Sahkib/PropertyRenter/PropertyRenterDashboard",
                        (Node) event.getSource()
                );
                break;

            case "Property Manager":
                SceneSwitcher.switchTo(
                        "Sahkib/PropertyManager/PropertyManagerDashboard",
                        (Node) event.getSource()
                );
                break;

            case "Property buyer":
                SceneSwitcher.switchTo(
                        "Sahkib/PropertyBuyer/PropertyBuyerDashboard",
                        (Node) event.getSource()
                );
                break;

            case "Sales Agent":
                SceneSwitcher.switchTo(
                        "Sahkib/SalesAgent/SalesAgentDashboard",
                        (Node) event.getSource()
                );
                break;

            default:
                errorLabel.setText("Dashboard not implemented yet!");
                break;
        }
    }

    @FXML
    public void createAccountOnClick(ActionEvent event) throws Exception {
        SceneSwitcher.switchTo("create_account", (Node) event.getSource());
    }
}
