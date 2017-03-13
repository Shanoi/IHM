package fr.polytech.ihm.controller;

import fr.polytech.ihm.JSONParser;
import fr.polytech.ihm.model.ProductInListView;
import fr.polytech.ihm.model.ProductListViewCell;
import fr.polytech.ihm.model.ProductModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

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
    @FXML
    private Label productName;

    private ObservableList observableList = FXCollections.observableArrayList();
    private ProductModel productModel;

    @FXML
    public void initialize() throws IOException, NoSuchFieldException, ParseException {
        productModel = new ProductModel();
        setListView(listViewNeuroProductsPromo, productModel.getPromoNeuroProducts());
        setListView(listViewScienceProductsPromo, productModel.getPromoScienceProducts());
        setListView(listViewPopularProducts, productModel.getPopularProducts());
    }

    @FXML
    void takeFocus(MouseEvent event) {
        parentNode.requestFocus();
    }

    public void setListView(ListView<ProductInListView> productsList, ObservableList<ProductInListView> products) {
        observableList = FXCollections.observableArrayList();
        observableList.addAll(products);
        productsList.setItems(observableList);
        productsList.setCellFactory(listView -> new ProductListViewCell());
    }

    @FXML
    void goProductPage(MouseEvent event) throws Exception {
        Stage stage = (Stage) productName.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Client/produitMain.fxml"));
        Parent root = loader.load();
        JSONObject staticProductInfo = new JSONParser().parse("src/main/resources/data/produits_scientifique.json");
        ((ProductMainController) loader.getController()).initProduct(initializeProduct(staticProductInfo.getJSONObject("tablette_conductivité")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        new CommonController(stage, scene);
        stage.setFullScreen(true);
        stage.show();
    }

    private ProductInListView initializeProduct(JSONObject product) {
        String name = product.getString("nom");
        String genre = product.getString("genre");
        String image = "/images/product_science/tablette_conductivité.jpg";
        int price = product.getInt("prix");
        int promo;
        if (product.get("promo") instanceof Double)
            promo = (int) ((double) product.get("promo"));
        else if (product.get("promo") instanceof Long)
            promo = (int) ((long) product.get("promo"));
        else promo = (int) product.get("promo");
        String description = product.getString("description");
        String disponible = product.getString("disponibilité");
        ProductInListView plv = new ProductInListView(false);
        plv.initializeProduct("tablette_conductivité", name, image, price, promo, disponible, description, genre);
        return plv;
    }

}

