package fr.unice.polytech.a.ihm.g2c.controller;

import fr.unice.polytech.a.ihm.g2c.common.AppScene;
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

public class StoreController {

    private static final Logger logger = LogManager.getLogger(StoreController.class);
    
    @FXML
    private BorderPane rootPane;
    @FXML
    private ImageView logo;
    @FXML
    private Label name;
    @FXML
    private Label description;
    @FXML
    public HBox buttons;

    @FXML
    void initialyze() {

    }

    public void initStore(Store store) {
        logger.debug("Init "+store);
        name.setText(store.getName());
        description.setText(store.getDescription());
        logo.setImage(store.getImg());
        if (store.isSign())
            buttons.getChildren().add(createButton("Voir la page de l'enseigne"));
        buttons.getChildren().add(createButton("Voir la page du magasin"));
    }

    @FXML
    void back(MouseEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        ControllerUtil.showScene(AppScene.INDEX, stage);
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.getStyleClass().add("button2");
        return button;
    }

}

