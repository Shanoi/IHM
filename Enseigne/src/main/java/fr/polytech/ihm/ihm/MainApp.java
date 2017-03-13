package fr.polytech.ihm.ihm;

import static fr.polytech.ihm.kernel.Tools.getMaxPriceCategoryProduct;
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

        String fxmlFileMain = "/fxml/MainPage.fxml";
        String fxmlFileAdmin = "/fxml/AdminPanel.fxml";

        FXMLLoader loader = new FXMLLoader();
        FXMLLoader loaderAdmin = new FXMLLoader();

        Parent rootNodeMain = loader.load(getClass().getResourceAsStream(fxmlFileMain));
        Parent rootNodeAdmin = loaderAdmin.load(getClass().getResourceAsStream(fxmlFileAdmin));

        Stage stageAdmin = new Stage();

        Scene sceneMain = new Scene(rootNodeMain, 1920, 1080);
        Scene sceneAdmin = new Scene(rootNodeAdmin, widthAdmin, heightAdmin);

        sceneMain.getStylesheets().add("/styles/styles.css");
        sceneAdmin.getStylesheets().add("/styles/styles.css");

        stage.setTitle("To Be Or To Have - Main Menu");
        stageAdmin.setTitle("To Be Or To Have - Admin panel");

        stage.setScene(sceneMain);
        stageAdmin.setScene(sceneAdmin);

        stage.show();
        stageAdmin.show();
    }
}
