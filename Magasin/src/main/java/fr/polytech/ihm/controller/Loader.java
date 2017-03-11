package fr.polytech.ihm.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Thoma on 3/11/2017.
 */
public class Loader {

    public void load(Stage stage, String fxml_file){

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(fxml_file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
}
