package org.example;

import com.sun.glass.ui.Clipboard;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
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

        readJSon();

        scene = new Scene(loadFXML("MainScreen"));
        stage.setScene(scene);
        stage.show();
    }

    private void readJSon() {

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