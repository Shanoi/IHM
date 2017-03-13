/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.kernel;

import fr.polytech.ihm.data.JobOffer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class JobOfferParser {

    private List<JobOffer> jobOffers;

    public JobOfferParser() {

        jobOffers = new ArrayList<>();

        extractJobs();
    }

    private void extractJobs(){
        jobOffers.clear();

        try {
            Class.forName("org.sqlite.JDBC").newInstance();

            Connection cnx = DriverManager.getConnection("jdbc:sqlite:magasin.sqlite");

            Statement lien = cnx.createStatement();

            ResultSet rs = lien.executeQuery("select * from offersJobs");

            while (rs.next()) {
                jobOffers.add(new JobOffer(rs.getInt("idOffer"),
                        rs.getString("function"),
                        rs.getString("description"),
                        rs.getString("dateBegin"),
                        rs.getInt("idMagasin")));
            }

            rs.close();
            lien.close();
            cnx.close();

        } catch (Exception e) {
            System.out.println("Le Programme a Echoué :/ \n" + e.getMessage());
        }
    }

    public List<JobOffer> getJobOffers(){
        extractJobs();
        return jobOffers;
    }

}
