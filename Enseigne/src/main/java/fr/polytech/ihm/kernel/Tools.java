/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.kernel;

import fr.polytech.ihm.data.Category;
import fr.polytech.ihm.data.Marque;
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
public class Tools {

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
                    + "WHERE products.category = \'" + category + "\'";

            ResultSet rs = lien.executeQuery(query);
            System.out.println("Requête Effectuée");

            while (rs.next()) {

                products.add(new Product(rs.getFloat("priceProduct"),
                        rs.getString("productName"),
                        rs.getString("picture"),
                        rs.getString("description"),
                        rs.getString("category"),
                        rs.getInt("idMarque"),
                        rs.getInt("nbSell"),
                        rs.getInt("idProduct"),
                        (rs.getInt("produitPhare") == 1),
                        (rs.getInt("enVente") == 1),
                        rs.getInt("promo")));
                
            }

            rs.close();
            lien.close();
            cnx.close();

        } catch (Exception e) {

            System.out.println("Le Programme a Echoué :/ \n" + e.getMessage());

        }

        return products;

    }

    public static float getMaxPriceCategoryProduct(String category) {

        

        float max = 5000;
        
        try {

            Class.forName("org.sqlite.JDBC").newInstance();
            System.out.println("Chargement du Driver Réussie");

            Connection cnx = DriverManager.getConnection("jdbc:sqlite:magasin.sqlite");
            System.out.println("Connexion Réussie");

            Statement lien = cnx.createStatement();
            System.out.println("Lien Créé");

            String query = "select max(priceProduct) AS maxPrice "
                    + "FROM products "
                    + "WHERE products.category = \'" + category + "\'";

            ResultSet rs = lien.executeQuery(query);
            System.out.println("Requête Effectuée");

            max = rs.getFloat("maxPrice");

            rs.close();
            lien.close();
            cnx.close();

            return max;
            
        } catch (Exception e) {

            System.out.println("Le Programme a Echoué :/ \n" + e.getMessage());

        }

        return max;

    }

    public static ArrayList<Category> getAllCategory() {

        ArrayList<Category> categories = new ArrayList<>();

        try {

            Class.forName("org.sqlite.JDBC").newInstance();
            System.out.println("Chargement du Driver Réussie");

            Connection cnx = DriverManager.getConnection("jdbc:sqlite:magasin.sqlite");
            System.out.println("Connexion Réussie");

            Statement lien = cnx.createStatement();
            System.out.println("Lien Créé");

            String query = "select * "
                    + "FROM category ";

            ResultSet rs = lien.executeQuery(query);
            System.out.println("Requête Effectuée");

            while (rs.next()) {

                categories.add(new Category(rs.getString("category"),
                        rs.getString("imageCategory")));

            }

            rs.close();
            lien.close();
            cnx.close();

        } catch (Exception e) {

            System.out.println("Le Programme a Echoué :/ \n" + e.getMessage());

        }

        return categories;

    }

    public static ArrayList<Marque> getAllMarque(String category) {

        ArrayList<Marque> marques = new ArrayList<>();

        try {

            Class.forName("org.sqlite.JDBC").newInstance();
            System.out.println("Chargement du Driver Réussie");

            Connection cnx = DriverManager.getConnection("jdbc:sqlite:magasin.sqlite");
            System.out.println("Connexion Réussie");

            Statement lien = cnx.createStatement();
            System.out.println("Lien Créé");

            String query = "SELECT DISTINCT marqueName, idMarque "
                    + "FROM marque "
                    + "NATURAL JOIN products "
                    + "WHERE category = \'" + category + "\'";

            ResultSet rs = lien.executeQuery(query);
            System.out.println("Requête Effectuée");

            while (rs.next()) {

                marques.add(new Marque(rs.getString("marqueName"),
                        rs.getInt("idMarque")));

            }

            rs.close();
            lien.close();
            cnx.close();

        } catch (Exception e) {

            System.out.println("Le Programme a Echoué :/ \n" + e.getMessage());

        }

        return marques;

    }

}
