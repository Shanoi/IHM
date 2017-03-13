package fr.polytech.ihm.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Created by Thoma on 3/9/2017.
 */
public class UpperBandController {

    @FXML
    private Label homeLabel;
    @FXML
    private ImageView searchImage;
    @FXML
    private TextField searchBar;
    @FXML
    private Label searchNotif;

    @FXML
    public void initialize(){
        searchNotif.setText(null);
    }

    @FXML
    void goHome() throws Exception {
        Stage stage = (Stage) homeLabel.getScene().getWindow();
        Loader loader = new Loader();
        loader.load(stage, "/fxml/Client/shopMain_listView.fxml");
    }

    @FXML
    void enSavoirPlus() throws Exception {
        Stage stage = (Stage) homeLabel.getScene().getWindow();
        Loader loader = new Loader();
        loader.load(stage, "/fxml/Client/savoirplus.fxml");
    }

    @FXML
    void searchProduct(MouseEvent event) {

    }

}
