package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;

public class EventsScreenController {

    public TableColumn<Venue, String> venuesName = new TableColumn<>("Venue Name");

    public TextField peopleInvitedtxt;
    public TextField hourAvailabilitytxt;
    public TextField ticketPricetxt;
    public TextField eventTypetxt;
    public Button saveEventBtn;
    public DatePicker calendartxt;

    @FXML
    private void switchToMainScreen() throws IOException {
        App.setRoot("MainScreen");
    }

    public void initialize() {
    }

    private void loadEvents() {
        //load venues from saved file
        //open and read JSon file for any previously saved data
        Gson gson = new Gson();
        try(Reader reader = new FileReader("venues.json")){
            //convert JSON file to Java Object
            ArrayList<Event> imports = gson.fromJson(reader, new TypeToken<ArrayList<Venue>>() {
            }.getType());
            App.events = FXCollections.observableArrayList(imports);
        } catch (IOException e){
            e.printStackTrace();
            //convert JSon file to Java object
        }
    }

    public void findVenueBtnAction(ActionEvent actionEvent) throws IOException {
        int notFilledIn=0;
        String errorMessage = ""; //error pop-up message will display on screen
        if (calendartxt.getValue() == null) {
            errorMessage = "You need to insert a date, This is a required field";
            notFilledIn++; //if date not inserted, error message displayed regarding missing date
        }else if (peopleInvitedtxt.getText().isEmpty()){
            errorMessage = "People Invited needs to be inputted, This is a required field";
            notFilledIn++; //if people invited box not filled, error message displayed
        }else if (ticketPricetxt.getText().isEmpty()){
            errorMessage = "You need to insert Ticket Price, This is a required field";
            notFilledIn++;//if ticket price box not filled, error message displayed
        }else if (hourAvailabilitytxt.getText().isEmpty()){
            errorMessage = "Insert time available for the event, This is a required field";
            notFilledIn++; //if time available box not filled, error message displayed
        }else if (eventTypetxt.getText().isEmpty()){
            errorMessage = "You need to insert the event type, This is a required field";
            notFilledIn++; //if people event type not filled, error message displayed
        }

        if(notFilledIn==0) {
            LocalDate localdate = calendartxt.getValue();
            Instant instant = Instant.from(localdate.atStartOfDay(ZoneId.systemDefault()));
            Date date = Date.from(instant);
            App.events.add(new Event(date, Integer.parseInt(peopleInvitedtxt.getText()), Double.parseDouble(ticketPricetxt.getText()), Integer.parseInt(hourAvailabilitytxt.getText()), eventTypetxt.getText()));
            App.setRoot("ComparisonScreen");
        }else{
            JOptionPane.showMessageDialog(null, errorMessage);
        }
    }
}