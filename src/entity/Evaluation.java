/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ahmed
 */
public class Evaluation {
    private int id;
    private String titre;
    private Float note;
    private String commentaire;
    private Float facility;
    private Float service;
    private Float interesting;
    private Float human;
    private int id_offre;
    

    public Evaluation(String titre, Float note, String commentaire) {
        this.titre = titre;
        this.note = note;
        this.commentaire = commentaire;
    }

   

    public int getId_offre() {
        return id_offre;
    }

    public Evaluation(String titre, String commentaire,Float facility, Float service, Float interesting, Float human, int id_offre) {
        this.titre = titre;
        this.commentaire = commentaire;
        this.facility = facility;
        this.service = service;
        this.interesting = interesting;
        this.human = human;
        this.id_offre = id_offre;
    }
 

    public Evaluation() {
    }

    public Evaluation(int id, String titre, Float note, String commentaire, Float facility, Float service, Float interesting, Float human) {
        this.id = id;
        this.titre = titre;
        this.note = note;
        this.commentaire = commentaire;
        this.facility = facility;
        this.service = service;
        this.interesting = interesting;
        this.human = human;
    }

    public Evaluation(String titre, String commentaire, Float facility, Float service, Float interesting, Float human) {
        this.titre = titre;
        this.commentaire = commentaire;
        this.facility = facility;
        this.service = service;
        this.interesting = interesting;
        this.human = human;
    }

    public Evaluation(int id, String titre, String commentaire, Float facility, Float service, Float interesting, Float human) {
        this.id = id;
        this.titre = titre;
        this.commentaire = commentaire;
        this.facility = facility;
        this.service = service;
        this.interesting = interesting;
        this.human = human;
    }

    public Evaluation(int id,String titre, String commentaire) {
        this.id = id;
        this.titre = titre;
        this.commentaire = commentaire;
    }

    public Evaluation(int id, String titre, Float note, String commentaire) {
        this.id = id;
        this.titre = titre;
        this.note = note;
        this.commentaire = commentaire;
    }
    



    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Float getFacility() {
        return facility;
    }

    public void setFacility(Float facility) {
        this.facility = facility;
    }

    public Float getService() {
        return service;
    }

    public void setService(Float service) {
        this.service = service;
    }

    public Float getInteresting() {
        return interesting;
    }

    public void setInteresting(Float interesting) {
        this.interesting = interesting;
    }

    public Float getHuman() {
        return human;
    }

    public void setHuman(Float human) {
        this.human = human;
    }

    @Override
    public String toString() {
        return "Evaluation{" + "titre=" + titre + ", note=" + note + ", commentaire=" + commentaire + ", facility=" + facility + ", service=" + service + ", interesting=" + interesting + ", human=" + human + '}';
    }
    
    

    
}
