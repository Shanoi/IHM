package fr.polytech.ihm.model;

import javafx.scene.control.ListCell;

/**
 * Created by Kovox on 11/03/2017.
 */
public class ProductListViewCell extends ListCell<ProductListView> {

    @Override
    public void updateItem(ProductListView productListView, boolean empty) {
        super.updateItem(productListView, empty);
        setGraphic(productListView.getParent());
    }
}
