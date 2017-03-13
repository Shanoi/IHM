package fr.polytech.ihm.controllers;

import fr.polytech.ihm.data.Shop;
import fr.polytech.ihm.kernel.UpdateApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enzo on 11/03/2017.
 */
public class InfosShopController {

    private List<TextField> textFieldList;
    private UpdateApp updateApp;

    private int idCurrentShop;

    @FXML
    private Label confirmLabel;

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
        idCurrentShop = shop.getIdShop();
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

        updateApp = new UpdateApp();

        initShopFields();
    }

    private void initShopFields(){
        textFieldList = new ArrayList<>();

        textFieldList.add(nameShop);
        textFieldList.add(adressShop);
        textFieldList.add(latShop);
        textFieldList.add(longShop);
        textFieldList.add(phoneShop);
        textFieldList.add(mailShop);
        textFieldList.add(websiteShop);
        textFieldList.add(caShop);
        textFieldList.add(nbEmpShop);
        textFieldList.add(costShop);
        textFieldList.add(prodBackShop);
    }

    @FXML
    public void saveChanges(){
        if (allFieldsAreFull()){
            updateApp.upDateMagasin(idCurrentShop,
                    nameShop.getText(),
                    adressShop.getText(),
                    Double.parseDouble(latShop.getText()),
                    Double.parseDouble(longShop.getText()),
                    phoneShop.getText(),
                    mailShop.getText(),
                    Double.parseDouble(caShop.getText()),
                    Integer.parseInt(nbEmpShop.getText()),
                    Double.parseDouble(costShop.getText()),
                    websiteShop.getText(),
                    Integer.parseInt(prodBackShop.getText())
                    );

            confirmLabel.setText("Effectué");
        } else {
            confirmLabel.setText("Invalide");
        }
    }

    private boolean allFieldsAreFull(){
        for (TextField textField :
                textFieldList) {
            if (textField.getText().isEmpty()){
                return false;
            }
        }
        return true;
    }
}
