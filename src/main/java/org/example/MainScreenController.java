package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainScreenController {

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
