package fr.unice.polytech.a.ihm.g2c.controller;

import javafx.fxml.FXML;

/**
 * Created by user on 10/03/2017.
 */
public abstract class AdminSceneController {

    protected AdminController adminController;

    @FXML
    void initParent(AdminController adminController) {
        this.adminController = adminController;
    }

}
