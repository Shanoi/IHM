package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.ProductInListView;
import fr.polytech.ihm.model.ProductModel;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AdminController {

    //Changer données magasin
    @FXML
    private TextField changeAdresse;
    @FXML
    private TextField changeNum;
    @FXML
    private TextField changeSite;
    @FXML
    private Label applyNotif;

    //Ajouter promo
    @FXML
    private TextField addPromoAmount;
    @FXML
    private ComboBox<ProductInListView> productListAdd;
    @FXML
    private Label addNotif;

    //Supprimer promo
    @FXML
    private ComboBox<ProductInListView> productListSupp;
    @FXML
    private TextField suppPromoCurrentAmount;
    @FXML
    private Label suppNotif;

    //Modifier promo
    @FXML
    private TextField modifPromoAmount;
    @FXML
    private TextField modifPromoCurrentAmount;
    @FXML
    private ComboBox<ProductInListView> productListModif;
    @FXML
    private Label modifNotif;

    private ObservableList<ProductInListView> productListInPromo = FXCollections.observableArrayList();
    private ObservableList<ProductInListView> productListNotInPromo = FXCollections.observableArrayList();
    private JSONObject produitsScientifiques;
    private JSONObject produitsNeurologiques;
    private ProductInListView currentAddName;
    private ProductInListView currentModifName;
    private ProductInListView currentSuppName;
    private static final String NO_PRODUCT = "Aucun produit spécifié";
    private static final String PATH = "src\\main\\resources\\data\\produits_";

    @FXML
    public void initialize() throws IOException, ParseException {
        produitsScientifiques = (JSONObject) new JSONParser().parse(new FileReader("src\\main\\resources\\data\\produits_scientifique.json"));
        produitsNeurologiques = (JSONObject) new JSONParser().parse(new FileReader("src\\main\\resources\\data\\produits_neurologique.json"));
        applyNotif.setText(null);
        addNotif.setText(null);
        modifNotif.setText(null);
        suppNotif.setText(null);
        initProductList();
    }

    @FXML
    void checkInBoxAdd(ActionEvent event) {
        currentAddName = productListAdd.getValue();
    }

    @FXML
    void checkInBoxModif(ActionEvent event) {
        modifPromoCurrentAmount.setText(Integer.toString(productListModif.getValue().getPromo()) + "%");
        currentModifName = productListModif.getValue();
    }

    @FXML
    void checkInBoxSupp(ActionEvent event) {
        suppPromoCurrentAmount.setText(Integer.toString(productListSupp.getValue().getPromo()) + "%");
        currentSuppName = productListSupp.getValue();
    }

    @FXML
    void addPromo(ActionEvent event) throws IOException, ParseException {
        if (productListAdd.getValue() == null) {
            addNotif.setText(NO_PRODUCT);
            makeTimeLine(addNotif, 5);
            return;
        }
        if ("".equals(addPromoAmount.getText()) || checkBound(addPromoAmount.getText())) {
            addNotif.setText("Valeur entre 15 et 75 uniquement");
            makeTimeLine(addNotif, 10);
            return;
        }
        String genre = currentAddName.getGenre();
        JSONParser parser = new JSONParser();
        String url = PATH + genre + ".json";
        Object obj = parser.parse(new FileReader(url));
        JSONObject newData = (JSONObject) obj;
        JSONObject product = (JSONObject) newData.get(currentAddName.getProductID());
        product.put("promo", Integer.parseInt(addPromoAmount.getText()));
        newData.put(currentAddName.getProductID(), product);
        writeFile(newData, url);
        initialize();
        addPromoAmount.setText(null);
        addNotif.setText("Promotion Ajoutée");
        makeTimeLine(addNotif, 5);
    }

    @FXML
    void modifyPromo(ActionEvent event) throws IOException, ParseException {
        if (productListModif.getValue() == null) {
            modifNotif.setText(NO_PRODUCT);
            makeTimeLine(modifNotif, 5);
            return;
        }
        if ("".equals(modifPromoAmount.getText()) || checkBound(modifPromoAmount.getText())) {
            modifNotif.setText("Valeur entre 15 et 75 uniquement");
            makeTimeLine(modifNotif, 10);
            return;
        }
        String genre = currentModifName.getGenre();
        JSONParser parser = new JSONParser();
        String url = PATH + genre + ".json";
        Object obj = parser.parse(new FileReader(url));
        JSONObject newData = (JSONObject) obj;
        JSONObject product = (JSONObject) newData.get(currentModifName.getProductID());
        product.put("promo", Integer.parseInt(modifPromoAmount.getText()));
        newData.put(currentModifName.getProductID(), product);
        writeFile(newData, url);
        initialize();
        modifPromoAmount.setText(null);
        modifPromoCurrentAmount.setText(null);
        modifNotif.setText("Promotion Modifiée");
        makeTimeLine(modifNotif, 5);
    }

    @FXML
    void suppPromo(ActionEvent event) throws IOException, ParseException {
        if (productListSupp.getValue() == null) {
            suppNotif.setText(NO_PRODUCT);
            makeTimeLine(suppNotif, 5);
            return;
        }
        String genre = currentSuppName.getGenre();
        JSONParser parser = new JSONParser();
        String url = PATH + genre + ".json";
        Object obj = parser.parse(new FileReader(url));
        JSONObject newData = (JSONObject) obj;
        JSONObject product = (JSONObject) newData.get(currentSuppName.getProductID());
        product.put("promo", 0);
        newData.put(currentSuppName.getProductID(), product);
        writeFile(newData, url);
        initialize();
        suppPromoCurrentAmount.setText(null);
        suppNotif.setText("Promotion Supprimée");
        makeTimeLine(suppNotif, 5);
    }

    @FXML
    void applyChangements(ActionEvent event) throws IOException, ParseException, InterruptedException {
        JSONParser parser = new JSONParser();
        String url = "src\\main\\resources\\data\\magasins_data.json";
        Object obj = parser.parse(new FileReader(url));
        JSONObject newData = (JSONObject) obj;
        if (checkEmpty()) {
            makeTimeLine(applyNotif, 5);
            return;
        }
        if (!changeAdresse.getText().isEmpty()) {
            newData.put("adresse", changeAdresse.getText());
        }
        if (!changeNum.getText().isEmpty()) {
            newData.put("tel", changeNum.getText());
        }
        if (!changeSite.getText().isEmpty()) {
            newData.put("siteweb", changeSite.getText());
        }
        applyNotif.setText("Changements appliqués.");
        writeFile(newData, url);
        makeTimeLine(applyNotif, 5);
    }

    public boolean checkEmpty() throws InterruptedException {
        if (changeNum.getText().isEmpty() && changeAdresse.getText().isEmpty() && changeSite.getText().isEmpty()) {
            applyNotif.setText("Aucun changement mentionné.");
            return true;
        }
        return false;
    }

    public void writeFile(JSONObject data, String url) throws IOException {
        try (FileWriter file = new FileWriter(url)) {
            file.write(data.toJSONString());
            file.flush();
        }
    }

    public void initProductList() throws IOException, ParseException {
        ProductModel productData = new ProductModel();
        productListInPromo = FXCollections.observableArrayList();
        productListNotInPromo = FXCollections.observableArrayList();
        productListNotInPromo.addAll(productData.getAllProductsNotInPromo());
        productListInPromo.addAll(productData.getPromoScienceProducts());
        productListInPromo.addAll(productData.getPromoNeuroProducts());
        productListAdd.setItems(productListNotInPromo);
        productListModif.setItems(productListInPromo);
        productListSupp.setItems(productListInPromo);
    }

    public boolean checkBound(String promoAmount) {
        int promo = Integer.parseInt(promoAmount);
        return (promo <= 15) || (promo >= 70);
    }

    public void makeTimeLine(Label label, int seconds) {
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(seconds), new KeyValue(label.textProperty(), "")));
        timeline.play();
    }

}
