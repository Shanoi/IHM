package fr.polytech.ihm.controllers;


import fr.polytech.ihm.kernel.mainProducts;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class CatalogController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private ImageView logo;

    @FXML
    private Label prixMin;

    @FXML
    private Slider slider1;

    @FXML
    private Label prixMax;

    @FXML
    private Slider slider2;

    @FXML
    private CheckBox venteFlash;

    @FXML
    private CheckBox Autre;

    @FXML
    private Label catégorie;

    @FXML
    private ChoiceBox<?> choice1;

    @FXML
    private Label marque;

    @FXML
    private ChoiceBox<?> choice2;

    @FXML
    private Label gamme;

    @FXML
    private ChoiceBox<?> choice3;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ListView<?> itemList;


    private mainProducts mainProds;




















}
