/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ihm.kernel;

import fr.polytech.ihm.data.Events;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EventParser {

    private List<Events> events;

    public EventParser() {

        events = new ArrayList<>();

        try {
            Class.forName("org.sqlite.JDBC").newInstance();

            Connection cnx = DriverManager.getConnection("jdbc:sqlite:magasin.sqlite");

            Statement lien = cnx.createStatement();

            ResultSet rs = lien.executeQuery("select * from event");

            while (rs.next()) {
                events.add(new Events(rs.getInt("idEvent"),
                        rs.getInt("idMagasin"),
                        rs.getString("nameEvent"),
                        rs.getString("dateEvent"),
                        rs.getString("descriptionEvent")));
            }
        } catch (Exception e) {
            System.out.println("Le Programme a Echoué :/ \n" + e.getMessage());
        }
    }

    public List<Events> getEvents(){
        return events;
    }

}
