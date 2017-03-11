package fr.unice.polytech.a.ihm.g2c.controller;

import fr.unice.polytech.a.ihm.g2c.common.Category;
import fr.unice.polytech.a.ihm.g2c.model.DataModel;
import fr.unice.polytech.a.ihm.g2c.model.Store;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Jeremy on 07/03/2017.
 */

import static fr.unice.polytech.a.ihm.g2c.common.AppScene.*;

public class IndexController {

    private static final Logger logger = LogManager.getLogger(IndexController.class);

    private double tileWidth;
    private double tileHeight;
    private List<Category> categoryFilter;

    @FXML
    private Label highlight;
    @FXML
    private BorderPane rootPane;
    @FXML
    private TilePane storesList;
    @FXML
    private VBox menuList;

    public void test() {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        ControllerUtil.showScene(ADMIN, stage);
    }


    @FXML
    public void initialize() {
        tileHeight = storesList.getPrefTileHeight();
        tileWidth = storesList.getPrefTileWidth();
        categoryFilter = new ArrayList<>();

        Arrays.stream(Category.values()).forEach(category ->  {
            CheckBox cb = new CheckBox(category.toString());
            cb.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                if (newValue)
                    categoryFilter.add(Category.valueOf(cb.getText()));
                else
                    categoryFilter.remove(Category.valueOf(cb.getText()));
                refreshStoresList();
            });
            menuList.getChildren().add(cb);
        });

        DataModel data = DataModel.getInstance();
        highlight.setText(data.getHighlight());
        //List<Store> stores = DataModel.getInstance().getStoreList();
        //stores.forEach(store -> addTile(store.getImg()));
        refreshStoresList();
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

    private void addTile(Image img) {
        ImageView tile = new ImageView(img);
        tile.setFitWidth(tileWidth);
        tile.setFitHeight(tileHeight);
        storesList.getChildren().add(tile);
    }

    private void refreshStoresList() {
        logger.debug("Refreshing store list");
        List<Store> stores = DataModel.getInstance().getStoreList();
        if (!categoryFilter.isEmpty())
            stores = stores.stream().filter(store -> categoryFilter.contains(store.getCategory())).collect(Collectors.toList());
        logger.debug("Stores to display: " + stores);
        storesList.getChildren().clear();
        stores.forEach(store -> addTile(store.getImg()));
    }

}

