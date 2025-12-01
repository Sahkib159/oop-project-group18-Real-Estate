package com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdminBackupManagerController {

    @FXML
    private TextArea outputArea;

    @FXML
    public void initialize() {
        outputArea.setText("Click 'Create Backup' to begin...\n");
    }

    @FXML
    public void createBackupOnClick(ActionEvent event) {

        // Fake backup message for now (no file copy yet)
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        outputArea.appendText("Backup created successfully at: " + timestamp + "\n");

        showAlert("Backup Completed", "Backup created at:\n" + timestamp);
    }

    @FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SystemAdministratorDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
