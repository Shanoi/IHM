package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.ProductListView;
import fr.polytech.ihm.model.ProductModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

/**
 * @author Jérémy LARA
 * @version 1.0
 *          Represents the main shop view controller.
 */
public class ShopMainController {

    @FXML
    private BorderPane parentNode;
    @FXML
    private ListView<ProductListView> listViewPopularProducts;
    @FXML
    private ListView<ProductListView> listViewNeuroProductsPromo;
    @FXML
    private ListView<ProductListView> listViewScienceProductsPromo;
    private ProductModel productModel;

    public ShopMainController() {

    }

    public void initialize() throws IOException, NoSuchFieldException {
        productModel = new ProductModel();
        productModel.initializeNeurologicalProductPromoView(listViewNeuroProductsPromo);
    }

    @FXML
    void takeFocus(MouseEvent event) {
        parentNode.requestFocus();
    }

}

