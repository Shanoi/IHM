package fr.polytech.ihm.controllers;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * Created by Enzo on 14/03/2017.
 */
public class GMapsController {

    @FXML
    private WebView gMapsWebView;

    @FXML
    public void initialise(){
        WebEngine webEngine = gMapsWebView.getEngine();
        webEngine.load("https://www.google.fr/maps");
    }
}
