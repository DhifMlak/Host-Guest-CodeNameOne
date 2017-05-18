/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Joey Badass
 */
public class Sortie extends Offre{
   
    private String titre;
    private String lieu;
    private int nbMax;
    private String description;
    private String conditions;
    private String typeSortie;
    private String date;

    public Sortie(String titre, String lieu, int nbMax, String description, String conditions, String typeSortie, int id, String type, Hote hote) {
        super(id, type, hote);
        this.titre = titre;
        this.lieu = lieu;
        this.nbMax = nbMax;
        this.description = description;
        this.conditions = conditions;
        this.typeSortie = typeSortie;
    }

    public Sortie(String titre, String lieu, int nbMax, String description, String conditions, String typeSortie, String date, int id, String type, Hote hote) {
        super(id, type, hote);
        this.titre = titre;
        this.lieu = lieu;
        this.nbMax = nbMax;
        this.description = description;
        this.conditions = conditions;
        this.typeSortie = typeSortie;

        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

   
    
    

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public void setTypeSortie(String typeSortie) {
        this.typeSortie = typeSortie;
    }

    public String getConditions() {
        return conditions;
    }

    public String getTypeSortie() {
        return typeSortie;
    }

//    public Sortie(int id,String titre, String lieu, int nbMax, String description,String conditions,String typeSortie, String typeOffre, Hote hote) {
//        super(id,typeOffre, hote);
//       
//        this.titre = titre;
//        this.lieu = lieu;
//        this.nbMax = nbMax;
//        this.description = description;
//        this.conditions=conditions;
//        this.typeSortie=typeSortie;
//    }

   

        public Sortie(String titre, String lieu, int nbMax, String description,String conditions,String typeSortie,String typeOffre, Hote hote) {
        super(typeOffre,hote);
        this.titre = titre;
        this.lieu = lieu;
        this.nbMax = nbMax;
        this.description = description;
        this.conditions=conditions;
        this.typeSortie=typeSortie;

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
        return "Sortie{" + "titre=" + titre + ", lieu=" + lieu + ", nbMax=" + nbMax + ", description=" + description + ", conditions=" + conditions + ", typeSortie=" + typeSortie + '}';
    }}

    

    
    
    
    
    


