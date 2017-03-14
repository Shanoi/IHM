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
import static fr.polytech.ihm.kernel.Tools.getAllMarque;
import static fr.polytech.ihm.kernel.Tools.getCategoryProduct;
import static fr.polytech.ihm.kernel.Tools.getMaxPriceCategoryProduct;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Olivier
 */
public class CatalogueController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initCatalogue(ObservableList<Category> cats, String category) {

        initSliders(category);
        initCategory(cats);
        initBrand(category);
        initProduct(category);

    }

    private void initProduct(String category) {

        productObservableList = FXCollections.observableArrayList();

        productObservableList.addAll(getCategoryProduct(category));

        listItem.setItems(productObservableList);
        listItem.setCellFactory(productlistItem -> new ProductCataListCell());

    }

    private void initCategory(ObservableList<Category> cats) {
        ObservableList<String> catList = FXCollections.observableArrayList();

        cats.stream().forEach((cat) -> {
            catList.add(cat.getCategory());
        });

        cbBoxCat.setItems(catList);
    }

    private void initBrand(String category) {
        ObservableList<String> catList = FXCollections.observableArrayList();

        ArrayList<Marque> marques = getAllMarque(category);

        marques.stream().forEach((marque) -> {
            catList.add(marque.getNom());
        });

        cbBoxMarque.setItems(catList);
    }

    private void initSliders(String category) {

        float max = getMaxPriceCategoryProduct(category);

        sliderPriceMin.setMin(0);
        sliderPriceMax.setMin(0);
        sliderPriceMin.setMax(max);
        sliderPriceMax.setMax(max);
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
            stage.setScene(scene);

            ((ItemController) loader.getController()).initItem(product);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
