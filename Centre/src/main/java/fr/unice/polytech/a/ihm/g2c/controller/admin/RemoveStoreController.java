package fr.unice.polytech.a.ihm.g2c.controller.admin;

import fr.unice.polytech.a.ihm.g2c.common.AdminScene;
import fr.unice.polytech.a.ihm.g2c.model.DataModel;
import fr.unice.polytech.a.ihm.g2c.model.Store;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RemoveStoreController extends AdminSceneController{

    private static final Logger logger = LogManager.getLogger(RemoveStoreController.class);
    
    @FXML
    private ChoiceBox<Store> storeChoice;

    @FXML
    void initialize() {
        storeChoice.getItems().addAll(DataModel.getInstance().getStoreList());
    }

    @FXML
    void submit(MouseEvent event) {
        try {
            DataModel.getInstance().removeStore(storeChoice.getValue());
            adminController.setAdminScene(AdminScene.MENU);
        } catch (IllegalArgumentException e) {
            logger.error(e);
            errorDialog("Veuillez saisir un magasin");
        }
    }

}

