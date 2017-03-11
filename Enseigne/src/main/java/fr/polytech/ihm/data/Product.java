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

    public Product(float prix, String nom, String image, String description) {
        this.prix = prix;
        this.nom = nom;
        this.image = image;
        this.description = description;
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

}
