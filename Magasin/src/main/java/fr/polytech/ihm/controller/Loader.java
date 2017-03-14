package fr.polytech.ihm.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Thomas Gréaux
 * @version 1.0
 *          Automatic Loader to simplify new Scene / Stage loading
 */
public class Loader {

    private static final Logger log = LoggerFactory.getLogger(Loader.class);

    public void load(Stage stage, String fxml_file) throws Exception {
        load(stage, fxml_file, true);
    }

    public void load(Stage stage, String fxml_file, boolean full_screen) throws Exception {

        log.info("Starting application");
        log.debug("Loading FXML for main view from: {}", fxml_file);

        Parent root = FXMLLoader.load(getClass().getResource(fxml_file));
        Scene scene = new Scene(root);
        //String css = getClass().getResource("/styles/windows.css").toExternalForm();
        //scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setFullScreen(full_screen);
        new CommonController(stage, scene);

        log.debug("Showing JFX scene");

        stage.show();
    }

}
