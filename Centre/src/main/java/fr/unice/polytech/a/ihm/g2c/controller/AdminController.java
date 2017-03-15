package fr.unice.polytech.a.ihm.g2c.controller;

import fr.unice.polytech.a.ihm.g2c.common.AdminScene;
import fr.unice.polytech.a.ihm.g2c.common.AppScene;
import fr.unice.polytech.a.ihm.g2c.controller.admin.AdminSceneController;
import fr.unice.polytech.a.ihm.g2c.model.DataModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class AdminController extends AbstractController{

    private static final Logger logger = LogManager.getLogger(AdminController.class);
    private AdminScene currentAdminScene;

    @FXML
    private BorderPane rootPane;

    @FXML
    public void initialize() {
        initialize(rootPane);

        setAdminScene(AdminScene.MENU);
    }

    @FXML
    void back(MouseEvent event) {
        if (currentAdminScene == AdminScene.MENU) {
            Stage stage = (Stage) rootPane.getScene().getWindow();
            showScene(AppScene.INDEX, stage);
        } else {
            setAdminScene(AdminScene.MENU);
        }
    }

    public void setAdminScene(AdminScene scene) {
        logger.debug(DataModel.getInstance().getStoreList());
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent rootNode = loader.load(getClass().getResourceAsStream(scene.getFxmlFile()));
            ((AdminSceneController)loader.getController()).initParent(this);
            rootPane.setCenter(rootNode);
            currentAdminScene = scene;
        } catch (IOException e) {
            logger.error(e);
        }
    }

}
