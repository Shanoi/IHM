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
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
    private Label lblOldPrice;
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

    final Color[] colors = {Color.BLACK, Color.RED, Color.GREEN, Color.ORANGE, Color.GREY};

    final String[] families = {"System"};

    private ObservableList<Product> productObservableList;
    @FXML
    private GridPane gridPane;

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

        if (product.getCurrentPromo() > 0) {

            /*Text text = new Text(Float.toString(product.getPrixPromo()) + "€");

             text.setFill(colors[1]);
             text.setFont(Font.font(families[0], 44));
       
             gridPane.add(text, 0, 0);
            
             text = new Text(Float.toString(product.getPrix()) + "€");
            
             text.setFill(colors[0]);
             text.setFont(Font.font(families[0], 30));

             gridPane.add(text, 0, 1);*/
            lblOldPrice.setVisible(true);
            priceProd.setText(Float.toString(product.getPrixPromo()) + "€");
            priceProd.setStyle("-fx-text-fill: red;");
            lblOldPrice.setText(Float.toString(product.getPrix()) + "€");

        } else {

           /* Text text = new Text(Float.toString(product.getPrix()) + "€");

            text.setFill(colors[0]);
            text.setFont(Font.font(families[0], 44));

            gridPane.add(text, 0, 0);*/

            //lblOldPrice.setText(Float.toString(product.getPrix()) + "€");
            
            priceProd.setText(Float.toString(product.getPrix()) + "€");
            priceProd.setStyle("-fx-text-fill: #FFFFFF;");
            lblOldPrice.setVisible(false);
            
        }

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
            
            scene.getStylesheets().add("/styles/DarkTheme.css");
            
            stage.setScene(scene);
            log.info("Produit selectionné depuis la page Item : " + product.getNom());
            ((ItemController) loader.getController()).initItem(product);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
