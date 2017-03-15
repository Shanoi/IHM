package fr.polytech.ihm;

import com.aquafx_project.AquaFx;
import com.guigarage.flatterfx.FlatterFX;
import fr.polytech.ihm.controller.Loader;
import javafx.application.Application;
import javafx.stage.Stage;

public class MagasinApp extends Application {

    public static final String PREFIXE = "/fxmlSansCss/";

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        AquaFx.style();
        //FlatterFX.style();

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
