/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.data;

/**
 *
 * @author Olivier
 */
public class Marque {

    private String nom;

    private int id;

    public Marque(String nom, int id) {
        this.nom = nom;
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }

}
