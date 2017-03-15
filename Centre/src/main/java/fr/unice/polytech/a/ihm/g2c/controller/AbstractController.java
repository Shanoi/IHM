package fr.unice.polytech.a.ihm.g2c.controller;

import fr.unice.polytech.a.ihm.g2c.common.AppScene;
import fr.unice.polytech.a.ihm.g2c.model.DataModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Created by Jeremy on 14/03/2017.
 */
public class AbstractController {
    
    private static final Logger logger = LogManager.getLogger(AbstractController.class);

    protected DataModel data = DataModel.getInstance();

    void initialize(Parent rootPane) {
        rootPane.getStylesheets().setAll(data.getStylesheet());
    }

    void showScene(AppScene appScene, Stage stage) {
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent rootNode = loader.load(getClass().getResourceAsStream(appScene.getFxmlFile()));
            Scene scene = new Scene(rootNode);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            logger.error(e);
        }
    }

}
