package Models;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String phrase;
    private List<Reponse> reponses = new ArrayList<>();

    public Question(String phrase, Reponse[] reponses){
        this.phrase = phrase;
        this.reponses.add(reponses[0]);
        this.reponses.add(reponses[1]);
        this.reponses.add(reponses[2]);
        this.reponses.add(reponses[3]);
    }

    public String getPhrase(){
        return this.phrase;
    }
    public Reponse getReponse(int indAns){
        return this.reponses.get(indAns);
    }


}
