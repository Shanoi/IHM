package fr.unice.polytech.a.ihm.g2c.controller;

import fr.unice.polytech.a.ihm.g2c.common.AdminScene;
import fr.unice.polytech.a.ihm.g2c.common.AppScene;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {

    @FXML
    private BorderPane rootPane;

    @FXML
    public void initialize() {
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent rootNode = loader.load(getClass().getResourceAsStream(AdminScene.GLOBAL.getFxmlFile()));
            setSubFrame(rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void index(MouseEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        ControllerUtil.showScene(AppScene.INDEX, stage);
    }

    public void setAdminScene(AdminScene scene) {
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent rootNode = loader.load(getClass().getResourceAsStream(scene.getFxmlFile()));
            ((AdminSceneController)loader.getController()).initParent()
            rootPane.setCenter(rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
