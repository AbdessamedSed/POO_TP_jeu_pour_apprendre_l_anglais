package Models;

public class CaseBonus extends Case {
    private final int bonus = 10;
    private final int deplacement = 2;

    public CaseBonus(){};

    public CaseBonus(Couleur color) {
        super(color);
    }

    public int getBonus() {
        return bonus;
    }

    public int getDeplacement() {
        return deplacement;
    }

}
