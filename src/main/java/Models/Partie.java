package Models;

public class Partie {
    private Plateau plateau;
    private Case caseCourante;
    private int score;
    private int numberCurrentCase;

    public Partie(Plateau plateau) {
        this.plateau = plateau;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public Case getCaseCourante() {
        return caseCourante;
    }

    public void setCaseCourante(Case caseCourante) {
        this.caseCourante = caseCourante;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumberCurrentCase() {
        return this.numberCurrentCase;
    }

    public void setNumberCurrentCase(int numberCurrentCase) {
        this.numberCurrentCase = numberCurrentCase;
    }

    public int SumDe(int de1, int de2) {
        return de1 + de2;
    }

    public void startGame() {
        this.score = 0;
        this.caseCourante = this.plateau.getCases()[0];
    }

    public void resumeGame(int score, int current){
        this.score = score;
        this.caseCourante = this.plateau.getCases()[current];
    }

    public void ModifyScore(int score) {
        this.score += score;
    }

    public void ModifyCurrentCase() {
        // this.caseCourante + SumDe();
    }

}
