package fr.polytech.ihm;

import com.aquafx_project.AquaFx;
import fr.polytech.ihm.controller.client.Loader;
import javafx.application.Application;
import javafx.stage.Stage;
import org.aerofx.AeroFX;

public class MagasinApp extends Application {

    public static final String PREFIXE = "/fxml/";

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        //AquaFx.style();
        //FlatterFX.style();
        //AeroFX.style();

        primaryStage.setTitle("Magasin");
        String fxml_magasin = PREFIXE + "Client/shopMain_listView.fxml";
        String fxml_admin = PREFIXE + "Admin/VueAdmin.fxml";

        Stage Admin_Stage = new Stage();
        Admin_Stage.setTitle("Administration");
        Admin_Stage.setResizable(false);

        Loader loader = new Loader();
        loader.load(primaryStage, fxml_magasin);
        loader.load(Admin_Stage, fxml_admin, false);
    }

}
