package fr.unice.polytech.a.ihm.g2c.controller.admin;

import fr.unice.polytech.a.ihm.g2c.common.AdminScene;
import fr.unice.polytech.a.ihm.g2c.common.SortingType;
import fr.unice.polytech.a.ihm.g2c.model.DataModel;
import fr.unice.polytech.a.ihm.g2c.model.Store;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SelectionStoreController extends AdminSceneController {

    private Map<CheckBox, Store> storeMap;

    @FXML
    private VBox storeList;

    @FXML
    void initialize() {
        storeMap = new LinkedHashMap<>();
        List<Store> stores = DataModel.getInstance().getStoreList();
        stores.sort(SortingType.A_TO_Z.getComparator());
        List<Store> storeSelection = DataModel.getInstance().getStoreSelectionList();
        stores.forEach(store -> {
            CheckBox cb = new CheckBox(store.toString());
            cb.setSelected(storeSelection.contains(store));
            storeMap.put(cb, store);
        });
        storeList.getChildren().addAll(storeMap.keySet());
    }

    @FXML
    void submit(MouseEvent event) {
        List<Store> storeSelection = storeMap.entrySet().stream()
                .filter(entry -> entry.getKey().isSelected())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        DataModel.getInstance().setStoreSelectionList(storeSelection);
        adminController.setAdminScene(AdminScene.MENU);
    }

}

