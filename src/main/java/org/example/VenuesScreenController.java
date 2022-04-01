package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class VenuesScreenController {

    @FXML
    private void switchToMainScreen() throws IOException {
        App.setRoot("MainScreen");
    }

    public void initialize(){
        new Venue("Newton College", "Ricardo Elias Aparicio 240", 500, 1300.67);
    }

}