/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.kernel;

import fr.polytech.ihm.data.Category;
import fr.polytech.ihm.data.Marque;
import fr.polytech.ihm.data.Product;
import static fr.polytech.ihm.kernel.Constantes.All;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Olivier
 */
public class Tools {

    private static final Logger log = LoggerFactory.getLogger(Tools.class);

    public static ArrayList<Product> getCategoryProduct(String category) {

        ArrayList<Product> products = new ArrayList<>();

        StringBuilder query = new StringBuilder();

        try {

            Class.forName("org.sqlite.JDBC").newInstance();
            System.out.println("Chargement du Driver Réussie");

            Connection cnx = DriverManager.getConnection("jdbc:sqlite:magasin.sqlite");
            System.out.println("Connexion Réussie");

            Statement lien = cnx.createStatement();
            System.out.println("Lien Créé");

            query.append("select * "
                    + "FROM products ");

            query.append("WHERE products.category = \'").append(category).append("\'");

            ResultSet rs = lien.executeQuery(query.toString());
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

    public static ArrayList<Product> getSearchProduct(String category, String marque, boolean promo, int pMax, int pMin) {

        log.info("Marque : " + marque + " category : " + category);

        ArrayList<Product> products = new ArrayList<>();

        StringBuilder query = new StringBuilder();

        try {

            Class.forName("org.sqlite.JDBC").newInstance();
            System.out.println("Chargement du Driver Réussie");

            Connection cnx = DriverManager.getConnection("jdbc:sqlite:magasin.sqlite");
            System.out.println("Connexion Réussie");

            Statement lien = cnx.createStatement();
            System.out.println("Lien Créé");

            query.append("SELECT * " + "FROM products "
                    + "NATURAL JOIN marque "
                    + "WHERE priceProduct >= ")
                    .append(pMin)
                    .append(" AND priceProduct <= ")
                    .append(pMax);

            if (!category.equals(All.toString())) {

                query.append(" AND products.category = \'").append(category).append("\'");

            }

            if (!marque.equals(All.toString())) {

                query.append(" AND marqueName = \'").append(marque).append("\'");

            }

            if (promo) {
                query.append(" AND promo != 0");

            }

            ResultSet rs = lien.executeQuery(query.toString());
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

            log.error("getSearchProduct --- Le Programme a Echoué :/ \n" + e.getMessage());

        }

        return products;

    }

    public static float getMaxPriceCategoryProduct(String category, String marque, boolean promo) {

        log.info("Marque : " + marque + " category : " + category);

        float max = 5000;

        int promoPrice = 0;

        StringBuilder query = new StringBuilder();

        try {

            Class.forName("org.sqlite.JDBC").newInstance();
            System.out.println("Chargement du Driver Réussie");

            Connection cnx = DriverManager.getConnection("jdbc:sqlite:magasin.sqlite");
            System.out.println("Connexion Réussie");

            Statement lien = cnx.createStatement();
            System.out.println("Lien Créé");

            /*query.append("select max(priceProduct) AS maxPrice "
             + "FROM products "
             + "NATURAL JOIN marque ");*/
            query.append("select * "
                    + "FROM products "
                    + "NATURAL JOIN marque ");

            if (!category.equals(All.toString())) {

                query.append("WHERE products.category = \'").append(category).append("\' ");

            }

            if (!category.equals("All") && !marque.equals(All.toString())) {

                query.append(" AND marqueName = \'").append(marque).append("\'");

            }

            if (category.equals("All") && !marque.equals(All.toString())) {

                query.append("WHERE marqueName = \'").append(marque).append("\'");

            }

            if (promo && category.equals("All") && marque.equals(All.toString())) {

                query.append("WHERE promo != 0");

            } else if (promo) {

                query.append(" AND promo != 0");

            }

            query.append(" ORDER BY priceProduct DESC, promo ASC");

            log.debug("QUERY : " + query);

            ResultSet rs = lien.executeQuery(query.toString());
            System.out.println("Requête Effectuée");

            max = rs.getFloat("priceProduct");

            promoPrice = rs.getInt("promo");

            if (promoPrice != 0) {

                max = max * ((float) promoPrice / 100);

            }

            rs.close();
            lien.close();
            cnx.close();

            return max + 1;

        } catch (Exception e) {

            log.error("getMaxPriceCategoryProduct -- Le Programme a Echoué :/ \n" + e.getMessage());

        }

        return max + 1;

    }

    public static float getMaxPriceSearchProduct(String search) {

        float max = 5000;

        int promoPrice = 0;

        StringBuilder query = new StringBuilder();

        try {

            Class.forName("org.sqlite.JDBC").newInstance();
            System.out.println("Chargement du Driver Réussie");

            Connection cnx = DriverManager.getConnection("jdbc:sqlite:magasin.sqlite");
            System.out.println("Connexion Réussie");

            Statement lien = cnx.createStatement();
            System.out.println("Lien Créé");

            query.append("SELECT * " + "FROM products " + "NATURAL JOIN marque " + "WHERE productName LIKE \'%").append(search).append("%\' ");

            query.append(" ORDER BY priceProduct DESC, promo ASC");

            log.debug("QUERY : " + query);

            ResultSet rs = lien.executeQuery(query.toString());
            System.out.println("Requête Effectuée");

            max = rs.getFloat("priceProduct");

            promoPrice = rs.getInt("promo");

            if (promoPrice != 0) {

                max = max * ((float) promoPrice / 100);

            }

            rs.close();
            lien.close();
            cnx.close();

            return max + 1;

        } catch (Exception e) {

            log.error("getMaxPriceCategoryProduct -- Le Programme a Echoué :/ \n" + e.getMessage());

        }

        return max + 1;

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

        StringBuilder query = new StringBuilder();

        try {

            Class.forName("org.sqlite.JDBC").newInstance();
            System.out.println("Chargement du Driver Réussie");

            Connection cnx = DriverManager.getConnection("jdbc:sqlite:magasin.sqlite");
            System.out.println("Connexion Réussie");

            Statement lien = cnx.createStatement();
            System.out.println("Lien Créé");

            query.append("SELECT DISTINCT marqueName, idMarque "
                    + "FROM marque "
                    + "NATURAL JOIN products ");

            if (!category.equals(All.toString())) {

                query.append("WHERE category = \'").append(category).append("\'");

            }

            ResultSet rs = lien.executeQuery(query.toString());
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

    public static ArrayList<Product> getAllProduct(String name) {

        ArrayList<Product> products = new ArrayList<>();

        StringBuilder query = new StringBuilder();

        try {

            Class.forName("org.sqlite.JDBC").newInstance();
            System.out.println("Chargement du Driver Réussie");

            Connection cnx = DriverManager.getConnection("jdbc:sqlite:magasin.sqlite");
            System.out.println("Connexion Réussie");

            Statement lien = cnx.createStatement();
            System.out.println("Lien Créé");

            query.append("SELECT * " + "FROM products " + "NATURAL JOIN marque " + "WHERE productName LIKE \'%").append(name).append("%\' ");

            ResultSet rs = lien.executeQuery(query.toString());
            System.out.println("Requête Effectuée");

            while (rs.next()) {
                System.out.println("RESR : " + rs.getString("productName"));
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

            log.error("getSearchProduct --- Le Programme a Echoué :/ \n" + e.getMessage());

        }

        return products;

    }

}
