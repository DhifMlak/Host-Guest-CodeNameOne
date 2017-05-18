/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Joey Badass
 */
public class Rating {
    int id;
    int idSortie;
    int rate;

    public Rating(int id, int idSortie, int rate) {
        this.id = id;
        this.idSortie = idSortie;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSortie() {
        return idSortie;
    }

    public void setIdSortie(int idSortie) {
        this.idSortie = idSortie;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "rating{" + "id=" + id + ", idSortie=" + idSortie + ", rate=" + rate + '}';
    }
    
    
}
