package com.group18.oopprojectgroup18realestate.Ramisa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;


public class propertySearchController
{
    @javafx.fxml.FXML
    private TableColumn<propertymanagement,String> typeCol;
    @javafx.fxml.FXML
    private Label messageL;
    @javafx.fxml.FXML
    private TextField locationTF;
    @javafx.fxml.FXML
    private TableColumn<propertymanagement,String> propertyIDCol;
    @javafx.fxml.FXML
    private TableColumn<propertymanagement,String> statusCol;
    @javafx.fxml.FXML
    private ComboBox<String> typeCB;
    @javafx.fxml.FXML
    private Label propertydetailsL;
    @javafx.fxml.FXML
    private TableView<propertymanagement> searchPropertyTableview;
    @javafx.fxml.FXML
    private TextField budgetTF;
    @javafx.fxml.FXML
    private TableColumn<propertymanagement,String> LocationCol;
    @javafx.fxml.FXML
    private TableColumn<propertymanagement,String> priceCol;


    private ArrayList<propertymanagement> allProperties = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {
        typeCB.getItems().addAll("All", "Apartment", "House", "Flat", "Commercial");
        typeCB.setValue("All");

        propertyIDCol.setCellValueFactory(new PropertyValueFactory<>("propertyID"));
        LocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("propertyType"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("rentPrice"));

        loadButtonOC(null);

    }

    @javafx.fxml.FXML
    public void bookPropertyOnClickButton(ActionEvent actionEvent) {
        propertymanagement selected = searchPropertyTableview.getSelectionModel().getSelectedItem();

        if (selected == null) {
            messageL.setText("Please select a property first!");
            return;
        }

        ArrayList<BookMark> bookmarks = new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("bookmarks.bin"))) {
            bookmarks = (ArrayList<BookMark>) in.readObject();
        } catch (FileNotFoundException e) {
            // First time - no file yet
            bookmarks = new ArrayList<>();
        } catch (Exception e) {
            messageL.setText("Error");
            bookmarks = new ArrayList<>();
        }

        // Check if already bookmarked
        for (BookMark b : bookmarks) {
            if (b.getPropertyID() == selected.getPropertyID()) {
                messageL.setText("This property is already bookmarked!");
                return;
            }
        }

        // Create new BookMark object
        int newBookmarkID = bookmarks.size() + 1;
        BookMark newBookmark = new BookMark(
                1,
                newBookmarkID,
                selected.getPropertyID(),
                java.time.LocalDate.now(),
                selected.getLocation(),
                selected.getRentPrice(),
                selected.getPropertyType()
        );

        bookmarks.add(newBookmark);


        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("bookmarks.bin"))) {
            out.writeObject(bookmarks);
            messageL.setText(" bookmarked successfully!");
        } catch (IOException e) {
            messageL.setText("Failed ");
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void searchPropertyOnClick(ActionEvent actionEvent) {
        String location = locationTF.getText().strip();
        String type = typeCB.getValue();
        String budgetText = budgetTF.getText().strip();

        searchPropertyTableview.getItems().clear();
        searchPropertyTableview.getItems().addAll(allProperties);

        if (location.isEmpty() || budgetText.isEmpty() || type == null) {
            messageL.setText("fill all information.");
            return;


        }

        // validation (budget)
        double budget;
        try {
            budget = Double.parseDouble(budgetText);
            if (budget <= 0) {
                messageL.setText("budget should positive!");
                return;
            }
        } catch (NumberFormatException e) {
            messageL.setText("budget amount invalid!");
            return;
        }

        int count = 0;
        for (propertymanagement property : allProperties) {
            boolean matchLocation = location.isEmpty() ||
                property.getLocation().equalsIgnoreCase(location);


            boolean matchType = type != null || !type.equals("All");
                property.getPropertyType().equalsIgnoreCase(type);

            boolean matchBudget = budgetText.isEmpty() ||
                property.getRentPrice() <= budget;

            boolean isAvailable = property.getStatus().equalsIgnoreCase("Available");

            if (matchLocation && matchType && matchBudget && isAvailable) {
                searchPropertyTableview.getItems().add(property);

                count++;
            }
        }messageL.setText("Found: " + count);

        if (count == 0) {
            messageL.setText("No properties found!");
        } else {messageL.setText(" Found property");
        }

    }


    @javafx.fxml.FXML
    public void loadButtonOC(ActionEvent actionEvent) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("properties.bin"))) {
            allProperties = (ArrayList<propertymanagement>) in.readObject();

            // Available properties ONLY
            ArrayList<propertymanagement> availableProperties = new ArrayList<>();
            for (propertymanagement p : allProperties) {
                if (p.getStatus().equals("Available")) {
                    availableProperties.add(p);
                }
            }
            searchPropertyTableview.getItems().clear();
            for (propertymanagement p : availableProperties) {
                searchPropertyTableview.getItems().add(p);
            }

            messageL.setText("Loaded available property!");

        } catch (FileNotFoundException e) {
            messageL.setText("No saved file found!");

        } catch (Exception e) {
            messageL.setText("Error loading properties!");
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