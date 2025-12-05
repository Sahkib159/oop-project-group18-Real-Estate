//package com.group18.oopprojectgroup18realestate.Sonda.MarketingOfficer;
//
//import com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport.AppendableObjectOutPutStream;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.stage.Stage;
//
//import java.io.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class managePropertiesController {
//
//    @FXML private ComboBox<String> PropertyTypeField;
//    @FXML private ComboBox<String> StatusField;
//    @FXML private TableColumn<Manageproperties, String> priceColumn;
//    @FXML private TextField priceField;
//    @FXML private TextField propertyIdField;
//    @FXML private TableColumn<Manageproperties, String> propertyIdcolumn;
//    @FXML private TableColumn<Manageproperties, String> propertynameColumn;
//    @FXML private TextField propertynameField;
//    @FXML private TableColumn<Manageproperties, String> propertytypeColumn;
//    @FXML private TableColumn<Manageproperties, String> statusColumn;
//    @FXML private TableView<Manageproperties> tableview;
//
//    private final String FILE_NAME = "Manageproperties.bin";
//
//    @FXML
//    public void initialize() {
//
//        // Set column bindings
//        propertyIdcolumn.setCellValueFactory(new PropertyValueFactory<>("propertyID"));
//        propertynameColumn.setCellValueFactory(new PropertyValueFactory<>("propertyName"));
//        propertytypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
//        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
//        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
//
//        // ComboBox values
//        StatusField.getItems().addAll("Available", "Sold", "Pending", "Rented");
//        PropertyTypeField.getItems().addAll("Apartment", "Office", "Shop", "Land");
//
//        // Load previous properties
//        loadAll();
//    }
//
//
//    @FXML
//    void addPropertybutton(ActionEvent event) {
//
//        String propertyName = propertynameField.getText();
//        String propertyID   = propertyIdField.getText();
//        String price        = priceField.getText();
//        String status       = StatusField.getValue();
//        String type         = PropertyTypeField.getValue();
//
//        if (propertyName.isEmpty() || propertyID.isEmpty() || price.isEmpty() || status == null || type == null) {
//            System.out.println("❌ Please fill all fields.");
//            return;
//        }
//
//        Manageproperties p = new Manageproperties(propertyID, propertyName, price, status, type);
//
//        saveToFile(p);
//        tableview.getItems().add(p);
//
//        clearFields();
//    }
//
//
//    private void saveToFile(Manageproperties p) {
//        File f = new File(FILE_NAME);
//        try (FileOutputStream fos = new FileOutputStream(f, true);
//             ObjectOutputStream oos = f.exists() ? new AppendableObjectOutPutStream(fos)
//                     : new ObjectOutputStream(fos)) {
//
//            oos.writeObject(p);
//
//        } catch (IOException ex) {
//            Logger.getLogger(managePropertiesController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//
//    private void loadAll() {
//        tableview.getItems().clear();
//
//        File f = new File(FILE_NAME);
//        if (!f.exists()) return;
//
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
//            while (true) {
//                Manageproperties p = (Manageproperties) ois.readObject();
//                tableview.getItems().add(p);
//            }
//        } catch (EOFException eof) {
//            // End of file — normal
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//
//    private void clearFields() {
//        propertyIdField.clear();
//        propertynameField.clear();
//        priceField.clear();
//        StatusField.getSelectionModel().clearSelection();
//        PropertyTypeField.getSelectionModel().clearSelection();
//    }
//
//
//    @FXML
//    public void backbutton(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MarketingOfficerDashboard.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//    }
//
//
//    @FXML
//    void updatePropertyButton(ActionEvent event) {
//        loadAll();
//    }
//}
