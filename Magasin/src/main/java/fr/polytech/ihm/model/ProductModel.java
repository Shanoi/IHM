package fr.polytech.ihm.model;

import fr.polytech.ihm.JSONParser;
import fr.polytech.ihm.controller.ListViewProductController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
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

    public void initializeNeurologicalProductPromoView(ListView<Parent> listView) throws IOException, NoSuchFieldException {
        listView.setItems(initializeListViewPromo(currentNeurologicalProductPromo, produitsNeurologique, "neuro"));
    }

    private void initializeScientificProductPromoView(ListView<Parent> listView) throws IOException {
        listView.setItems(initializeListViewPromo(currentScientificProductPromo, produitsScientifique, "science"));
    }

    private void initializePopularProductView(ListView<Parent> listView) throws IOException {
        listView.setItems(initializeListView(currentPopularProduct, produitsScientifique, produitsNeurologique));
    }

    private ObservableList<Parent> initializeListView(List<String> listOfProducts, JSONObject... data) throws IOException {
        ObservableList<Parent> items = FXCollections.observableArrayList();
        String fileName;
        for (String str : listOfProducts) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Client/listView_product.fxml"));
            Parent productView = (Parent) loader.load();
            ListViewProductController listViewcontroller = loader.getController();
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
            listViewcontroller.initializeProduct(name, image, price);
            items.add(productView);
        }
        return items;
    }

    private ObservableList<Parent> initializeListViewPromo(List<String> listOfProducts, JSONObject data, String dataFolder) throws IOException {
        ObservableList<Parent> items = FXCollections.observableArrayList();
        for (String str : listOfProducts) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Client/listView_product_promo.fxml"));
            Parent productView = (Parent) loader.load();
            ListViewProductController listViewcontroller = loader.getController();
            JSONObject product = data.getJSONObject(str);
            String name = product.getString("nom");
            ImageView image = new ImageView();
            image.setImage(new Image("/images/product_" + dataFolder + "/" + str + ".jpg"));
            int price = product.getInt("prix");
            listViewcontroller.initializeProductPromo(name, image, price);
            items.add(productView);
        }
        return items;
    }

}
