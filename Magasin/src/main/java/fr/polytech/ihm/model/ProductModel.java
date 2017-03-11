package fr.polytech.ihm.model;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class ProductModel {

    private JSONObject produitsScientifique;
    private JSONObject produitsNeurologique;
    private List<String> currentScientificProductPromo;
    private List<String> currentNeurologicalProductPromo;
    private List<String> currentPopularProduct;
    @FXML
    private ListView<FXML> currentScientificProductPromoView;
    @FXML
    private ListView<FXML> currentNeurologicalProductPromoView;
    @FXML
    private ListView<FXML> currentPopularProductPromoView;

    public ProductModel() {
        produitsScientifique = new JSONObject("data/produits_scientifiques.json");
        produitsNeurologique = new JSONObject("data/produits_neurologiques.json");
        initializeScientificProductPromoList();
        initializeNeurologicalProductPromoList();
        initializePopularProductList();
    }

    @FXML
    public void initialize() throws IOException, NoSuchFieldException {
        currentScientificProductPromoView = new ListView<>();
        currentNeurologicalProductPromoView = new ListView<>();
        currentPopularProductPromoView = new ListView<>();
        initializeScientificProductPromoView();
        initializeNeurologicalProductPromoView();
        initializePopularProductView();
    }

    private void initializeNeurologicalProductPromoView() throws IOException, NoSuchFieldException {
        ObservableList<FXML> items;
        for (String str : currentNeurologicalProductPromo) {
            Parent productView = FXMLLoader.load(getClass().getResource("/fxml/listView_product_promo.fxml"));
            JSONObject neuroProduct = produitsNeurologique.getJSONObject(str);
            String name = neuroProduct.getString("nom");
        }
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
