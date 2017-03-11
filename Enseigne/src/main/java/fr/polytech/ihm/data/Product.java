/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.data;

public class Product {

    private final float prix;
    private final String nom;
    private final String image;
    private final String description;
    private final String category;
    private int idMarque;
    private int nbSell;

    public Product(float prix, String nom, String image,
                   String description, String category, int idMarque, int nbSell) {
        this.prix = prix;
        this.nom = nom;
        this.image = image;
        this.description = description;
        this.category = category;
        this.idMarque = idMarque;
        this.nbSell = nbSell;
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
}
