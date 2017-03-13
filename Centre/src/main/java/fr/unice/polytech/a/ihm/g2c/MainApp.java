package fr.unice.polytech.a.ihm.g2c;

import fr.unice.polytech.a.ihm.g2c.common.Category;
import fr.unice.polytech.a.ihm.g2c.controller.IndexController;
import fr.unice.polytech.a.ihm.g2c.model.DataModel;
import fr.unice.polytech.a.ihm.g2c.model.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static fr.unice.polytech.a.ihm.g2c.common.AppScene.*;
import static fr.unice.polytech.a.ihm.g2c.common.Category.*;

public class MainApp extends Application {

    public static final int HEIGHT = 540;
    public static final int WIDTH = 960;
    
    private static final Logger logger = LogManager.getLogger(MainApp.class);


    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        DataModel data = DataModel.getInstance();
        data.setHighlight("Les soldes arrivent !! Jusqu'à -70% dans tous les magasins");

        data.addStore(new Store("Fnac", "salut", "src/main/resources/images/stores/fnac.jpg", HIGH_TECH, true));
        data.addStore(new Store("Armani", "salut", "src/main/resources/images/stores/armani.jpg", FASHION_MAN, true));
        data.addStore(new Store("Zara", "salut", "src/main/resources/images/stores/zara.png", FASHION_WOMAN, true));
        data.addStore(new Store("The Hipster Label", "salut", "src/main/resources/images/stores/hipster.png", FASHION_MAN, false));
        data.addStore(new Store("Orange", "salut", "src/main/resources/images/stores/orange.jpg", TELECOM, true));
        data.addStore(new Store("Hugo Boss", "salut", "src/main/resources/images/stores/hugoboss.jpg", FASHION_MAN, true));
        data.addStore(new Store("Sephora", "salut", "src/main/resources/images/stores/sephora.png", COSMETIC, true));
        data.addStore(new Store("To be or to have", "salut", "src/main/resources/images/stores/to_be_or_to_have.png", HIGH_TECH, true));

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
        //stage.setMaximized(true);
        //stage.setFullScreen(true);
        stage.show();
        /*Thread.sleep(1000);
        controller.test();*/
    }

}
