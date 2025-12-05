package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;

import com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport.AssignTickets;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class assignTicketsController{

    @FXML
    private TableColumn<AssignTickets, String> assignedtocolumn;

    @FXML
    private ComboBox<String> assigntocombobox;

    @FXML
    private TextField currentstatusField;

    @FXML
    private TableColumn<AssignTickets, String> customercolumn;

    @FXML
    private TableColumn<AssignTickets, String> issuetypecolumn;

    @FXML
    private TableColumn<AssignTickets, String> prioritycolumn;

    @FXML
    private ComboBox<String> prioritycombobox;

    @FXML
    private ComboBox<String> selectdepartmentcombobox;

    @FXML
    private TableColumn<AssignTickets, String> statuscolumn;

    @FXML
    private TextField tickedidfield;

    @FXML
    private TableColumn<AssignTickets, String> ticketidcolumn;

    @FXML
    private TextField ticketsummaryField;
    @FXML
    private TableView<AssignTickets> tableview;

    @javafx.fxml.FXML
    public void initialize() {
        selectdepartmentcombobox.getItems().addAll("Sales",  "Maintenance",  "Finance", "Support");
        assigntocombobox.getItems().addAll("Staff Name", "Team");
        prioritycombobox.getItems().addAll("Low , Medium , High");

        ticketidcolumn.setCellValueFactory(new PropertyValueFactory<>("ticId"));
        issuetypecolumn.setCellValueFactory(new PropertyValueFactory<>("issueType"));
        customercolumn.setCellValueFactory(new PropertyValueFactory<>("customer"));
        prioritycolumn.setCellValueFactory(new PropertyValueFactory<>("priority"));
        assignedtocolumn.setCellValueFactory(new PropertyValueFactory<>("assignTo"));
        statuscolumn.setCellValueFactory(new PropertyValueFactory<>("status"));

    }


    @FXML
    void assignticketbutton(ActionEvent event) {
        tableview.getItems().clear();
        String currentStatus=currentstatusField.getText();
        int ticId=Integer.parseInt(tickedidfield.getText());
        String ticSummary=ticketsummaryField.getText();

        String email= null;
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("AssignTickets.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            AssignTickets y=new AssignTickets(email,ticId,ticSummary,currentStatus);
            tableview.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(AssignTickets.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(AssignTickets.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


}

    @FXML
    void cleatformbutton(ActionEvent event) {

    }

    @FXML
    void updateassignmentbutton(ActionEvent event) {
        tableview.getItems().clear();
        loadAll();

    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            AssignTickets y;
            ois = new ObjectInputStream(new FileInputStream("AssignTickets.bin"));
            while (true) {
                y = (AssignTickets) ois.readObject();
                tableview.getItems().add(y);
            }
        } catch (Exception ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex2) {
                ex2.printStackTrace();
            }
            ex.printStackTrace();
        }
    }

}
