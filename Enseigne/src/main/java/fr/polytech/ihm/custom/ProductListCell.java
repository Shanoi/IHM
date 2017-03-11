/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.custom;

import fr.polytech.ihm.data.Product;
import java.io.IOException;
import javafx.scene.control.ListCell;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Olivier
 */
public class ProductListCell extends ListCell<Product> {
    
    @FXML
    private ImageView imgProd;
    
    @FXML
    private Label nomProd;
    
    @FXML
    private Label prixProd;
    
    @FXML
    private GridPane gridPane;
    
    private FXMLLoader mLLoader;
    
    @Override
    protected void updateItem(Product product, boolean empty) {
        super.updateItem(product, empty);

        if(empty || product == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/fxml/ItemCell.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            
            Image img = new Image(getClass().getClassLoader().getResourceAsStream("images/" + product.getImage()));
            
            imgProd.setImage(img);
            
            nomProd.setText(product.getNom());
            prixProd.setText(String.valueOf(product.getPrix()) + "€");

            setText(null);
            setGraphic(gridPane);
        }

    }
    
}
