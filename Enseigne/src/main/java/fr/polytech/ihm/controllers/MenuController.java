package fr.polytech.ihm.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Enzo on 08/03/2017.
 *
 * Ajouter l'image des catégories dans la BD
 *
 */
public class MenuController {
    @FXML
    private ImageView logoCompany;

    @FXML
    private TextField searchBar;

    @FXML
    private Button shopsButton;

    @FXML
    private Button aboutUsButton;

    @FXML
    private ImageView cd;

    @FXML
    void clickedOnLogo(MouseEvent event) throws IOException {
        Stage stage;

        if (event.getButton() == MouseButton.PRIMARY){
            stage = (Stage)  aboutUsButton.getScene().getWindow();
            startMainView(stage);
        }
    }

    @FXML
    void goToAboutUsView(MouseEvent event) throws IOException {
        Stage stage;

        if (event.getButton() == MouseButton.PRIMARY){
            stage = (Stage)  aboutUsButton.getScene().getWindow();
            startAboutUsView(stage, 0);
        }
    }

    @FXML
    void goToShopsViews(MouseEvent event) throws IOException {
        Stage stage;

        if (event.getButton() == MouseButton.PRIMARY){
            stage = (Stage)  aboutUsButton.getScene().getWindow();
            startAboutUsView(stage, 1);
        }
    }

    @FXML
    void goToCatalogCDView(MouseEvent event) throws IOException {
        Stage stage;

        if (event.getButton() == MouseButton.PRIMARY){
            stage = (Stage)  cd.getScene().getWindow();
            startCatalogCDView(stage);
        }
    }

    @FXML
    void goToSearchView(KeyEvent event) {

    }

    private void startAboutUsView(Stage stage, int tabID) throws IOException {
        String fxmlFile = "/fxml/testSp.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = fxmlLoader.load();

        SavoirPlusController savoirPlusController = fxmlLoader.getController();
        savoirPlusController.setTabView(tabID);

        Scene scene = new Scene(root, 1920, 1080);
        scene.getStylesheets().add("/styles/styles.css");
        stage.setTitle("To be or To Have");

        stage.setScene(scene);
        stage.show();
    }

    private void startMainView(Stage stage) throws IOException {
        String fxmlFile = "/fxml/MainPage.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 1920, 1080);
        scene.getStylesheets().add("/styles/styles.css");
        stage.setTitle("To be or To Have");

        stage.setScene(scene);
        stage.show();
    }


    private void startCatalogCDView(Stage stage) throws IOException{
        String fxmlFile = "/fxml/searchFinal.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 1920, 1080);
        scene.getStylesheets().add("/styles/styles.css");
        stage.setTitle("To be or To Have: Catalog");

        stage.setScene(scene);
        stage.show();
    }
}
