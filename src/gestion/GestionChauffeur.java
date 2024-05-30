/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import classes.Chauffeur;
import connectionbd.ConnexionBase;
import java.sql.ResultSet;

/**
 *
 * @author ordi
 */
public class GestionChauffeur {

    public ConnexionBase connexion;

    public GestionChauffeur() throws Exception {
        connexion = new ConnexionBase();
    }

    public void insert(Chauffeur obj) throws Exception {
        String req = "INSERT INTO chauffeur(nom,prenom,adresse,cin,telephone,exp) VALUES('" +obj.getNom()+ "','" + obj.getPrenom()+ "','" + obj.getAdresse()+ "','" + obj.getCin()+ "','" + obj.getTelephone()+"','" + obj.getExp()+  "')";
        connexion.executeUpdate(req);
    }

    public void update(String id, Chauffeur obj) throws Exception {
        String query = "UPDATE chauffeur SET nom='" + obj.getNom()+ "',prenom='" + obj.getPrenom()+ "',adresse='" + obj.getAdresse()+ "',cin='" + obj.getCin()+ "',telephone='" + obj.getTelephone()+ "',exp='" + obj.getExp()+ "' WHERE id='" + id + "'";
        connexion.executeUpdate(query);
    }

    public void delete(String id) throws Exception {
        String query = "DELETE FROM chauffeur WHERE id='" + id + "'";
        connexion.executeUpdate(query);
    }

    public ResultSet getAll() throws Exception {
        String query = "SELECT * FROM chauffeur";
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }
    
     public ResultSet getByNom(String nom) throws Exception {
        String query = "SELECT * FROM chauffeur WHERE nom like('%" + nom + "%')";
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }
    
     public int countenregByNom (String nom) throws Exception {
        String query = "SELECT count(*) as nombre FROM chauffeur WHERE nom like('%" + nom + "%')" ;
        ResultSet rs = connexion.executeQuery(query) ;
        rs.next();
        int nbr = rs.getInt("nombre") ;
        return nbr ;
    }
     
    public int countenreg () throws Exception {
        String query = "SELECT count(*) as nombre FROM chauffeur" ;
        ResultSet rs = connexion.executeQuery(query) ;
        rs.next();
        int nbr = rs.getInt("nombre") ;
        return nbr ;
    }
}
