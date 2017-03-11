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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    private Label resultLabel;

    public void initialize(){
        shopParser = new ShopParser();
        productsParser = new ProductsParser();
        insertApp = new InsertApp();

        initShopFields();

        fillShop();
        fillProducts();
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
    public void addShop(){
        if(allFieldAreCompleted()){
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

            clearAllField();
            resultLabel.setText("Effectué");
        } else {
            resultLabel.setText("Invalide");
        }
    }

    private boolean allFieldAreCompleted() {
        for (TextField textField :
                shopTextFields) {
            if (!textField.isDisable() && textField.getText().isEmpty()){
                return false;
            }
        }
        return true;
    }

    private void clearAllField(){
        for (TextField textField :
                shopTextFields) {
            textField.clear();
        }
    }
}
