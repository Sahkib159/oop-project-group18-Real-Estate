package com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdminBackupManagerController {

    @FXML
    private TextArea outputArea;

    private static final String[] FILES_TO_BACKUP = {
            "users.bin",
            "properties.bin",
            "payments.bin",
            "logs.bin"
    };

    @FXML
    public void initialize() {
        outputArea.setText("Click 'Create Backup' to begin...\n");
    }

    @FXML
    public void createBackupOnClick(ActionEvent event) {

        // Create timestamped folder
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

        String backupFolderPath = "backups/backup_" + timestamp;
        File backupFolder = new File(backupFolderPath);
        backupFolder.mkdirs();

        outputArea.appendText("Backup started at: " + timestamp + "\n");

        int filesCopied = 0;

        // Copy each file individually
        for (String fileName : FILES_TO_BACKUP) {

            File originalFile = new File(fileName);

            if (originalFile.exists()) {
                try {
                    Path source = originalFile.toPath();
                    Path dest = Paths.get(backupFolderPath + "/" + fileName);

                    Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);

                    outputArea.appendText("✔ Backed up: " + fileName + "\n");
                    filesCopied++;

                } catch (Exception e) {
                    outputArea.appendText("✘ Failed to copy: " + fileName + "\n");
                }
            } else {
                outputArea.appendText("Skipped (not found): " + fileName + "\n");
            }
        }

        outputArea.appendText("\nBackup completed. Files copied: " + filesCopied + "\n\n");

        showAlert("Backup Completed", "Backup created successfully!\nFolder:\n" + backupFolderPath);
//I added it later
        LogService.addLog("Backup created.");

    }

    @FXML
    public void backOnClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SystemAdministratorDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
