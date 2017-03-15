package fr.polytech.ihm.controllers;

import fr.polytech.ihm.data.Product;
import fr.polytech.ihm.data.Shop;
import fr.polytech.ihm.kernel.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enzo on 11/03/2017.
 */
public class AdminPanelController {

    private ShopParser shopParser;
    private ProductsParser productsParser;
    private InfosEnseigneParser infosEnseigneParser;

    private CheckerTool checkerTool;
    private InsertApp insertApp;
    private UpdateApp updateApp;

    private List<TextField> shopTextFields;
    private List<TextField> productTextFields;
    private List<TextField> enseigneFields;

    int productTab = 0;
    int addProductTab = 1;
    int shopTab = 2;
    int addShopTab = 3;
    int infosEnseigneTab = 4;

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

    @FXML
    private TextField descEnseigneField;

    @FXML
    private TextField logoTextField;

    @FXML
    private Label confirmationEnseigne;

    public void initialize(){
        shopParser = new ShopParser();
        productsParser = new ProductsParser();
        insertApp = new InsertApp();
        checkerTool = new CheckerTool();
        infosEnseigneParser = new InfosEnseigneParser();
        updateApp = new UpdateApp();

        catProductField.textProperty().addListener((observable, oldValue, newValue) -> checkCategory());

        initShopFields();
        initProductFields();
        initEnseigneFields();

        fillShop();
        fillProducts();
        fillEnseigne();

        adminPanel.getSelectionModel().selectedIndexProperty().addListener((ov, oldValue, newValue) -> {

            if (newValue.intValue() == productTab){
                fillProducts();
            }

            if (newValue.intValue() == shopTab){
                fillShop();
            }

            if (newValue.intValue() == infosEnseigneTab){
                fillEnseigne();
            }

            if (newValue.intValue() == addProductTab) {
                resultLabelProduct.setText("");
            }

            if (newValue.intValue() == addShopTab) {
                resultLabel.setText("");
            }
        });
    }

    private void initEnseigneFields(){
        this.enseigneFields = new ArrayList<>();

        enseigneFields.add(logoTextField);
        enseigneFields.add(descEnseigneField);
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

        productList.setRowFactory(tv -> {
            TableRow<Product> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (! row.isEmpty() && event.getButton()== MouseButton.PRIMARY) {

                    Product clickedRow = row.getItem();
                    String fxmlFile = "/fxml/ProductInfos.fxml";
                    FXMLLoader loader = new FXMLLoader();
                    try {
                        Stage stage = new Stage();
                        Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));

                        Scene scene = new Scene(rootNode);
                        stage.setScene(scene);
                        ((ProductInfosController)loader.getController()).initInfosProd(clickedRow);
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row ;
        });
    }

    private void fillShop(){
        ObservableList<Shop> shops = FXCollections.observableArrayList();

        shops.addAll(shopParser.getShop());

        nameShop.setCellValueFactory(cellData -> cellData.getValue().getNameShop());
        adressShop.setCellValueFactory(cellData -> cellData.getValue().getAdressShop());
        phoneShop.setCellValueFactory(cellData -> cellData.getValue().getPhoneShop());

        shopList.setItems(shops);

        shopList.setRowFactory(tv -> {
            TableRow<Shop> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (! row.isEmpty() && event.getButton()== MouseButton.PRIMARY) {

                    Shop clickedRow = row.getItem();
                    String fxmlFile = "/fxml/infosShop.fxml";
                    FXMLLoader loader = new FXMLLoader();
                    try {
                        Stage stage = new Stage();
                        Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));

                        Scene scene = new Scene(rootNode);
                        stage.setScene(scene);
                        ((InfosShopController)loader.getController()).initInfosShop(clickedRow);
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row ;
        });
    }

    @FXML
    public void fillEnseigne(){
        infosEnseigneParser.extractData();

        logoTextField.setText(infosEnseigneParser.getImagePath());
        descEnseigneField.setText(infosEnseigneParser.getDescEnseigne());
    }

    @FXML
    public void addProduct(){
        try{
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
    } catch (NumberFormatException e){
        resultLabelProduct.setText("Invalide");
        System.out.println("Wrong input in a text fields");
    }
    }

    @FXML
    public void addShop(){
        try{
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
    } catch (NumberFormatException e){
        resultLabel.setText("Invalide");
        System.out.println("Wrong input in a text fields");
    }
    }

    @FXML
    public void saveEnseigne(){

        if (allFieldAreCompleted(enseigneFields)){
            updateApp.updateEnseigne(1,
                    logoTextField.getText(),
                    descEnseigneField.getText());

            confirmationEnseigne.setText("Effectué");
        } else {
            resultLabel.setText("Invalide");
        }

    }

    public void checkCategory(){
        if (checkerTool.catAlreadyExists(catProductField.getText())){
            catNameField.setDisable(true);
            catNameField.clear();
        } else {
            catNameField.setDisable(false);
        }
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
