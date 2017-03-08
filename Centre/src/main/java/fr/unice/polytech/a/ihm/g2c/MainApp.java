package fr.unice.polytech.a.ihm.g2c;

import fr.unice.polytech.a.ihm.g2c.common.AppScene;
import fr.unice.polytech.a.ihm.g2c.controller.IndexController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static fr.unice.polytech.a.ihm.g2c.common.AppScene.*;

public class MainApp extends Application {

    public static final int HEIGHT = 1080;
    public static final int WIDTH = 1920;
    
    private static final Logger logger = LogManager.getLogger(MainApp.class);


    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void init() throws Exception {

    }

    @Override
    public void start(Stage stage) throws Exception {
        //initScene();

        stage.setTitle("Cap Sophia");
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = loader.load(getClass().getResourceAsStream(INDEX.getFxmlFile()));
        Scene scene = new Scene(rootNode, MainApp.WIDTH, MainApp.HEIGHT);
        IndexController controller = loader.getController();
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setFullScreen(true);
        stage.show();
        Thread.sleep(1000);
        controller.test();
    }

}
