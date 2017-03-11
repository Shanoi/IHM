package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.ProductModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

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

    @FXML
    public void initialize() {

    }

    @FXML
    void goProductPage(MouseEvent event) {

    }

}
