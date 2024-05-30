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
public class Versement {
    private String date;
    private int montant;
    private String ligne ;
    private String point1 ;
    private String point2 ;
    private int idChauffeur ;
    private int idVoiture;
    private String voiture;

    public Versement() {
    }

    public Versement(String date , int montant ,String ligne , String point1 , String point2 , int idChauffeur,int idVoiture,String voiture) {
        this.date = date;
        this.montant = montant;
        this.ligne = ligne ;
        this.point1 = point1 ;
        this.point2 =  point2 ;
        this.idChauffeur = idChauffeur ;
        this.idVoiture= idVoiture ;
        this.voiture = voiture;
    }
    
    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}
    public int getMontant() {return montant;}
    public void setMontant(int montant) {this.montant = montant;}
    public String getLigne() {return ligne;}
    public void setLigne(String ligne) {this.ligne = ligne;}
    public String getPoint1() {return point1;}
    public void setPoint1(String point1) {this.point1 = point1;}
    public String getPoint2() {return point2;}
    public void setPoint2(String point2) {this.point2 = point2;}
    public int getIdChauffeur() {return idChauffeur;}
    public void setIdChauffeur(int idChauffeur) {this.idChauffeur = idChauffeur;}
    public int getIdVoiture() {return idVoiture;}
    public void setIdVoiture(int idVoiture) {this.idVoiture = idVoiture;}
    public String getvoiture() {return voiture;}
    public void setVoiture(String voiture) {this.voiture = voiture;}
}
