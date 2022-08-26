package org.example;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.Date;

public class SavedEventsController {

public TableColumn<Event, Date> dateColumn = new TableColumn<Event, Date>("Date");
public TableColumn<Event, String> eventTypeColumn = new TableColumn<>("Event");
public TableColumn<Event, String> venueNameColumn = new TableColumn<Event, String>("Venue");
public TableColumn<Event, Integer> peopleInvitedColumn = new TableColumn<Event, Integer>("People Invited");
public TableView savedEventsTable;

    public void switchToComparisonScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("ComparisonScreen");
    }

    public void initialize()
    {
        dateColumn.setCellValueFactory(new PropertyValueFactory<Event, Date>("date"));
        eventTypeColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("eventType"));
        venueNameColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("chosenVenue"));
        peopleInvitedColumn.setCellValueFactory(new PropertyValueFactory<Event, Integer>("peopleInvited"));

        savedEventsTable.getColumns().add(dateColumn);
        savedEventsTable.getColumns().add(eventTypeColumn);
        savedEventsTable.getColumns().add(venueNameColumn);
        savedEventsTable.getColumns().add(peopleInvitedColumn);

        savedEventsTable.setItems(App.events);
    }
}
