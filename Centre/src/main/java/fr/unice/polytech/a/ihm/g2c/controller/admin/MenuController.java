package fr.unice.polytech.a.ihm.g2c.controller.admin;

import fr.unice.polytech.a.ihm.g2c.common.AdminScene;
import fr.unice.polytech.a.ihm.g2c.controller.AdminSceneController;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import static fr.unice.polytech.a.ihm.g2c.common.AdminScene.*;

import java.io.IOException;

/**
 * Created by user on 10/03/2017.
 */
public class MenuController extends AdminSceneController {

    @FXML
    private VBox rootPane;

    @FXML
    void addStore(MouseEvent event) {
        adminController.setAdminScene(STORE_ADD);
    }

    @FXML
    void changeHighlight(MouseEvent event) {
        adminController.setAdminScene(HIGHLIGHT);
    }

    @FXML
    void changeInfo(MouseEvent event) {
        adminController.setAdminScene(INFO);
    }

    @FXML
    void changeSelection(MouseEvent event) {
        adminController.setAdminScene(STORE_SELECTION);
    }

    @FXML
    void removeStore(MouseEvent event) {
        adminController.setAdminScene(STORE_REMOVE);
    }

}
