package fr.unice.polytech.a.ihm.g2c.controller.admin;

import fr.unice.polytech.a.ihm.g2c.common.AdminScene;
import fr.unice.polytech.a.ihm.g2c.controller.AdminController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by user on 10/03/2017.
 */
public class MenuController {

    private AdminController adminController;

    @FXML
    private VBox rootPane;


    @FXML
    void initialize() {
    }

    @FXML void initParent(AdminController adminController) {
        this.adminController = adminController;
    }

    @FXML
    void addStore(MouseEvent event) {

    }

    @FXML
    void changeHighlight(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent rootNode = loader.load(getClass().getResourceAsStream(AdminScene.HIGHLIGHT.getFxmlFile()));
            adminController.setSubFrame(rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void changeInfo(MouseEvent event) {

    }

    @FXML
    void changeOrder(MouseEvent event) {

    }

    @FXML
    void removeStore(MouseEvent event) {

    }

}
