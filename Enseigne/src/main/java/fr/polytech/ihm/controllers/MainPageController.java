    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.controllers;

    import fr.polytech.ihm.data.Product;
import fr.polytech.ihm.kernel.MainProducts;
    import fr.polytech.ihm.kernel.ProductsParser;
    import javafx.animation.AnimationTimer;
    import javafx.animation.FadeTransition;
    import javafx.animation.ParallelTransition;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.fxml.Initializable;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.control.Label;
    import javafx.scene.image.Image;
    import javafx.scene.image.ImageView;
    import javafx.scene.input.MouseEvent;
    import javafx.stage.Stage;
    import javafx.util.Duration;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;

    import java.io.IOException;
    import java.net.URL;
    import java.util.ResourceBundle;


public class MainPageController implements Initializable {

    private static final Logger log = LoggerFactory.getLogger(MainPageController.class);

    @FXML
    private Label accrochePhare;

    @FXML
    private ImageView imagePhare;

    @FXML
    private Label prixPhare;

    private MainProducts mainProds;

    private final String pathToImageSortBy = "nameOfProject/resources/testDataIcons/";

    private Image image;

    //private ObservableList<Image> imagesList;
    private int indexPrev = 0;
    private int indexNext = 0;

    private AnimationTimer tracker;

    private Product currentProduct;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        //Image image = new Image(getClass().getClassLoader().getResourceAsStream("images/DVD.png"));
        mainProds = new MainProducts();

        changeMainProd(mainProds.getCurrentProduct());

        //accrochePhare.setText(mainProds.getCurrentProduct().getNom());
        //imagePhare.setImage(image);

        /*new Timer().schedule(
         new TimerTask() {

         @Override
         public void run() {
         accrochePhare.setText(mainProds.nextProduct().getNom());
         }
         }, 0, 5000);*/
        //Soluttion qui fonctionne  
        /*Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>() {

         @Override
         public void handle(ActionEvent event) {

         accrochePhare.setText(mainProds.nextProduct().getNom());

         }
         }));
         fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
         fiveSecondsWonder.play();*/
        tracker = new AnimationTimer() {

            private long lastUpdate = 0;

            private Product product;

            @Override
            public void handle(long timestamp) {
                if (timestamp - lastUpdate >= 900000000) { //Mettre un 2ème if si on veut rallonger le temps?

                    FadeTransition ft1 = new FadeTransition();
                    FadeTransition ft2 = new FadeTransition();

                    product = mainProds.nextProduct();

                    accrochePhare.setText(product.getNom());

                    image = new Image(getClass().getClassLoader().getResourceAsStream("images/" + product.getImage()));

                    imagePhare.setImage(image);

                    ft1.setNode(imagePhare);
                    ft1.setDuration(new Duration(300));
                    ft1.setFromValue(1.0);
                    ft1.setToValue(0.0);
                    ft1.setCycleCount(0);
                    ft1.setAutoReverse(true);

                    ft2.setNode(accrochePhare);
                    ft2.setDuration(new Duration(300));
                    ft2.setFromValue(1.0);
                    ft2.setToValue(0.0);
                    ft2.setCycleCount(0);
                    ft2.setAutoReverse(true);

                    final ParallelTransition masterAnimation = new ParallelTransition(ft1, ft2);

                    masterAnimation.playFromStart();

                    lastUpdate = timestamp;
                }
            }
        };

    }

    @FXML
    private void gauchePhare(MouseEvent event) {
        //tracker.start();

        currentProduct = mainProds.prevProduct();

        changeMainProd(currentProduct);

    }

    @FXML
    private void droitePhare(MouseEvent event) {

        currentProduct = mainProds.nextProduct();

        changeMainProd(currentProduct);

    }

    @FXML
    private void clickImgPhare(MouseEvent event){
        
        displayItem();
        
    }
    
    private void changeMainProd(Product product) {

        currentProduct = product;
        
        accrochePhare.setText(product.getNom());

        image = new Image(getClass().getClassLoader().getResourceAsStream("images/" + product.getImage()));

        imagePhare.setImage(image);

        prixPhare.setText(Float.toString(product.getPrix()));

    }
    
    private void displayItem() {
        String fxmlFile = "/fxml/Item.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Stage stage = (Stage) imagePhare.getScene().getWindow();
            Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));

            Scene scene = new Scene(rootNode);
            stage.setScene(scene);
            log.info("Produit selectionné depuis la MainPage : " + currentProduct.getNom());
            ((ItemController) loader.getController()).initItem(currentProduct);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
