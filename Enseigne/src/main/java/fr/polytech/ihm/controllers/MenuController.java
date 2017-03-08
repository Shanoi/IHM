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
    void clickedOnLogo(MouseEvent event) {

    }

    @FXML
    void goToAboutUsView(MouseEvent event) throws IOException {
        Stage stage;

        if (event.getButton() == MouseButton.PRIMARY){
            stage = (Stage)  aboutUsButton.getScene().getWindow();
            startViewAboutUs(stage);
        }
    }

    @FXML
    void goToShopsViews(MouseEvent event) {

    }

    @FXML
    void goToSearchView(KeyEvent event) {

    }

    @FXML
    private void startViewAboutUs(Stage stage) throws IOException {
        String fxmlFile = "/fxml/savoirplus.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        Scene scene = new Scene(rootNode, 1920, 1080);
        scene.getStylesheets().add("/styles/styles.css");

        stage.setTitle("To be or To Have");
        stage.setScene(scene);
        stage.show();
    }
}
