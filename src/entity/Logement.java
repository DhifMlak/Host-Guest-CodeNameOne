/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.Hote;
import entity.Offre;

/**
 *
 * @author Firas
 */
public class Logement extends Offre{
    private String titre;
    private String address;
    private String ville;
    private String paye;
    private float prix;
    private String type;

     public Logement() {
        
    }
    public Logement(String titre, String address, String ville, String paye, float prix, String type, int id, String typeOffre, Hote hote) {
        super(id,typeOffre, hote);
        this.titre = titre;
        this.address = address;
        this.ville = ville;
        this.paye = paye;
        this.prix = prix;
        this.type = type;
    }

    public Logement(String titre, String address, String ville, String paye, float prix, String type,String typeOffre, Hote hote) {
        super(typeOffre,hote);
        this.titre = titre;
        this.address = address;
        this.ville = ville;
        this.paye = paye;
        this.prix = prix;
        this.type = type;
    }

   

    public String getTitre() {
        return titre;
    }

    public String getAddress() {
        return address;
    }

    public String getVille() {
        return ville;
    }

    public String getPaye() {
        return paye;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrix() {
        return prix;
    }

    public String getTypeOffre() {
        return type;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setPaye(String paye) {
        this.paye = paye;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setTypeOffre(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "logement{" + "titre=" + titre + ", address=" + address + ", ville=" + ville + ", paye=" + paye + ", prix=" + prix + ", type=" + type + '}';
    }
    
    
    
      
    
    
    
}
