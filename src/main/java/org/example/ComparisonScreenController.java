package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class ComparisonScreenController {

    @FXML
    private void switchToMainScreen() throws IOException {
        App.setRoot("MainScreen");
    }
}