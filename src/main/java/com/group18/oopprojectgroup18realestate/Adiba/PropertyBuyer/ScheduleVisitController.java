package com.group18.oopprojectgroup18realestate.Adiba.PropertyBuyer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ScheduleVisitController
{
    @javafx.fxml.FXML
    private ComboBox<String> selectTimeCB;
    @javafx.fxml.FXML
    private DatePicker selectDateDP;
    @javafx.fxml.FXML
    private Label outputLabel;
    private ArrayList<schedule> scheduleList = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("scheduleVisits.bin"))) {
            scheduleList = (ArrayList<schedule>) in.readObject();
        } catch (FileNotFoundException e) {
        } catch (Exception e) {
            outputLabel.setText("Error loading previous schedules!");
        }
        selectTimeCB.getItems().addAll("10:00 am","12:00 am", "2:00pm", "4:00pm","6:00pm");

    }

    @javafx.fxml.FXML
    public void cancelOA(ActionEvent actionEvent) {
        LocalDate date = selectDateDP.getValue();
        String time = selectTimeCB.getValue();

        if (date == null || time == null) {
            outputLabel.setText("Please select date and time to cancel!");
            return;
        }

        boolean removed = scheduleList.removeIf(s -> s.getSelectDate().equals(date) && s.getSelectTime().equals(time));

        if (removed) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("scheduleVisits.bin"))) {
                out.writeObject(scheduleList);
                outputLabel.setText("Visit cancelled successfully");
            } catch (IOException e) {
                outputLabel.setText("Error updating schedule.");
            }
        } else {
            outputLabel.setText("No matching schedule found");
        }

        selectDateDP.setValue(null);
        selectTimeCB.setValue(null);
    }

    @javafx.fxml.FXML
    public void scheduleOA(ActionEvent actionEvent) {
        LocalDate date = selectDateDP.getValue();
        String time = selectTimeCB.getValue();

        if (date == null || time == null) {
            outputLabel.setText("Please select date and time!");
            return;
        }

        schedule newSchedule = new schedule(time, date);
        scheduleList.add(newSchedule);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("scheduleVisits.bin"))) {
            out.writeObject(scheduleList);
            outputLabel.setText("Visit scheduled successfully!");
        } catch (IOException e) {
            outputLabel.setText("Error saving schedule");
        }

        selectDateDP.setValue(null);
        selectTimeCB.setValue(null);
    }

    @javafx.fxml.FXML
    public void backOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PropertyBuyerDashboard.fxml"));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }


}