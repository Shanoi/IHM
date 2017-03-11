package fr.polytech.ihm;

import fr.polytech.ihm.controller.AppController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MagasinApp extends Application {

    private Stage stage;
    private static final int WIDTH = 1920;
    private static final int HEIGHT = 1080;
    private static final Logger log = LoggerFactory.getLogger(MagasinApp.class);

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(final Stage stage) throws Exception {
        this.stage = stage;
        String fxmlFile = "/fxml/shopMain.fxml";

        log.info("Starting Shop application");
        log.debug("Loading FXML for main view from: {}", fxmlFile);

        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));

        log.debug("Showing JFX scene");
        final Scene scene = new Scene(rootNode, WIDTH, HEIGHT);
        //scene.getStylesheets().add("/styles/styles.css");

        //allow main app command
        //new AppController(stage, scene);
        stage.setTitle("Magasin");
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
    }

}
