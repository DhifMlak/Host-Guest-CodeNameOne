/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Firas
 */
public class Hote extends Utilisateur {

    public Hote() {
    }
    
    public Hote(int id, String nom, String prenom, String cin){
        super(id, nom, prenom, cin);
    }

    public Hote(int id, String nom, String prenom, Date dateNaissance, String cin, String email, String pseudo, String motDePasse, int etat, String role) {
        super(id, nom, prenom, dateNaissance, cin, email, pseudo, motDePasse, etat, role);
    }

    public Hote(String nom, String prenom, Date dateNaissance, String cin, String email, String pseudo, String motDePasse, int etat) {
        super(nom, prenom, dateNaissance, cin, email, pseudo, motDePasse, etat);
    }

    
   
    
    
    
    
}
