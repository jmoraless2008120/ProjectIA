package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainScreenController {

    /**
    1. create the venues.
     A)making the venue screen work.
     B)Create the venue class to hold the information about the venue. See the video.
     C)let the user create a venue.
     D)Save the venue that the user creates into an arraylist of venues.

     2. Make the event screen work
        A) add the fx:IDs and button actions for the different elements of the screen.
     B) Create the events class.
     c) when the user creates a new event, selecting a venue, save it to another arraylist.

     3. Save this information to a json file.
    **/

    @FXML
    public void switchToEventScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("EventsScreen");
    }

    @FXML
    public void switchToVenueScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("VenuesScreen");
    }
    @FXML
    public void switchToComparisonScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("ComparisonScreen");
    }
}
