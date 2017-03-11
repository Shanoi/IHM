package fr.polytech.ihm.controllers;


import fr.polytech.ihm.kernel.ProductsParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class CatalogController {

    private static int MINPRICE = 0;

    private static int MAXPRICE = 5000;

    @FXML
    private Label priceMinDisplay;

    @FXML
    private Label priceMaxDisplay;

    @FXML
    private Slider sliderMinPrice;

    @FXML
    private Slider sliderMaxPrice;

    @FXML
    private CheckBox venteFlash;

    @FXML
    private CheckBox Autre;

    @FXML
    private Label catégorie;

    @FXML
    private ChoiceBox<String> categoryChoice;

    @FXML
    private Label marque;

    @FXML
    private ChoiceBox<String> brandChoice;

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


    private ProductsParser mainProds;

    public void initialize(){
        initSliders();
        initCategory();
        initBrand();
    }


    private void initSliders(){
        sliderMinPrice.setMin(MINPRICE);
        sliderMaxPrice.setMin(MINPRICE);
        sliderMinPrice.setMax(MAXPRICE);
        sliderMaxPrice.setMax(MAXPRICE);
    }

    @FXML
    public void actuMinPrice(){
        int sliderMin = (int) sliderMinPrice.getValue();
        int sliderMax = (int) sliderMaxPrice.getValue();

        if (sliderMin > sliderMax){
            sliderMaxPrice.setValue(sliderMin);
            priceMaxDisplay.setText(Integer.toString(sliderMin));
        }
        priceMinDisplay.setText(Integer.toString(sliderMin));
    }

    @FXML
    public void actuMaxPrice(){
        int sliderMin = (int) sliderMinPrice.getValue();
        int sliderMax = (int) sliderMaxPrice.getValue();

        if (sliderMax < sliderMin){
            sliderMinPrice.setValue(sliderMax);
            priceMinDisplay.setText(Integer.toString(sliderMax));
        }
        priceMaxDisplay.setText(Integer.toString(sliderMax));
    }

    private void initCategory(){
        ObservableList<String> catList = FXCollections.observableArrayList();

        catList.add("Ordinateur");
        catList.add("DVD");
        catList.add("Periphérique");
        categoryChoice.setItems(catList);
    }

    private void initBrand(){
        ObservableList<String> catList = FXCollections.observableArrayList();

        catList.add("Apple");
        catList.add("ASUS");
        catList.add("IBM");
        brandChoice.setItems(catList);
    }
}
