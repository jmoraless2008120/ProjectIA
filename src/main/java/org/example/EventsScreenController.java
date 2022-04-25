package org.example;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EventsScreenController {

    public TableView venueTable;
    public TableColumn<Venue, String> venuesName = new TableColumn<>("Venue Name");
    public ArrayList<Event> events = new ArrayList<>();
    public Button sSaveEventButton;
    public TextField peopleInvitedtxt;
    public TextField hourAvailabilitytxt;
    public TextField ticketPricetxt;
    public TextField eventTypetxt;

    @FXML
    private void switchToMainScreen() throws IOException {
        App.setRoot("MainScreen");
    }

    public void initialize(){
        events.add(new Event(500, 120.5, 7.50-2, "concert"));
        venueTable.getColumns().add(venuesName);

    }

    public void sSaveEventButton(ActionEvent actionEvent) {
        boolean add = events.add(new Event((int) Integer.parseInt(peopleInvitedtxt.getText()), (double) Integer.parseInt(hourAvailabilitytxt.getText()), (double) Integer.parseInt(ticketPricetxt.getText()), eventTypetxt.getText()));
    }





}