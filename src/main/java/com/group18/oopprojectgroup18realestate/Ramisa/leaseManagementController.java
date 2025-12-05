<<<<<<< HEAD
//package com.group18.oopprojectgroup18realestate.Ramisa;
//
//public class leaseManagementController
//{
//    @javafx.fxml.FXML
//    private Button backOCButton;
//    @javafx.fxml.FXML
//    private Label messageaboutTerminate;
//    @javafx.fxml.FXML
//    private Label typeL;
//    @javafx.fxml.FXML
//    private Label leaseIDL;
//    @javafx.fxml.FXML
//    private Label propertyL;
//    @javafx.fxml.FXML
//    private Label rentamountL;
//    @javafx.fxml.FXML
//    private Label leasedatelabel;
//
//    @javafx.fxml.FXML
//    public void initialize() {
//    }}
=======
package com.group18.oopprojectgroup18realestate.Ramisa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class leaseManagementController
{
    @javafx.fxml.FXML
    private Label messageaboutTerminate;
    @javafx.fxml.FXML
    private Label typeL;
    @javafx.fxml.FXML
    private Label leaseIDL;
    @javafx.fxml.FXML
    private Label propertyL;
    @javafx.fxml.FXML
    private Label rentamountL;
    @javafx.fxml.FXML
    private Label leasedatelabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backbuttonOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tenantDashBoard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage =(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
>>>>>>> origin/main
