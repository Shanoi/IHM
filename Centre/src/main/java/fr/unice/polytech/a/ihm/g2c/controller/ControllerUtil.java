package fr.unice.polytech.a.ihm.g2c.controller;

import fr.unice.polytech.a.ihm.g2c.common.AppScene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Created by user on 08/03/2017.
 */
public class ControllerUtil {

    private static final Logger logger = LogManager.getLogger(ControllerUtil.class);
    
    private ControllerUtil() {

    }

    public static void showScene(AppScene appScene, Stage stage) {
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent rootNode = loader.load(ControllerUtil.class.getResourceAsStream(appScene.getFxmlFile()));
            Scene scene = new Scene(rootNode);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
