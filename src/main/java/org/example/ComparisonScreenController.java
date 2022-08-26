package org.example;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    public CheckBox checkBoxVenue1;
    public CheckBox checkBoxVenue2;
    public CheckBox checkBoxVenue3;

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

        EventHandler checkboxClicked = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (event.getSource() instanceof CheckBox) {
                    CheckBox chk = (CheckBox) event.getSource();
                    if(chk.getId().equals("checkBoxVenue1")){
                        checkBoxVenue2.setSelected(false);
                        checkBoxVenue3.setSelected(false);
                    }else if(chk.getId().equals("checkBoxVenue2")){
                        checkBoxVenue1.setSelected(false);
                        checkBoxVenue3.setSelected(false);
                    }else if(chk.getId().equals("checkBoxVenue3")){
                        checkBoxVenue2.setSelected(false);
                        checkBoxVenue1.setSelected(false);
                    }
                }
            }
        };
        checkBoxVenue1.setOnAction(checkboxClicked);
        checkBoxVenue2.setOnAction(checkboxClicked);
        checkBoxVenue3.setOnAction(checkboxClicked);

    }
    @FXML
    private void switchToMainScreen() throws IOException {
        App.setRoot("MainScreen");
    }

    public void saveEventToJSon(ActionEvent actionEvent) throws IOException{

        if(checkBoxVenue1.isSelected()){
            App.events.get(App.events.size()-1).setChosenVenue((Venue) VenueChoiceBox1.getSelectionModel().getSelectedItem());
        }else  if(checkBoxVenue2.isSelected()){
            App.events.get(App.events.size()-1).setChosenVenue((Venue) VenueChoiceBox2.getSelectionModel().getSelectedItem());
        }else if(checkBoxVenue3.isSelected()){
            App.events.get(App.events.size()-1).setChosenVenue((Venue) VenueChoiceBox3.getSelectionModel().getSelectedItem());
        }
        App.savEventsToJSon();
        App.setRoot("SavedEventsScreen");
    }

}