package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.ButtonModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Thoma on 3/9/2017.
 */
public class UpperBandController {

    private ButtonModel buttonModel = new ButtonModel();

    @FXML
    public void initialize(){
    }

    @FXML
    private ImageView homePicture;
    @FXML
    private Label homeLabel;

    @FXML
    void goHome(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView) {
            buttonModel.homeView((Stage) homePicture.getScene().getWindow());
        } else buttonModel.homeView((Stage) homeLabel.getScene().getWindow());
    }
}
