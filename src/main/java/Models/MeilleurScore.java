package Models;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MeilleurScore {
    private String joueur;
    private int top;

    public MeilleurScore() {
        Gson gson = new Gson();
        MeilleurScore meilleurScore = null;
        try{
            Reader reader = Files.newBufferedReader(Paths.get("MeilleureScore.json"));
            meilleurScore = gson.fromJson(reader,MeilleurScore.class);
            reader.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        if(meilleurScore != null) {
            this.top = meilleurScore.top;
            this.joueur = meilleurScore.joueur;
        } else{
            this.top = 0;
            this.joueur = "No player";
        }
    }

    public String getJoueur() {
        return joueur;
    }

    public void setJoueur(String joueur) {
        this.joueur = joueur;
    }

    public String getTop() {
        return String.valueOf(top);
    }

    public void setTop(int top) {
        this.top = top;
    }


    public void modifyMeiScore(String joueur, int score) {
        if(this.top <= score) {
            this.joueur = joueur;
            this.top = score;
        }
        Gson gson = new Gson();
        try{
            Writer writer = new FileWriter("MeilleureScore.json");
            gson.toJson(this, writer);
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
