package com.group18.oopprojectgroup18realestate.Adiba.PropertyBuyer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SubmitFeedbackController
{
    @javafx.fxml.FXML
    private ComboBox<String> ratingCB;
    @javafx.fxml.FXML
    private TextArea yourCommentTF;
    @javafx.fxml.FXML
    private Label outputLabel;
    public ArrayList<feedback> feedbackList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        ratingCB.getItems().addAll("1", "2", "3", "4", "5");
    }

    @javafx.fxml.FXML
    public void submitFeedbackOA(ActionEvent actionEvent) {
        String rating = ratingCB.getValue();
        String comment = yourCommentTF.getText();

        if (rating==null || rating.isEmpty()){
            outputLabel.setText("please select a rating");
            return;
        }
        if (comment==null || comment.isEmpty()){
            outputLabel.setText("please write feedback");
            return;
        }
        feedback fb = new feedback(rating,comment);
        feedbackList.add(fb);

        try(ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("feedback.bin")
        )){
            out.writeObject(feedbackList);
            outputLabel.setText("feedback submitted successfully");
        }catch(IOException ex){
            outputLabel.setText("saving failed");
        }
    }

    @javafx.fxml.FXML
    public void backOA(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PropertyBuyerDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }
}