package com.group18.oopprojectgroup18realestate.Ramisa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class bookmarkPropertyController
{
    @javafx.fxml.FXML
    private TableColumn<BookMark,String> locationCol;
    @javafx.fxml.FXML
    private TableColumn<BookMark,Integer> idCol;
    @javafx.fxml.FXML
    private TableColumn<BookMark, LocalDate> dateCol;
    @javafx.fxml.FXML
    private Label priceL;
    @javafx.fxml.FXML
    private Label typeL;
    @javafx.fxml.FXML
    private Button backButtonOnClick;
    @javafx.fxml.FXML
    private Label savedonL;
    @javafx.fxml.FXML
    private TableView<BookMark> tableViewBookMark;
    @javafx.fxml.FXML
    private TableColumn<BookMark,Integer> priceCol;
    @javafx.fxml.FXML
    private Label detailslocationL;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void refeshOnClickButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void removeBookmarkOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tenantDashBoard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage =(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}