/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.controllers;

import fr.polytech.ihm.data.Product;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FXML Controller class
 *
 * @author Olivier
 */
public class ItemController implements Initializable {

    private static final Logger log = LoggerFactory.getLogger(ItemController.class);
    
    @FXML
    private ImageView imgProd;
    @FXML
    private Label descrProd;
    @FXML
    private Label priceProd;
    @FXML
    private Label dispoProd;
    @FXML
    private Label nomProd;
    @FXML
    private ListView listItem;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initItem(Product product) {

        log.info("Produit selectionné : " + product.getNom());
        
        nomProd.setText(product.getNom());

        Image image = new Image(getClass().getClassLoader().getResourceAsStream("images/" + product.getImage()));

        imgProd.setImage(image);
        
        descrProd.setText(product.getDescription());

    }

}
