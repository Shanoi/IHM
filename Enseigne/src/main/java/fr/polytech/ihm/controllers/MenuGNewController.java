/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.controllers;

import fr.polytech.ihm.custom.CategoryListCell;
import fr.polytech.ihm.data.Category;
import static fr.polytech.ihm.kernel.Tools.getAllCategory;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FXML Controller class
 *
 * @author Olivier
 */
public class MenuGNewController implements Initializable {

    private static final Logger log = LoggerFactory.getLogger(MenuGNewController.class);

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
        
        String fxmlFile = "/fxml/MainPage.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Stage stage = (Stage) aboutUsButton.getScene().getWindow();
            Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));

            Scene scene = new Scene(rootNode);
            stage.setScene(scene);
            
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    @FXML
    private void goToShopsViews(MouseEvent event) {
        
        Stage stage = (Stage) shopsButton.getScene().getWindow();
        
        goInfoPage(stage, 1);
       
    }

    @FXML
    private void goToAboutUsView(MouseEvent event) {

        Stage stage = (Stage) aboutUsButton.getScene().getWindow();
        
        goInfoPage(stage, 0);

    }
    
   private void goInfoPage(Stage stage, int id){
       
       String fxmlFile = "/fxml/testSp.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            
            Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));

            Scene scene = new Scene(rootNode);
            stage.setScene(scene);

            SavoirPlusController savoirPlusController = loader.getController();
            savoirPlusController.setTabView(id);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
   }

    private void lol() {

       /* String fxmlFile = "/fxml/testSp.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Stage stage = (Stage) aboutUsButton.getScene().getWindow();
            Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));

            Scene scene = new Scene(rootNode);
            stage.setScene(scene);
            log.info("Catégorie selectionné depuis le menu : " + currentProduct.getNom());
            ((CatalogController) loader.getController()).initCata(currentProduct);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

}
