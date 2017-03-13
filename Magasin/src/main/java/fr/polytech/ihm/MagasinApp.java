package fr.polytech.ihm;

import com.aquafx_project.AquaFx;
import fr.polytech.ihm.controller.Loader;
import javafx.application.Application;
import javafx.stage.Stage;

public class MagasinApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        //AquaFx.style();

        primaryStage.setTitle("Magasin");
        String fxml_magasin = "/fxml/Client/shopMain_listView.fxml";
        String fxml_admin = "/fxml/Admin/VueAdmin.fxml";

        Stage Admin_Stage = new Stage();
        Admin_Stage.setTitle("Administration");
        Admin_Stage.setResizable(false);

        Loader loader = new Loader();
        loader.load(primaryStage, fxml_magasin);
        loader.load(Admin_Stage, fxml_admin, false);
    }

}
