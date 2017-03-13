/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.data;

    public class Product {

    private int productID;
    private String nom;
    private String description;
    private float prix;
    private int idMarque;
    private int nbSell;
    private String image;
    private String category;
    private boolean isProdPhare;
    private boolean isInSell;
    private int currentPromo;

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

    public int getIdMarque(){
        return idMarque;
    }

    public int getNbSell() {
        return nbSell;
    }

    public int getProductID(){
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

