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
public class UpdateApp {
    
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
    
    public void upDateMagasin(int idMagasin, String name, String adresse, double latitude, double longitude,
            String tel, String mail, double ca, int nbEmployes, double coutMaintenance, String pageWeb, int prodRenvoyes) {
        
        
        String sql = "UPDATE magasin SET magasinName = ?, adresseMagasin = ?, latitudeMagasin = ?, longitudeMagasin = ?,"
                + "TelephoneMagasin = ?, mailMagasin = ?, CAMagasin = ?, nbEmployés = ?, coutMaintenance = ?, pageWeb = ?, prodRenvoyés = ? "
                + "WHERE idMagasin = ?";
        
        System.out.println("QUERY :  " + sql);

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, adresse);
            pstmt.setDouble(3, latitude);
            pstmt.setDouble(4, longitude);
            pstmt.setString(5, tel);
            pstmt.setString(6, mail);
            pstmt.setDouble(7, ca);
            pstmt.setInt(8, nbEmployes);
            pstmt.setDouble(9, coutMaintenance);
            pstmt.setString(10, pageWeb);
            pstmt.setInt(11, prodRenvoyes);
            pstmt.setInt(12, idMagasin);
            
            System.out.println("QUERY :  " + pstmt.toString());

            System.out.println("Requête d'update Effectuée " + pstmt.executeUpdate());

        } catch (SQLException e) {
            System.out.println("Le Programme a Echoué :/ \n" + e.getMessage());
        }
    }
    
}