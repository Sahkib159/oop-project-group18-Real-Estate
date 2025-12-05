package com.group18.oopprojectgroup18realestate.Ramisa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class bookmarkPropertyController
{
    @javafx.fxml.FXML
    private TableColumn<BookMark, String>  locationCol;
    @javafx.fxml.FXML
    private Label messageL;
    @javafx.fxml.FXML
    private TableColumn<BookMark, Integer>  idCol;
    @javafx.fxml.FXML
    private TableColumn<BookMark, LocalDate>  dateCol;
    @javafx.fxml.FXML
    private Label priceL;
    @javafx.fxml.FXML
    private Label typeL;
    @javafx.fxml.FXML
    private Label savedonL;
    @javafx.fxml.FXML
    private TableView<BookMark>  tableViewBookMark;
    @javafx.fxml.FXML
    private TableColumn<BookMark, Integer>  priceCol;
    @javafx.fxml.FXML
    private Label detailslocationL;


    private ArrayList<BookMark> bookmarkList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("propertyID"));
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("rentPrice"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("savedDate"));
    }

    @javafx.fxml.FXML
    public void showbuttonOC(ActionEvent actionEvent) {
        BookMark selected = tableViewBookMark.getSelectionModel().getSelectedItem();
        if (selected != null) {
            detailslocationL.setText(selected.getLocation());
            priceL.setText(String.valueOf(selected.getRentPrice()));
            typeL.setText(selected.getPropertyType());
            savedonL.setText("Saved");
        }

    }

    @javafx.fxml.FXML
    public void refeshOnClickButton(ActionEvent actionEvent) {
        loadbuttonOC(actionEvent);
    }

    @javafx.fxml.FXML
    public void loadbuttonOC(ActionEvent actionEvent) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("bookmarks.bin"))) {
        bookmarkList = (ArrayList<BookMark>) in.readObject();

        tableViewBookMark.getItems().clear();
        for (BookMark b : bookmarkList) {
            tableViewBookMark.getItems().add(b);
        }
        messageL.setText("Loaded " + bookmarkList.size() + " bookmarks!");
    } catch (FileNotFoundException e) {
        messageL.setText("No bookmarks saved");
    } catch (Exception e) {
        messageL.setText("Error");
    }

    }

    @javafx.fxml.FXML
    public void removeBookmarkOnClick(ActionEvent actionEvent) {
        BookMark selected = tableViewBookMark.getSelectionModel().getSelectedItem();

        if (selected == null) {
            messageL.setText("Please select a bookmark to remove!");
            return;
        }

        bookmarkList.remove(selected);
        tableViewBookMark.getItems().remove(selected);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("bookmarks.bin"))) {
            out.writeObject(bookmarkList);
            messageL.setText("Bookmark removed ");
        } catch (IOException e) {
            messageL.setText(" failed!");
        }
    }



    @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tenantDashBoard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }
