package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.ProductInListView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class ProductMainController {

    @FXML
    private Label NomProduit;

    @FXML
    private Label PrixProduit;

    @FXML
    private Label Disponible;

    @FXML
    private Text DescriptionProduit;

    public void initProduct(ProductInListView product){
        this.NomProduit.setText(product.getName().toString());
        this.PrixProduit.setText(Integer.toString(product.getPrice()) + "€");
        this.Disponible.setText(product.getDisponible());
        this.DescriptionProduit.setText(product.getProductDescription());
    }
}