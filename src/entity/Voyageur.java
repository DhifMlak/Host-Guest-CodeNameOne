/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Firas
 */
public class Voyageur extends Utilisateur{

    public Voyageur() {
    }

    public Voyageur(int id, String nom, String prenom, Date dateNaissance, String cin, String email, String pseudo, String motDePasse, int etat, String role) {
        super(id, nom, prenom, dateNaissance, cin, email, pseudo, motDePasse, etat, role);
    }

    public Voyageur(String nom, String prenom, Date dateNaissance, String cin, String email, String pseudo, String motDePasse, int etat) {
        super(nom, prenom, dateNaissance, cin, email, pseudo, motDePasse, etat);
    }

    public Voyageur(String nom, String prenom, String cin, String email, String pseudo, String motDePasse, int etat) {
        super(nom, prenom, cin, email, pseudo, motDePasse, etat);
    }
    

    
    
    
    
}
