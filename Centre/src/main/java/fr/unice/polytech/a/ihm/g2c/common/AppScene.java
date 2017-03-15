package fr.unice.polytech.a.ihm.g2c.common;

/**
 * Created by Jeremy on 07/03/2017.
 */
public enum AppScene {

    INDEX("/fxml/index.fxml"),
    ADMIN("/fxml/administration.fxml"),
    STORE("/fxml/store.fxml"),
    INFORMATIONS("/fxml/informations.fxml");

    private String fxmlFile;

    AppScene(String fxmlFile) {
        this.fxmlFile = fxmlFile;
    }

    public String getFxmlFile() {
        return fxmlFile;
    }

}
