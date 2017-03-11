package fr.unice.polytech.a.ihm.g2c.model;

import fr.unice.polytech.a.ihm.g2c.common.Category;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by user on 08/03/2017.
 */
public class Store {

    private String name;
    private String description;
    private Image img;
    private Category category;
    private boolean sign;


    public Store(String name, String description, String imgPath, Category category, boolean sign) throws FileNotFoundException {
        this.name = name;
        this.description = description;
        this.img = new Image(new FileInputStream(imgPath));
        this.category = category;
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Image getImg() {
        return img;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isSign() {
        return sign;
    }
}
