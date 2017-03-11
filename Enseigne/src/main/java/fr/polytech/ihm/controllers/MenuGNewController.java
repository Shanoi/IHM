/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.controllers;

import fr.polytech.ihm.custom.CategoryListCell;
import fr.polytech.ihm.data.Category;
import static fr.polytech.ihm.kernel.Tools.getAllCategory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Olivier
 */
public class MenuGNewController implements Initializable {

    @FXML
    private ImageView logoCompany;
    @FXML
    private Button shopsButton;
    @FXML
    private Button aboutUsButton;
    @FXML
    private ListView listCat;

    private ObservableList<Category> catObservableList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        catObservableList = FXCollections.observableArrayList();

        catObservableList.addAll(getAllCategory());

        listCat.setItems(catObservableList);

        listCat.setCellFactory(param -> new CategoryListCell());

    }

    @FXML
    private void clickedOnLogo(MouseEvent event) {
    }

    @FXML
    private void goToShopsViews(MouseEvent event) {
    }

    @FXML
    private void goToAboutUsView(MouseEvent event) {
    }

}
