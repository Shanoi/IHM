/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.kernel;

import fr.polytech.ihm.data.Shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ShopParser {

    private List<Shop> shops;

    public ShopParser() {

        shops = new ArrayList<>();

        try {
            Class.forName("org.sqlite.JDBC").newInstance();

            Connection cnx = DriverManager.getConnection("jdbc:sqlite:magasin.sqlite");

            Statement lien = cnx.createStatement();

            ResultSet rs = lien.executeQuery("select * from magasin");

            while (rs.next()) {
                shops.add(new Shop(rs.getInt("idMagasin"),
                        rs.getString("magasinName"),
                        rs.getString("adresseMagasin"),
                        rs.getDouble("latitudeMagasin"),
                        rs.getDouble("longitudeMagasin"),
                        rs.getString("telephoneMagasin"),
                        rs.getString("mailMagasin"),
                        rs.getDouble("CAMagasin"),
                        rs.getInt("nbEmployés"),
                        rs.getDouble("coutMaintenance"),
                        rs.getString("pageWeb"),
                        rs.getInt("prodRenvoyés")));
            }
        } catch (Exception e) {
            System.out.println("Le Programme a Echoué :/ \n" + e.getMessage());
        }
    }

    public List<Shop> getShop(){
        return shops;
    }

}
