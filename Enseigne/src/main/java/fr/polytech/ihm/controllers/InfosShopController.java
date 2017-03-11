package fr.polytech.ihm.controllers;

import fr.polytech.ihm.data.Shop;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Created by Enzo on 11/03/2017.
 */
public class InfosShopController {

    @FXML
    private TextField nameShop;

    @FXML
    private TextField adressShop;

    @FXML
    private TextField latShop;

    @FXML
    private TextField longShop;

    @FXML
    private TextField phoneShop;

    @FXML
    private TextField mailShop;

    @FXML
    private TextField websiteShop;

    @FXML
    private TextField caShop;

    @FXML
    private TextField nbEmpShop;

    @FXML
    private TextField costShop;

    @FXML
    private TextField prodBackShop;

    public void initInfosShop(Shop shop){
        nameShop.setText(shop.getNameShop().get());
        adressShop.setText(shop.getAdressShop().get());
        latShop.setText(Double.toString(shop.getLatitudeShop()));
        longShop.setText(Double.toString(shop.getLongitudeShop()));
        phoneShop.setText(shop.getPhoneShop().get());
        mailShop.setText(shop.getMailShop().get());
        websiteShop.setText(shop.getWebsite().get());
        caShop.setText(Double.toString(shop.getCaShop()));
        nbEmpShop.setText(Integer.toString(shop.getNbEmployees()));
        costShop.setText(Double.toString(shop.getMaintenanceCost()));
        prodBackShop.setText(Integer.toString(shop.getProdBack()));
    }

    @FXML
    public void saveChanges(){

    }
}
