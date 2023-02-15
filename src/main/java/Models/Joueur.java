package Models;

import java.util.ArrayList;
import java.util.List;

public class Joueur {

    private String nom;
    private int meilleureScore;
    private Partie partie;
    private int LastScore;
    private int LastCase;

    public Joueur(String nom, Partie session) {
        this.nom = nom;
        this.partie = session;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getMeilleurScore() {
        return this.meilleureScore;
    }

    public void setMeilleurScore(int meilleurScore) {
        this.meilleureScore = meilleurScore;
    }

    public int getMeilleureScore() {
        return this.meilleureScore;
    }


    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    public int getLastScore() {
        return this.LastScore;
    }

    public void setLastScore(int lastScore) {
        this.LastScore = lastScore;
    }

    public int getLastCase() {
        return this.LastCase;
    }

    public void setLastCase(int lastCase) {
        this.LastCase = lastCase;
    }

    public void modifyTop(int score) {
        if((this.meilleureScore) < score){
            this.meilleureScore = score;
        }
    }


}