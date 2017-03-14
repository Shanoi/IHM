/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.controllers;

import fr.polytech.ihm.custom.ProductListCell;
import fr.polytech.ihm.data.Category;
import fr.polytech.ihm.data.Marque;
import static fr.polytech.ihm.kernel.Tools.getAllMarque;
import static fr.polytech.ihm.kernel.Tools.getCategoryProduct;
import static fr.polytech.ihm.kernel.Tools.getMaxPriceCategoryProduct;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fr.polytech.ihm.data.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FXML Controller class
 */
public class CatalogueController implements Initializable {



    private static final Logger log = LoggerFactory.getLogger(ItemController.class);

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
    private ListView listProduct;

    private static int MINPRICE = 0;

    private static int MAXPRICE = 5000;


    private ObservableList<Product> productObservableList;

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


    public void initProduct(Product product) {

        productObservableList = FXCollections.observableArrayList();

        productObservableList.addAll(getCategoryProduct(product.getCategory()));

        System.out.println("LIST : " + getCategoryProduct(product.getCategory()));

        listProduct.setItems(productObservableList);
        log.info("Produit selectionné : " + product.getNom());
        //nomProd.setText(product.getNom());
        Image image = new Image(getClass().getClassLoader().getResourceAsStream("images/" + product.getImage()));
  /*
        imgProd.setImage(image);
        descrProd.setText(product.getDescription());
*/
    }

    @FXML
    private void clickListProduct(MouseEvent event) {
        Product prod = (Product) listProduct.getSelectionModel().getSelectedItem();
        System.out.println(prod.getNom());
        displayProduct(prod);
    }

    private void displayProduct(Product product) {
        String fxmlFile = "/fxml/productCell.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Stage stage = (Stage) listProduct.getScene().getWindow();
            Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));
            Scene scene = new Scene(rootNode);
            stage.setScene(scene);
            ((CatalogueController) loader.getController()).initProduct(product);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


/*
    private void displayShops(ObservableList<Product> productList){
        cleanShops();
        ObservableList<Product> products = productList;
        String[] lettres={"A","B"};
        int shop=0;
        int line=1;
        int column=0;

        for(int lettre=0;lettre<lettres.length;lettre++){
            ImageView imageLettre=new ImageView("/images/catalogueView/lettres/"+lettres[lettre]+".PNG");
            imageLettre.setFitHeight(100);
            imageLettre.setFitWidth(100);
            shopsGridPane.add(imageLettre,column,line);
            line++;
            while (shop!=products.size() && products.get(shop).getName().startsWith(lettres[lettre])){
                ImageView imageShop=new ImageView(products.get(shop).getImage());
                imageShop.setFitHeight(100);
                imageShop.setFitWidth(100);
                shopsGridPane.add(imageShop,column,line);
                column++;
                if(column>9){
                    column=0;
                    line++;
                }
                shop++;
            }
            line++;
            column=0;
        }
    }

    private void cleanShops(){
        while(shopsGridPane.getChildren().size()!=0){
            shopsGridPane.getChildren().remove(0);
        }
    }
*/
}
