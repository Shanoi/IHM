/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.controllers;

import fr.polytech.ihm.custom.CategoryListCell;
import fr.polytech.ihm.data.Category;
import fr.polytech.ihm.kernel.InfosEnseigneParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static fr.polytech.ihm.kernel.Tools.getAllCategory;

/**
 * FXML Controller class
 *
 * @author Olivier
 */
public class MenuGNewController implements Initializable {

    private InfosEnseigneParser infosEnseigneParser;


    @FXML
    private Button shopsButton;
    @FXML
    private Button aboutUsButton;
    @FXML
    private ListView listCat;
    @FXML
    private ImageView logoCompany;

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

        infosEnseigneParser = new InfosEnseigneParser();
        infosEnseigneParser.extractData();
        try {
            Image image = new Image(getClass().getClassLoader().getResourceAsStream("images/" + infosEnseigneParser.getImagePath()));

            logoCompany.setImage(image);
        } catch (IllegalArgumentException e){
            System.out.println("Cannot load the wanted logo : Invalid file name-->\n" + e.toString());
        }

    }
    
    @FXML
    private void clickListCat(MouseEvent event){
        
        Category cat = (Category) listCat.getSelectionModel().getSelectedItem();
        
        System.out.println(cat.getCategory());
   
        displayCatalogue(catObservableList, cat.getCategory());
        
    }

    @FXML
    private void clickedOnLogo(MouseEvent event) {
        
        String fxmlFile = "/fxml/MainPage.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Stage stage = (Stage) aboutUsButton.getScene().getWindow();
            Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));

            ((MainPageController) loader.getController()).modifyDesc();

            Scene scene = new Scene(rootNode);
            
            scene.getStylesheets().add("/styles/DarkTheme.css");
            
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
            
            scene.getStylesheets().add("/styles/DarkTheme.css");
            
            stage.setScene(scene);

            SavoirPlusController savoirPlusController = loader.getController();
            savoirPlusController.setTabView(id);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
   }

   private void displayCatalogue(ObservableList<Category> cats, String category) {
        
       
       
        String fxmlFile = "/fxml/catalogue/catalogue.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Stage stage = (Stage) listCat.getScene().getWindow();
            Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));

            Scene scene = new Scene(rootNode);
            
            scene.getStylesheets().add("/styles/DarkTheme.css");
            
            stage.setScene(scene);

            ((CatalogueController) loader.getController()).initCatalogue(cats, category);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
