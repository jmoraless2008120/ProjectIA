package org.example;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class EventsScreenController {

 public ChoiceBox eEventSelectionDropBox;

   ObservableList<String> venues =
           FXCollections.observableArrayList(

           );




    @FXML
    private void switchToMainScreen() throws IOException {
        App.setRoot("MainScreen");
    }


}