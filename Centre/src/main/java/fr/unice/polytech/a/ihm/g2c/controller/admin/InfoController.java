package fr.unice.polytech.a.ihm.g2c.controller.admin;

import fr.unice.polytech.a.ihm.g2c.common.AdminScene;
import fr.unice.polytech.a.ihm.g2c.model.DataModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class InfoController extends AdminSceneController {

    @FXML
    private TextArea info;

    @FXML
    void submit(MouseEvent mouseEvent) {
        DataModel.getInstance().setInformations(info.getText());
        adminController.setAdminScene(AdminScene.MENU);
    }
}
