package com.group18.oopprojectgroup18realestate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class LogInController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    private ComboBox<String> roleComboBox;

    @FXML
    public void initialize() {
        roleComboBox.getItems().addAll(
                "System Administrator",
                "Finance Officer",
                "Marketing Officer",
                "Customer Support Executive",
                "Property Tenant",
                "Property Manager",
                "Property buyer",
                "Sales Agent"
        );
    }

    @FXML
    public void logInOnClick(ActionEvent event) throws Exception {

        String username = usernameField.getText();
        String password = passwordField.getText();
        String role = roleComboBox.getValue();

        // Validation
        if (username.isEmpty() || password.isEmpty() || role == null) {
            errorLabel.setText("Please fill all fields!");
            return;
        }

        //Loads users from users.bin
        List<User1> users = UserService.loadUsers();

        // Check login from users.bin
        for (User1 u : users) {
            if (u.getUsername().equals(username)
                    && u.getPassword().equals(password)
                    && u.getRole().equals(role)) {

                // if runs Switch to dashboard
                SceneSwitcher.switchTo(
                        getDashboardPath(role),
                        (Node) event.getSource()
                );
                return;
            }
        }

        // If no match found
        errorLabel.setText("Invalid username, password, or role!");
    }


    // Switch path by role

    private String getDashboardPath(String role) {

        return switch (role) {

            case "System Administrator" ->
                    "Sahkib/SystemAdministrator/SystemAdministratorDashboard";

            case "Finance Officer" ->
                    "Sahkib/FinanceOfficer/FinanceOfficerDashboard";

            case "Marketing Officer" ->
                    "Sonda/MarketingOfficer/MarketingOfficerDashboard";

            case "Customer Support Executive" ->
                    "Sonda/CustomerSupport/CustomerSupportDashboard";

            case "Property Renter" ->
                    "Ramisa/tenantDashBoardController";

            case "Property Manager" ->
                    "Ramisa/ProjectManagerDashboard";

            case "Property buyer" ->
                    "Adiba/PropertyBuyer/PropertyBuyerDashboard";

            case "Sales Agent" ->
                    "Adiba/SalesAgent/SalesAgentDashboard";

            default -> "";
        };
    }

    @FXML
    public void createAccountOnClick(ActionEvent event) throws Exception {
        SceneSwitcher.switchTo("create_account", (Node) event.getSource());
    }
}
