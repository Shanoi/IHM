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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.JSONObject;

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
    private VBox newProductSciences1;
    @FXML
    private Label productName;
    @FXML
    private ImageView imageProduct;
    @FXML


    private ObservableList observableList = FXCollections.observableArrayList();
    private ProductModel productModel;

    public ShopMainController() {

    }

    @FXML
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
        JSONObject staticProductInfo = new JSONParser().parse("src\\main\\resources\\data\\produits_scientifiques.json");
        ((ProductMainController) loader.getController()).initProduct(initializeProduct(staticProductInfo.getJSONObject("tablette_condictivité")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        new CommonController(stage, scene);
        stage.show();
    }

    public ProductInListView initializeProduct(JSONObject product) {
        String name = product.getString("nom");
        Image image = new Image("/images/product_science/tablette_conductivite.jpg");
        int price = product.getInt("prix");
        String description = product.getString("description");
        String disponible = product.getString("disponibilité");
        ProductInListView plv = new ProductInListView(true);
        plv.initializeProduct(name, image, price, disponible, description);
        return plv;
    }

}

