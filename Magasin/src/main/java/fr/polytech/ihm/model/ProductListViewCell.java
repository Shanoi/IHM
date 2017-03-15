package fr.polytech.ihm.model;

import fr.polytech.ihm.MagasinApp;
import fr.polytech.ihm.controller.ListViewProductController;
import fr.polytech.ihm.controller.ListViewProductPromoController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;

/**
 * @author Kovox
 * @version 1.0
 *          This class defines a particular ListCell for products in listview.
 */
public class ProductListViewCell extends ListCell<ProductInListView> {

    @Override
    public void updateItem(ProductInListView product, boolean empty) {
        super.updateItem(product, empty);
        if (product != null) {
            FXMLLoader loader = null;
            Parent element = null;
            try {
                if (product.isPromo()) {
                    loader = new FXMLLoader(getClass().getResource(MagasinApp.PREFIXE + "Client/listView_product_promo.fxml"));
                    element = loader.load();
                    ((ListViewProductPromoController) loader.getController()).initializeProduct(product);
                } else {
                    loader = new FXMLLoader(getClass().getResource(MagasinApp.PREFIXE + "Client/listView_product.fxml"));
                    element = loader.load();
                    ((ListViewProductController) loader.getController()).initializeProduct(product);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            setGraphic(element);
        }
    }

}
