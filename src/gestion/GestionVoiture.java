/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import classes.Voiture;
import connectionbd.ConnexionBase;
import java.sql.ResultSet;

/**
 *
 * @author ordi
 */
public class GestionVoiture {

    public ConnexionBase connexion;

    public GestionVoiture() throws Exception {
        connexion = new ConnexionBase();
    }

    public void insert(Voiture obj) throws Exception {
        String req = "INSERT INTO voiture(marque,immatriculation,places) VALUES('" +obj.getMarque()+ "','" + obj.getImmatriculation()+ "','" + obj.getPlaces()+"')";
        connexion.executeUpdate(req);
    }

    public void update(String id, Voiture obj) throws Exception {
        String query = "UPDATE voiture SET marque='" + obj.getMarque()+ "',immatriculation='" + obj.getImmatriculation()+ "',places='" + obj.getPlaces()+"' WHERE id='" + id + "'";
        connexion.executeUpdate(query);
    }

    public void delete(String id) throws Exception {
        String query = "DELETE FROM voiture WHERE id='" + id + "'";
        connexion.executeUpdate(query);
    }

    public ResultSet getAll() throws Exception {
        String query = "SELECT * FROM voiture";
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }
    
    public int countenreg () throws Exception {
        String query = "SELECT count(*) as nombre FROM voiture" ;
        ResultSet rs = connexion.executeQuery(query) ;
        rs.next();
        int nbr = rs.getInt("nombre") ;
        return nbr ;
    }
    
    public ResultSet getByImm(String imm) throws Exception {
        String query = "SELECT * FROM voiture WHERE immatriculation like('%" + imm + "%')";
        ResultSet rs = connexion.executeQuery(query);
        return rs;
    }
    
    public int countenregByImm (String imm) throws Exception {
        String query = "SELECT count(*) as nombre FROM voiture WHERE immatriculation like('%" + imm + "%')" ;
        ResultSet rs = connexion.executeQuery(query) ;
        rs.next();
        int nbr = rs.getInt("nombre") ;
        return nbr ;
    }
    
}
