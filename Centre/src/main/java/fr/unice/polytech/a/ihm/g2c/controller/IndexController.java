package fr.unice.polytech.a.ihm.g2c.controller;

import fr.unice.polytech.a.ihm.g2c.common.Category;
import fr.unice.polytech.a.ihm.g2c.common.SortingType;
import fr.unice.polytech.a.ihm.g2c.model.DataModel;
import fr.unice.polytech.a.ihm.g2c.model.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Created by Jeremy on 07/03/2017.
 */

import static fr.unice.polytech.a.ihm.g2c.common.AppScene.*;

public class IndexController extends AbstractController implements Translable {

    private static final Logger logger = LogManager.getLogger(IndexController.class);

    private double tileWidth;
    private double tileHeight;
    private DataModel data = DataModel.getInstance();

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
    private ChoiceBox<SortingType> sortTypeChooser;
    @FXML
    private TextField searchField;
    @FXML
    private Button aboutButton;
    @FXML
    private ImageView flag;
    @FXML
    private Label categoryLabel;
    @FXML
    private Label selectionLabel;
    @FXML
    private Label storesLabel;
    @FXML
    private Label sortBy;



    @FXML
    public void initialize() {

        initialize(rootPane);

        // Fields
        if (rootPane.getStylesheets().contains("/styles/style-big.css")) {
            tileHeight = 200;
            tileWidth = 200;
        } else {
            tileHeight = 100;
            tileWidth = 100;
        }
        logger.debug("tileWidth " + tileWidth + ", tileHeight " + tileHeight);

        // Sorting
        sortTypeChooser.getItems().addAll(SortingType.values());
        sortTypeChooser.setValue(data.getSortingType());
        sortTypeChooser.valueProperty().addListener((observable, oldValue, newValue) -> {
            data.setSortingType(newValue);
            refreshStoresList();
        });

        // Search field
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            logger.debug("Search field changed");
            data.setSearch(searchField.getText());
            refreshStoresList();
        });

        // Stores
        highlight.setText(data.getHighlight());
        refreshStoresList();

        // Flag
        setFlag(flag);

        // Translation
        refreshText();
    }

    @FXML
    void admin(MouseEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        showScene(ADMIN, stage);
    }

    @FXML
    void info(MouseEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        showScene(INFORMATIONS, stage);
    }

    @FXML
    public void changeLang(MouseEvent mouseEvent) {
        changeLang(flag);
    }

    private void addTile(TilePane pane, Store store) {
        logger.debug(String.format("Add store: %s (%dx%d)", store, (int)tileWidth, (int)tileHeight));
        ImageView tile = new ImageView(store.getImg());
        tile.setFitWidth(tileWidth);
        tile.setFitHeight(tileHeight);
        tile.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            logger.debug("Clicked on " + store);
            Stage stage = (Stage) tile.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            try {
                Parent rootNode = loader.load(getClass().getResourceAsStream(STORE.getFxmlFile()));
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

        // Clear
        storesList.getChildren().clear();
        storeSelection.getChildren().clear();

        // Stores
        List<Store> storesToDisplay = DataModel.getInstance().getStoreList();
        if (!data.getCategoryFilter().isEmpty())
            storesToDisplay = storesToDisplay.stream()
                    .filter(store -> data.getCategoryFilter().contains(store.getCategory()))
                    .collect(Collectors.toList());
        String search = data.getSearch().toLowerCase();
        if (!search.isEmpty())
            storesToDisplay = storesToDisplay.stream()
                    .filter(store -> (store.getName().toLowerCase().contains(search)
                            || store.getDescription().toLowerCase().contains(search)
                            || store.getCategory().toString().toLowerCase().contains(search)))
                    .collect(Collectors.toList());
        storesToDisplay.sort(data.getSortingType().getComparator());
        logger.debug("Stores to display: " + storesToDisplay);
        if (storesToDisplay.isEmpty())
            storesList.getChildren().add(noResult());
        else
            storesToDisplay.forEach(store -> addTile(storesList, store));

        // Selection
        List<Store> storeSelectionToDisplay = DataModel.getInstance().getStoreSelectionList();
        storeSelectionToDisplay = storeSelectionToDisplay.stream()
                .filter(storesToDisplay::contains)
                .collect(Collectors.toList());
        if (storeSelectionToDisplay.isEmpty())
            storeSelection.getChildren().add(noResult());
        else
            storeSelectionToDisplay.forEach(store -> addTile(storeSelection, store));
    }

    private Label noResult() {
        Label lbl = new Label(data.getLangBundle().getString("no.result"));
        lbl.getStyleClass().add("h2");
        return lbl;
    }

    private void refreshCategories() {
        menuList.getChildren().clear();
        data.getCategoryFilter().clear();
        Arrays.stream(Category.values()).forEach(category ->  {
            CheckBox cb = new CheckBox(category.toString());
            cb.setSelected(data.getCategoryFilter().contains(category));
            cb.selectedProperty().addListener((observable, oldValue, newValue) -> {
                ResourceBundle langBundle = data.getLangBundle();
                Category cat = Category.categoryOf(langBundle.keySet().stream().filter(key -> langBundle.getString(key).equals(cb.getText())).findAny().get());
                if (newValue)
                    data.getCategoryFilter().add(cat);
                else
                    data.getCategoryFilter().remove(cat);
                refreshStoresList();
            });
            menuList.getChildren().add(cb);
        });
    }

    public void refreshText() {
        ResourceBundle langBundle = data.getLangBundle();
        aboutButton.setText(langBundle.getString("about"));
        categoryLabel.setText(langBundle.getString("category"));
        searchField.setPromptText(langBundle.getString("search"));
        selectionLabel.setText(langBundle.getString("to.discover"));
        storesLabel.setText(langBundle.getString("all.shops"));
        sortBy.setText(langBundle.getString("sort.by"));

        refreshStoresList();
        refreshCategories();
    }

}

