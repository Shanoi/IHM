package fr.unice.polytech.a.ihm.g2c.common;

/**
 * Created by Jeremy on 14/03/2017.
 */
public enum Stylesheet {

    NORMAL("/styles/style.css"),
    BIG("/styles/style-big.css");

    private String cssFile;

    Stylesheet(String cssFile) {
        this.cssFile = cssFile;
    }

    @Override
    public String toString() {
        return cssFile;
    }
}
