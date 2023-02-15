package Models;

public class Reponse {
    private String text;
    private boolean isCorrect;

    public Reponse(String text, boolean isCorrect){
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public String getText(){
        return this.text;
    }

    public boolean isCorrect(){
        return this.isCorrect;
    }
}
