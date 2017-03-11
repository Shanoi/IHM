package fr.unice.polytech.a.ihm.g2c.controller.admin;

import fr.unice.polytech.a.ihm.g2c.common.AdminScene;
import fr.unice.polytech.a.ihm.g2c.controller.AdminSceneController;
import fr.unice.polytech.a.ihm.g2c.model.DataModel;
import fr.unice.polytech.a.ihm.g2c.model.Store;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

public class RemoveStoreController extends AdminSceneController{

    @FXML
    private ChoiceBox<Store> storeChoice;

    @FXML
    void initialize() {
        storeChoice.getItems().addAll(DataModel.getInstance().getStoreList());
    }

    @FXML
    void submit(MouseEvent event) {
        DataModel.getInstance().removeStore(storeChoice.getValue());
        adminController.setAdminScene(AdminScene.MENU);
    }

}

