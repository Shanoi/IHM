package fr.polytech.ihm.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AdminController {

    @FXML
    private Button shopChange;

    @FXML
    private TextField addPromoAmount;

    @FXML
    private ComboBox<?> productListAdd;

    @FXML
    private Button applyAdd;

    @FXML
    private ComboBox<?> productListSupp;

    @FXML
    private Button applySupp;

    @FXML
    private TextField suppPromoCurrentAmont;

    @FXML
    private TextField modifPromoAmount;

    @FXML
    private ComboBox<?> productListModif;

    @FXML
    private Button applyModif;

    @FXML
    private Label addNotif;

    @FXML
    private Label modifNotif;

    @FXML
    private Label suppNotif;

    @FXML
    private TextField modifPromoCurrentAmount;

    @FXML
    void addPromo(ActionEvent event) {

    }

    @FXML
    void applyChangements(ActionEvent event) {

    }

    @FXML
    void modifyPromo(ActionEvent event) {

    }

    @FXML
    void suppPromo(ActionEvent event) {

    }

}
