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

    private StringProperty productID;
    private StringProperty productName;
    private StringProperty productDescription;
    private StringProperty disponible;
    private StringProperty genre;
    private Image productImage;
    private boolean inPromo;
    private int price;
    private int promo;

    public ProductInListView(boolean inPromo) {
        productID = new SimpleStringProperty();
        productName = new SimpleStringProperty();
        productDescription = new SimpleStringProperty();
        disponible = new SimpleStringProperty();
        genre = new SimpleStringProperty();
        this.inPromo = inPromo;
    }

    public void initializeProduct(String productID, String name, Image image, int price, int promo, String disponible, String description, String genre) {
        this.productID.setValue(productID);
        productName.setValue(name);
        productImage = image;
        this.price = price;
        this.promo = promo;
        this.disponible.setValue(disponible);
        this.genre.setValue(genre);
        productDescription.setValue(description);
    }

    public String getProductID() {
        return productID.get();
    }

    public String getName() {
        return productName.get();
    }

    public String getProductDescription() {
        return productDescription.get();
    }

    public String getDisponible() {
        return disponible.get();
    }

    public Image getImage() {
        return productImage;
    }

    public boolean isPromo() {
        return inPromo;
    }

    public int getPrice() {
        return price;
    }

    public int getPromo() {
        return promo;
    }

    public String getGenre() {
        return genre.get();
    }

    @Override
    public String toString() {
        return productName.getValue();
    }

}
