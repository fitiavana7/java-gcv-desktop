/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import classes.Versement;
import connectionbd.ConnexionBase;
import java.sql.ResultSet;

/**
 *
 * @author ordi
 */
public class GestionVersement {

    public ConnexionBase connexion;

    public GestionVersement() throws Exception {
        connexion = new ConnexionBase();
    }

    public void insert(Versement obj) throws Exception {
        String req = "INSERT INTO versement(date , montant , ligne , point1 , point2 , chauffeur_id ,voiture_id , voiture) VALUES('" + obj.getDate()+ "','" + obj.getMontant()+ "','" + obj.getLigne()+ "','" + obj.getPoint1()+ "','" + obj.getPoint2()+ "','" + obj.getIdChauffeur()+ "','" + obj.getIdVoiture()+ "','" + obj.getvoiture()+ "')";
        connexion.executeUpdate(req);
    }

    public void update(String id, String code_vers, Versement obj) throws Exception {
        String query = "UPDATE versement SET date='" + obj.getDate()+ "',montant='" + obj.getMontant()+ "',ligne='" + obj.getLigne()+ "',point1='" + obj.getPoint1()+ "',point2='" + obj.getPoint2()+ "',chauffeur_id='" + obj.getIdChauffeur()+ "' , id_voiture='" + obj.getIdVoiture()+ "' WHERE id_chauffeur='" + id + "' AND id='" + code_vers + "'";
        connexion.executeUpdate(query);
    }

    public void delete(String id) throws Exception {
        String query = "DELETE FROM versement WHERE id='" + id + "'";
        connexion.executeUpdate(query);
    }
    
    public void deleteByImmatriculation(String id) throws Exception {
        String query = "DELETE FROM versement WHERE voiture='" + id + "'";
        connexion.executeUpdate(query);
    }
    
    public void deleteByChauffeur(String id) throws Exception {
        String query = "DELETE FROM versement WHERE chauffeur_id='" + id + "'";
        connexion.executeUpdate(query);
    }

    public ResultSet getDonneeByChauffeur() throws Exception {
        String query = "SELECT chauffeur.nom , SUM(versement.montant) as montant from versement JOIN chauffeur ON chauffeur.id=versement.chauffeur_id GROUP BY chauffeur.nom ";
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }
    
    public ResultSet getDonneeByVoiture() throws Exception {
        String query = "SELECT voiture , sum(montant) as montant FROM versement GROUP BY voiture;";
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }
    
    
    
    public ResultSet getByChauffeur(int chauffeur_id) throws Exception {
        String query = "SELECT * FROM versement where chauffeur_id='" + chauffeur_id + "' ;";
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }
    
     public ResultSet getByChauffeurAndDate(int chauffeur_id , String date) throws Exception {
        String query = "SELECT * FROM versement where chauffeur_id='" + chauffeur_id + "' AND date like('%" + date + "%')";
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }
    
    
    public ResultSet getDonneeByClasse() throws Exception {
        String query = "SELECT classe , COUNT(classe) as nombre FROM `reservation` GROUP BY classe ;";
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }
    
     public int countenregByChauffeur (int chauffeur_id) throws Exception {
        String query = "SELECT count(ligne) AS nombre FROM versement WHERE chauffeur_id='" + chauffeur_id + "';" ;
        ResultSet rs = connexion.executeQuery(query) ;
        rs.next();
        int nbr = rs.getInt("nombre") ;
        return nbr ;
    }
     
      public int countenregByChauffeurAndDate (int chauffeur_id , String date) throws Exception {
        String query = "SELECT count(ligne) AS nombre FROM versement WHERE chauffeur_id='" + chauffeur_id + "' AND date like('%" + date + "%')" ;
        ResultSet rs = connexion.executeQuery(query) ;
        rs.next();
        int nbr = rs.getInt("nombre") ;
        return nbr ;
    }
    
    public int countenreg () throws Exception {
        String query = "SELECT count(nom) AS nombre FROM client INNER JOIN reservation ON client.id_client = reservation.id_client;" ;
        ResultSet rs = connexion.executeQuery(query) ;
        rs.next();
        int nbr = rs.getInt("nombre") ;
        return nbr ;
    }
    public int countenregspecify (String nom , String depart , String arrivee) throws Exception {
        String query = "SELECT count(nom) AS nombre FROM client INNER JOIN reservation ON client.id_client = reservation.id_client  WHERE nom='" + nom + "' AND ville_depart='" + depart + "' AND ville_arrivee='" + arrivee + "' ;" ;
        ResultSet rs = connexion.executeQuery(query) ;
        rs.next();
        int nbr = rs.getInt("nombre") ;
        return nbr ;
    }
    public ResultSet getAll() throws Exception {
        String query = "SELECT nom , prenom , cin , classe , ville_depart , ville_arrivee , nombre_place , date_voyage , reservation.id_client , code_reservation , total FROM client INNER JOIN reservation ON client.id_client = reservation.id_client ORDER BY reservation.code_reservation DESC;";
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }
    public ResultSet getSpecifyDonnee(String nom , String depart , String arrivee) throws Exception {
        String query = "SELECT nom , prenom , cin , classe , ville_depart , ville_arrivee , nombre_place , date_voyage , reservation.id_client , code_reservation , montant FROM client INNER JOIN reservation ON client.id_client = reservation.id_client WHERE nom='" + nom + "' AND ville_depart='" + depart + "' AND ville_arrivee='" + arrivee + "' ORDER BY reservation.code_reservation DESC;";
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }
    public ResultSet getAllDonnee(String id , String code_res) throws Exception {
        String query = "SELECT * FROM client INNER JOIN reservation ON client.id_client = reservation.id_client WHERE reservation.id_client='" + id + "' AND code_reservation='" + code_res + "';";
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }
}
