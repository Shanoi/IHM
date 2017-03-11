package fr.polytech.ihm.controllers;

import fr.polytech.ihm.data.Product;
import fr.polytech.ihm.data.Shop;
import fr.polytech.ihm.kernel.InsertApp;
import fr.polytech.ihm.kernel.ProductsParser;
import fr.polytech.ihm.kernel.ShopParser;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enzo on 11/03/2017.
 */
public class AdminPanelController {

    private ShopParser shopParser;
    private ProductsParser productsParser;

    private InsertApp insertApp;

    private List<TextField> shopTextFields;
    private List<TextField> productTextFields;

    @FXML
    private TabPane adminPanel;

    @FXML
    private TableView<Product> productList;

    @FXML
    private TableColumn<Product, String> nameProduct;

    @FXML
    private TableColumn<Product, String> catProduct;

    @FXML
    private TableColumn<Product, String> brandProduct;

    @FXML
    private TableColumn<Product, String> nbSold;

    @FXML
    private TableView<Shop> shopList;

    @FXML
    private TableColumn<Shop, String> nameShop;

    @FXML
    private TableColumn<Shop, String> adressShop;

    @FXML
    private TableColumn<Shop, String> phoneShop;

    @FXML
    private TextField nameShopField;

    @FXML
    private TextField adressShopField;

    @FXML
    private TextField latShopField;

    @FXML
    private TextField longShopField;

    @FXML
    private TextField phoneShopField;

    @FXML
    private TextField mailShopField;

    @FXML
    private TextField webShopField;

    @FXML
    private TextField nbEmpShopField;

    @FXML
    private TextField costShopField;

    @FXML
    private TextField nameProductField;

    @FXML
    private TextField imageProductField;

    @FXML
    private TextField brandProductField;

    @FXML
    private TextField catProductField;

    @FXML
    private TextField catNameField;

    @FXML
    private TextArea descProductField;

    @FXML
    private Label resultLabel;

    @FXML
    private Label resultLabelProduct;

    public void initialize(){
        shopParser = new ShopParser();
        productsParser = new ProductsParser();
        insertApp = new InsertApp();

        catProductField.textProperty().addListener((observable, oldValue, newValue) -> checkCategory());

        initShopFields();
        initProductFields();

        fillShop();
        fillProducts();

        adminPanel.getSelectionModel().selectedIndexProperty().addListener((ov, oldValue, newValue) -> {
            int productTab = 0;
            int shopTab = 2;

            if (newValue.intValue() == productTab){
                fillProducts();
            }

            if (newValue.intValue() == shopTab){
                fillShop();
            }
        });
    }

    private void initProductFields(){
        this.productTextFields = new ArrayList<>();

        productTextFields.add(nameProductField);
        productTextFields.add(imageProductField);
        productTextFields.add(brandProductField);
        productTextFields.add(catProductField);
        productTextFields.add(catNameField);
    }

    private void initShopFields(){
        this.shopTextFields = new ArrayList<>();

        shopTextFields.add(nameShopField);
        shopTextFields.add(adressShopField);
        shopTextFields.add(latShopField);
        shopTextFields.add(longShopField);
        shopTextFields.add(phoneShopField);
        shopTextFields.add(mailShopField);
        shopTextFields.add(webShopField);
        shopTextFields.add(nbEmpShopField);
        shopTextFields.add(costShopField);
    }

    private void fillProducts(){
        ObservableList<Product> products = FXCollections.observableArrayList();

        products.addAll(productsParser.getProducts());

        nameProduct.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
        catProduct.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategory()));
        brandProduct.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdMarque() + ""));
        nbSold.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNbSell() + ""));

        productList.setItems(products);

    }

    private void fillShop(){
        ObservableList<Shop> shops = FXCollections.observableArrayList();

        shops.addAll(shopParser.getShop());

        nameShop.setCellValueFactory(cellData -> cellData.getValue().getNameShop());
        adressShop.setCellValueFactory(cellData -> cellData.getValue().getAdressShop());
        phoneShop.setCellValueFactory(cellData -> cellData.getValue().getPhoneShop());

        shopList.setItems(shops);
    }

    @FXML
    public void addProduct(){
        if(allFieldAreCompleted(productTextFields) && !descProductField.getText().isEmpty()){
            insertApp.insertProduct(nameProductField.getText(),
                    descProductField.getText(),
                    Integer.parseInt(brandProductField.getText()),
                    imageProductField.getText(),
                    catProductField.getText());

            clearAllField(productTextFields);
            descProductField.clear();
            resultLabelProduct.setText("Effectué");
        } else {
            resultLabelProduct.setText("Invalide");
        }
    }

    @FXML
    public void addShop(){
        if(allFieldAreCompleted(shopTextFields)){
            insertApp.insertMagasin(nameShopField.getText(),
                    adressShopField.getText(),
                    Double.parseDouble(latShopField.getText()),
                    Double.parseDouble(longShopField.getText()),
                    phoneShopField.getText(),
                    mailShopField.getText(),
                    0,
                    Integer.parseInt(nbEmpShopField.getText()),
                    Double.parseDouble(costShopField.getText()),
                    webShopField.getText(),
                    0);

            clearAllField(shopTextFields);
            resultLabel.setText("Effectué");
        } else {
            resultLabel.setText("Invalide");
        }
    }

    public void checkCategory(){
        if (catAlreadyExists(catProductField.getText())){
            catNameField.setDisable(true);
            catNameField.clear();
        } else {
            catNameField.setDisable(false);
        }
    }

    private boolean catAlreadyExists(String category){

        try {

            Class.forName("org.sqlite.JDBC").newInstance();
            System.out.println("Chargement du Driver Réussie");

            Connection cnx = DriverManager.getConnection("jdbc:sqlite:magasin.sqlite");
            System.out.println("Connexion Réussie");

            Statement lien = cnx.createStatement();
            System.out.println("Lien Créé");

            String query = "select COUNT(*) AS nbL "
                    + "from category "
                    + "WHERE category = \'" + category + "\'";

            ResultSet rs = lien.executeQuery(query);
            System.out.println("Requête Effectuée");

            boolean isTrue = rs.getInt("nbL") != 0;
            
            rs.close();
            lien.close();
            cnx.close();
            
            return isTrue;


        } catch (Exception e) {

            System.out.println("Le Programme a Echoué :/ \n" + e.getMessage());

        }

        return false;

    }

    private boolean allFieldAreCompleted(List<TextField> textFields) {
        for (TextField textField :
                textFields) {
            if (!textField.isDisable() && textField.getText().isEmpty()){
                return false;
            }
        }
        return true;
    }

    private void clearAllField(List<TextField> textFields){
        for (TextField textField :
                textFields) {
            textField.clear();
        }
    }
}
