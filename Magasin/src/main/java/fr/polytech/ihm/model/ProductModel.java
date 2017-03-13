package fr.polytech.ihm.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {

    private JSONObject produitsScientifique;
    private JSONObject produitsNeurologique;
    public static List<String> popularProductsID;
    private ObservableList<ProductInListView> allProductsNotInPromo = FXCollections.observableArrayList();
    private ObservableList<ProductInListView> promoNeuroProducts = FXCollections.observableArrayList();
    private ObservableList<ProductInListView> promoScienceProducts = FXCollections.observableArrayList();
    private ObservableList<ProductInListView> popularProducts = FXCollections.observableArrayList();

    public ProductModel() throws IOException, ParseException {
        produitsScientifique = (JSONObject) new JSONParser().parse(new FileReader("src/main/resources/data/produits_scientifique.json"));
        produitsNeurologique = (JSONObject) new JSONParser().parse(new FileReader("src/main/resources/data/produits_neurologique.json"));
        popularProductsID = new ArrayList<>();

        if (popularProducts.isEmpty())
            initializePopularProductList();
        allProductsNotInPromo.addAll(initializeListViewProducts(produitsScientifique));
        allProductsNotInPromo.addAll(initializeListViewProducts(produitsNeurologique));
    }

    private void initializePopularProductList() {
        popularProductsID.add("logiciel_neurovagination");
        popularProductsID.add("la_physique_aristote");
        popularProductsID.add("mayan_lunette_protection");
        popularProductsID.add("le_mal_mesure_de_lhomme");
        popularProductsID.add("microscope_opératoire");
        popularProductsID.add("mini_microscope");
    }

    public static void addPopularProduct(String productID) {
        popularProductsID.add(productID);
    }

    public static void removePopularProduct(String productID) {
        popularProductsID.remove(productID);
    }

    private ObservableList<ProductInListView> initializeListViewProducts(JSONObject data) throws IOException {
        ObservableList<ProductInListView> allProducts = FXCollections.observableArrayList();
        List<String> productID = new ArrayList<>();
        productID.addAll(data.keySet());
        for (String productData : productID) {
            ProductInListView plv;
            JSONObject product = (JSONObject) data.get(productData);
            String id = productData;
            String name = (String) product.get("nom");
            String genre = (String) product.get("genre");
            String disponible = (String) product.get("disponibilité");
            String description = (String) product.get("description");
            int price = checkCast("prix", product);
            int promo = checkCast("promo", product);
            String image;
            if ("neurologique".equals(product.get("genre")))
                image = "/images/product_neuro/" + id + ".jpg";
            else image = "/images/product_science/" + id + ".jpg";
            if (promo == 0 && popularProductsID.contains(id)) {
                plv = new ProductInListView(false);
                plv.initializeProduct(id, name, image, price, promo, disponible, description, genre);
                popularProducts.add(plv);
                allProductsNotInPromo.add(plv);
            } else if (promo != 0 && "scientifique".equals(genre)) {
                plv = new ProductInListView(true);
                plv.initializeProduct(id, name, image, price, promo, disponible, description, genre);
                promoScienceProducts.add(plv);
            } else if (promo != 0 && "neurologique".equals(genre)) {
                plv = new ProductInListView(true);
                plv.initializeProduct(id, name, image, price, promo, disponible, description, genre);
                promoNeuroProducts.add(plv);
            } else {
                plv = new ProductInListView(false);
                plv.initializeProduct(id, name, image, price, promo, disponible, description, genre);
                allProductsNotInPromo.add(plv);
            }
        }
        return allProducts;
    }

    public ObservableList<ProductInListView> getPopularProducts() {
        return popularProducts;
    }

    public ObservableList<ProductInListView> getPromoScienceProducts() {
        return promoScienceProducts;
    }

    public ObservableList<ProductInListView> getPromoNeuroProducts() {
        return promoNeuroProducts;
    }

    public ObservableList<ProductInListView> getAllProductsNotInPromo() {
        return allProductsNotInPromo;
    }

    public int checkCast(String value, JSONObject product) {
        int result;
        if (product.get(value) instanceof Double)
            result = (int) ((double) product.get(value));
        else if (product.get(value) instanceof Long)
            result = (int) ((long) product.get(value));
        else result = (int) product.get(value);
        return result;
    }

}
