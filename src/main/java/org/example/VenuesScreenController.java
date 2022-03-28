package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class VenuesScreenController {

    @FXML
    private void switchToMainScreen() throws IOException {
        App.setRoot("MainScreen");
    }

}