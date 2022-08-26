package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sun.glass.ui.Clipboard;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static ObservableList<Event> events = FXCollections.observableArrayList();
    public static ObservableList<Venue> venues = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws IOException {


        loadVenues();
        loadEvents();
        scene = new Scene(loadFXML("MainScreen"));
        stage.setScene(scene);
        stage.show();
    }

    private void loadEvents() {
        //load venues from saved file
        //open and read JSon file for any previously saved data
        Gson gson = new Gson();
        try(Reader reader = new FileReader("events.json")){
            //convert JSON file to Java Object
            ArrayList<Event> imports = gson.fromJson(reader, new TypeToken<ArrayList<Event>>() {
            }.getType());
            App.events = FXCollections.observableArrayList(imports);
        } catch (IOException e){
            e.printStackTrace();
            //convert JSon file to Java object
        }
    }
    private void loadVenues() {
        //load venues from saved file
        //open and read JSon file for any previously saved data
        Gson gson = new Gson();
        try(Reader reader = new FileReader("venues.json")){
            //convert JSON file to Java Object
            ArrayList<Venue> imports = gson.fromJson(reader, new TypeToken<ArrayList<Venue>>() {
            }.getType());
            App.venues = FXCollections.observableArrayList(imports);
        } catch (IOException e){
            e.printStackTrace();
            //convert JSon file to Java object
        }
    }
    public static void saveVenuesToJSon() {
        //this saves the venues list to a method.
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter writer = new FileWriter("venues.json")) {
            gson.toJson(venues,writer);
            System.out.print("Saved Venues.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void savEventsToJSon() {
        //this saves the venues list to a method.
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter writer = new FileWriter("events.json")) {
            gson.toJson(events,writer);
            System.out.print("Saved events.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}