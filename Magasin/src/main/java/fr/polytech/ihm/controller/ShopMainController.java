package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.ProductInListView;
import fr.polytech.ihm.model.ProductListViewCell;
import fr.polytech.ihm.model.ProductModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import java.io.IOException;

/**
 * @author Jérémy LARA
 * @version 1.0
 *          Represents the main shop view controller.
 */
public class ShopMainController {

    @FXML
    private BorderPane parentNode;
    @FXML
    private ListView<ProductInListView> listViewPopularProducts;
    @FXML
    private ListView<ProductInListView> listViewNeuroProductsPromo;
    @FXML
    private ListView<ProductInListView> listViewScienceProductsPromo;

    private ObservableList observableList = FXCollections.observableArrayList();
    private ProductModel productModel;

    public ShopMainController() {

    }

    public void initialize() throws IOException, NoSuchFieldException {
        productModel = new ProductModel();
        setListView(listViewNeuroProductsPromo, productModel.initializeNeurologicalProductPromoView());
        setListView(listViewScienceProductsPromo, productModel.initializeScientificProductPromoView());
        setListView(listViewPopularProducts, productModel.initializePopularProductView());
    }

    @FXML
    void takeFocus(MouseEvent event) {
        parentNode.requestFocus();
    }

    public void setListView(ListView<ProductInListView> productsList, ObservableList<ProductInListView> products){
        observableList = FXCollections.observableArrayList();
        observableList.addAll(products);
        productsList.setItems(observableList);
        productsList.setCellFactory(listView -> new ProductListViewCell());
    }

}

