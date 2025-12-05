package com.group18.oopprojectgroup18realestate;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneSwitcher {

    public static void switchTo(String fxmlName, Node sourceNode) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                SceneSwitcher.class.getResource("/com/group18/oopprojectgroup18realestate/" + fxmlName + ".fxml")
        );

        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) sourceNode.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
