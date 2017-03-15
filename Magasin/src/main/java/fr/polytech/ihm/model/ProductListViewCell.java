package fr.polytech.ihm.model;

import fr.polytech.ihm.MagasinApp;
import fr.polytech.ihm.controller.client.ProductInListViewController;
import fr.polytech.ihm.controller.client.ProductInListViewPromoController;
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
                    ((ProductInListViewPromoController) loader.getController()).initializeProduct(product);
                } else {
                    loader = new FXMLLoader(getClass().getResource(MagasinApp.PREFIXE + "Client/listView_product.fxml"));
                    element = loader.load();
                    ((ProductInListViewController) loader.getController()).initializeProduct(product);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            setGraphic(element);
        }
    }

}
