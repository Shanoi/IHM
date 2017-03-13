package fr.polytech.ihm.controllers;

import fr.polytech.ihm.data.Category;
import fr.polytech.ihm.kernel.ProductsParser;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class CatalogController implements Initializable {

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    public void initCatalogue(ObservableList<Category> cats, String category) {
        
        initSliders();
        initCategory(cats);
        initBrand();
        
    }

    private void initSliders() {
        sliderMinPrice.setMin(MINPRICE);
        sliderMaxPrice.setMin(MINPRICE);
        sliderMinPrice.setMax(MAXPRICE);
        sliderMaxPrice.setMax(MAXPRICE);
    }

    @FXML
    public void actuMinPrice() {
        int sliderMin = (int) sliderMinPrice.getValue();
        int sliderMax = (int) sliderMaxPrice.getValue();

        if (sliderMin > sliderMax) {
            sliderMaxPrice.setValue(sliderMin);
            priceMaxDisplay.setText(Integer.toString(sliderMin));
        }
        priceMinDisplay.setText(Integer.toString(sliderMin));
    }

    @FXML
    public void actuMaxPrice() {
        int sliderMin = (int) sliderMinPrice.getValue();
        int sliderMax = (int) sliderMaxPrice.getValue();

        if (sliderMax < sliderMin) {
            sliderMinPrice.setValue(sliderMax);
            priceMinDisplay.setText(Integer.toString(sliderMax));
        }
        priceMaxDisplay.setText(Integer.toString(sliderMax));
    }

    private void initCategory(ObservableList<Category> cats) {
        ObservableList<String> catList = FXCollections.observableArrayList();

        System.out.println("INIT CAT");
        
        cats.stream().forEach((cat) -> {
            catList.add(cat.getCategory());
        });

        categoryChoice.setItems(catList);
    }

    private void initBrand() {
        ObservableList<String> catList = FXCollections.observableArrayList();

        catList.add("Apple");
        catList.add("ASUS");
        catList.add("IBM");
        brandChoice.setItems(catList);
    }

}
