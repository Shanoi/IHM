package fr.unice.polytech.a.ihm.g2c;

import fr.unice.polytech.a.ihm.g2c.model.DataModel;
import fr.unice.polytech.a.ihm.g2c.model.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static fr.unice.polytech.a.ihm.g2c.common.AppScene.INDEX;
import static fr.unice.polytech.a.ihm.g2c.common.Category.*;

public class MainApp extends Application {

    private static final int HEIGHT = 540;
    private static final int WIDTH = 960;
    private static final String DEFAULT_DESCRIPTION = "Descrption ici.";

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        DataModel data = DataModel.getInstance();
        data.setHighlight("Les soldes arrivent !! Jusqu'à -70% dans tous les magasins");

        data.addStore(new Store("Armani", DEFAULT_DESCRIPTION, makeImgPath("armani.jpg"), FASHION_MAN, true));
        data.addStore(new Store("Zara", DEFAULT_DESCRIPTION, makeImgPath("zara.png"), FASHION_WOMAN, true));
        data.addStore(new Store("The Hipster Label", DEFAULT_DESCRIPTION, makeImgPath("hipster.png"), FASHION_MAN, false));
        data.addStore(new Store("Orange", DEFAULT_DESCRIPTION, makeImgPath("orange.jpg"), TELECOM, true));
        data.addStore(new Store("Hugo Boss", DEFAULT_DESCRIPTION, makeImgPath("hugoboss.jpg"), FASHION_MAN, true));
        data.addStore(new Store("Sephora", DEFAULT_DESCRIPTION, makeImgPath("sephora.png"), COSMETIC, true));
        data.addStore(new Store("To be or to have", DEFAULT_DESCRIPTION, makeImgPath("to_be_or_to_have.png"), HIGH_TECH, true));
        data.addStore(new Store("Hippopotamus", DEFAULT_DESCRIPTION, makeImgPath("hippopotamus.jpg"), RESTORATION, true));

        data.addStore(new Store("Fnac", "Découvrez nos univers: Livres, Papeterie, Kids, maison & design, objets connectés, smatphones, high tech, apple, son, musique, vidéo, TV, jeux vidéo, billetterie,..\nLa Fnac c’est aussi 10 millions de produits disponibles sur fnac.com",
                makeImgPath("fnac.jpg"), HIGH_TECH, true));
        data.addStore(new Store("Ben Burger", "Découvrez d'authentiques burgers gourmands à la française: deux généreuses tranches de pain, une viande savoureuse, la fraîcheur des tomates et le croquant d'une salade... \nIl n'en faut pas plus pour faire de bons burgers ! ",
                makeImgPath("ben-burger.png"), RESTORATION, false));

    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Cap Sophia");
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = loader.load(getClass().getResourceAsStream(INDEX.getFxmlFile()));
        Scene scene = new Scene(rootNode, MainApp.WIDTH, MainApp.HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    private String makeImgPath(String imgName) {
        return "src/main/resources/images/stores/" + imgName;
    }

}
