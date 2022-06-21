package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.io.IOException;

public class ComparisonScreenController {

    public TextField peopleConfirmedTextBox;
    public TextField eventHourstxt;
    public TextField ticketRevenuetxt;
    public TextArea venueListComparison;
    public ChoiceBox VenueChoiceBox1;
    public ChoiceBox VenueChoiceBox2;
    public ChoiceBox VenueChoiceBox3;
    public TextField profitSalesVenue1;
    public TextField capacityVenue1;
    public TextField addressVenue1;
    public TextField profitSalesVenue2;
    public TextField capacityVenue2;
    public TextField addressVenue2;
    public TextField profitSalesVenue3;
    public TextField capacityVenue3;
    public TextField addressVenue3;

    public void  initialize(){
        try {
            peopleConfirmedTextBox.setText(String.valueOf(App.events.get(App.events.size() - 1).getPeopleInvited()));
            eventHourstxt.setText(String.valueOf(App.events.get(App.events.size() - 1).getHourAvailability()));
            ticketRevenuetxt.setText(String.valueOf(App.events.get(App.events.size() - 1).getTicketPrice() * App.events.get(App.events.size() - 1).getPeopleInvited()));
        }catch(Exception e){
            //do something if error.
        }
        VenueChoiceBox1.setItems(App.venues);
        VenueChoiceBox2.setItems(App.venues);
        VenueChoiceBox3.setItems(App.venues);
        VenueChoiceBox1.getSelectionModel().selectedItemProperty().addListener((options,oldValue,newValue)->{

            profitSalesVenue1.setText(String.valueOf(App.venues.get(VenueChoiceBox1.getSelectionModel().getSelectedIndex()).getCost()*App.events.get(App.events.size()-1).getPeopleInvited()));
            capacityVenue1.setText(String.valueOf(App.venues.get(VenueChoiceBox1.getSelectionModel().getSelectedIndex()).getCapacity()));
            if(App.venues.get(VenueChoiceBox1.getSelectionModel().getSelectedIndex()).getCapacity() < App.events.get(App.events.size()-1).getPeopleInvited()){
                capacityVenue1.setStyle("-fx-background-color:red;");
                if(App.venues.get(VenueChoiceBox1.getSelectionModel().getSelectedIndex()).getCapacity() == App.events.get(App.events.size()-1).getPeopleInvited()){
                    capacityVenue1.setStyle("-fx-background-color:white;");
                }
            } else {
                capacityVenue1.setStyle("-fx-background-color:green;");
            }
            addressVenue1.setText(String.valueOf(App.venues.get(VenueChoiceBox1.getSelectionModel().getSelectedIndex()).getAddress()));
        });
        VenueChoiceBox2.getSelectionModel().selectedItemProperty().addListener((options,oldValue,newValue)->{
            profitSalesVenue2.setText(String.valueOf(App.venues.get(VenueChoiceBox2.getSelectionModel().getSelectedIndex()).getCost()*App.events.get(App.events.size()-1).getPeopleInvited()));
            capacityVenue2.setText(String.valueOf(App.venues.get(VenueChoiceBox2.getSelectionModel().getSelectedIndex()).getCapacity()));
            if(App.venues.get(VenueChoiceBox2.getSelectionModel().getSelectedIndex()).getCapacity() < App.events.get(App.events.size()-1).getPeopleInvited()){
                capacityVenue2.setStyle("-fx-background-color:red;");
            } else {
                capacityVenue2.setStyle("-fx-background-color:green;");
            }
            addressVenue2.setText(String.valueOf(App.venues.get(VenueChoiceBox2.getSelectionModel().getSelectedIndex()).getAddress()));
        });

        VenueChoiceBox3.getSelectionModel().selectedItemProperty().addListener((options,oldValue,newValue)->{
            profitSalesVenue3.setText(String.valueOf(App.venues.get(VenueChoiceBox3.getSelectionModel().getSelectedIndex()).getCost()*App.events.get(App.events.size()-1).getPeopleInvited()));
            capacityVenue3.setText(String.valueOf(App.venues.get(VenueChoiceBox3.getSelectionModel().getSelectedIndex()).getCapacity()));
            if(App.venues.get(VenueChoiceBox3.getSelectionModel().getSelectedIndex()).getCapacity() < App.events.get(App.events.size()-1).getPeopleInvited()){
                capacityVenue3.setStyle("-fx-background-color:red;");
            } else {
                capacityVenue3.setStyle("-fx-background-color:green;");
            }
            addressVenue3.setText(String.valueOf(App.venues.get(VenueChoiceBox3.getSelectionModel().getSelectedIndex()).getAddress()));
        });

        //TO DO
        /**
         * 1. If the capacity of the venue is smaller than the event number of people, make the venueCapacity text box RED.
         * 2. Imagine you have lots of venues in your list of venues. Make the program automatically select the best 3 (calculate profit first for each event and then pick the most proffitable three.
         *
         */
    }
    @FXML
    private void switchToMainScreen() throws IOException {
        App.setRoot("MainScreen");
    }

    public void saveEventToJSon(ActionEvent actionEvent) {
    }

    public void setVenueDetails1(MouseEvent mouseEvent) {

    }

    public void setVenueDetails2(MouseEvent mouseEvent) {
    }

    public void setVenueDetails3(MouseEvent mouseEvent) {
    }
}