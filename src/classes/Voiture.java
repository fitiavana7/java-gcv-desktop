/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author ordi
 */
public class Voiture {
    private String id;
    private String marque;
    private String immatriculation;
    private int places;

    public Voiture() {
    }

    public Voiture(String marque , String immatriculation , int places) {
        this.marque = marque;
        this.immatriculation = immatriculation;
        this.places = places;     
    }
    
    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getMarque() {return marque;}
    public void setMarque(String marque) {this.marque = marque;}
    public String getImmatriculation() {return immatriculation;}
    public void setPlaces(int places) {this.places = places;}
    public int getPlaces() {return places;}
}
