package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.ProductInListView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ProductMainController {

    @FXML
    private Label NomProduit;
    @FXML
    private Label PrixProduit;
    @FXML
    private Label Disponible;
    @FXML
    private ImageView productImage;

    @FXML
    private Text DescriptionProduit;

    void initProduct(ProductInListView product) {
        this.NomProduit.setText(product.getName());
        Image image = new Image(getClass().getResource(product.getImage()).toExternalForm());
        productImage.setImage(image);
        if (product.isPromo()) {
            this.PrixProduit.setText("-" + product.getPromo() + "%   "
                    + Integer.toString((int) ((1 - ((double) product.getPromo() / 100)) * product.getPrice())) + "€");
        } else this.PrixProduit.setText(Integer.toString(product.getPrice()) + "€");
        this.Disponible.setText(product.getDisponible());
        this.DescriptionProduit.setText(product.getProductDescription());
    }

}