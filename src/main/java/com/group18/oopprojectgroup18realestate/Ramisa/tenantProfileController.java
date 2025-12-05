<<<<<<< HEAD
//package com.group18.oopprojectgroup18realestate.Ramisa;
//
//public class tenantProfileController
//{
//    @javafx.fxml.FXML
//    private Label messageShowLabel;
//    @javafx.fxml.FXML
//    private TextField nameTF;
//    @javafx.fxml.FXML
//    private TextField emailTF;
//    @javafx.fxml.FXML
//    private TextField PhoneTF;
//    @javafx.fxml.FXML
//    private TextField LocationTF;
//
//    @javafx.fxml.FXML
//    public void initialize() {
//    }
//
//    @javafx.fxml.FXML
//    public void saveOnClickButton(ActionEvent actionEvent) {
//    }
//
//    @javafx.fxml.FXML
//    public void backButtonOnClick(ActionEvent actionEvent) {
//    }
//}
=======
package com.group18.oopprojectgroup18realestate.Ramisa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class tenantProfileController
{
    @javafx.fxml.FXML
    private Label messageShowLabel;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private TextField PhoneTF;
    @javafx.fxml.FXML
    private TextField LocationTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void saveOnClickButton(ActionEvent actionEvent) {
        String name = nameTF.getText().strip();
        String email = emailTF.getText().strip();
        String phone = PhoneTF.getText().strip();
        String location = LocationTF.getText().strip();

        //  check field
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || location.isEmpty()) {
            messageShowLabel.setText("Please fill all fields!");
            return;
        }


    }

    @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tenantDashBoard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage =(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
>>>>>>> origin/main
