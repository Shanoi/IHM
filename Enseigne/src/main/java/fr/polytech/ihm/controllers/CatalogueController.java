/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.controllers;

import fr.polytech.ihm.custom.ProductCataListCell;
import fr.polytech.ihm.data.Category;
import fr.polytech.ihm.data.Marque;
import fr.polytech.ihm.data.Product;
import static fr.polytech.ihm.kernel.Constantes.All;
import fr.polytech.ihm.kernel.Tools;
import static fr.polytech.ihm.kernel.Tools.getAllCategory;
import static fr.polytech.ihm.kernel.Tools.getAllMarque;
import static fr.polytech.ihm.kernel.Tools.getAllProduct;
import static fr.polytech.ihm.kernel.Tools.getCategoryProduct;
import static fr.polytech.ihm.kernel.Tools.getMaxPriceCategoryProduct;
import static fr.polytech.ihm.kernel.Tools.getMaxPriceSearchProduct;
import static fr.polytech.ihm.kernel.Tools.getSearchProduct;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FXML Controller class
 *
 * @author Olivier
 */
public class CatalogueController implements Initializable {

    private static final Logger log = LoggerFactory.getLogger(CatalogueController.class);

    @FXML
    private Slider sliderPriceMin;
    @FXML
    private Slider sliderPriceMax;
    @FXML
    private CheckBox chkBPromo;
    @FXML
    private Label lblPMin;
    @FXML
    private Label lblPMax;
    @FXML
    private ComboBox<String> cbBoxCat;
    @FXML
    private ComboBox<String> cbBoxMarque;
    @FXML
    private ListView<Product> listItem;

    private ObservableList<Product> productObservableList;

    private static int MINPRICE = 0;

    private static int MAXPRICE = 5000;

    private String currentCategory;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initCatalogue(ObservableList<Category> cats, String category) {

        currentCategory = category;

        initSliders(category);
        initCategory(cats);
        initBrand(category);
        initProduct(category);

    }

    public void initCatalogue(String search) {

        currentCategory = All.toString();

        initSlidersAll(currentCategory);
        initCategory(getAllCategory());
        initBrand(All.toString());
        initProduct(getAllProduct(search));

    }

    private void initSlidersAll(String search){
        
        float max = getMaxPriceSearchProduct(search);

        sliderPriceMin.setMin(0);
        sliderPriceMax.setMin(0);
        sliderPriceMin.setMax(max);
        sliderPriceMax.setMax(max);
        sliderPriceMax.setValue(max);
        lblPMax.setText((int) max + " €");
        
    }
    
    private void initProduct(String category) {

        productObservableList = FXCollections.observableArrayList();

        productObservableList.addAll(getCategoryProduct(category));

        listItem.setItems(productObservableList);
        listItem.setCellFactory(productlistItem -> new ProductCataListCell());

    }

    private void initProduct(ArrayList<Product> prods) {

        productObservableList = FXCollections.observableArrayList();

        productObservableList.addAll(prods);

        listItem.setItems(productObservableList);
        listItem.setCellFactory(productlistItem -> new ProductCataListCell());

    }

    private void initCategory(ObservableList<Category> cats) {
        ObservableList<String> catList = FXCollections.observableArrayList();

        catList.add("All");

        cats.stream().forEach((cat) -> {
            catList.add(cat.getCategory());
        });

        cbBoxCat.setItems(catList);

        cbBoxCat.getSelectionModel().select(currentCategory);
    }

    private void initCategory(ArrayList<Category> cats) {
        ObservableList<String> catList = FXCollections.observableArrayList();

        catList.add("All");

        cats.stream().forEach((cat) -> {
            catList.add(cat.getCategory());
        });

        cbBoxCat.setItems(catList);

        cbBoxCat.getSelectionModel().select(currentCategory);
    }

    private void initBrand(String category) {
        ObservableList<String> brandList = FXCollections.observableArrayList();

        ArrayList<Marque> marques = getAllMarque(category);

        brandList.add(All.toString());

        marques.stream().forEach((marque) -> {
            brandList.add(marque.getNom());
        });

        cbBoxMarque.setItems(brandList);

        cbBoxMarque.getSelectionModel().selectFirst();
    }

    private void initSliders(String category) {

        float max = getMaxPriceCategoryProduct(category, All.toString(), false);

        sliderPriceMin.setMin(0);
        sliderPriceMax.setMin(0);
        sliderPriceMin.setMax(max);
        sliderPriceMax.setMax(max);
        sliderPriceMax.setValue(max);
        lblPMax.setText((int) max + " €");
    }

    @FXML
    public void actuMinPrice() {
        int sliderMin = (int) sliderPriceMin.getValue();
        int sliderMax = (int) sliderPriceMax.getValue();

        if (sliderMin > sliderMax) {
            sliderPriceMax.setValue(sliderMin);
            lblPMax.setText(Integer.toString(sliderMin) + " €");
        }
        lblPMin.setText(Integer.toString(sliderMin) + " €");
    }

    @FXML
    public void actuMaxPrice() {
        int sliderMin = (int) sliderPriceMin.getValue();
        int sliderMax = (int) sliderPriceMax.getValue();

        if (sliderMax < sliderMin) {
            sliderPriceMin.setValue(sliderMax);
            lblPMin.setText(Integer.toString(sliderMax) + " €");
        }
        lblPMax.setText(Integer.toString(sliderMax) + " €");
    }

    @FXML
    private void clickListItem(MouseEvent event) {

        Product prod = (Product) listItem.getSelectionModel().getSelectedItem();

        displayItem(prod);

    }

    private void displayItem(Product product) {

        String fxmlFile = "/fxml/Item.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Stage stage = (Stage) listItem.getScene().getWindow();
            Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));

            Scene scene = new Scene(rootNode);

            scene.getStylesheets().add("/styles/DarkTheme.css");

            stage.setScene(scene);

            ((ItemController) loader.getController()).initItem(product);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clickSearch(MouseEvent event) {

        productObservableList.clear();

        productObservableList.addAll(getSearchProduct(cbBoxCat.getSelectionModel().getSelectedItem(),
                cbBoxMarque.getSelectionModel().getSelectedItem(), chkBPromo.isSelected(), (int) sliderPriceMax.getValue(), (int) sliderPriceMin.getValue()));

        listItem.setItems(productObservableList);
        listItem.setCellFactory(productlistItem -> new ProductCataListCell());

        float max = getMaxPriceCategoryProduct(cbBoxCat.getSelectionModel().getSelectedItem(), cbBoxMarque.getSelectionModel().getSelectedItem(), chkBPromo.isSelected());

        sliderPriceMax.setMax(max);
        sliderPriceMin.setMax(max);

    }

}
