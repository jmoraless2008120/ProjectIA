package org.example;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.naming.Name;

public class VenuesScreenController {

    public ArrayList<Venue> venues = new ArrayList<>();
    public TextField cCostTxt;
    public TextField cCapacityTxt;
    public TextField cAddressTxt;
    public TextField cNameTxt;

    @FXML
    private void switchToMainScreen() throws IOException {
        App.setRoot("MainScreen");
    }

    public void initialize() {
        venues.add(new Venue("Newton College", "Ricardo Elias Aparicio 240", 500, 1300.67));
    }


    public void saveBtn(ActionEvent actionEvent) throws IOException {

        venues.add(new Venue(cNameTxt.getText(), cAddressTxt.getText(), (int) Integer.parseInt(cCostTxt.getText()), (double) Integer.parseInt(cCapacityTxt.getText())));
        cCostTxt.clear();
        cCapacityTxt.clear();
        cAddressTxt.clear();
        cNameTxt.clear();
        App.setRoot("MainScreen");
    }
}