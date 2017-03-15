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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ListViewProductPromoController {

    @FXML
    private Label productName;
    @FXML
    private ImageView imageProductPromo;
    @FXML
    private Text oldPrice;
    @FXML
    private Label newPrice;
    @FXML
    private Label reduction;

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
        imageProductPromo.setImage(image);
        oldPrice.setText(Integer.toString(product.getPrice()) + "€");
        oldPrice.setStrikethrough(true);
        newPrice.setText(Integer.toString((int) ((1 - ((double) product.getPromo() / 100)) * product.getPrice())) + "€");
        reduction.setText("-" + Double.toString(product.getPromo()) + "%");
    }

}
