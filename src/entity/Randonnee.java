/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Firas
 */
public class Randonnee extends Offre {
    private String titre;
    private String lieu;
    private int nbMax;
    private String description;
    private String lieuRencontre;
    private String heureRencontre;
    private int prix;

    public String getLieuRencontre() {
        return lieuRencontre;
    }

    public void setLieuRencontre(String lieuRencontre) {
        this.lieuRencontre = lieuRencontre;
    }
    
    public Randonnee() {
        
    }
    public Randonnee(String titre, String lieu, int nbMax, String description,String lieuRencontre,String heureRencontre,int prix, int id,String typeOffre, Hote hote) {
        super(id,typeOffre, hote);
        this.titre = titre;
        this.lieu = lieu;
        this.nbMax = nbMax;
        this.description = description;
        this.lieuRencontre=lieuRencontre;
        this.heureRencontre=heureRencontre;
        this.prix=prix;
        
    }

    public Randonnee(String titre, String lieu, int nbMax, String description,String lieuRencontre,String heureRencontre,int prix,String typeOffre, Hote hote) {
        super(typeOffre,hote);
        this.titre = titre;
        this.lieu = lieu;
        this.nbMax = nbMax;
        this.description = description;
        this.lieuRencontre=lieuRencontre;
        this.heureRencontre=heureRencontre;
        this.prix=prix;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getNbMax() {
        return nbMax;
    }

    public void setNbMax(int nbMax) {
        this.nbMax = nbMax;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Randonnee{" + "titre=" + titre + ", lieu=" + lieu + ", nbMax=" + nbMax + ", description=" + description + ", lieuRencontre=" + lieuRencontre + ", heureRencontre=" + heureRencontre + ", prix=" + prix + '}';
    }

    

    public String getHeureRencontre() {
        return heureRencontre;
    }

    public void setHeureRencontre(String heureRencontre) {
        this.heureRencontre = heureRencontre;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    
    
    
    
    
}
