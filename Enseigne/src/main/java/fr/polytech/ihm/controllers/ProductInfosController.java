package fr.polytech.ihm.controllers;

import fr.polytech.ihm.data.Product;
import fr.polytech.ihm.kernel.CheckerTool;
import fr.polytech.ihm.kernel.UpdateApp;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enzo on 13/03/2017.
 */
public class ProductInfosController {

    private UpdateApp updateApp;

    private int idProduct, nbSell;

    private List<TextField> textFieldList;

    private CheckerTool checkerTool;

    @FXML
    private TextField nameProductField;

    @FXML
    private TextField pictureProductField;

    @FXML
    private TextField brandProductField;

    @FXML
    private TextField priceProductField;

    @FXML
    private TextField remiseProductField;

    @FXML
    private TextField catProductField;

    @FXML
    private TextField picCatProductField;

    @FXML
    private Label confirmationLabel;

    @FXML
    private TextArea descProductArea;

    @FXML
    private CheckBox premiumCheckBox;

    @FXML
    private CheckBox sellCheckBox;

    public void initInfosProd(Product product){
        checkerTool = new CheckerTool();

        idProduct = product.getProductID();
        nbSell = product.getNbSell();

        nameProductField.setText(product.getNom());
        pictureProductField.setText(product.getImage());
        brandProductField.setText(product.getIdMarque() + "");
        priceProductField.setText(product.getPrix() + "");
        remiseProductField.setText(product.getCurrentPromo() + "");
        catProductField.setText(product.getCategory());
        descProductArea.setText(product.getDescription());

        catProductField.textProperty().addListener((observable, oldValue, newValue) -> checkCategory());

        initCheckBoxes(product);

        updateApp = new UpdateApp();

        initInfosFields();
    }

    public void checkCategory(){
        if (checkerTool.catAlreadyExists(catProductField.getText())){
            picCatProductField.setDisable(true);
            picCatProductField.clear();
        } else {
            picCatProductField.setDisable(false);
        }
    }

    private void initCheckBoxes(Product product){
        premiumCheckBox.setSelected(product.isProdPhare());
        sellCheckBox.setSelected(product.isInSell());
    }

    private void initInfosFields(){
        textFieldList = new ArrayList<>();

        textFieldList.add(nameProductField);
        textFieldList.add(pictureProductField);
        textFieldList.add(brandProductField);
        textFieldList.add(priceProductField);
        textFieldList.add(remiseProductField);
        textFieldList.add(catProductField);
        textFieldList.add(picCatProductField);
    }

    @FXML
    public void saveChanges(){
        if (allFieldsAreFull() && !descProductArea.getText().isEmpty() && promoIsOk()){

            updateApp.updateProduct(idProduct,
                    nameProductField.getText(),
                    descProductArea.getText(),
                    Float.parseFloat(priceProductField.getText()),
                    Integer.parseInt(brandProductField.getText()),
                    nbSell,
                    pictureProductField.getText(),
                    catProductField.getText(),
                    boolToInt(premiumCheckBox.isSelected()),
                    boolToInt(sellCheckBox.isSelected()),
                    Integer.parseInt(remiseProductField.getText()));

            confirmationLabel.setText("Effectué");
        } else {
            confirmationLabel.setText("Invalide");
        }

    }

    private boolean promoIsOk(){
        return (Integer.parseInt(remiseProductField.getText()) >= 0 &&  Integer.parseInt(remiseProductField.getText()) <= 100);
    }

    private int boolToInt(boolean bool){
        if (bool){
            return 1;
        } else {
            return 0;
        }
    }

    private boolean allFieldsAreFull(){
        for (TextField textfield :
                textFieldList) {
            if (textfield.getText().isEmpty() && !textfield.isDisable()){
                return false;
            }
        }
        return true;
    }
}
