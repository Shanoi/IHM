/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.kernel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Olivier
 */
public class InsertApp {

    private Connection connect() {
        // SQLite connection string 
        String url = "jdbc:sqlite:magasin.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insertMagasin(String name, String adresse, double latitude, double longitude,
            String tel, String mail, double ca, int nbEmployes, double coutMaintenance, String pageWeb, int prodRenvoyes) {
        String sql = "INSERT INTO magasin(idMagasin,magasinName,adresseMagasin,latitudeMagasin,longitudeMagasin,"
                + "TelephoneMagasin,mailMagasin,CAMagasin,nbEmployés,coutMaintenance,pageWeb,prodRenvoyés) "
                + "VALUES($next_id,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(2, name);
            pstmt.setString(3, adresse);
            pstmt.setDouble(4, latitude);
            pstmt.setDouble(5, longitude);
            pstmt.setString(6, tel);
            pstmt.setString(7, mail);
            pstmt.setDouble(8, ca);
            pstmt.setInt(9, nbEmployes);
            pstmt.setDouble(10, coutMaintenance);
            pstmt.setString(11, pageWeb);
            pstmt.setInt(12, prodRenvoyes);
            pstmt.executeUpdate();
            
            System.out.println("Requête Effectuée");
            
        } catch (SQLException e) {
            System.out.println("Le Programme a Echoué :/ \n" + e.getMessage());
        }
    }

}
