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
        int wrongDoubleDataType = 0;
        int wrongIntegerDataType = 0;
        String errorMessage = ""; //error-message will display on screen
        try{
            Double.parseDouble(cCostTxt.getText()); //this is going to try to change the text to a double
        }catch(Exception e){ //if it cannot, it will produce an error
            wrongDoubleDataType++;
        }
        try{
            Integer.parseInt(cCapacityTxt.getText()); //this is going to try to change the text into n integer
        }catch(Exception e){ //if it cannot, it will produce an error.
            wrongIntegerDataType++;
        }

        if (cCostTxt.getText().isEmpty()) {
            errorMessage = "You need to insert a cost, This is a required field";
            notFilledIn++; //if date not inserted, error message displayed regarding missing date
        } if (wrongDoubleDataType!=0) {
            errorMessage = "You need to insert a cost as decimal number (e.g 6.40), This is a required field";
            notFilledIn++; //if date not inserted, error message displayed regarding missing date
        }  else if (cCapacityTxt.getText().isEmpty()) {
            errorMessage = "Capacity needs to be inputted, This is a required field";
            notFilledIn++; //if people invited box not filled, error message displayed
        } if (wrongIntegerDataType!=0) {
            errorMessage = "Capacity needs to be inputted as a whole number (e.g 12), This is a required field";
            notFilledIn++; //if date not inserted, error message displayed regarding missing date
        }else if (cAddressTxt.getText().isEmpty()) {
            errorMessage = "You need to insert the Address, This is a required field";
            notFilledIn++; //if ticket price box not filled, error message displayed
        } else if (cNameTxt.getText().isEmpty()) {
            errorMessage = "Insert venue name, This is a required field";
            notFilledIn++; //if time available box not filled, error message displayed
        }

        if(notFilledIn==0) {
        App.venues.add(new Venue(cNameTxt.getText(), cAddressTxt.getText(), Integer.parseInt(cCapacityTxt.getText()), Double.parseDouble(cCostTxt.getText())));
        cCostTxt.clear();
        cCapacityTxt.clear();
        cAddressTxt.clear();
        cNameTxt.clear(); //it will clear the text boxes for the next operation
        App.saveVenuesToJSon();
        App.setRoot("EventsScreen");
        }else{ //condition that if count is not 0 then the program will output an error message because something is not correct
            JOptionPane.showMessageDialog(null, errorMessage);
        }

    }

}