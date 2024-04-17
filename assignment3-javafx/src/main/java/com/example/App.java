package com.example;

// Import necessary libraries
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// Main class that extends the JavaFX Application class
public class App extends Application {

    // Variable for the scene
    private static Scene scene;

    // Method that is called when the program is launched
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    // Change the scene to the one defined in the loadFXML function
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    // Load the FXML file, which is responsible for the scene design
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    // Main method that launches the program
    public static void main(String[] args) {
        launch();
    }

}
