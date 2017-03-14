/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.data;

public class Product {

    private final int productID;
    private final String nom;
    private final String description;
    private final float prix;
    private final int idMarque;
    private final int nbSell;
    private final String image;
    private final String category;
    private final boolean isProdPhare;
    private final boolean isInSell;
    private final int currentPromo;

    public Product(float prix, String nom, String image,
            String description, String category, int idMarque, int nbSell, int productID,
            boolean isProdPhare, boolean isInSell, int currentPromo) {
        this.prix = prix;
        this.nom = nom;
        this.image = image;
        this.description = description;
        this.category = category;
        this.idMarque = idMarque;
        this.nbSell = nbSell;
        this.productID = productID;
        this.isInSell = isInSell;
        this.isProdPhare = isProdPhare;
        this.currentPromo = currentPromo;
    }

    public float getPrix() {
        return prix;
    }
    
    public float getPrixPromo(){
        System.out.println("PROMO : " + this.prix * ((float) currentPromo / 100));
        return this.prix * ((float) currentPromo / 100);
        
    }

    public String getNom() {
        return nom;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public int getIdMarque() {
        return idMarque;
    }

    public int getNbSell() {
        return nbSell;
    }

    public int getProductID() {
        return productID;
    }

    public boolean isInSell() {
        return isInSell;
    }

    public boolean isProdPhare() {
        return isProdPhare;
    }

    public int getCurrentPromo() {
        return currentPromo;
    }
}
