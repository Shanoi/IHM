package fr.polytech.ihm.model;

import fr.polytech.ihm.JSONParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {

    private JSONObject produitsScientifique;
    private JSONObject produitsNeurologique;
    private List<String> currentScientificProductPromo;
    private List<String> currentNeurologicalProductPromo;
    private List<String> currentPopularProduct;

    public ProductModel() throws IOException {
        produitsScientifique = new JSONParser().parse("src\\main\\resources\\data\\produits_scientifiques.json");
        produitsNeurologique = new JSONParser().parse("src\\main\\resources\\data\\produits_neurologiques.json");

        currentScientificProductPromo = new ArrayList<>();
        currentNeurologicalProductPromo = new ArrayList<>();
        currentPopularProduct = new ArrayList<>();

        initializeScientificProductPromoList();
        initializeNeurologicalProductPromoList();
        initializePopularProductList();
    }

    private void initializeNeurologicalProductPromoList() {
        currentNeurologicalProductPromo.add("casque_neurologie_eeg");
        currentNeurologicalProductPromo.add("cerveau_avec_artère");
        currentNeurologicalProductPromo.add("doppler_extracranien");
        currentNeurologicalProductPromo.add("logiciel_denregistrement");
    }

    private void initializeScientificProductPromoList() {
        currentScientificProductPromo.add("balance_industrielle");
        currentScientificProductPromo.add("chronometre_quartz");
        currentScientificProductPromo.add("horloge_orbite");
        currentScientificProductPromo.add("la_magie_du_cosmos");
    }

    private void initializePopularProductList() {
        currentPopularProduct.add("logiciel_neurovagination");
        currentPopularProduct.add("la_physique_aristote");
        currentPopularProduct.add("mayan_lunette_protection");
        currentPopularProduct.add("le_mal_mesure_de_lhomme");
        currentPopularProduct.add("microscope_opératoire");
        currentPopularProduct.add("mini_microscope");
    }

    public void initializeNeurologicalProductPromoView(ListView<ProductListView> listView) throws IOException, NoSuchFieldException {
        listView.setItems(initializeListViewPromo(currentNeurologicalProductPromo, produitsNeurologique, "neuro"));
        listView.setCellFactory(lv -> new ProductListViewCell());
    }

    private void initializeScientificProductPromoView(ListView<ProductListView> listView) throws IOException {
        listView.setItems(initializeListViewPromo(currentScientificProductPromo, produitsScientifique, "science"));
    }

    private void initializePopularProductView(ListView<ProductListView> listView) throws IOException {
        listView.setItems(initializeListView(currentPopularProduct, produitsScientifique, produitsNeurologique));
    }

    private ObservableList<ProductListView> initializeListView(List<String> listOfProducts, JSONObject... data) throws IOException {
        ObservableList<ProductListView> items = FXCollections.observableArrayList();
        String fileName;
        for (String str : listOfProducts) {
            JSONObject product = new JSONObject();
            for (JSONObject productData : data) {
                if (productData.has(str))
                    product = productData.getJSONObject(str);
            }
            String name = product.getString("nom");
            ImageView image = new ImageView();
            if ("neurologique".equals(product.get("genre")))
                image.setImage(new Image("/images/product_neuro/" + str + ".jpg"));
            else image.setImage(new Image("/images/product_science/" + str + ".jpg"));
            int price = product.getInt("prix");
            ProductListView plv = new ProductListView(false);
            plv.initializeProduct(name, image, price);
            items.add(plv);
        }
        return items;
    }

    private ObservableList<ProductListView> initializeListViewPromo(List<String> listOfProducts, JSONObject data, String dataFolder) throws IOException {
        ObservableList<ProductListView> items = FXCollections.observableArrayList();
        for (String str : listOfProducts) {
            JSONObject product = data.getJSONObject(str);
            String name = product.getString("nom");
            ImageView image = new ImageView();
            image.setImage(new Image("/images/product_" + dataFolder + "/" + str + ".jpg"));
            int price = product.getInt("prix");
            ProductListView plv = new ProductListView(true);
            plv.initializeProductPromo(name, image, price);
            items.add(plv);
        }
        return items;
    }

}
