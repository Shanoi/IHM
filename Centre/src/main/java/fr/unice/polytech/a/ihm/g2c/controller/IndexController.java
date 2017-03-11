package fr.unice.polytech.a.ihm.g2c.controller;

import fr.unice.polytech.a.ihm.g2c.common.Category;
import fr.unice.polytech.a.ihm.g2c.common.SortingType;
import fr.unice.polytech.a.ihm.g2c.model.DataModel;
import fr.unice.polytech.a.ihm.g2c.model.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    private SortingType sortingType = SortingType.A_TO_Z;

    @FXML
    private Label highlight;
    @FXML
    private BorderPane rootPane;
    @FXML
    private TilePane storesList;
    @FXML
    private TilePane storeSelection;
    @FXML
    private VBox menuList;
    @FXML
    public ChoiceBox<SortingType> sortTypeChooser;



    @FXML
    public void initialize() {
        // Fields
        tileHeight = storesList.getPrefTileHeight();
        tileWidth = storesList.getPrefTileWidth();
        categoryFilter = new ArrayList<>();

        // Sorting
        sortTypeChooser.getItems().addAll(SortingType.values());
        sortTypeChooser.setValue(SortingType.A_TO_Z);
        sortTypeChooser.valueProperty().addListener((observable, oldValue, newValue) -> {
            sortingType = newValue;
            refreshStoresList();
        });

        // Menu
        Arrays.stream(Category.values()).forEach(category ->  {
            CheckBox cb = new CheckBox(category.toString());
            cb.selectedProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue)
                    categoryFilter.add(Category.valueOf(cb.getText()));
                else
                    categoryFilter.remove(Category.valueOf(cb.getText()));
                refreshStoresList();
            });
            menuList.getChildren().add(cb);
        });

        // Stores
        DataModel data = DataModel.getInstance();
        highlight.setText(data.getHighlight());
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

    private void addTile(TilePane pane, Store store) {
        logger.debug("Add store: " + store);
        ImageView tile = new ImageView(store.getImg());
        tile.setFitWidth(tileWidth);
        tile.setFitHeight(tileHeight);
        tile.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            logger.debug("Clicked on " + store);
            Stage stage = (Stage) tile.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            try {
                Parent rootNode = loader.load(ControllerUtil.class.getResourceAsStream(STORE.getFxmlFile()));
                ((StoreController)loader.getController()).initStore(store);
                Scene scene = new Scene(rootNode);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        pane.getChildren().add(tile);
    }

    private void refreshStoresList() {
        logger.debug("Refreshing store list");
        List<Store> storesToDisplay = DataModel.getInstance().getStoreList();
        if (!categoryFilter.isEmpty())
            storesToDisplay = storesToDisplay.stream().filter(store -> categoryFilter.contains(store.getCategory())).collect(Collectors.toList());
        storesToDisplay.sort(sortingType.getComparator());
        logger.debug("Stores to display: " + storesToDisplay);
        storesList.getChildren().clear();
        storesToDisplay.forEach(store -> addTile(storesList, store));
        List<Store> storeSelectionToDisplay = DataModel.getInstance().getStoreSelectionList();
        storeSelection.getChildren().clear();
        storeSelectionToDisplay.stream().filter(storesToDisplay::contains).forEach(store -> addTile(storeSelection, store));
    }

}

