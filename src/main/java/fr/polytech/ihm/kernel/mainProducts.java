/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.kernel;

import fr.polytech.ihm.data.Product;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Olivier
 */
public class mainProducts {

    private ArrayList<Product> products;

    private int currentIndex = 0;

    public mainProducts() {

        products = new ArrayList<Product>();

        try {

            Class.forName("org.sqlite.JDBC").newInstance();
            System.out.println("Chargement du Driver R�ussie");

            Connection cnx = DriverManager.getConnection("jdbc:sqlite:magasin.sqlite");
            System.out.println("Connexion R�ussie");

            Statement lien = cnx.createStatement();
            System.out.println("Lien Cr��");

            ResultSet rs = lien.executeQuery("select * from `product` ");
            System.out.println("Requ�te Effectu�e");

            while (rs.next()) {

                products.add(new Product(rs.getFloat("price"), rs.getString("productname"), rs.getString("image")));
                

            }

        } catch (Exception e) {

            System.out.println("Le Programme a Echou� :/ \n" + e.getMessage());

        }

    }

    public Product getCurrentProduct() {

        return products.get(currentIndex);

    }

    public Product nextProduct() {

        if (currentIndex == products.size() - 1) {

            currentIndex = 0;

        } else {

            currentIndex++;

        }

        return products.get(currentIndex);

    }

    public Product prevProduct() {

        if (currentIndex == 0) {

            currentIndex = products.size() - 1;

        } else {

            currentIndex--;

        }

        return products.get(currentIndex);

    }

}
