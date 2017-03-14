package fr.polytech.ihm.kernel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Enzo on 14/03/2017.
 */
public class InfosEnseigneParser {

    private String imagePath;
    private String descEnseigne;

    public void extractData(){

        try {

            Class.forName("org.sqlite.JDBC").newInstance();
            System.out.println("Chargement du Driver Réussie");

            Connection cnx = DriverManager.getConnection("jdbc:sqlite:magasin.sqlite");
            System.out.println("Connexion Réussie");

            Statement lien = cnx.createStatement();
            System.out.println("Lien Créé");

            String query = "SELECT * "
                    + "FROM enseigne "
                    + "WHERE idEnseigne = 1 ";

            ResultSet rs = lien.executeQuery(query);
            System.out.println("Requête Effectuée");

            while (rs.next()) {

                imagePath = rs.getString("imageEnseigne");
                descEnseigne = rs.getString("descEnseigne");

            }

        } catch (Exception e) {

            System.out.println("Le Programme a Echoué :/ \n" + e.getMessage());

        }
    }

    public String getDescEnseigne() {
        return descEnseigne;
    }

    public String getImagePath() {
        return imagePath;
    }
}
