package fr.polytech.ihm.model;

import fr.polytech.ihm.controller.ListViewProductController;
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
            FXMLLoader loader = new FXMLLoader();
            Parent element = null;
            try {
                if (product.isPromo())
                    element = loader.load(getClass().getResourceAsStream("/fxml/Client/listView_product_promo.fxml"));
                else element = loader.load(getClass().getResourceAsStream("/fxml/Client/listView_product.fxml"));
                //loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (product.isPromo())
                ((ListViewProductController) loader.getController()).initializeProductPromo(product);
            else ((ListViewProductController) loader.getController()).initializeProduct(product);
            setGraphic(element);
        }
    }

}
