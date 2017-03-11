package fr.polytech.ihm.model;

import fr.polytech.ihm.JSONParser;
import fr.polytech.ihm.controller.ListViewProductController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
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
    @FXML
    private ListView<Parent> currentScientificProductPromoView;
    @FXML
    private ListView<Parent> currentNeurologicalProductPromoView;
    @FXML
    private ListView<Parent> currentPopularProductPromoView;

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

    public void initializeListView() throws IOException, NoSuchFieldException {
        currentScientificProductPromoView = new ListView<>();
        currentNeurologicalProductPromoView = new ListView<>();
        currentPopularProductPromoView = new ListView<>();
        initializeScientificProductPromoView();
        initializeNeurologicalProductPromoView();
        initializePopularProductView();
    }

    private void initializeNeurologicalProductPromoView() throws IOException, NoSuchFieldException {
        ObservableList<Parent> items = FXCollections.observableArrayList();
        for (String str : currentNeurologicalProductPromo) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Client/listView_product.fxml"));
            Parent productView = (Parent) loader.load();
            ListViewProductController listViewcontroller = loader.getController();
            JSONObject neuroProduct = produitsNeurologique.getJSONObject(str);
            String name = neuroProduct.getString("nom");
            Image image = new Image("/images/product_neuro/" + str + ".jpg");
            int price = neuroProduct.getInt("prix");
            listViewcontroller.initializeProduct(name, image, price);
            items.add(productView);
        }
        currentNeurologicalProductPromoView.setItems(items);
    }

    private void initializeScientificProductPromoView() {

    }

    private void initializePopularProductView() {

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

}
