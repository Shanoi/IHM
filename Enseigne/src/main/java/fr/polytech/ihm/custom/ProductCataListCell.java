/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.custom;

import fr.polytech.ihm.data.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.IOException;

/**
 *
 * @author Olivier
 */
public class ProductCataListCell extends ListCell<Product> {

    private FXMLLoader mLLoader;

    @FXML
    private GridPane gridPane;
    @FXML
    private Label prixPromoProd;
    @FXML
    private Label nomProd;
    @FXML
    private Label descProd;
    @FXML
    private Label prixProd;
    @FXML
    private ImageView imgProd;

    @Override
    protected void updateItem(Product product, boolean empty) {
        super.updateItem(product, empty);

        if (empty || product == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/fxml/catalogue/itemCatalogue.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            Image img = new Image(getClass().getClassLoader().getResourceAsStream("/images/" + product.getImage()));

            imgProd.setImage(img);
            descProd.setText(product.getCategory());
            nomProd.setText(product.getNom());

            if (product.getCurrentPromo() != 0) {

                prixProd.setText(String.valueOf(product.getPrix()) + "€");

                prixPromoProd.setText(String.valueOf(product.getPrixPromo()) + "€");
                
            } else {

                prixProd.setText(String.valueOf(product.getPrix()) + "€");

            }

            setText(null);
            setGraphic(gridPane);
        }

    }

}
