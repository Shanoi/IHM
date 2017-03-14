/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.controllers;

import fr.polytech.ihm.custom.ProductListCell;
import fr.polytech.ihm.data.Product;
import fr.polytech.ihm.kernel.Tools;
import static fr.polytech.ihm.kernel.Tools.getCategoryProduct;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FXML Controller class
 *
 * @author Olivier
 */
public class ItemController implements Initializable {

    private static final Logger log = LoggerFactory.getLogger(ItemController.class);

    @FXML
    private ImageView imgProd;
    @FXML
    private Label descrProd;
    @FXML
    private Label priceProd;
    @FXML
    private Label dispoProd;
    @FXML
    private Label nomProd;
    @FXML
    private ListView listItem;

    private ObservableList<Product> productObservableList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initItem(Product product) {

        productObservableList = FXCollections.observableArrayList();

        productObservableList.addAll(getCategoryProduct(product.getCategory()));

        System.out.println("LIST : " + getCategoryProduct(product.getCategory()));

        listItem.setItems(productObservableList);
        listItem.setCellFactory(productlistItem -> new ProductListCell());

        log.info("Produit selectionné : " + product.getNom());

        nomProd.setText(product.getNom());

        priceProd.setText(Float.toString(product.getPrix()));
        
        Image image = new Image(getClass().getClassLoader().getResourceAsStream("images/" + product.getImage()));

        imgProd.setImage(image);

        descrProd.setText(product.getDescription());

    }

    @FXML
    private void clickListItem(MouseEvent event) {

        Product prod = (Product) listItem.getSelectionModel().getSelectedItem();

        System.out.println(prod.getNom());

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
            log.info("Produit selectionné depuis la page Item : " + product.getNom());
            ((ItemController) loader.getController()).initItem(product);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
