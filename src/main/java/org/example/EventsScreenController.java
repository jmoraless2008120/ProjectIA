package org.example;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EventsScreenController {

    public TableColumn<Venue, String> venuesName = new TableColumn<>("Venue Name");
    public ArrayList<Event> events = new ArrayList<>();
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


    public void findVenueBtnAction(ActionEvent actionEvent) throws IOException {
        App.setRoot("MainScreen");

    }
}