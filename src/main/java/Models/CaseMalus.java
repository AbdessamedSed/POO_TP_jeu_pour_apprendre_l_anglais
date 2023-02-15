package Models;

public class CaseMalus extends Case {
    private final int malus = -10;
    private final int deplacement = -2;

    public CaseMalus(){};

    public CaseMalus(Couleur color) {
        super(color);
    }

    public int getMalus() {
        return this.malus;
    }

    public int getDeplacement(){return this.deplacement;};
}
