package fr.unice.polytech.a.ihm.g2c.controller;

import fr.unice.polytech.a.ihm.g2c.MainApp;
import fr.unice.polytech.a.ihm.g2c.common.AppScene;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Created by Jeremy on 07/03/2017.
 */

public class IndexController {

    private static final Logger logger = LogManager.getLogger(IndexController.class);

    @FXML
    private BorderPane rootPane;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void admin(MouseEvent event) {
        /*try {
            logger.debug("admin");
            FXMLLoader loader = new FXMLLoader();
            Parent rootNode = loader.load(getClass().getResourceAsStream("/fxml/administration.fxml"));
            Scene scene = new Scene(rootNode, MainApp.WIDTH, MainApp.HEIGHT);
            scene.getStylesheets().add("/styles/administration.css");
            rootNode.get
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //AppScene.ADMIN.getScene().show();

    }

    @FXML
    void info(MouseEvent event) {
        logger.debug("info");
    }

}

