package fr.unice.polytech.a.ihm.g2c.controller;

import fr.unice.polytech.a.ihm.g2c.model.DataModel;
import fr.unice.polytech.a.ihm.g2c.model.Store;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by Jeremy on 07/03/2017.
 */

import static fr.unice.polytech.a.ihm.g2c.common.AppScene.*;

public class IndexController {

    private static final Logger logger = LogManager.getLogger(IndexController.class);

    @FXML
    private Label highlight;
    @FXML
    private BorderPane rootPane;
    @FXML
    private TilePane storesList;

    public void test() {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        ControllerUtil.showScene(ADMIN, stage);
    }


    @FXML
    public void initialize() {
        DataModel data = DataModel.getInstance();
        highlight.setText(data.getHighlight());
        List<Store> stores = DataModel.getInstance().getStoreList();
        stores.forEach(store -> storesList.getChildren().add(new ImageView(store.getImg())));
    }

    @FXML
    void admin(MouseEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        ControllerUtil.showScene(ADMIN, stage);
    }

    @FXML
    void info(MouseEvent event) {
        logger.debug("info");
    }

}

