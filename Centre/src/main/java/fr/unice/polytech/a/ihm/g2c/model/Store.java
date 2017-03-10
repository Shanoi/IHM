package fr.unice.polytech.a.ihm.g2c.model;

import fr.unice.polytech.a.ihm.g2c.common.Category;
import javafx.scene.image.Image;

/**
 * Created by user on 08/03/2017.
 */
public class Store {

    private String name;
    private String description;
    private Image img;
    private Category category;

    public Store(String name, String description, String imgPath, Category category) {
        this.name = name;
        this.description = description;
        //this.img = new Image(getClass().getResourceAsStream(imgPath));
        this.category = category;
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
        final StringBuilder sb = new StringBuilder("Store{");
        sb.append("name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", img=").append(img);
        sb.append(", category=").append(category);
        sb.append('}');
        return sb.toString();
    }
}
