//package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//import java.io.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class assignTicketsController {
//
//    @FXML
//    private TableView<AssignTickets> tableview;
//
//    @FXML
//    private TableColumn<AssignTickets, Integer> ticketidcolumn;
//
//    @FXML
//    private TableColumn<AssignTickets, String> issuetypecolumn;
//
//    @FXML
//    private TableColumn<AssignTickets, String> customercolumn;
//
//    @FXML
//    private TableColumn<AssignTickets, String> prioritycolumn;
//
//    @FXML
//    private TableColumn<AssignTickets, String> assignedtocolumn;
//
//    @FXML
//    private TableColumn<AssignTickets, String> statuscolumn;
//
//    @FXML
//    private ComboBox<String> selectdepartmentcombobox;
//
//    @FXML
//    private ComboBox<String> assigntocombobox;
//
//    @FXML
//    private ComboBox<String> prioritycombobox;
//
//    @FXML
//    private TextField tickedidfield;
//
//    @FXML
//    private TextField ticketsummaryField;
//
//    @FXML
//    private TextField currentstatusField;
//
//
//    @FXML
//    public void initialize() {
//
//        // ComboBoxes
//        selectdepartmentcombobox.getItems().addAll("Sales", "Maintenance", "Finance", "Support");
//        assigntocombobox.getItems().addAll("Team A", "Team B", "Staff 1", "Staff 2");
//        prioritycombobox.getItems().addAll("Low", "Medium", "High");
//
//        // Table Columns
//        ticketidcolumn.setCellValueFactory(new PropertyValueFactory<>("ticId"));
//        issuetypecolumn.setCellValueFactory(new PropertyValueFactory<>("issueType"));
//        customercolumn.setCellValueFactory(new PropertyValueFactory<>("customer"));
//        prioritycolumn.setCellValueFactory(new PropertyValueFactory<>("priority"));
//        assignedtocolumn.setCellValueFactory(new PropertyValueFactory<>("assignTo"));
//        statuscolumn.setCellValueFactory(new PropertyValueFactory<>("status"));
//
//        // Load existing tickets
//        loadAll();
//    }
//
//
//    @FXML
//    void assignticketbutton(ActionEvent event) {
//
//        String issueType = ticketsummaryField.getText();
//        String status = currentstatusField.getText();
//        String priority = prioritycombobox.getValue();
//        String assignTo = assigntocombobox.getValue();
//        String customer = selectdepartmentcombobox.getValue();
//
//        if (issueType.isEmpty() || status.isEmpty() || priority == null
//                || assignTo == null || customer == null || tickedidfield.getText().isEmpty()) {
//
//            showAlert("Error", "Please fill all fields correctly!");
//            return;
//        }
//
//        int ticketId = Integer.parseInt(tickedidfield.getText());
//
//        AssignTickets ticket = new AssignTickets(ticketId, issueType, customer, priority, assignTo, status);
//
//        tableview.getItems().add(ticket);
//        saveTicket(ticket);
//
//        showAlert("Success", "Ticket Assigned Successfully!");
//    }
//
//
//    private void saveTicket(AssignTickets ticket) {
//        try {
//            File f = new File("AssignTickets.bin");
//            ObjectOutputStream oos;
//
//            if (f.exists()) {
//                oos = new AppendableObjectOutputStream(new FileOutputStream(f, true));
//            } else {
//                oos = new ObjectOutputStream(new FileOutputStream(f));
//            }
//
//            oos.writeObject(ticket);
//            oos.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    @FXML
//    void updateassignmentbutton(ActionEvent event) {
//        tableview.getItems().clear();
//        loadAll();
//    }
//
//
//    public void loadAll() {
//        File f = new File("AssignTickets.bin");
//        if (!f.exists()) return;
//
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
//
//            while (true) {
//                AssignTickets x = (AssignTickets) ois.readObject();
//                tableview.getItems().add(x);
//            }
//
//        } catch (EOFException ignored) {
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//
//    @FXML
//    void cleatformbutton(ActionEvent event) {
//        tickedidfield.clear();
//        ticketsummaryField.clear();
//        currentstatusField.clear();
//        prioritycombobox.getSelectionModel().clearSelection();
//        assigntocombobox.getSelectionModel().clearSelection();
//        selectdepartmentcombobox.getSelectionModel().clearSelection();
//    }
//
//
//    private void showAlert(String title, String msg) {
//        Alert a = new Alert(Alert.AlertType.INFORMATION);
//        a.setHeaderText(null);
//        a.setTitle(title);
//        a.setContentText(msg);
//        a.showAndWait();
//    }
//}
