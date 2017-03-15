package fr.unice.polytech.a.ihm.g2c.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ResourceBundle;

import static fr.unice.polytech.a.ihm.g2c.common.AppScene.INDEX;

/**
 * Created by Jeremy on 11/03/2017.
 */
public class InfoController extends AbstractController implements Translable {

    private static final Logger logger = LogManager.getLogger(InfoController.class);

    private static final int ZOOM_STEP = 100;

    private int zoom = 100;
    private double baseHeight;
    private double baseWidth;

    @FXML
    private ImageView map;
    @FXML
    public Label description;
    @FXML
    private ScrollPane scrollMap;
    @FXML
    private Label zoomLabel;
    @FXML
    private ImageView flag;
    @FXML
    private Button backButton;
    @FXML
    private Label informationLabel;
    @FXML
    private Label mapLabel;
    @FXML
    private BorderPane rootPane;

    @FXML
    public void initialize() {
        initialize(rootPane);

        baseHeight = scrollMap.getPrefHeight();
        baseWidth = scrollMap.getPrefWidth();
        logger.debug("baseWidth " + baseWidth + ", baseHeight " + baseHeight);
        refreshMapSize();
        setFlag(flag);
        refreshText();
    }

    @FXML
    void changeLang(MouseEvent mouseEvent) {
        changeLang(flag);
    }

    @FXML
    void back(MouseEvent mouseEvent) {
        Stage stage = (Stage) map.getScene().getWindow();
        showScene(INDEX, stage);
    }

    @FXML
    void zoomPlus(MouseEvent mouseEvent) {
        if (zoom >= 500)
            return;
        zoom += ZOOM_STEP;
        refreshMapSize();
    }

    @FXML
    void zoomMinus(MouseEvent mouseEvent) {
        if (zoom <= 100)
            return;
        zoom -= ZOOM_STEP;
        refreshMapSize();
    }

    @Override
    public void refreshText() {
        ResourceBundle langBundle = data.getLangBundle();
        description.setText(data.getInformations());
        backButton.setText(langBundle.getString("back"));
        informationLabel.setText(langBundle.getString("information.about.center"));
        mapLabel.setText(langBundle.getString("map.of.center"));
    }


    private void refreshMapSize() {
        zoomLabel.setText("Zoom: " + zoom + "%");
        map.setFitWidth(baseWidth * ((double)zoom/100) * 0.99);
        map.setFitHeight(baseHeight * ((double)zoom/100) * 0.99);
    }

}
