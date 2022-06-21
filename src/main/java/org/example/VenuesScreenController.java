package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.naming.Name;
import javax.swing.*;

import static org.example.App.events;
import static org.example.App.venues;

public class VenuesScreenController {

    public TextField cCostTxt;
    public TextField cCapacityTxt;
    public TextField cAddressTxt;
    public TextField cNameTxt;

    @FXML
    private void switchToMainScreen() throws IOException {
        App.setRoot("MainScreen");
    }

    public void initialize() {
        //App.venues.add(new Venue("Newton College", "Ricardo Elias Aparicio 240", 500, 1300.67));


    }



    public void saveBtn(ActionEvent actionEvent) throws IOException {
        int notFilledIn = 0;
        String errorMessage = ""; //error pop-up message will display on screen
        if (cCostTxt.getText().isEmpty()) {
            errorMessage = "You need to insert a cost, This is a required field";
            notFilledIn++; //if date not inserted, error message displayed regarding missing date
        } else if (cCapacityTxt.getText().isEmpty()) {
            errorMessage = "Capacity needs to be inputted, This is a required field";
            notFilledIn++; //if people invited box not filled, error message displayed
        } else if (cAddressTxt.getText().isEmpty()) {
            errorMessage = "You need to insert the Address, This is a required field";
            notFilledIn++;//if ticket price box not filled, error message displayed
        } else if (cNameTxt.getText().isEmpty()) {
            errorMessage = "Insertvenue name, This is a required field";
            notFilledIn++; //if time available box not filled, error message displayed
        }

        if(notFilledIn==0) {
        App.venues.add(new Venue(cNameTxt.getText(), cAddressTxt.getText(), Integer.parseInt(cCapacityTxt.getText()), Double.parseDouble(cCostTxt.getText())));
        cCostTxt.clear();
        cCapacityTxt.clear();
        cAddressTxt.clear();
        cNameTxt.clear();
        App.saveVenuesToJSon();
        App.setRoot("EventsScreen");
        }else{
            JOptionPane.showMessageDialog(null, errorMessage);

        }

    }

}