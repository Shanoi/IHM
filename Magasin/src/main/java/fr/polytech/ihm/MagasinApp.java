package fr.polytech.ihm;

import fr.polytech.ihm.controller.Loader;
import javafx.application.Application;
import javafx.stage.Stage;

public class MagasinApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(final Stage stage) throws Exception {
        stage.setTitle("Magasin");
        String fxmlFile = "/fxml/shopMain.fxml";

        Loader loader = new Loader();
        loader.load(stage, fxmlFile);
    }

}
