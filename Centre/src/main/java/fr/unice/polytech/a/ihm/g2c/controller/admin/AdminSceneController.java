package fr.unice.polytech.a.ihm.g2c.controller.admin;

import fr.unice.polytech.a.ihm.g2c.controller.AdminController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

/**
 * Created by user on 10/03/2017.
 */
public abstract class AdminSceneController {

    protected AdminController adminController;

    @FXML
    public void initParent(AdminController adminController) {
        this.adminController = adminController;
    }

    void errorDialog(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(msg);
        alert.showAndWait();
    }

}
