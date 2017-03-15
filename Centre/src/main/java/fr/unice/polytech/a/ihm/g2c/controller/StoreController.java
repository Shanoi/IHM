package fr.unice.polytech.a.ihm.g2c.controller;

import fr.unice.polytech.a.ihm.g2c.common.AppScene;
import fr.unice.polytech.a.ihm.g2c.model.DataModel;
import fr.unice.polytech.a.ihm.g2c.model.Store;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ResourceBundle;

public class StoreController extends AbstractController implements Translable{

    private static final Logger logger = LogManager.getLogger(StoreController.class);

    private DataModel data = DataModel.getInstance();
    private Button buttonSign;
    private Button buttonStore;
    
    @FXML
    private BorderPane rootPane;
    @FXML
    private ImageView logo;
    @FXML
    private Label name;
    @FXML
    private Label description;
    @FXML
    private HBox buttons;
    @FXML
    private ImageView flag;
    @FXML
    private Button backButton;

    @FXML
    void initialize() {
    }

    public void initStore(Store store) {
        initialize(rootPane);

        logger.debug("Init "+store);
        name.setText(store.getName());
        description.setText(store.getDescription());
        logo.setImage(store.getImg());
        buttonSign = createButton();
        buttonStore = createButton();
        if (store.isSign())
            buttons.getChildren().add(buttonSign);
        buttons.getChildren().add(buttonStore);
        setFlag(flag);
        refreshText();
    }

    @FXML
    void back(MouseEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        showScene(AppScene.INDEX, stage);
    }

    @FXML
    void changeLang(MouseEvent mouseEvent) {
        changeLang(flag);
    }

    private Button createButton() {
        Button button = new Button("");
        button.getStyleClass().add("button-black");
        return button;
    }

    @Override
    public void refreshText() {
        ResourceBundle langBundle = data.getLangBundle();
        buttonStore.setText(langBundle.getString("see.store.page"));
        buttonSign.setText(langBundle.getString("see.sign.page"));
        backButton.setText(langBundle.getString("back"));
    }

}

