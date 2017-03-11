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
public class Category {

    private final String category;

    private final String img;

    public Category(String category, String img) {
        this.category = category;
        this.img = img;
    }

    public String getCategory() {
        return category;
    }

    public String getImg() {
        return img;
    }

}
