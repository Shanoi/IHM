    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.controllers;

import fr.polytech.ihm.kernel.mainProducts;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class PAController implements Initializable {

    @FXML private Label accrochePhare;
    
    @FXML private ImageView imagePhare;
    
    private mainProducts mainProds;
    
    private final String pathToImageSortBy = "nameOfProject/resources/testDataIcons/";
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        

        
        //Image image = new Image(getClass().getClassLoader().getResource("DVD.png"));
        
        mainProds = new mainProducts();
        
        accrochePhare.setText(mainProds.getCurrentProduct().getNom());
        
        // imagePhare.setImage(image);
        
        
    }    

    @FXML
    private void gauchePhare(MouseEvent event) {
        
        accrochePhare.setText(mainProds.prevProduct().getNom());
        
    }

    @FXML
    private void droitePhare(MouseEvent event) {
        
        accrochePhare.setText(mainProds.nextProduct().getNom());
        
    }
    
}
