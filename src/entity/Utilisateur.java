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
public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String cin;
    private String email;
    private String pseudo;
    private String motDePasse;
    private int etat;
    private String role;
    
    public Utilisateur() {
        
    }

    public Utilisateur(int id, String nom, String prenom, Date dateNaissance, String cin, String email, String pseudo, String motDePasse, int etat,String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.cin = cin;
        this.email = email;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.etat = etat;
        this.role=role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Utilisateur(String nom, String prenom, Date dateNaissance, String cin, String email, String pseudo, String motDePasse, int etat) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.cin = cin;
        this.email = email;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.etat = etat;
    }
     public Utilisateur(String nom, String prenom ,String cin, String email, String pseudo, String motDePasse, int etat) {
        this.nom = nom;
        this.prenom = prenom;
        //this.dateNaissance = dateNaissance;
        this.cin = cin;
        this.email = email;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.etat = etat;
    }
      public Utilisateur(int id, String nom, String prenom, String cin) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

  

   

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", cin=" + cin + ", email=" + email + ", login=" + pseudo + ", pwd=" + motDePasse + ", etat=" + etat + '}';
    }
    
    
}
