package fr.polytech.ihm.model;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Random;

/**
 * Created by Kovox on 11/03/2017.
 */
public class ProductListView {

    @FXML
    private Pane productListView;

    @FXML
    private Label productName;

    @FXML
    private ImageView productImage;

    @FXML
    private Label price;

    @FXML
    private Text oldPrice;

    @FXML
    private Label newPrice;

    @FXML
    private Label reduction;

    private int[] reduc = {15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70};



    public ProductListView(boolean promo) throws IOException {
        FXMLLoader loader;
        if (promo)
            loader = new FXMLLoader(getClass().getResource("/fxml/Client/listView_product_promo.fxml"));
        else loader = new FXMLLoader(getClass().getResource("/fxml/Client/listView_product.fxml"));
        loader.load();
    }

    public void initializeProduct(String name, ImageView image, int price) {
        productName.setText(name);
        this.productImage = image;
        this.price.setText(Integer.toString(price));
    }

    public void initializeProductPromo(String name, ImageView image, int price) {
        productName.setText(name);
        this.productImage = image;
        Random r = new Random();
        int reductionNb = reduc[r.nextInt(reduc.length)];
        oldPrice.setText(Integer.toString(price));
        oldPrice.setStrikethrough(true);
        newPrice.setText(Integer.toString((1 - reductionNb / 100)*price));
        reduction.setText("-" + Integer.toString(reductionNb) + "%");
    }

    public Pane getParent() {
        return productListView;
    }

}
