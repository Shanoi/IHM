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

/**
 *
 * @author Olivier
 */
public class CategoryProduct {

    public static ArrayList<Product> getCategoryProduct(String category) {

        ArrayList<Product> products = new ArrayList<>();

        try {

            Class.forName("org.sqlite.JDBC").newInstance();
            System.out.println("Chargement du Driver Réussie");

            Connection cnx = DriverManager.getConnection("jdbc:sqlite:magasin.sqlite");
            System.out.println("Connexion Réussie");

            Statement lien = cnx.createStatement();
            System.out.println("Lien Créé");

            String query = "select * "
             + "FROM products "
             + "NATURAL JOIN sell "
             + "WHERE products.category = \'"+ category +"\'";


            System.out.println("Requête : " + query);

            ResultSet rs = lien.executeQuery(query);
            System.out.println("Requête Effectuée");

            while (rs.next()) {

                products.add(new Product(rs.getFloat("priceSell"),
                 rs.getString("productName"),
                 rs.getString("picture"),
                 rs.getString("description"),
                 rs.getString("category")));
                System.out.println("RES : " + rs.getString("productName"));

            }

        } catch (Exception e) {

            System.out.println("Le Programme a Echoué :/ \n" + e.getMessage());

        }

        return products;

    }

}
