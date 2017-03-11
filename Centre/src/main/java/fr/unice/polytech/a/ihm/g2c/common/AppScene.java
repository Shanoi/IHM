package fr.unice.polytech.a.ihm.g2c.common;

import fr.unice.polytech.a.ihm.g2c.MainApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Created by Jeremy on 07/03/2017.
 */
public enum AppScene {

    INDEX("/fxml/index.fxml"),
    ADMIN("/fxml/administration.fxml"),
    STORE("/fxml/store.fxml"),
    INFORMATIONS("/fxml/informations.fxml");

    private String fxmlFile;

    AppScene(String fxmlFile) {
        this.fxmlFile = fxmlFile;
    }

    public String getFxmlFile() {
        return fxmlFile;
    }

}
