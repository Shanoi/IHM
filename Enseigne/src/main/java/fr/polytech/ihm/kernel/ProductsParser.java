/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.kernel;

import fr.polytech.ihm.data.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductsParser {

    private List<Product> products;

    private int currentIndex = 0;

    public ProductsParser() {

        products = new ArrayList<>();

        try {

            Class.forName("org.sqlite.JDBC").newInstance();
            System.out.println("Chargement du Driver Réussie");

            Connection cnx = DriverManager.getConnection("jdbc:sqlite:magasin.sqlite");
            System.out.println("Connexion Réussie");

            Statement lien = cnx.createStatement();
            System.out.println("Lien Créé");

            ResultSet rs = lien.executeQuery("select * from products "
                    + "NATURAL JOIN sell");
            System.out.println("Requête Effectuée");

            while (rs.next()) {

                products.add(new Product(rs.getFloat("priceSell"),
                        rs.getString("productName"),
                        rs.getString("picture"),
                        rs.getString("description"),
                        rs.getString("category"),
                        rs.getInt("idMarque"),
                        rs.getInt("nbSell")));
                System.out.println("RES : " + rs.getString("category"));

            }

        } catch (Exception e) {

            System.out.println("Le Programme a Echoué :/ \n" + e.getMessage());

        }

    }

    public int getNbMainProds() {

        return products.size();

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

    public List<Product> getProducts(){
        return products;
    }
}
