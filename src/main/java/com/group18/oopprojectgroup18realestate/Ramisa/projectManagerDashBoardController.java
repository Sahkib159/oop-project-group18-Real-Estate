//<<<<<<< HEAD
//package com.group18.oopprojectgroup18realestate.Ramisa;
//
//import javafx.event.ActionEvent;
//
//public class projectManagerDashBoardController
//{
//    @javafx.fxml.FXML
//    public void initialize() {
//    }
//
//    @javafx.fxml.FXML
//    public void tenantmanagementOnClick(ActionEvent actionEvent) {
//    }
//
//    @javafx.fxml.FXML
//    public void propertyMangement(ActionEvent actionEvent) {
//    }
//
//    @javafx.fxml.FXML
//    public void maintainanceButton(ActionEvent actionEvent) {
//    }
//
//    @javafx.fxml.FXML
//    public void reportButton(ActionEvent actionEvent) {
//    }
//
//    @javafx.fxml.FXML
//    public void logoutOCButton(ActionEvent actionEvent) {
//    }
//
//    @javafx.fxml.FXML
//    public void aboutrentbutton(ActionEvent actionEvent) {
//    }
//}
//=======
package com.group18.oopprojectgroup18realestate.Ramisa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class projectManagerDashBoardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void tenantmanagementOnClick(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tenantManagement.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage =(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void maintainanceButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("handleMaintenanceReq.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage =(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void aboutrentbutton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("rentTracking.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage =(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void propertyMangementOnClickButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("propertyManagement.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage =(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @javafx.fxml.FXML
    public void logoutButtonOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/group18/oopprojectgroup18realestate/Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage =(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
}
//>>>>>>> origin/main
