//package com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.TextArea;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//public class FinanceMonthlySummaryController
//{
//    @javafx.fxml.FXML
//    private TextArea summaryOutputTextArea;
//    @javafx.fxml.FXML
//    private ComboBox<String > yearComboBox;
//    @javafx.fxml.FXML
//    private ComboBox<String> monthComboBox;
//
//
//    // Temporary payment data
//    private final ObservableList<Payment> paymentList = FXCollections.observableArrayList();
//
//
//    @javafx.fxml.FXML
//    public void initialize() {
//
//        // Months
//        monthComboBox.getItems().addAll(
//                "01","02","03","04","05","06",
//                "07","08","09","10","11","12"
//        );
//
//        // Years
//        yearComboBox.getItems().addAll("2024", "2025", "2026");
//
//        // Sample data
//        paymentList.add(new Payment("C101", 50000, "2025-01-10"));
//        paymentList.add(new Payment("C102", 75000, "2025-01-12"));
//        paymentList.add(new Payment("C103", 30000, "2025-02-05"));
//        paymentList.add(new Payment("C104", 60000, "2025-02-15"));
//        paymentList.add(new Payment("C105", 45000, "2025-03-01"));
//    }
//
//
//
//    @javafx.fxml.FXML
//    public void loadSummaryOnClick(ActionEvent actionEvent) {
//        String month = monthComboBox.getValue();
//        String year = yearComboBox.getValue();
//
//        if (month == null || year == null) {
//            showAlert("Error", "Please select both month and year.");
//            return;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        double totalAmount = 0;
//        int count = 0;
//
//        sb.append("=== Monthly Summary for ").append(month).append("/").append(year).append(" ===\n\n");
//
//        for (Payment p : paymentList) {
//            LocalDate date = LocalDate.parse(p.getDate());
//
//            if (date.getMonthValue() == Integer.parseInt(month)
//                    && date.getYear() == Integer.parseInt(year)) {
//
//                sb.append("Client: ").append(p.getClientId())
//                        .append(" | Amount: ").append(p.getAmount())
//                        .append(" | Date: ").append(p.getDate())
//                        .append("\n");
//
//                totalAmount += p.getAmount();
//                count++;
//            }
//        }
//
//        if (count == 0) {
//            summaryOutputTextArea.setText("No payments found for this month.");
//        } else {
//            sb.append("\n----------------------------------\n");
//            sb.append("Total Payments: ").append(count).append("\n");
//            sb.append("Total Revenue: ").append(totalAmount).append(" BDT\n");
//            sb.append("----------------------------------");
//            summaryOutputTextArea.setText(sb.toString());
//        }
//    }
//
//
//
//
//
//    @javafx.fxml.FXML
//    public void backOnClick(ActionEvent actionEvent) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FinanceOfficerDashboard.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    private void showAlert(String title, String msg) {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setHeaderText(null);
//        alert.setTitle(title);
//        alert.setContentText(msg);
//        alert.showAndWait();
//    }
//}