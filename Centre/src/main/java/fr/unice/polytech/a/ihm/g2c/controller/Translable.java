package fr.unice.polytech.a.ihm.g2c.controller;

import fr.unice.polytech.a.ihm.g2c.model.DataModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface Translable {

    default void setFlag(ImageView flag) {
        flag.setImage(new Image(getClass().getResourceAsStream(DataModel.getInstance().getLang().getNext().getImgPath())));
    }

    default void changeLang(ImageView flag) {
        DataModel data = DataModel.getInstance();
        data.setLang(data.getLang().getNext());
        flag.setImage(new Image(getClass().getResourceAsStream(data.getLang().getNext().getImgPath())));
        refreshText();
    }

    void refreshText();
}
