    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.controllers;

import fr.polytech.ihm.kernel.mainProducts;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PAController implements Initializable {

    private static final Logger log = LoggerFactory.getLogger(PAController.class);

    @FXML
    private Label accrochePhare;

    @FXML
    private ImageView imagePhare;

    private mainProducts mainProds;

    private final String pathToImageSortBy = "nameOfProject/resources/testDataIcons/";

    private Image image;

    //private ObservableList<Image> imagesList;
    private int indexPrev = 0;
    private int indexNext = 0;

    Integer i = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        //Image image = new Image(getClass().getClassLoader().getResource("DVD.png"));
        mainProds = new mainProducts();

        accrochePhare.setText(mainProds.getCurrentProduct().getNom());
        // imagePhare.setImage(image);

        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                accrochePhare.setText(mainProds.nextProduct().getNom());

            }
        }));
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();

    }

    @FXML
    private void gauchePhare(MouseEvent event) {

        accrochePhare.setText(mainProds.prevProduct().getNom());

    }

    @FXML
    private void droitePhare(MouseEvent event) {

        accrochePhare.setText(mainProds.nextProduct().getNom());

    }

}
