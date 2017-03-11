package fr.polytech.ihm.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by Thoma on 3/11/2017.
 */
public class Loader {

    private static final Logger log = LoggerFactory.getLogger(Loader.class);

    public void load(Stage stage, String fxml_file) throws Exception{

        log.info("Starting application");
        log.debug("Loading FXML for main view from: {}", fxml_file);

        Parent root = FXMLLoader.load(getClass().getResource(fxml_file));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        new CommonController(stage, scene);

        log.debug("Showing JFX scene");

        stage.show();
    }
}
