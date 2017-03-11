package fr.polytech.ihm.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * @author Jérémy LARA
 * @version 1.0
 *          Represents the main lower band (directionsCommon) controller class.
 *          It allows to go on the directions page and handle directions button.
 */
public class ListViewProductController {

    @FXML
    private Pane productListView;

    @FXML
    private Label productName;

    @FXML
    private ImageView productImage;

    @FXML
    private Label price;

    @FXML
    public void initialize() {

    }

    public void initializeProduct(String name, Image image, int price) {
        productName.setText(name);
        this.productImage.setImage(image);
        this.price.setText(Integer.toString(price));
    }

    @FXML
    void goProductPage(MouseEvent event) {

    }

}
