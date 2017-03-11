package fr.unice.polytech.a.ihm.g2c.common;

/**
 * Created by user on 10/03/2017.
 */
public enum AdminScene {

    MENU("/fxml/inc/administration-menu.fxml"),
    INFO("/fxml/inc/administration-info.fxml"),
    HIGHLIGHT("/fxml/inc/administration-highlight.fxml"),
    STORE_ADD("/fxml/inc/administration-addStore.fxml"),
    STORE_REMOVE("/fxml/inc/administration-removeStore.fxml");

    private String fxmlFile;

    AdminScene(String fxmlFile) {
        this.fxmlFile = fxmlFile;
    }

    public String getFxmlFile() {
        return fxmlFile;
    }

}
