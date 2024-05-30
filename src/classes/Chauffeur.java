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
public class Chauffeur {
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String cin;
    private String telephone;
    private int exp;

    public Chauffeur() {
    }

    public Chauffeur(String nom , String prenom , String adresse , String cin , String telephone , int exp ) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.cin = cin;
        this.telephone = telephone;
        this.exp = exp;
    }
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}
    public String getPrenom() {return prenom;}
    public void setPrenom(String prenom) {this.prenom = prenom;}
    public String getAdresse() {return adresse;}
    public void setAdresse(String adresse) {this.adresse = adresse;}
    public String getCin() {return cin;}
    public void setCin(String cin) {this.cin = cin;}
    public String getTelephone() {return telephone;}
    public void setTelephone(String telephone) {this.telephone = telephone;}
    public int getExp() {return exp;}
    public void setExp(int exp) {this.exp = exp;}
}
