package fr.polytech.ihm.controller;

import fr.polytech.ihm.JSONParser;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.json.JSONObject;

/**
 * @author Jérémy Lara
 * @version 1.0
 *          Manages the direction page data
 */
public class DirectionController {

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

    private void loadData() {
        JSONObject shopData = new JSONParser().parse("src\\main\\resources\\data\\magasins_data.json");
        telMagasin.setText(shopData.getString("tel"));
        adresseMagasin.setText(shopData.getString("adresse"));
        siteWebMagasin.setText(shopData.getString("siteweb"));
    }

}
