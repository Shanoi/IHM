package fr.unice.polytech.a.ihm.g2c.controller.admin;

import fr.unice.polytech.a.ihm.g2c.common.AdminScene;
import fr.unice.polytech.a.ihm.g2c.controller.AdminSceneController;
import fr.unice.polytech.a.ihm.g2c.model.DataModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * Created by Jeremy on 10/03/2017.
 */
public class HighlightController extends AdminSceneController {

    @FXML
    private TextField textField;

    @FXML
    void submit(MouseEvent event) {
        DataModel.getInstance().setHighlight(textField.getText());
        adminController.setAdminScene(AdminScene.MENU);
    }

}