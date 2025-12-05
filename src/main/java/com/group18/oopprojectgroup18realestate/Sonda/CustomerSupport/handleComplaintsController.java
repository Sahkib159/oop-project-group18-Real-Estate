//package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;
//
//import com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport.Handlecomplaints;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//import java.io.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class handleComplaintsController {
//
//    @FXML
//    private TextField complaintidtextField;
//
//    @FXML
//    private ComboBox<String> complaintstatuscombobox;
//
//    @FXML
//    private ComboBox<String> complainttypecombobox;
//
//    @FXML
//    private TextField contractnumbertextfield;
//
//    @FXML
//    private TableColumn<Handlecomplaints, String> customernamecolumn;
//
//    @FXML
//    private TextField customernametextfield;
//
//    @FXML
//    private TableColumn<Handlecomplaints, String> datesubmittedcolumn;
//
//    @FXML
//    private TableColumn<Handlecomplaints, String> idcolumn;
//
//    @FXML
//    private TableColumn<Handlecomplaints, String> statuscolumn;
//
//    @FXML
//    private TableColumn<Handlecomplaints, String> typecolumn;
//    @FXML
//    private TableView<Handlecomplaints> tableview;
//
//    @javafx.fxml.FXML
//    public void initialize() {
//        complaintstatuscombobox.getItems().addAll("Service", "Property", "Billing");
//        complainttypecombobox.getItems().addAll("Service", "Property", "Billing");
//        customernamecolumn.setCellValueFactory(new PropertyValueFactory<>("customer"));
//        datesubmittedcolumn.setCellValueFactory(new PropertyValueFactory<>("date") );
//        idcolumn.setCellValueFactory(new PropertyValueFactory<>("complntId"));
//        statuscolumn.setCellValueFactory(new PropertyValueFactory<>("status"));
//        typecolumn.setCellValueFactory(new PropertyValueFactory<>("complaintType"));
//
//    }
//
//    @FXML
//    void clearformbutton(ActionEvent event) {
//
//    }
//
//    @FXML
//    void submitcomplaintbutton(ActionEvent event) {
//        tableview.getItems().addAll();
//        String customer=customernametextfield.getText();
//        int complntId=Integer.parseInt(complaintidtextField.getText());
//        String complaintType=contractnumbertextfield.getText();
//
//        String email=null;
//        String pass=null;
//        File f= null;
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        try{
//            f=new File("HandleComplaints.bin");
//            if(f.exists()){
//                fos=new FileOutputStream(f,true);
//                oos=new AppendableObjectOutPutStream(fos);
//            }
//            else{
//                fos=new FileOutputStream(f);
//                oos=new ObjectOutputStream(fos);
//            }
//            Handlecomplaints y=new Handlecomplaints(email,pass,customer,complntId,complaintType);
//            tableview.getItems().add(y);
//
//            oos.writeObject(y);
//
//        }catch(IOException ex){
//            Logger.getLogger(handleComplaintsController.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            try {
//                if(oos!=null){
//                    oos.close();
//                }
//            }catch(IOException ex){
//                Logger.getLogger(handleComplaintsController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//
//    }
//
//    @FXML
//    void updatecomplaintbutton(ActionEvent event) {
//        tableview.getItems().clear();
//        loadAll();
//
//    }
//    public void loadAll() {
//        ObjectInputStream ois = null;
//        try {
//            Handlecomplaints y;
//            ois = new ObjectInputStream(new FileInputStream("Handlecomplaints.bin"));
//            while (true) {
//                y = (Handlecomplaints) ois.readObject();
//                tableview.getItems().add(y);
//            }
//        } catch (Exception ex) {
//            try {
//                if (ois != null) {
//                    ois.close();
//                }
//            } catch (IOException ex2) {
//                ex2.printStackTrace();
//            }
//            ex.printStackTrace();
//        }
//    }
//
//}
//
