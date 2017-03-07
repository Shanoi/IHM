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

    INDEX("/fxml/index.fxml", "/styles/administration.css"),
    ADMIN("/fxml/administration.fxml", "/styles/administration.css");

    static {
        //initScene();
    }

    private static final Logger logger = LogManager.getLogger(AppScene.class);

    private String fxmlFile;
    private String cssFile;

    private Scene scene;

    AppScene(String fxmlFile, String cssFile) {
        this.fxmlFile = fxmlFile;
        this.cssFile = cssFile;
    }

    private static void initScene() {
        for (AppScene sc: values()) {
            try {
                FXMLLoader loader = new FXMLLoader();
                //System.out.println(new File("/fxml/").list());
                Parent rootNode = loader.load(ClassLoader.getSystemClassLoader().getResourceAsStream("/fxml/index.fxml"));
                sc.scene = new Scene(rootNode, MainApp.WIDTH, MainApp.HEIGHT);
                sc.scene.getStylesheets().add(sc.cssFile);
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }

    public String getFxmlFile() {
        return fxmlFile;
    }

    public String getCssFile() {
        return cssFile;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

}
