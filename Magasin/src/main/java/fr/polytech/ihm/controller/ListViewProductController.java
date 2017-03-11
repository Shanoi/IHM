package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.ProductModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.Random;

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
    private Text oldPrice;

    @FXML
    private Label newPrice;

    @FXML
    private Label reduction;

    private ProductModel productModel;

    private int[] reduc = {15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70};

    @FXML
    public void initialize() {

    }

    public void initializeProduct(String name, ImageView image, int price) {
        productName.setText(name);
        this.productImage = image;
        this.price.setText(Integer.toString(price));
    }

    public void initializeProductPromo(String name, ImageView image, int price) {
        productName.setText(name);
        this.productImage = image;
        Random r = new Random();
        int reductionNb = reduc[r.nextInt(reduc.length)];
        oldPrice.setText(Integer.toString(price));
        oldPrice.setStrikethrough(true);
        newPrice.setText(Integer.toString((1 - reductionNb / 100)*price));
        reduction.setText("-" + Integer.toString(reductionNb) + "%");
    }

    @FXML
    void goProductPage(MouseEvent event) {

    }

}
