package fr.polytech.ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

/**
 * @author Kovox
 * @version 1.0
 *          A class which represents a product in a listview.
 */
public class ProductInListView {

    private StringProperty productName;
    private StringProperty productDescription;
    private StringProperty disponible;
    private Image productImage;
    private int price;
    private boolean inPromo;

    public String getProductDescription() {
        return productDescription.get();
    }

    public StringProperty productDescriptionProperty() {
        return productDescription;
    }

    public String getDisponible() {
        return disponible.get();
    }

    public StringProperty disponibleProperty() {
        return disponible;
    }

    public ProductInListView(boolean inPromo) {
        this.inPromo = inPromo;
        productName = new SimpleStringProperty();
        productDescription = new SimpleStringProperty();
        disponible = new SimpleStringProperty();
    }

    public void initializeProduct(String name, Image image, int price, String disponible, String description) {
        productName.setValue(name);
        productImage = image;
        this.price = price;
        this.disponible.setValue(disponible);
        productDescription.setValue(description);
    }

    public boolean isPromo() {
        return inPromo;
    }

    public StringProperty getName() {
        return productName;
    }

    public Image getImage() {
        return productImage;
    }

    public int getPrice() {
        return price;
    }

}
