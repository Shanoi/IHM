package fr.polytech.ihm.controller.client;

import fr.polytech.ihm.JSONParser;
import fr.polytech.ihm.MagasinApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.json.JSONObject;

/**
 * @author Thomas
 * @version 1.0
 *          Represents the main lower band (directionsCommon) controller class.
 *          It allows to go on the directions page and handle directions button.
 */
public class LowerBandController {

    @FXML
    private Button seDirigerBouton;
    @FXML
    private Label telMagasin;
    @FXML
    private Label adresseMagasin;
    @FXML
    private Label siteWebMagasin;

    @FXML
    public void initialize() {
        loadData();
    }

    @FXML
    void directionsPage() throws Exception {
        Stage stage = (Stage) seDirigerBouton.getScene().getWindow();
        Loader loader = new Loader();
        loader.load(stage, MagasinApp.PREFIXE + "Client/directions.fxml");
    }

    public void loadData() {
        JSONObject shopData = new JSONParser().parse("src/main/resources/data/magasins_data.json");
        telMagasin.setText(shopData.getString("tel"));
        adresseMagasin.setText(shopData.getString("adresse"));
        siteWebMagasin.setText(shopData.getString("siteweb"));
    }

}
