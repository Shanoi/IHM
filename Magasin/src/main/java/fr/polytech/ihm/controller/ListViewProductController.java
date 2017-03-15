package fr.polytech.ihm.controller;

import fr.polytech.ihm.MagasinApp;
import fr.polytech.ihm.model.ProductInListView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * @author Jérémy LARA
 * @version 1.0
 *          Represents the main lower band (directionsCommon) controller class.
 *          It allows to go on the directions page and handle directions button.
 */
public class ListViewProductController {

    @FXML
    private Label productName;
    @FXML
    private ImageView productImage;
    @FXML
    private Label price;

    private ProductInListView productTemp;

    @FXML
    void goProductPage(MouseEvent event) throws Exception {
        Stage stage = (Stage) productName.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(MagasinApp.PREFIXE + "Client/produitMain.fxml"));
        Parent root = loader.load();
        ((ProductMainController) loader.getController()).initProduct(productTemp);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        new CommonController(stage, scene);
        stage.setFullScreen(true);
        stage.show();
    }

    public void initializeProduct(ProductInListView product) {
        productTemp = product;
        productName.setText(product.getName());
        Image image = new Image(getClass().getResource(product.getImage()).toExternalForm());
        productImage.setImage(image);
        price.setText(Integer.toString(product.getPrice()) + "€");
    }

}
