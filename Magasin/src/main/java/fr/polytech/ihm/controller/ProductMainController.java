package fr.polytech.ihm.controller;

import javafx.beans.property.StringProperty;
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

    public void initProduct(String NomProduit, double PrixProduit, String Disponible, String DescriptionProduit){
        this.NomProduit.setText(NomProduit);
        this.PrixProduit.setText(Double.toString(PrixProduit));
        this.Disponible.setText(Disponible);
        this.DescriptionProduit.setText(DescriptionProduit);
    }
}