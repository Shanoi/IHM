package fr.unice.polytech.a.ihm.g2c.controller.admin;

import fr.unice.polytech.a.ihm.g2c.common.AdminScene;
import fr.unice.polytech.a.ihm.g2c.common.SortingType;
import fr.unice.polytech.a.ihm.g2c.model.DataModel;
import fr.unice.polytech.a.ihm.g2c.model.Store;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class RemoveStoreController extends AdminSceneController{

    private static final Logger logger = LogManager.getLogger(RemoveStoreController.class);
    
    @FXML
    private ChoiceBox<Store> storeChoice;

    @FXML
    void initialize() {
        List<Store> toDisplay = DataModel.getInstance().getStoreList().stream()
                .sorted(SortingType.A_TO_Z.getComparator())
                .collect(Collectors.toList());
        storeChoice.getItems().addAll(toDisplay);
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

