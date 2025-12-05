package com.group18.oopprojectgroup18realestate.Sonda.MarketingOfficer;

import com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport.AppendableObjectOutPutStream;
import com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport.CoordinateIssue;
import com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport.coordinateissueResolutionController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class managePropertiesController {

    @FXML
    private ComboBox<String> PropertyTypeField;

    @FXML
    private ComboBox<String> StatusField;

    @FXML
    private TableColumn<Manageproperties, String> priceColumn;

    @FXML
    private TextField priceField;

    @FXML
    private TextField propertyIdField;

    @FXML
    private TableColumn<Manageproperties, String> propertyIdcolumn;

    @FXML
    private TableColumn<Manageproperties, String> propertynameColumn;

    @FXML
    private TextField propertynameField;

    @FXML
    private TableColumn<Manageproperties, String> propertytypeColumn;

    @FXML
    private TableColumn<Manageproperties, String> statusColumn;
    @FXML
    private TableView<Manageproperties> tableview;

    @javafx.fxml.FXML
    public void initialize() {
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        propertytypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        propertynameColumn.setCellValueFactory(new PropertyValueFactory<>("propertyName"));
        propertyIdcolumn.setCellValueFactory(new PropertyValueFactory<>("propertyID"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    }


    @FXML
    void addPropertybutton(ActionEvent event) {
        tableview.getItems().clear();
        String propertyName=propertynameField.getText();
        String propertyID=propertyIdField.getText();
        String price=priceField.getText();
        String status=StatusField.getValue();
        String type=PropertyTypeField.getValue();
        String email=null;
        String pass=null;
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("Manageproperties.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            Manageproperties y=new Manageproperties(email,pass,propertyID,propertyName,price,status,type);
            tableview.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(managePropertiesController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(managePropertiesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }

    @FXML
    public void backbutton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MarketingOfficerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void updatePropertyButton(ActionEvent event) {


    }

}
