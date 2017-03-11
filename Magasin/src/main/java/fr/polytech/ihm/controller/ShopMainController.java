package fr.polytech.ihm.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import org.json.JSONObject;

import java.util.List;

/**
 * @author Jérémy LARA
 * @version 1.0
 *          Represents the main shop view controller.
 */
public class ShopMainController {

    @FXML
    private BorderPane parentNode;
    @FXML
    private ListView<FXML> scienceProductPromo;

    public ShopMainController() {

    }

    public void initialize() {

    }

    @FXML
    void takeFocus(MouseEvent event) {
        parentNode.requestFocus();
    }

}

