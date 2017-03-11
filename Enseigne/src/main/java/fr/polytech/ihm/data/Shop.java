package fr.polytech.ihm.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.awt.*;
import java.math.BigDecimal;

/**
 * Created by Enzo on 06/03/2017.
 */
public class Shop {
    private int idShop;
    private StringProperty nameShop;
    private StringProperty adressShop;
    private Point position;
    private double latitudeShop;
    private double longitudeShop;
    private StringProperty phoneShop;
    private StringProperty mailShop;
    private double caShop;
    private int nbEmployees;
    private double maintenanceCost;
    private StringProperty website;
    private int prodBack;

    public Shop(int idShop, String nameShop, String adressShop, double latitudeShop, double longitudeShop, String phoneShop, String mailShop, double caShop, int nbEmployees, double maintenanceCost, String website, int prodBack){
        this.idShop = idShop;
        this.nameShop = new SimpleStringProperty(nameShop);
        this.adressShop = new SimpleStringProperty(adressShop);
        this.position = new Point((int) latitudeShop, (int) longitudeShop);
        this.phoneShop = new SimpleStringProperty(phoneShop);
        this.mailShop = new SimpleStringProperty(mailShop);
        this.caShop = caShop;
        this.nbEmployees = nbEmployees;
        this.maintenanceCost = maintenanceCost;
        this.website = new SimpleStringProperty(website);
        this.prodBack = prodBack;
    }

    public double distanceShopForPos(Point point){
        double dist = this.position.distance(point);

        BigDecimal bd = new BigDecimal(dist);
        bd= bd.setScale(3,BigDecimal.ROUND_DOWN);
        dist = bd.doubleValue();

        return dist;
    }

    public int getIdShop(){
        return idShop;
    }

    public StringProperty getNameShop(){
        return nameShop;
    }

    public StringProperty getAdressShop(){
        return adressShop;
    }

    public double getLatitudeShop(){
        return latitudeShop;
    }

    public double getLongitudeShop(){
        return longitudeShop;
    }

    public StringProperty getPhoneShop(){
        return phoneShop;
    }

    public StringProperty getMailShop(){
        return mailShop;
    }

    public double getCaShop(){
        return caShop;
    }

    public int getNbEmployees(){
        return nbEmployees;
    }

    public double getMaintenanceCost(){
        return maintenanceCost;
    }

    public StringProperty getWebsite(){
        return website;
    }

    public int getProdBack(){
        return prodBack;
    }
}
