package fr.polytech.ihm.kernel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Enzo on 13/03/2017.
 */
public class CheckerTool {

    public boolean catAlreadyExists(String category){

        try {

            Class.forName("org.sqlite.JDBC").newInstance();
            System.out.println("Chargement du Driver Réussie");

            Connection cnx = DriverManager.getConnection("jdbc:sqlite:magasin.sqlite");
            System.out.println("Connexion Réussie");

            Statement lien = cnx.createStatement();
            System.out.println("Lien Créé");

            String query = "select COUNT(*) AS nbL "
                    + "from category "
                    + "WHERE category = \'" + category + "\'";

            ResultSet rs = lien.executeQuery(query);
            System.out.println("Requête Effectuée");

            boolean isTrue = rs.getInt("nbL") != 0;

            rs.close();
            lien.close();
            cnx.close();

            return isTrue;


        } catch (Exception e) {

            System.out.println("Le Programme a Echoué :/ \n" + e.getMessage());

        }

        return false;

    }
}
