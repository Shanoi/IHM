/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.custom;

import fr.polytech.ihm.data.Category;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Olivier
 */
public class CategoryListCell extends ListCell<Category> {

    @FXML
    private ImageView imgCat;

    @FXML
    private GridPane gridPane;

    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(Category category, boolean empty) {
        super.updateItem(category, empty);

        if (empty || category == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/fxml/CatCell.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            Image img = new Image(getClass().getClassLoader().getResourceAsStream("images/" + category.getImg()));

            imgCat.setImage(img);   

            setText(null);
            setGraphic(gridPane);
        }

    }

}
