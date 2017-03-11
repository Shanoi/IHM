package fr.polytech.ihm.ihm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApp extends Application {

    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        int widthAdmin = 800;
        int heightAdmin = 533;

        log.info("Starting Hello JavaFX and Maven demonstration application");

        String fxmlFile = "/fxml/AdminPanel.fxml";
        log.debug("Loading FXML for main view from: {}", fxmlFile);
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));

        log.debug("Showing JFX scene");
        Scene scene = new Scene(rootNode, widthAdmin, heightAdmin);
        scene.getStylesheets().add("/styles/styles.css");

        stage.setTitle("To Be Or To Have - Admin panel");
        stage.setScene(scene);
        stage.show();
    }
}
