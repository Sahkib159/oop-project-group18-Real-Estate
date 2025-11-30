package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.CornerRadii;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class coordinateissueResolutionController {

    @FXML
    private TableColumn<CoordinateIssue, String> customernamecolumn;

    @FXML
    private TextField customernametextfield;

    @FXML
    private TableColumn<CoordinateIssue, String> departmentcolumn;

    @FXML
    private TextField issuedescriptiontextfield;

    @FXML
    private TextField issueidTextfield;

    @FXML
    private TableColumn<CoordinateIssue, Integer> issueidcolumn;

    @FXML
    private TableColumn<CoordinateIssue, String> issuetypecolumn;

    @FXML
    private ComboBox<String> issuetypecombobox;

    @FXML
    private TableColumn<CoordinateIssue, String> prioritycolumn;

    @FXML
    private ComboBox<String> routingprioritycombobox;

    @FXML
    private ComboBox<String> selectdepartmetcombobox;
    @FXML
    private TableView<CoordinateIssue> tableview;

    @javafx.fxml.FXML
    public void initialize() {
        selectdepartmetcombobox.getItems().addAll("Customer Support","Marketing Officer","finance  officer","System Administrator");
        issuetypecombobox.getItems().addAll("Billing", "Maintenance","Sales","Other");
        routingprioritycombobox.getItems().addAll("Left","right");
        issueidcolumn.setCellValueFactory(new PropertyValueFactory<>("cusId"));
        issuetypecolumn.setCellValueFactory(new PropertyValueFactory<>("issuType"));
        prioritycolumn.setCellValueFactory(new PropertyValueFactory<>("routingPri"));
        departmentcolumn.setCellValueFactory(new PropertyValueFactory<>("delDep"));
        customernamecolumn.setCellValueFactory(new PropertyValueFactory<>("cusName"));
    }

    @FXML
    void clearformbutton(ActionEvent event) {

    }

    @FXML
    void forwardissuebutton(ActionEvent event) {
        tableview.getItems().clear();
        String cusNAme=customernametextfield.getText();
        int cusId=Integer.parseInt(issueidTextfield.getText());
        String des=issuedescriptiontextfield.getText();
        String dep=selectdepartmetcombobox.getValue();
        String rou=routingprioritycombobox.getValue();
        String issuType=issuetypecombobox.getValue();
        String email=null;
        String pass=null;
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("CoordinateIssues.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            CoordinateIssue y=new CoordinateIssue(email,pass,cusId,cusNAme,des,issuType,rou,dep);
            tableview.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(coordinateissueResolutionController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(coordinateissueResolutionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    void updateroutinebutton(ActionEvent event) {
        tableview.getItems().clear();
        loadAll();

    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            CoordinateIssue y;
            ois = new ObjectInputStream(new FileInputStream("CoordinateIssues.bin"));
            while (true) {
                y = (CoordinateIssue) ois.readObject();
                tableview.getItems().add(y);
            }
        } catch (Exception ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex2) {
                ex2.printStackTrace();
            }
            ex.printStackTrace();
        }
    }

}
